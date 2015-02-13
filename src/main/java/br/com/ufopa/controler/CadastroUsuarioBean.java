package br.com.ufopa.controler;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ufopa.model.security.Grupo;
import br.com.ufopa.model.security.Usuario;
import br.com.ufopa.repository.GrupoRepository;
import br.com.ufopa.service.UsuarioService;
import br.com.ufopa.util.jsf.FacesUtil;

@Named("cadastroUsuario")
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService serviceUsuario;

	@Inject
	private GrupoRepository repositorioGrupos;

	private Usuario usuario;
	private List<Grupo> grupos;
	private Grupo grupoSelecionado;

	public CadastroUsuarioBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			usuario.adicionarItemVazio();
		}
	}

	public List<Grupo> completaGrupo(String nome) {
		return repositorioGrupos.porNome(nome);
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		this.usuario.setCheckPassword(usuario.getPassword());
	}

	public Grupo getGrupoSelecionado() {
		return grupoSelecionado;
	}

	public void setGrupoSelecionado(Grupo grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}
	
	public boolean isEditando(){
		return this.usuario.isExistente();
	}

	public void carregaGrupoSelecionado() {
		Grupo gr = usuario.getGrupos().get(0); 
		if (existeGrupo(grupoSelecionado)) {
			FacesUtil.addErrorMassage("O Grupo selecionado já foi adicionado.");
			grupoSelecionado = null;
		} else {
			if (grupoSelecionado != null) {
				gr.copy(grupoSelecionado);
				usuario.adicionarItemVazio();
				grupoSelecionado = null;
			}
		}
	}

	private boolean existeGrupo(Grupo gr) {
		boolean existente = false;
		for (Grupo g : usuario.getGrupos()) {
			if (g.equals(gr)) {
				existente = true;
				break;
			}
		}
		return existente;
	}
	
	public void excluir(){
		usuario.getGrupos().remove(grupoSelecionado);
		FacesUtil.addInfoMassage("Grupo removido com sucesso.");
		grupoSelecionado = null;
	}

	public void salvar() {
		usuario.removeItemVazio();
		try {
			usuario = serviceUsuario.salvar(usuario);
			FacesUtil.addInfoMassage("Usuaário \"" + usuario.getNome() + "\" salvo com sucesso.");
			limpar();
		} finally {
			usuario.adicionarItemVazio();
		}
	}

	private void limpar() {
		usuario = new Usuario();
	}
}
