package br.com.ufopa.util.jsf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FacesProducer {
	
	@Produces
	@RequestScoped
	public FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	@Produces
	@RequestScoped
	public ExternalContext getExternalContext(){
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	@Produces
	@RequestScoped
	public HttpServletRequest getServletRequest(){
		return ((HttpServletRequest)getExternalContext().getRequest());
	}
	
	@Produces
	@RequestScoped
	public HttpServletResponse getServletResponse(){
		return ((HttpServletResponse)getExternalContext().getResponse());
	}

}
