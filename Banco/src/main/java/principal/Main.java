package principal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Date;
import banco.model.*;


//import resources.Config;

public class Main {

	public static void main(String[] args)
	{
		agregarRegistros();	 
		System.out.println("Registros insertados correctamente");
	}

	public static void agregarRegistros() 
	{		
    	SessionFactory sessionFactory;
    	
    	Configuration configuration = new Configuration();
    	configuration.configure();	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();
 
    	session.beginTransaction();
		
		Pais pais = new Pais("Argentina");
		Pais pais1 = new Pais("Colombia");
		Pais pais2 = new Pais("Brasil");
		Pais pais3 = new Pais("Chile");
		Pais pais4 = new Pais("Peru");
		Pais pais5 = new Pais("Ecuador");
		Pais pais6 = new Pais("Uruguay");
		Pais pais7 = new Pais("Paraguay");
		Pais pais8 = new Pais("Venezuela");
		Pais pais9 = new Pais("Bolivia");
		Pais pais10 = new Pais("Mexico");
		Pais pais11 = new Pais("Otro");


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
		Localidad localidad1 = new Localidad("Valle hermoso", provincia);
		Localidad localidad2 = new Localidad("La cumbre", provincia);
		
		Localidad localidad3 = new Localidad("Salta", provincia1);
		Localidad localidad4 = new Localidad("Cafayate", provincia1);
		Localidad localidad5 = new Localidad("Molinos", provincia1);

		Localidad localidad6 = new Localidad("Pacheco", provincia2);
		Localidad localidad7 = new Localidad("San miguel", provincia2);
		Localidad localidad8 = new Localidad("Garin", provincia2);
		
		Localidad localidad9 = new Localidad("Tilcara", provincia3);
		Localidad localidad10 = new Localidad("Volcan", provincia3);
		Localidad localidad11 = new Localidad("Palpala", provincia3);

		Localidad localidad12 = new Localidad("Rawson", provincia4);
		Localidad localidad13 = new Localidad("Comodoro rivadavia", provincia4);
		Localidad localidad14 = new Localidad("Camarones", provincia4);
		
		Localidad localidad15 = new Localidad("Godoy cruz", provincia5);
		Localidad localidad16 = new Localidad("Guaymallen", provincia5);
		Localidad localidad17 = new Localidad("Gral. Alvear", provincia5);

		Localidad localidad18 = new Localidad("San miguel de tucuman", provincia6);
		Localidad localidad19 = new Localidad("Los pocitos", provincia6);
		Localidad localidad20 = new Localidad("Santa Lucia", provincia6);

		Localidad localidad21 = new Localidad("Ushuaia", provincia7);
		Localidad localidad22 = new Localidad("Rio grande", provincia7);
		Localidad localidad23 = new Localidad("Lago escondido", provincia7);

		Localidad localidad24 = new Localidad("Bariloche", provincia8);
		Localidad localidad25 = new Localidad("Alumine", provincia8);
		Localidad localidad26 = new Localidad("Junin de los Andes", provincia8);
	
		
		Localidad localidad27 = new Localidad("Santa rosa", provincia9);
		Localidad localidad28 = new Localidad("Carro quemado", provincia9);
		Localidad localidad29 = new Localidad("25 de Mayo", provincia9);
		
		TipoUsuario tipoUsuario = new TipoUsuario("Cliente");
		TipoUsuario tipoUsuario2 = new TipoUsuario("Administrador");
		
		Genero genero = new Genero("Masculino");
		Genero genero1 = new Genero("Femenino");
		Genero genero2 = new Genero("Otros");
		
		Usuario usuario = new Usuario("12345","@jose", true, null, tipoUsuario2);
		Usuario usuario1 = new Usuario("12345","@maumolina", true, null, tipoUsuario2);
		Usuario usuario2 = new Usuario("12345","@Juan", true, null, tipoUsuario2);
		Usuario usuario3 = new Usuario("12345","@marcos", true, null, tipoUsuario);
		
		Cliente cliente = new Cliente(40184777, "2040184775", "Jose", "Rodriguez", new Date(), "jose@gmail.com", "calle false 123", pais, localidad, provincia, genero, usuario);	
		usuario.setCliente(cliente);
		
		Cliente cliente1 = new Cliente(40184763, "20401847635", "Mauricio", "Molina", new Date(), "maumolina@gmail.com", "calle false 125", pais, localidad, provincia, genero1, usuario1);	
		usuario1.setCliente(cliente1);
		
        Cliente cliente2 = new Cliente(40896124, "20789654", "Juan", "Gonzalez", new Date(), "gonzalezjuan@gmail.com", "calle juan 222", pais, localidad, provincia, genero, usuario2);
        usuario2.setCliente(cliente2);
		
		Cliente cliente3 = new Cliente(40762755, "20407627555", "Marcos", "Vera", new Date(), "marcosv@gmail.com", "calle false 325", pais, localidad, provincia, genero2, usuario3);	
		usuario3.setCliente(cliente3);
		
        TipoMoneda tipoCuenta = new TipoMoneda("Peso");
        TipoMoneda tipoCuenta1 = new TipoMoneda("Dolar");
		
		session.save(localidad);
		session.save(localidad1);
		session.save(localidad2);
		session.save(localidad3);
		session.save(localidad4);
		session.save(localidad5);
		session.save(localidad6);
		session.save(localidad7);
		session.save(localidad8);
		session.save(localidad9);
		session.save(localidad10);
		session.save(localidad11);		
		session.save(localidad12);
		session.save(localidad13);
		session.save(localidad14);
		session.save(localidad15);
		session.save(localidad16);
		session.save(localidad17);
		session.save(localidad18);
		session.save(localidad19);
		session.save(localidad20);
		session.save(localidad21);
		session.save(localidad22);
		session.save(localidad23);
		session.save(localidad24);
		session.save(localidad25);
		session.save(localidad26);
		session.save(localidad27);
		session.save(localidad28);
		session.save(localidad29);
		
		session.save(pais1);
		session.save(pais2);
		session.save(pais3);
		session.save(pais4);
		session.save(pais5);
		session.save(pais6);
		session.save(pais7);
		session.save(pais8);
		session.save(pais9);
		session.save(pais10);
		session.save(pais11);

		
		session.save(cliente);
		session.save(cliente1);
		session.save(cliente2);
		session.save(cliente3);
		
		session.save(tipoCuenta);
		session.save(tipoCuenta1);

    	session.getTransaction().commit();
    	session.close();
    	
    	sessionFactory.close();
}
}
