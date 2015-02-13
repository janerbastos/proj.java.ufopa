package br.com.ufopa.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.ufopa.model.security.Grupo;
import br.com.ufopa.model.security.Usuario;
import br.com.ufopa.repository.UsuarioRepository;
import br.com.ufopa.util.cdi.CDIServiceLocator;

public class AppUserDatailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioRepository usuarios = CDIServiceLocator.getBean(UsuarioRepository.class);
		Usuario usuario = usuarios.porUsername(username);
		UsuarioSistema user = null;
		
		if(usuario != null){
			user = new UsuarioSistema(usuario, getGrupo(usuario));
		}
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupo(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for(Grupo g : usuario.getGrupos()){
			authorities.add(new SimpleGrantedAuthority(g.getNome().toUpperCase()));
		}
		return authorities;
	}



}
