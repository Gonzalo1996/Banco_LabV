package banco.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import banco.model.TipoMoneda;

@Repository
public class TipoMonedaDAOImpl implements TipoMonedaDAO{

	private static final Logger logger = LoggerFactory.getLogger(GeneroDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public TipoMoneda obtenerTipoMoneda(Integer id) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "FROM TipoMoneda as t WHERE t.id = :id";
		Query query = session.createQuery(q);
		query.setParameter("id", id);
		TipoMoneda t = (TipoMoneda)query.uniqueResult();
		session.close();
		return t;
	}
}
