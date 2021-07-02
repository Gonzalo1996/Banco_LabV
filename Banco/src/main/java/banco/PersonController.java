package banco;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import banco.model.Person;
import banco.model.Usuario;
import banco.service.ClienteService;
import banco.service.CuentaService;
import banco.service.GeneroService;
import banco.service.LocalidadService;
import banco.service.MovimientoService;
import banco.service.PaisService;
import banco.service.PersonService;
import banco.service.ProvinciaService;
import banco.service.UsuarioService;

@Controller
public class PersonController {
	
	private PersonService personService;
	private GeneroService generoService;
	private PaisService paisService;
	private ProvinciaService provinciaService;
	private LocalidadService localidadService;
	private UsuarioService usuarioService;
	private ClienteService clienteService;
	private CuentaService cuentaService;
	private MovimientoService movimientoService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="generoService")
	public void setGeneroService(GeneroService g){
		this.generoService = g;
	}

	@Autowired(required=true)
	@Qualifier(value="paisService")
	public void setPaisService(PaisService paisService) {
		this.paisService = paisService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="provinciaService")
	public void setProvinciaService(ProvinciaService provinciaService) {
		this.provinciaService = provinciaService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="localidadService")
	public void setLocalidadService(LocalidadService localidadService) {
		this.localidadService = localidadService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="usuarioService")
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Autowired(required=true)
	@Qualifier(value="clienteService")
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@Autowired(required=true)
	@Qualifier(value="cuentaService")
	public void setCuentaService(CuentaService cuentaService) {
		this.cuentaService = cuentaService;
	}

	@Autowired(required=true)
	@Qualifier(value="movimientoService")
	public void setMovimientoService(MovimientoService movimientoService) {
		this.movimientoService = movimientoService;
	}
	
	@RequestMapping(value="/test.html",method = RequestMethod.POST)
	public void testAjax(@RequestBody Usuario usuario) {
	    System.out.println(usuario.toString());
	}

	//REDIRECCIONES
	@RequestMapping(value="/inicio.html",method = RequestMethod.GET)
	public String inicio(Model model) {	
		return "login";
	}
	
	@RequestMapping(value="/login.html",method = RequestMethod.GET)
	public String login(Model model) {	
		return "login";
	}
	
	@RequestMapping(value="/guardarUsuario.html",method = RequestMethod.GET)
	public String guardarUsuario(Model model, String nombre, String apellido, String fechaNacimiento, Integer dni, Integer cuil, 
		Integer genero)
	{	
		
		Date fecha = new Date(fechaNacimiento.replace('-', '/'));
		System.out.println(fecha);

		System.out.println("DENTRO DE REQUEST");
		System.out.println("NOMBRE: " + nombre + "APELLIDO: " + apellido + "DNI: " + dni + "CUIL: " + cuil + " FECHA: " + fecha +
				"GENERO: " + genero);
		
		return "redirect:/listadoCuentas.html";
	}
		
	@RequestMapping(value="/guardarUsuario.html",method = RequestMethod.POST)
	public String guardarUsuario(Model model)
	{	
		return "altaCliente";
	}
	
	@RequestMapping(value="/login.html",method = RequestMethod.POST)
	public String login(Model model, String nombreUsuario, Integer dni, String contrasenia) {	
		
		List<Object[]> listUsuarios = this.usuarioService.obtenerUsuarioLogin(nombreUsuario ,dni, contrasenia);
		
		Integer id = null;
		String  nombre = null;
		Integer tipoUser = null;
		Integer dniUser = null;
	
		if(listUsuarios.isEmpty()) {
			model.addAttribute("mensajeError", "Usuario o contrasenia incorrecta");
			return "login";
		}
		
		for(Object[] obj : listUsuarios) {
			  id = (Integer)obj[0];
			  nombre = (String)obj[2];
			  tipoUser = (Integer)obj[3];
			  dniUser = (Integer)obj[4];
			}
		
		model.addAttribute("usuario", nombre);
		
		if(tipoUser == 1) {
			return "redirect:/listadoCuentas.html";
		}
		else {
			return "redirect:/detallecliente.html";
		}
	}
	
	@RequestMapping(value="/detallecliente.html",method = RequestMethod.GET)
	public String redireccionarDetalleCliente(Model model) {
		return "detallecliente";
	}
	
	@RequestMapping(value="/listadoCuentas.html",method = RequestMethod.GET)
	public String redireccionarListadoCuentas(Model model) {
		model.addAttribute("listCuentas", this.cuentaService.listCuentas());
		return "listadoCuentas";
	}
	@RequestMapping(value="/listadoClientes.html",method = RequestMethod.GET)
	public String redireccionarListadoClientes(Model model) {
		model.addAttribute("listClientes", this.clienteService.listClientes());
		return "listadoClientes";
	}

	@RequestMapping(value="/altaCliente.html",method = RequestMethod.GET)
	public String redireccionarAltaCliente(Model model) {
		return "altaCliente";
	}
	
	@RequestMapping(value="/altaCuenta.html",method = RequestMethod.GET)
	public String redireccionarAltaCuenta(Model model) {
		return "altaCuenta";
	}

	@RequestMapping(value="/test2.html",method = RequestMethod.GET)
	public String redireccionarTest2(Model model) {
		model.addAttribute("listGeneros", this.generoService.listGeneros());
		return "test2";
	}
	
	@RequestMapping(value = "/generos", method = RequestMethod.GET)
	public String listGeneros(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listGeneros", this.personService.listPersons());
		return "person";
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
    
    /*
	@RequestMapping(value="/inicio.html",method = RequestMethod.GET)
	public String inicio(Model model) {
		
		model.addAttribute("ClienteUnico", this.clienteService.obtenerCliente(31484777));
		model.addAttribute("listClientes", this.clienteService.listClientes());
		
		model.addAttribute("UsuarioUnico", this.usuarioService.obtenerUsuario(3));
		model.addAttribute("listUsuarios", this.usuarioService.listUsuarios());
		model.addAttribute("UsuarioUnico", this.usuarioService.actualizarEstado(5, false));
		
		model.addAttribute("CuentaUnica", this.cuentaService.obtenerCuenta(18810));
		model.addAttribute("listCuentas", this.cuentaService.listCuentas());

		model.addAttribute("MovimientUnico", this.movimientoService.obtenerMovimiento(5));
		model.addAttribute("listMovimiento", this.movimientoService.listMovimientos());
		
		model.addAttribute("listGeneros", this.generoService.listGeneros());
		model.addAttribute("generoUnico", this.generoService.obtenerGenero(2));
		
		model.addAttribute("listPais", this.paisService.listPais());
		model.addAttribute("paisUnico", this.paisService.obtenerPais(1));
		
		model.addAttribute("listProvincias", this.provinciaService.listProvincias());
		model.addAttribute("listProvincias2", this.provinciaService.listProvincias_x_Pais(1));
		model.addAttribute("provinciaUnica", this.provinciaService.obtenerProvincia(1));
		
		model.addAttribute("listLocalidades", this.localidadService.listLocalidades());
		model.addAttribute("listLocalidades2", this.localidadService.listLocalidades_x_Prov(3));
		model.addAttribute("localidadUnica", this.localidadService.obtenerLocalidad(1));
		return "listadoCuentasAdmin";
	}
	*/
	
}
