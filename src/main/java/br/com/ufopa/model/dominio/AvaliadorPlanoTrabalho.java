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

@Entity @Table(name="Avaliador_Plano_Trabalho")
public class AvaliadorPlanoTrabalho {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne @JoinColumn(name="cod_planotrabalho", referencedColumnName="id" )
	private PlanoTrabalho planoTrabalho;
	
	@ManyToOne @JoinColumn(name="cod_avaliador", referencedColumnName="id" )
	private Avaliador avaliador;
	
	@Column(name="parecer") @Lob
	private String parecer;
	
	@Column(name="nota")
	private long nota;
	
	@Lob @Column(name="arquivo")
	private byte[] arquivo;
	
	@Column(name="tipo", length=100)
	private String tipo;
	
	@Column(name="extenso", length=10)
	private String extensao;
	
	public AvaliadorPlanoTrabalho() {
		planoTrabalho = new PlanoTrabalho();
		avaliador = new Avaliador();
	}

	public AvaliadorPlanoTrabalho(PlanoTrabalho planoTrabalho,
			Avaliador avaliador) {
		this.planoTrabalho = planoTrabalho;
		this.avaliador = avaliador;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PlanoTrabalho getPlanoTrabalho() {
		return planoTrabalho;
	}

	public void setPlanoTrabalho(PlanoTrabalho planoTrabalho) {
		this.planoTrabalho = planoTrabalho;
	}

	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public long getNota() {
		return nota;
	}

	public void setNota(long nota) {
		this.nota = nota;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
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
