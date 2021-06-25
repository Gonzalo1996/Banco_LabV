package dao;

import java.util.*;
import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import dominio.Cuenta;
import dominio.Usuario;

public class CuentaDao {
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarCuenta(Cuenta cuenta) {
		this.hibernateTemplate.save(cuenta);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Cuenta> obtenerCuentas() {
		String query = "FROM Cuenta";
		return (ArrayList<Cuenta>) this.hibernateTemplate.find(query);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Object[]> obtenerCuentasAtributos() {
		String query = "SELECT c.nroCuenta, c.alias, c.moneda FROM Cuenta c";
		return (List<Object[]>) this.hibernateTemplate.find(query);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Cuenta obtenerCuenta(Integer nroCuenta) {
		return this.hibernateTemplate.get(Cuenta.class, nroCuenta);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Object[]> obtenerCuentaAtributo(Integer p_nroCuenta) {
		String query = "SELECT c.nroCuenta, c.alias, c.moneda FROM Cuenta c WHERE nroCuenta= ?";
		Object[] queryParam = {p_nroCuenta};
		
		return (List<Object[]>) this.hibernateTemplate.find(query, queryParam);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void actualizarEstadoCuenta(Integer nroCuenta, Boolean estado) {
		Cuenta cuenta = obtenerCuenta(nroCuenta);
		cuenta.setEstado(estado);
		this.hibernateTemplate.update(cuenta);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void actualizarAlias(Integer nroCuenta, String alias) {
		Cuenta cuenta = obtenerCuenta(nroCuenta);
		cuenta.setAlias(alias);
		this.hibernateTemplate.update(cuenta);
	}
}