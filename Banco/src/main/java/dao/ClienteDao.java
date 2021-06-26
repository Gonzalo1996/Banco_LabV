package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dominio.Cliente;



public class ClienteDao {
	
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarCliente(Cliente cliente) {
		this.hibernateTemplate.save(cliente);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Cliente obtenerCliente(Integer dni) {
		return this.hibernateTemplate.get(Cliente.class, dni);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Cliente> obtenerClientes() {
		String query = "FROM Cliente";
		return (ArrayList<Cliente>) this.hibernateTemplate.find(query);
	}

	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Object[]> obtenerClienteAtributos(Integer dni) {
		String query = "SELECT c.dni, c.nombre, c.apellido FROM Cliente c WHERE dni= ?";
		Object[] queryParam = {dni};
		
		return (List<Object[]>) this.hibernateTemplate.find(query, queryParam);
	}
	
}
