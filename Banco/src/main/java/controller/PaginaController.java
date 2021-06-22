package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaginaController {
	
	@RequestMapping("inicio.html")
	public ModelAndView inicio() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("altaCuenta");
		return MV;
	}

	@RequestMapping("redireccionar_pag2.html")
	public ModelAndView eventoRedirPag2() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Pagina2");
		return MV;
	}
}