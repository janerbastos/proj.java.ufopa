package br.com.ufopa.repository.filter;

import java.io.Serializable;

import br.com.ufopa.model.security.Grupo;

public class UsuarioFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String username;
	private Grupo  grupo;

	public UsuarioFilter() {
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
