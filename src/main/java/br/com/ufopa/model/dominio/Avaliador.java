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
import br.com.ufopa.util.Comum;

@Entity @Table(name="avaliadores")
public class Avaliador {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne @JoinColumn(name="codigo_edital", referencedColumnName="edital")
	private Edital edital;
	
	@ManyToOne @JoinColumn(name="linha_pesquisa_id", referencedColumnName="id")
	private LinhaPesquisa linhaPesquisa;
	
	@ManyToOne @JoinColumn(name="avaliador_id", referencedColumnName="id")
	private Usuario usuario;
	
	@Column(name="prazo_limite") @Temporal(TemporalType.DATE)
	private Date prazo;
	
	public Avaliador() {
		edital = new Edital();
		linhaPesquisa = new LinhaPesquisa();
		usuario = new Usuario();
	}
	
	public Avaliador(long id){
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Edital getEdital() {
		return edital;
	}

	public void setEdital(Edital edital) {
		this.edital = edital;
	}

	public LinhaPesquisa getLinhaPesquisa() {
		return linhaPesquisa;
	}

	public void setLinhaPesquisa(LinhaPesquisa linhaPesquisa) {
		this.linhaPesquisa = linhaPesquisa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getPrazo() {
		return prazo;
	}

	public void setPrazo(Date prezo) {
		this.prazo = prezo;
	}
	
	public boolean isValidadePrazo(){
		Date hoje = Comum.dataSemHoras(new Date());
		if(hoje.before(Comum.addDiaToData(1, prazo))){
			return true;
		}else{
			return false;
		}
	}

}
