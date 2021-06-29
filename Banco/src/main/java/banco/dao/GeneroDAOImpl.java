package banco.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import banco.model.Genero;

@Repository
public class GeneroDAOImpl implements GeneroDAO {

	private static final Logger logger = LoggerFactory.getLogger(GeneroDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Genero> listGeneros() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Genero> generoList = session.createQuery("from Genero").list();

		for (Genero p : generoList) {
			logger.info("Genero List::" + p);
		}
		return generoList;
	}

	@Override
	public Genero obtenerGenero(int p_id) {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "FROM Genero as g WHERE g.id = :p_id";
		Query query = session.createQuery(q);
		query.setParameter("p_id", p_id);
		Genero g = (Genero)query.uniqueResult();
		return g;
	}

}
