package br.com.ufopa.model.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="matricula")
public class Matricula {

	@Id
	private long matricula;
	
	@Column(name="nome", length=200)
	private String nome;
	
	@Column(name="login", length=40)
	private String login;
	
	public Matricula() {
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	
}
