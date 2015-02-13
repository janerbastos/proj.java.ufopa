package br.com.ufopa.controler;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ufopa.model.security.Grupo;
import br.com.ufopa.model.security.Usuario;
import br.com.ufopa.repository.GrupoRepository;
import br.com.ufopa.repository.UsuarioRepository;
import br.com.ufopa.repository.filter.UsuarioFilter;
import br.com.ufopa.service.UsuarioService;
import br.com.ufopa.util.jsf.FacesUtil;

@Named("pesquisaUsuario")
@ViewScoped
public class PesquisaUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository repositorioUsuario;
	@Inject
	private UsuarioService servicoUsuario;
	@Inject
	private GrupoRepository repositorioGrupo;

	private Usuario usuarioSelecionado;
	private List<Usuario> usuarios;
	private UsuarioFilter filtro;
	private List<Grupo> grupos;

	public PesquisaUsuarioBean() {
		filtro = new UsuarioFilter();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			grupos = repositorioGrupo.cadastrados();
		}
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public UsuarioFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(UsuarioFilter filtro) {
		this.filtro = filtro;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void excluir() {
		servicoUsuario.excluir(usuarioSelecionado);
	}

	public void pesquisar() {
		usuarios = repositorioUsuario.filtrados(filtro);
	}

}
