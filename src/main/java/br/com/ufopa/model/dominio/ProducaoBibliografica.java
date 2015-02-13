package br.com.ufopa.model.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="producao_bibliografica")
public class ProducaoBibliografica {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Lob @Column(name="arquivo")
	private byte[] arquivo;
	
	@ManyToOne @JoinColumn(name="inscricao_id", referencedColumnName="id")
	private Inscricao inscricao;
	
	@Column(name="tipo", length=200)
	private String tipo;
	
	@Column(name="extensao", length=10)
	private String extensao;
	
	public ProducaoBibliografica(Inscricao inscricao){
		this.inscricao = inscricao;
	}
	
	public ProducaoBibliografica() {
		inscricao = new Inscricao();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	
}
