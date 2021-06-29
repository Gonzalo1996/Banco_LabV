package controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import servicio.UsuarioServicio;

@Controller
public class PaginaController {
	
    private UsuarioServicio service;

    @Autowired(required=true)
	public void setService(UsuarioServicio service) {
		this.service = service;
	}

	@RequestMapping("inicio.html")
	public ModelAndView inicio() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("listadoCuentasAdmin");
		return MV;
	}
	
	@RequestMapping("redireccionar_pag2.html")
	public ModelAndView eventoRedirPag2() {
		ModelAndView MV = new ModelAndView();	
		MV.addObject("listaUsuarios",service.obtenerUsuarios());
		MV.setViewName("listadoUsuarioAdmin");
		return MV;
	}
}