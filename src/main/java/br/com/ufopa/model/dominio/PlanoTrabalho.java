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

@Entity @Table(name="planotrabalho")
public class PlanoTrabalho {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="titulo_trabalho", length=200)
	private String titulo;
	
	@ManyToOne @JoinColumn(name="inscricao_id", referencedColumnName="id")
	private Inscricao inscricao;
	
	@ManyToOne @JoinColumn(name="linhapesquisa_id", referencedColumnName="id")
	private LinhaPesquisa linhaPesquisa;
	
	@Column(name="status")
	private int status;
	
	@Column(name="parecer", nullable=true) @Lob
	private String parecer;
	
	@Column(name="planotrabalho") @Lob
	private byte[] arquivo;
	
	@Column(name="tipo", length=200)
	private String tipo;
	
	@Column(name="extensao", length=10)
	private String extensao;
	
	@Column(name="nota")
	private long nota;
	
	public PlanoTrabalho() {
		inscricao = new Inscricao();
		linhaPesquisa = new LinhaPesquisa();
	}
	
	public PlanoTrabalho(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public LinhaPesquisa getLinhaPesquisa() {
		return linhaPesquisa;
	}

	public void setLinhaPesquisa(LinhaPesquisa linhaPesquisa) {
		this.linhaPesquisa = linhaPesquisa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public String getStatusTrabalho(){
		String result = null;
		switch (status) {
		case 0:
			result = "Em Análise";
			break;

		case 1:
			result = "Avaliado";
			break;
		
		case 2:
			result = "Não Aprovado";
			break;
		}
		return result;
	}

	public long getNota() {
		return nota;
	}

	public void setNota(long nota) {
		this.nota = nota;
	}
	
}
