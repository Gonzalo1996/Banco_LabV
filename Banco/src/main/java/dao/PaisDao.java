package dao;

import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dominio.Pais;
public class PaisDao {
	private HibernateTemplate hibernateTemplate = null;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Pais> obtenerPaises(){
		String query = "FROM Pais";
		return (ArrayList<Pais>) this.hibernateTemplate.find(query);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Pais obtenerPais(Integer id) {
		return this.hibernateTemplate.get(Pais.class, id);
	}
}
