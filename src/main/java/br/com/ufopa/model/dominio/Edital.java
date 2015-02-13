package br.com.ufopa.model.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ufopa.util.Comum;

@Entity @Table(name="edital")
public class Edital {

	@Id @Column(name="edital", length=30)
	private String edital;
	
	@Column(name="data_incial") @Temporal(value=TemporalType.DATE)
	private Date inicio;
	
	@Column(name="data_final") @Temporal(value=TemporalType.DATE)
	private Date termino;
	
	@Column(name="prazo_avaliacao") @Temporal(value=TemporalType.DATE)
	private Date prazo;
	
	@Column(name="status", columnDefinition="BOOLEAN")
	private Boolean status;
	
	@Column(name="resumo") @Lob
	private String resumo;
	
	@Column(name="file") @Lob
	private byte[] file;
	
	@Column(name="extencao", length=40)
	private String tipo;
	
	@Column(name="tipo", length=40)
	private String extensao;
	
	public Edital(String codigo_edital){
		this.edital = codigo_edital;
	}
	
	public Edital() {}

	public String getEdital() {
		return edital;
	}

	public void setEdital(String edital) {
		this.edital = edital;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
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

	public boolean getEditalAbilitado(){
		Date hoje = Comum.dataSemHoras(new Date());
		if(inicio.after(Comum.diminuiDiaToData(1, hoje)) || hoje.before(Comum.addDiaToData(1, termino))){
			return true;
		}else{
			return false;
		}
	}

	public Date getPrazo() {
		return prazo;
	}

	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}
	
	public boolean isValidadeDoPrazo(){
		Date hoje = Comum.dataSemHoras(new Date());
		if(hoje.before(Comum.addDiaToData(1, prazo))){
			return true;
		}else{
			return false;
		}
	}
	
}
