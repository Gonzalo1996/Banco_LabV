package banco.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

import banco.model.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO{

	private static final Logger logger = LoggerFactory.getLogger(GeneroDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listClientes() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		List<Cliente> clienteList = session.createQuery("FROM Cliente").list();

		for (Cliente c : clienteList) {
			logger.info("Cliente List::" + c);
		}
		session.close();
		return clienteList;
	}

	@Override
	public Cliente obtenerCliente(int p_dni) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "FROM Cliente as c WHERE c.dni = :p_dni";
		Query query = session.createQuery(q);
		query.setParameter("p_dni", p_dni);
		Cliente c = (Cliente)query.uniqueResult();
		session.close();
		return c;
	}

	@Override
	public int modificarCliente(Integer dni, String nombre, String apellido, Date fecha, String correo, String direccion,
		Integer pais, Integer provincia, Integer localidad) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "UPDATE Cliente c set c.nombre = :nombre, c.apellido = :apellido, c.fechaNacimiento = :fecha, c.correo= :correo, "
				+ "c.direccion = :direccion, c.pais.id = :pais, c.provincia.id = :provincia, c.localidad.id = :localidad"
				+ " WHERE c.dni = :dni";

		Query query = session.createQuery(q);
		query.setParameter("dni", dni);
		query.setParameter("nombre", nombre);
		query.setParameter("apellido", apellido);
		query.setParameter("fecha", fecha);
		query.setParameter("correo", correo);
		query.setParameter("direccion", direccion);
		query.setParameter("pais", pais);
		query.setParameter("provincia", provincia);
		query.setParameter("localidad", localidad);
		
		int execute = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return execute;		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> FiltradoClientes(Integer provincia, Integer localidad) {
		Session session = this.sessionFactory.openSession();
		String hql = "SELECT c FROM Cliente as c JOIN c.localidad JOIN c.provincia WHERE c.localidad.id = :localidad AND c.provincia.id= :provincia";
		Query query = session.createQuery(hql);
		query.setParameter("provincia", provincia);
		query.setParameter("localidad", localidad);
		List<Cliente> lista = (List<Cliente>)query.list();
		session.close();
		return lista;
	}
	
}
