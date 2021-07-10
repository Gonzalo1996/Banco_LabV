package banco;

import java.awt.SystemColor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import banco.helpers.Constantes;
import banco.model.Cliente;
import banco.model.Cuenta;
import banco.model.Localidad;
import banco.model.Movimiento;
import banco.model.Person;
import banco.model.TipoUsuario;
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
	@Autowired private PersonService personService;
	@Autowired private GeneroService generoService;
	@Autowired private PaisService paisService;
	@Autowired private ProvinciaService provinciaService;
	@Autowired private LocalidadService localidadService;
	@Autowired private UsuarioService usuarioService;
	@Autowired private ClienteService clienteService;	
	@Autowired private CuentaService cuentaService;
	@Autowired private MovimientoService movimientoService;

	@RequestMapping(value="/inicio.html",method = RequestMethod.GET)
	public String inicio(Model model) {	
		return "login";
	}
	
	@RequestMapping(value="/login.html",method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/ajaxExamples.html",method = RequestMethod.GET)
	public String ajaxExamples(Model model) {	
		return "ajaxExamples";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxParams.html", method = RequestMethod.POST)
	public String ajaxParams(Integer dni, String nombreUsuario, String contrasenia) {
		System.out.println(dni + "-" + nombreUsuario + "-" + contrasenia);
		return "resultado OK";
	}

	@RequestMapping(value = "/ajaxObj.html", method = RequestMethod.POST)
	@ResponseBody
	public Object ajaxObj(@RequestBody Usuario usuario) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		
		System.out.println(usuario.toString());
		usuario.setIdUsuario(100);
		
		return om.writeValueAsString(usuario);
	}
	
	@RequestMapping(value = "/getLocalidadesPorProvincia.html", method = RequestMethod.GET)
	@ResponseBody
	public Object getLocalidadesPorProvincia(Integer idProvincia) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();

		List<Localidad> list = localidadService.listLocalidades_x_Prov(idProvincia);
		
		return om.writeValueAsString(list);
	}
	
	@RequestMapping(value="/guardarUsuario.html",method = RequestMethod.POST)
	public String guardarUsuario(Model model, String nombre, String apellido, String fechaNacimiento, Integer dni, String cuil, 
		Integer genero, Integer provincia, Integer localidad, String direccion, String correo, String nombreUsuario, String contrasenia)
	{	
		Date fecha = new Date(fechaNacimiento.replace('-', '/'));
		System.out.println(fecha);
		
		System.out.println("NOMBRE: " + nombre + "APELLIDO: " + apellido + "DNI: " + dni + "CUIL: " + cuil + " FECHA: " + fecha +
				"GENERO: " + genero + "PROVINCIA: " + provincia + "LOCALIDAD: " + localidad + direccion + correo+ nombreUsuario+ contrasenia);
		
		if(this.clienteService.obtenerCliente(dni) == null) {
			System.out.println("LISTO PARA CREAR");

			Cliente cliente = new Cliente(dni,cuil,nombre, apellido, fecha,correo, direccion, this.paisService.obtenerPais(1),
					this.localidadService.obtenerLocalidad(localidad), this.provinciaService.obtenerProvincia(provincia),
					this.generoService.obtenerGenero(genero), null);
			Usuario usuario = new Usuario(contrasenia,nombreUsuario,true, cliente, null);

			cliente.setUsuario(usuario);
			this.usuarioService.guardarUsuario(usuario);
			return "redirect:/listadoClientes.html";
		}
		else 
			System.out.println("!!!!!! USUARIO YA EXISTENTE");
		
		return "redirect:/guardarUsuario.html";
	}
		
	@RequestMapping(value="/guardarUsuario.html",method = RequestMethod.GET)
	public String guardarUsuario(Model model)
	{	
		return "altaCliente";
	}
	
	@RequestMapping(value="/guardarCuenta.html",method = RequestMethod.POST)
	public String guardarCuenta(Model model, String cbu, String alias, String nombre, Integer dni, Integer moneda)
	{	
		try {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy/mm/ss HH:mm:ss");
			Date fechaActual = new Date(formatter.format(System.currentTimeMillis()));
	
			Cuenta cuenta = new Cuenta(cbu, alias, moneda, 10000.0, true, null, fechaActual, nombre);
			this.cuentaService.guardarCuenta(cuenta, dni, cbu, alias);
			return "redirect:/listadoCuentas.html";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
			model.addAttribute("listClientes", this.clienteService.listClientes());
			return "altaCuenta";
		}
	}
	
	@RequestMapping(value="/guardarCuenta.html",method = RequestMethod.GET)
	public String guardarCuenta(Model model)
	{	
		model.addAttribute("listClientes", this.clienteService.listClientes());
		return "altaCuenta";
	}
	
	@RequestMapping(value="/login.html",method = RequestMethod.POST)
	public String login(Model model, String nombreUsuario, Integer dni, String contrasenia, HttpServletRequest request) {	
		try {
			Usuario usuario = this.usuarioService.obtenerUsuarioLogin(nombreUsuario ,dni, contrasenia);		
			model.addAttribute("usuario", usuario.getCliente().getNombre());
			
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			session.setAttribute("dni", usuario.getCliente().getDni());

			if (usuario.getTipoUsuario().getId() == Constantes.TipoUsuario.ADMIN.id) {
				return "redirect:/listadoCuentas.html";
			}
			else {
				return "redirect:/detallecliente.html";
			}		
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
			return "login";
		}
	}
	
	@RequestMapping(value="/listadoCuentas.html",method = RequestMethod.GET)
	public String redireccionarListadoCuentas(Model model) {
		model.addAttribute("listCuentas", this.cuentaService.listCuentas());
		return "listadoCuentas";
	}
	@RequestMapping(value="/listadoClientes.html",method = RequestMethod.GET)
	public String redireccionarListadoClientes(Model model) {
		model.addAttribute("listClientes", this.clienteService.listClientes());
		model.addAttribute("listLocalidades", this.localidadService.listLocalidades());
		return "listadoClientes";
	}

	@RequestMapping(value="/altaCliente.html",method = RequestMethod.GET)
	public String redireccionarAltaCliente(Model model) {
		model.addAttribute("listGeneros", this.generoService.listGeneros());
		model.addAttribute("listProvincias", this.provinciaService.listProvincias());
		model.addAttribute("listLocalidades", this.localidadService.listLocalidades());

		return "altaCliente";
	}
	
	@RequestMapping(value="/altaCuenta.html",method = RequestMethod.GET)
	public String redireccionarAltaCuenta(Model model) {
		model.addAttribute("listClientes", this.clienteService.listClientes());
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

	@RequestMapping(value="/modificarCuenta.html",method = RequestMethod.GET)
	public String redireccionarModificarCuenta(Model model) {
		return "modificarCuenta";
	}
	
    @RequestMapping("/editarCuenta.html")
    public String editarCuenta(Model model, Integer nroCuenta){
    	model.addAttribute("cuenta", this.cuentaService.obtenerCuenta(nroCuenta));
    	return "modificarCuenta";
    }
    
    @RequestMapping(value="/guardarCuentaModificada.html",method = RequestMethod.POST)
    public String guardarCuentaModificada(Model model, Integer nroCuenta, String nombre, Integer dni, String alias, Integer estado){    	
    	Boolean estadoCuenta;
    	try {
        	if(estado == 1)
        		estadoCuenta = true;
        	else 
        		estadoCuenta = false;
        	this.cuentaService.modificarCuenta(nroCuenta, alias, nombre, dni, estadoCuenta);
        	
        	return "redirect:/listadoCuentas.html";
    	}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
	    	model.addAttribute("cuenta", this.cuentaService.obtenerCuenta(nroCuenta));
			return "modificarCuenta";
		}
    }
    
    @RequestMapping("/bajaCuenta.html")
    public String bajaCuenta(Model model, Integer nroCuenta){
    	this.cuentaService.bajaCuenta(nroCuenta);
        return "redirect:/listadoCuentas.html";
    }
    
    @RequestMapping("/bajaUsuario.html")
    public String bajaUsuario(Model model, Integer dni){
    	this.usuarioService.bajaUsuario(dni);
        return "redirect:/listadoClientes.html";
    }
    
    @RequestMapping("/editarCliente.html")
    public String editarCliente(Model model, Integer dni){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fecha = sdf.format(this.clienteService.obtenerCliente(dni).getFechaNacimiento());

    	model.addAttribute("cliente", this.clienteService.obtenerCliente(dni));
    	model.addAttribute("fecha", fecha.replace('/', '-'));
		model.addAttribute("listProvincias", this.provinciaService.listProvincias());
		model.addAttribute("listLocalidades", this.localidadService.listLocalidades());
    	return "modificarCliente";
    }
    
    @RequestMapping(value="/guardarClienteModificado.html",method = RequestMethod.POST)
    public String guardarClienteModificado(Model model, Integer dni, String nombre, String apellido, String fecha, String correo, String direccion,
    										Integer pais, Integer provincia, Integer localidad, Integer estado) throws Exception{
		Date fechaNac = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		Boolean estadoCuenta;
		
       	if(estado == 1)
    		estadoCuenta = true;
    	else 
    		estadoCuenta = false;
    	
    	this.clienteService.modificarCliente(dni, nombre, apellido, fechaNac, correo, direccion, pais, provincia, localidad);
    	this.usuarioService.actualizarEstadoPorDni(dni, estadoCuenta);
    	return "redirect:/listadoClientes.html";
    }
    
    @RequestMapping(value="/cuentasCliente.html",method = RequestMethod.GET)
	public String redireccionarCuentaCliente(Model model, HttpServletRequest request) { 	
    	List<Cuenta> listCuentas = this.cuentaService.obtenerCuentasPorCliente((Integer)request.getSession().getAttribute("dni"));
    	model.addAttribute("listCuentas",listCuentas);
		return "cuentasCliente";
	}
    
    @RequestMapping(value="/transferencias.html",method = RequestMethod.GET)
	public String redireccionarTransferencias(Model model, HttpServletRequest request) {
    	List<Cuenta> listCuentas = this.cuentaService.obtenerCuentasPorCliente((Integer)request.getSession().getAttribute("dni"));	
    	
    	String error = (String)request.getSession().getAttribute("error");
    	if (error != null && !error.isEmpty()) {
    		model.addAttribute("error", error);
			request.getSession().removeAttribute("error");
    	}
    	
    	model.addAttribute("listCuentas",listCuentas);
		return "transferencias";
	}
    
    @RequestMapping(value="/transferenciasOtros.html", method=RequestMethod.POST)
    public String transferenciasOtros(Model model, Integer nroCuenta, String cbu, Double montoOtros, HttpServletRequest request) {
    	try {
    		this.movimientoService.guardarTransferenciaOtros(nroCuenta, cbu, montoOtros);
    		
        	return "redirect:/transferencias.html";	
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
        	return "redirect:/transferencias.html";	
		}
    }
    
    @RequestMapping(value="/transferenciasPropias.html", method=RequestMethod.POST)
    public String transferenciasPropias(Model model, Integer nroCuentaOrigen, Integer nroCuentaDestino, Double montoPropias, HttpServletRequest request) {
    	try {
    		this.movimientoService.guardarTransferenciaPropias(nroCuentaOrigen, nroCuentaDestino, montoPropias);
    		
        	return "redirect:/transferencias.html";	
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("error", e.getMessage());
        	return "redirect:/transferencias.html";	
		}
    }
    
	@RequestMapping(value="/movimientos.html",method = RequestMethod.GET)
    public String redireccionarMovimientos(Model model, String cbu){
		        
        Cuenta cuenta = this.cuentaService.obtenerPorCbu(cbu);
        
        List<Movimiento> listMovimientos = this.movimientoService.obtenerMovimientos_x_nroCuenta(cuenta.getNroCuenta());
                
        for(int i=0; i<listMovimientos.size();i++) {
        		System.out.println("Contenido del Objeto " + listMovimientos.get(i));
        }      
        model.addAttribute("nroCuenta", cuenta.getNroCuenta());
        model.addAttribute("nroCbu", cuenta.getCbu());
        model.addAttribute("saldo", cuenta.getSaldo());
        model.addAttribute("listMovimientos", listMovimientos);
        
        return "detalleCuentaCliente";
    }
	
	@RequestMapping(value="/detallecliente.html",method = RequestMethod.GET)
	public String redireccionarDetalleCliente(Model model, HttpServletRequest request) {
		Cliente cliente = this.clienteService.obtenerCliente((Integer)request.getSession().getAttribute("dni"));
		model.addAttribute("totalCuentas", this.cuentaService.obtenerCantCuentas_sinContarBajas((Integer)request.getSession().getAttribute("dni")));
		model.addAttribute("cliente", cliente);
		
		return "detallecliente";
	}
	
    @RequestMapping(value="/cerrarSesion.html",method = RequestMethod.GET)
	public String cerrarSesion(Model model, HttpServletRequest request) { 
    	request.getSession().removeAttribute("dni");
    	request.getSession().removeAttribute("usuario");
		return "login";
	}
	
	/////////EJEMPLOS PERSON///////////
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
}