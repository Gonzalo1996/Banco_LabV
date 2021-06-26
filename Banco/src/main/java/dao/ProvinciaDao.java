package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dominio.Provincia;

public class ProvinciaDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Provincia> obtenerProvincias() {
		String query = "FROM Provincia";
		return (ArrayList<Provincia>) this.hibernateTemplate.find(query);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Provincia obtenerProvincia(Integer id) {
		return this.hibernateTemplate.get(Provincia.class, id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public ArrayList<Provincia> obtenerProvincias_x_Pais(int id) {
		String query = "SELECT nombre FROM Provincia WHERE pais_id= ?";
		Object[] queryParam = {id};
		return (ArrayList<Provincia>) this.hibernateTemplate.find(query, queryParam);
	}
}
