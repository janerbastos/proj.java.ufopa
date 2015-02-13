package br.com.ufopa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.ufopa.model.security.Usuario;
import br.com.ufopa.repository.UsuarioRepository;
import br.com.ufopa.service.NegocioException;
import br.com.ufopa.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter {

	//@Inject
	private UsuarioRepository usuarios;
	
	public UsuarioConverter() {
		usuarios = CDIServiceLocator.getBean(UsuarioRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		Long codigo = null;
		try{
			codigo = Long.valueOf(value);
		}catch(NumberFormatException e){
			throw new NegocioException(e.getMessage());
		}
		
		if(value != null){
			
			Usuario usuario = usuarios.porId(codigo);
			return usuario;
		}
		return codigo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value != null && !value.equals("")){
			Usuario u = (Usuario) value;
			return String.valueOf(u.getId());
		}
		return "";
	}

}
