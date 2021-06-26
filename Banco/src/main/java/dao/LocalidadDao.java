package dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dominio.Localidad;

public class LocalidadDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Localidad> obtenerLocalidades() {
		String query = "FROM Localidad";
		return (ArrayList<Localidad>) this.hibernateTemplate.find(query);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Localidad obtenerLocalidad(Integer id) {
		return this.hibernateTemplate.get(Localidad.class, id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public ArrayList<Localidad> obtenerLocalidades_x_Provincia(int id) {
		String query = "SELECT nombre FROM Localidad WHERE idProvincia= ?";
		Object[] queryParam = {id};
		return (ArrayList<Localidad>) this.hibernateTemplate.find(query, queryParam);
	}
}