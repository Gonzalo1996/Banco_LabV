package dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dominio.Genero;


public class GeneroDao {

	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Genero> obtenerGenero() {
		String query = "FROM Genero";
		return (ArrayList<Genero>) this.hibernateTemplate.find(query);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Genero obtenerGenero(Integer codGenero) {
		return this.hibernateTemplate.get(Genero.class, codGenero);
	}
	
	
	
	
	
}
