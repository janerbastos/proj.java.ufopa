package br.com.ufopa.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.ufopa.model.security.Usuario;
import br.com.ufopa.repository.filter.UsuarioFilter;

public class UsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Usuario porUsername(String username) {
		Usuario usuario = null;
		try{
		usuario = manager.createQuery("from Usuario Where lower(username)=:username", Usuario.class)
				.setParameter("username", username.toLowerCase()).getSingleResult();
		}catch(NoResultException ex){
			//Só para identificar nenhum usuário foi encontrado com esse username.
		}
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> filtrados(UsuarioFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Usuario.class);
		
		if(StringUtils.isNotBlank(filtro.getNome())){
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.START));
		}
		
		if(StringUtils.isNotBlank(filtro.getUsername())){
			criteria.add(Restrictions.ilike("username", filtro.getNome(), MatchMode.START));
		}
		
		if(filtro.getGrupo()!=null){
			criteria.createCriteria("grupos").add(Restrictions.eq("nome", filtro.getGrupo().getNome()));
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
	}
	
	public Usuario guardar(Usuario user){
		return manager.merge(user);
	}

	public Usuario porId(Long codigo) {
		return manager.find(Usuario.class, codigo);
	}

	public void remover(Usuario usuario) {
		usuario = this.porId(usuario.getId());
		manager.remove(usuario);
		manager.flush();
	}

}
