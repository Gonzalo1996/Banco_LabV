package principal;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

//import resources.Config;

public class Main {

	public static void main(String[] args)
	{
		/*
		Date date = new Date("12/12/2020");
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class); // con comas se pueden agregar mas archivos de appcontext
		MovimientoServicio service = (MovimientoServicio)appContext.getBean("serviceBeanMovimiento");
		CuentaServicio service2 = (CuentaServicio)appContext.getBean("serviceBeanCuenta");
		
		Movimiento movimiento = new Movimiento(10, 100.0, 100.1, date, "MovimientoPrueba", service2.obtenerCuenta(18810));
		service.insertarMovimiento(movimiento);
		System.out.println("Insertado");
		
		 ((ConfigurableApplicationContext)(appContext)).close(); 
		 */
	}
/*
	public static void agregarRegistros() 
	{		
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		session.beginTransaction();
		Date date = new Date("12/12/2020");

		Pais pais = new Pais("Argentina");

		Provincia provincia = new Provincia("Cordoba", pais);
		Provincia provincia1 = new Provincia("Salta", pais);
		Provincia provincia2 = new Provincia("Buenos aires", pais);
		Provincia provincia3 = new Provincia("Jujuy", pais);
		Provincia provincia4 = new Provincia("Chubut", pais);
		Provincia provincia5 = new Provincia("Mendoza", pais);
		Provincia provincia6 = new Provincia("Tucuman", pais);
		Provincia provincia7 = new Provincia("Tierra del fuego", pais);
		Provincia provincia8 = new Provincia("Neuquen", pais);
		Provincia provincia9 = new Provincia("La pampa", pais);
		
		Localidad localidad = new Localidad("La falda", provincia);
		Localidad localidad1 = new Localidad("Salta", provincia1);
		Localidad localidad2 = new Localidad("Pacheco", provincia2);
		Localidad localidad3 = new Localidad("Jujuy", provincia3);
		Localidad localidad4 = new Localidad("Rawson", provincia4);
		Localidad localidad5 = new Localidad("Godoy cruz", provincia5);
		Localidad localidad6 = new Localidad("San miguel de tucuman", provincia6);
		Localidad localidad7 = new Localidad("Ushuaia", provincia7);
		Localidad localidad8 = new Localidad("Bariloche", provincia8);
		Localidad localidad9 = new Localidad("Santa rosa", provincia9);
		
		Genero genero = new Genero("Masculino");
		Genero genero2 = new Genero("Femenino");
		Genero genero3 = new Genero("Otros");
		
		Usuario usuario = new Usuario(null,"12345", 1, "@Jose123", true);
		Usuario usuario1 = new Usuario(null,"12345", 1, "@Maumolina", true);
		Usuario usuario2 = new Usuario(null,"12345", 1, "@MarcosV", true);
		Usuario usuario3 = new Usuario(null,"12345", 1, "@GonzaAlde", true);
		Usuario usuario4 = new Usuario(null,"12345", 1, "@Tdeamos", true);
		Usuario usuario5 = new Usuario(null,"12345", 1, "@Rarra", true);
		Usuario usuario6 = new Usuario(null,"12345", 1, "@JuanG", true);
		Usuario usuario7 = new Usuario(null,"12345", 1, "@Therrera", true);
		Usuario usuario8 = new Usuario(null,"12345", 1, "@ClaudioF", true);
		Usuario usuario9 = new Usuario(null,"12345", 1, "@Kloster", true);

		Cliente cliente = new Cliente(40184777, 2040184775, "Jose", "Rodriguez", date, "jose@gmail.com", "calle false 123", pais, localidad, provincia, genero, usuario);	
		usuario.setCliente(cliente);
		
		Cliente cliente1 = new Cliente(41184777, 2043184175, "Mauricio", "Molina", date, "maumolina@gmail.com", "calle false 125", pais, localidad1, provincia1, genero, usuario1);	
		usuario1.setCliente(cliente1);
		
		Cliente cliente2 = new Cliente(41484777, 2043184475, "Marcos", "Vera", date, "marcosv@gmail.com", "calle false 325", pais, localidad2, provincia2, genero, usuario2);	
		usuario2.setCliente(cliente2);
		
		Cliente cliente3 = new Cliente(31484777, 2040181175, "Gonzalo", "Alderete", date, "gonza@gmail.com", "calle false B", pais, localidad3, provincia3, genero, usuario3);	
		usuario3.setCliente(cliente3);
		
		Cliente cliente4 = new Cliente(44444444, 2144444444, "Tomas", "De amos", date, "tdeamos@gmail.com", "calle fake 321", pais, localidad4, provincia4, genero, usuario4);
        usuario4.setCliente(cliente4);

        Cliente cliente5 = new Cliente(40756145, 21556789, "Ramiro", "Villalba", date, "rarra@gmail.com", "calle rarra 333", pais, localidad5, provincia5, genero2, usuario5);
        usuario5.setCliente(cliente5);

        Cliente cliente6 = new Cliente(40896124, 20789654, "Juan", "Gonzalez", date, "gonzalezjuan@gmail.com", "calle juan 222", pais, localidad6, provincia6, genero, usuario6);
        usuario6.setCliente(cliente6);
        
        Cliente cliente7 = new Cliente(29477963, 2029477963, "Tamara", "Herrera", date, "tamara@gmail.com", "Av. SiempreViva 742", pais, localidad7, provincia7, genero2, usuario7);
        usuario7.setCliente(cliente7);

        Cliente cliente8 = new Cliente(30666701, 2030666701, "Claudio", "Fernandez", date, "claudio@gmail.com", "Brandsen 805", pais, localidad8, provincia8, genero, usuario8);
        usuario8.setCliente(cliente8);

        Cliente cliente9 = new Cliente(19447920, 2019447920, "Daniel", "Kloster", date, "dani_elCrack@gmail.com", "Av. Programador 1010", pais, localidad9, provincia9, genero3, usuario9);
        usuario9.setCliente(cliente9);

    	Cuenta cuenta = new Cuenta (10110, "11101010", "winrar.licencia", 1, 1044.5, true, cliente, date, "C/ahorro");
    	Cuenta cuenta1 = new Cuenta (12141, "12101010", "winrar.auto", 2, 1004.5, true, cliente1, date, "C/ahorro");
    	Cuenta cuenta2 = new Cuenta (121140, "13101010", "winrar.pirata", 1, 1004.5, true, cliente2, date, "C/ahorro");
    	Cuenta cuenta3 = new Cuenta (12310, "131401010", "winrar.nunca.pago", 1, 1004.5, true, cliente3, date, "C/ahorro");
    	Cuenta cuenta4 = new Cuenta (13310, "16101010", "winrar.nada", 1, 1054.5, true, cliente4, date, "C/ahorro");
    	Cuenta cuenta5= new Cuenta (12650, "10161710", "winrar.exe", 1, 1004.5, true, cliente5, date, "C/ahorro");
    	Cuenta cuenta6 = new Cuenta (17710, "1010177010", "winrar.rawson", 1, 1004.5, true, cliente6, date, "C/ahorro");
    	Cuenta cuenta7 = new Cuenta (18110, "19181010", "winrar.doc", 1, 1004.5, true, cliente7, date, "C/ahorro");
    	Cuenta cuenta8 = new Cuenta (18419, "19171010", "winrar.rar", 1, 1004.5, true, cliente8, date, "C/ahorro");
    	Cuenta cuenta9 = new Cuenta (18810, "101071910", "winrar.png", 1, 1094.5, true, cliente4, date, "C/ahorro");

    	
    	Movimiento movimiento = new Movimiento(1, 10101.7 , 50005.7 , date, "deuda", cuenta);
    	Movimiento movimiento1 = new Movimiento(2, 12001.7 , 50005.7 , date, "prestamo", cuenta1);
    	Movimiento movimiento2 = new Movimiento(3, 13001.7 , 50005.7 , date, "ayuda", cuenta2);
    	Movimiento movimiento3 = new Movimiento(4, 10401.7 , 50005.7 , date, "aporte", cuenta3);
    	Movimiento movimiento4 = new Movimiento(5, 14001.7 , 50005.7 , date, "pack futbol", cuenta4);
    	Movimiento movimiento5 = new Movimiento(6, 15001.7 , 50005.7 , date, "deuda 2", cuenta4);
    	Movimiento movimiento6 = new Movimiento(7, 10501.7 , 50005.7 , date, "particular", cuenta6);
    	Movimiento movimiento7 = new Movimiento(8, 10401.7 , 50005.7 , date, "bono", cuenta7);
    	Movimiento movimiento8 = new Movimiento(9, 1031.7 , 50005.7 , date, "Cuota tusi", cuenta8);
    	Movimiento movimiento9 = new Movimiento(0, 10101.7 , 50005.7 , date, "deuda", cuenta9);
    	

		session.save(movimiento);
		session.save(movimiento1);
		session.save(movimiento2);
		session.save(movimiento3);
		session.save(movimiento4);
		session.save(movimiento5);
		session.save(movimiento6);
		session.save(movimiento7);
		session.save(movimiento8);
		session.save(movimiento9);

	   	session.getTransaction().commit();
    	session.close();
	}*/
}