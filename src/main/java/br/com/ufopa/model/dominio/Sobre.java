package br.com.ufopa.model.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity @Table(name="sobre")
public class Sobre {

	@Id
	private long id;
	
	@Column(name="descricao") @Lob
	private String descricao;
	
	public Sobre() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
