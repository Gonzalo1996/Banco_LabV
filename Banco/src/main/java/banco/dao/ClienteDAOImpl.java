package banco.dao;

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
		Session session = this.sessionFactory.getCurrentSession();
		List<Cliente> clienteList = session.createQuery("FROM Cliente").list();

		for (Cliente c : clienteList) {
			logger.info("Cliente List::" + c);
		}
		return clienteList;
	}

	@Override
	public Cliente obtenerCliente(int p_dni) {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "FROM Cliente as c WHERE c.dni = :p_dni";
		Query query = session.createQuery(q);
		query.setParameter("p_dni", p_dni);
		Cliente c = (Cliente)query.uniqueResult();
		return c;
	}
}
