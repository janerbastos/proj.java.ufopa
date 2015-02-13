package br.com.ufopa.model.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="linha_pesquisa")
public class LinhaPesquisa {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="descricao", length=250)
	private String descricao;
	
	@Column(name="status", columnDefinition="BOOLEAN")
	private Boolean status;
	
	
	public LinhaPesquisa() {}

	public LinhaPesquisa(long id) {
		this.id = id;
	}

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


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}

}
