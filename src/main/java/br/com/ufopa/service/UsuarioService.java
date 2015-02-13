package br.com.ufopa.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.ufopa.model.security.Usuario;
import br.com.ufopa.repository.UsuarioRepository;
import br.com.ufopa.util.jpa.Transactional;

public class UsuarioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioRepository repositorio;
	
	@Transactional
	public Usuario salvar(Usuario user){
		
		Usuario usuarioExitente = repositorio.porUsername(user.getUsername());
		
		if(usuarioExitente != null && !usuarioExitente.equals(user) ){
			throw new NegocioException("Já existe um usuário cadastrado com esse username.");
		}
		
		if(!user.confirmaSenha()){
			throw new NegocioException("Senha não confirma. Corrija e tente novamente.");
		}
		
		if(!user.confirmaGrupo()){
			throw new NegocioException("Informe um grupo para o usuário.");
		}
		
		return repositorio.guardar(user);
	}
	
	@Transactional
	public void excluir(Usuario usuario){
		repositorio.remover(usuario);
	}
}
