package br.com.ufopa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.ufopa.model.security.Grupo;
import br.com.ufopa.repository.GrupoRepository;
import br.com.ufopa.service.NegocioException;
import br.com.ufopa.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Grupo.class)
public class GrupoConverter implements Converter {

	//@Inject
	private GrupoRepository grupos;
	
	public GrupoConverter() {
		grupos = CDIServiceLocator.getBean(GrupoRepository.class);
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
			Grupo grupo = grupos.porId(codigo);
			return grupo;
		}
		return codigo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value != null && !value.equals("")){
			Grupo g = (Grupo) value;
			return String.valueOf(g.getId());
		}
		return "";
	}

}
