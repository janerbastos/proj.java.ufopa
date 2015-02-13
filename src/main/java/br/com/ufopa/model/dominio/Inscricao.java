package br.com.ufopa.model.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ufopa.model.security.Usuario;

@Entity @Table(name="inscricao")
public class Inscricao {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)	
	private long id;
	
	@ManyToOne @JoinColumn(name="orientador_id", referencedColumnName="id")
	private Usuario orientador;
	
	@ManyToOne @JoinColumn(name="edital_codigo", referencedColumnName="edital")
	private Edital edital;
	
	@Column(name="regime_trabalho", length=30)
	private String regime;
	
	@Column(name="titulacao", length=100)
	private String titulacao;
	
	@Column(name="ano")
	private String ano; // Ano de obtencao do titulo
	
	@Column(name="vinculo")
	private boolean vinculo; //Se possui vinculo com programa de Pos-Graduacao
	
	@Column(name="nome_vinculo", length=60)
	private String nomeDoVinculo;
	
	@Column(name="grupo_pesquisa", length=100)
	private String grupoDePesquisa; //Nome do grupo de pesquisa que coordena ou que participa
	
	@Column(name="orienta_bolsita", columnDefinition="BOOLEAN")
	private boolean orientaBolsita; //Orienta bolsita em outro programa
	
	@Column(name="quantidade_orientando")
	private int quantidadeOrientando; //Se possui vinculo informar quantos
	
	@Column(name="numero_bolsa")
	private int numeroDeBolsa; //Quantidade de bolsas pretentidas
	
	@Column(name="bolsista_cnpq", columnDefinition="BOOLEAN")
	private boolean bolsistaCNPQ; //E bolsita Produtividade em Pesquisa (PQ) ou Produtividade Desenvolvimento Tec e Ext Inovadore (DT) do CNPQ
	
	@Column(name="nivel_bolsa", length=40)
	private String nivelDaBolsa;
	
	@Column(name="status", columnDefinition="BOOLEAN")
	private boolean status;
	
	@Column(name="registro") @Temporal(TemporalType.DATE)
	private Date registro; //Data de efetivacao do registro
	
	public Inscricao(long id){
		this.id = id;
	}
	
	public Inscricao() {
		orientador = new Usuario();
		edital = new Edital();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getOrientador() {
		return orientador;
	}

	public void setOrientador(Usuario orientador) {
		this.orientador = orientador;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public boolean isVinculo() {
		return vinculo;
	}

	public void setVinculo(boolean vinculo) {
		this.vinculo = vinculo;
	}

	public String getNomeDoVinculo() {
		return nomeDoVinculo;
	}

	public void setNomeDoVinculo(String nomeDoVinculo) {
		this.nomeDoVinculo = nomeDoVinculo;
	}

	public String getGrupoDePesquisa() {
		return grupoDePesquisa;
	}

	public void setGrupoDePesquisa(String grupoDePesquisa) {
		this.grupoDePesquisa = grupoDePesquisa;
	}

	public boolean isOrientaBolsita() {
		return orientaBolsita;
	}

	public void setOrientaBolsita(boolean orientaBolsita) {
		this.orientaBolsita = orientaBolsita;
	}

	public int getQuantidadeOrientando() {
		return quantidadeOrientando;
	}

	public void setQuantidadeOrientando(int quantidadeOrientando) {
		this.quantidadeOrientando = quantidadeOrientando;
	}

	public int getNumeroDeBolsa() {
		return numeroDeBolsa;
	}

	public void setNumeroDeBolsa(int numeroDeBolsa) {
		this.numeroDeBolsa = numeroDeBolsa;
	}

	public boolean isBolsistaCNPQ() {
		return bolsistaCNPQ;
	}

	public void setBolsistaCNPQ(boolean bolsistaCNPQ) {
		this.bolsistaCNPQ = bolsistaCNPQ;
	}

	public String getNivelDaBolsa() {
		return nivelDaBolsa;
	}

	public void setNivelDaBolsa(String nivelDaBolsa) {
		this.nivelDaBolsa = nivelDaBolsa;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	public Edital getEdital() {
		return edital;
	}

	public void setEdital(Edital edital) {
		this.edital = edital;
	}
	
	
}
