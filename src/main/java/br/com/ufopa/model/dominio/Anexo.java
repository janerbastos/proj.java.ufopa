package br.com.ufopa.model.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity @Table(name="anexo")
public class Anexo {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="arquivo") @Lob
	private byte[] file;
	
	@Column(name="tipo", length=100)
	private String tipo;
	
	@Column(name="nome_arquivo")
	private String nome;
	
	@Column(name="titulo")
	private String titulo;
	
	public Anexo() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
