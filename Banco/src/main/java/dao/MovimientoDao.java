package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dominio.Movimiento;

public class MovimientoDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarMovimiento(Movimiento movimiento) {
		this.hibernateTemplate.save(movimiento);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Movimiento> obtenerMovimientos() {
		String query = "FROM Movimiento";
		return (ArrayList<Movimiento>) this.hibernateTemplate.find(query);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<Object[]> obtenerMovimientosAtributos() {
		String query = "SELECT m.detalle, m.monto FROM Movimiento m";
		return (List<Object[]>) this.hibernateTemplate.find(query);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Object[]> obtenerMovimiento(int id) {
		String query = "FROM Movimiento WHERE id= ?";
		Object[] queryParam = {id};
		return (List<Object[]>) this.hibernateTemplate.find(query, queryParam);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Object[]> obtenerMovimientoAtributo(int id) {
		String query = "SELECT m.detalle, m.monto FROM Movimiento m WHERE id= ?";
		Object[] queryParam = {id};
		return (List<Object[]>) this.hibernateTemplate.find(query, queryParam);
	}
}
