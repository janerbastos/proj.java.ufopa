package br.com.ufopa.security;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Named
@RequestScoped
public class Seguranca {

	public String getNomeUsuario() {
		String nome = null;
		UsuarioSistema usuarioLogado = getUsuarioLogado();
		if (usuarioLogado != null) {
			nome = usuarioLogado.getUsuario().getNome();
		}
		return nome;
	}

	private UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuarioLogado = null;
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken)
		FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		if(auth != null && auth.getPrincipal()!=null){
			usuarioLogado = (UsuarioSistema) auth.getPrincipal();
		}
		
		return usuarioLogado;
	}
}
