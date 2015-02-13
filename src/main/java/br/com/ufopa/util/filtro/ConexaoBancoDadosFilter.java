package br.com.ufopa.util.filtro;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(servletNames={"Faces Servlet"})
public class ConexaoBancoDadosFilter implements Filter{

	private EntityManagerFactory emf;
	
	public void destroy() {
		emf.close();
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		EntityTransaction transaction = null;
		EntityManager em = null;
		try{
			em = this.emf.createEntityManager();
			request.setAttribute("em", em);
			transaction = em.getTransaction();
			transaction.begin();
			chain.doFilter(request, response);
			transaction.commit();
		}catch(Exception e){
			//Log.lopesINFOApp("\n\n"+ e.getMessage() +"\n\n");
			if(transaction != null && transaction.isActive()){
				transaction.rollback();
			}
		}finally{
			em.close();
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		emf = Persistence.createEntityManagerFactory("psa");
	}

}
