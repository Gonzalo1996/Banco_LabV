package dao;

import java.util.*;
import java.util.ArrayList;
import dao.ConfigHibernate;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.Query;

import org.hibernate.Session;


import dominio.Cuenta;

public class CuentaDao {
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarCuenta(Cuenta cuenta) {
		this.hibernateTemplate.save(cuenta);
	}
	
	//Consultar tabla entera
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Cuenta> obtenerCuentas() {
		String query = "FROM Cuenta";
		return (ArrayList<Cuenta>) this.hibernateTemplate.find(query);
	}
	
	//Consultar por atributos especificos
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Object[]> obtenerCuentasAtributos() {
		String query = "SELECT c.nroCuenta, c.alias, c.moneda FROM Cuenta c";
		return (List<Object[]>) this.hibernateTemplate.find(query);
	}
	
	//Consultar por una cuenta especifica
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Object[]> obtenerCuenta(Integer p_nroCuenta) {
		String query = "FROM Cuenta WHERE nroCuenta= ?";
		Object[] queryParam = {p_nroCuenta};
		
		return (List<Object[]>) this.hibernateTemplate.find(query, queryParam);
	}
	
	//Consultar atributos especificos de una cuenta especifica
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Object[]> obtenerCuentaAtributo(Integer p_nroCuenta) {
		String query = "SELECT c.nroCuenta, c.alias, c.moneda FROM Cuenta c WHERE nroCuenta= ?";
		Object[] queryParam = {p_nroCuenta};
		
		return (List<Object[]>) this.hibernateTemplate.find(query, queryParam);
	}
}