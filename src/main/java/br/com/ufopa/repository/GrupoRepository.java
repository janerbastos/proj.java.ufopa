package br.com.ufopa.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ufopa.model.security.Grupo;

public class GrupoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Grupo> cadastrados() {
		return manager.createQuery("from Grupo", Grupo.class).getResultList();
	}

	public Grupo porId(Long codigo) {
		return manager.find(Grupo.class, codigo);
	}

	public List<Grupo> porNome(String nome) {
		return manager.createQuery("from Grupo where nome like :nome ", Grupo.class)
				.setParameter("nome", nome + "%").getResultList();
	}
}
