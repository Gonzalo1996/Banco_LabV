package banco;

import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

	//REDIRECCIONES
	@RequestMapping(value="/inicio.html",method = RequestMethod.GET)
	public String inicio(Model model) {			
		model.addAttribute("listClientes", this.clienteService.listClientes());

		return "altaCuenta";
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
	
	@RequestMapping(value="/guardarUsuario.html",method = RequestMethod.POST)
	public String guardarUsuario(Model model, String nombre, String apellido, String fechaNacimiento, Integer dni, Integer cuil, 
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
		

		System.out.println("DENTRO DE REQUEST");
		
		
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
	public String login(Model model, String nombreUsuario, Integer dni, String contrasenia) {	
		try {
			Usuario usuario = this.usuarioService.obtenerUsuarioLogin(nombreUsuario ,dni, contrasenia);
			
			model.addAttribute("usuario", usuario.getCliente().getNombre());
			
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
	
    @RequestMapping(value="/cuentasCliente.html",method = RequestMethod.GET)
	public String redireccionarCuentaCliente(Model model, Integer dni) {
    	//model.addAttribute("listCuentas", this.cuentaService.listCuentas());
    	
    	List<Cuenta> listCuentas = this.cuentaService.obtenerCuentasPorCliente(44444444);
    	//for(int i=0; i<listCuentas.size();i++) {
    	//	System.out.println("Contenido del Objeto " + i + listCuentas.get(i));
    	//}
    	
    	model.addAttribute("listCuentas",listCuentas);
		return "cuentasCliente";
	}
    
    @RequestMapping(value="/transferencias.html",method = RequestMethod.GET)
	public String redireccionarTransferencias(Model model, Integer dni) {

    	List<Cuenta> listCuentas = this.cuentaService.obtenerCuentasPorCliente(44444444);
    	
    	model.addAttribute("listCuentas",listCuentas);
		return "transferencias";
	}
    
	@RequestMapping(value="/movimientos.html",method = RequestMethod.GET)
    public String redireccionarMovimientos(Model model, String cbu){
		
        System.out.println("Nro. de CBU: " + cbu);
        
        Cuenta cuenta = this.cuentaService.obtenerPorCbu(cbu);
        
        List<Movimiento> listMovimientos = this.movimientoService.obtenerMovimientos_x_nroCuenta(cuenta.getNroCuenta());
        
        System.out.println(cuenta.toString());
        
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
	public String redireccionarDetalleCliente(Model model, Integer dni) {
		
		Cliente cliente = this.clienteService.obtenerCliente(44444444);
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("totalCuentas", this.cuentaService.obtenerCantCuentas_sinContarBajas(44444444));
		
		return "detallecliente";
	}
}
