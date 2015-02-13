package br.com.ufopa.model.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="configuracao")
public class Configuracao {

	@Id
	private int id;
	
	@Column(name="porta")
	private int porta;
	
	@Column(name="usuario", length=60)
	private String usuario;
	
	@Column(name="pws", length=100)
	private String password;
	
	@Column(name="host", length=100)
	private String hostname;
	
	@Column(name="email_from")
	private String from;
	
	public Configuracao() {
		id = 0;
		porta = 25;
		password = "";
		hostname = "mail.ufopa.edu.br";
		from = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
