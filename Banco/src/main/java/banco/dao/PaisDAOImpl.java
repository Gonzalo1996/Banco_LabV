package banco.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import banco.model.Pais;

@Repository
public class PaisDAOImpl implements PaisDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(PaisDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> listPais() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Pais> paisList = session.createQuery("FROM Pais").list();

		for (Pais p : paisList) {
			logger.info("Pais List::" + p);
		}
		return paisList;	
	}
	
	@Override
	public Pais obtenerPais(int p_id) {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "FROM Pais as p WHERE p.id = :p_id";
		Query query = session.createQuery(q);
		query.setParameter("p_id", p_id);
		Pais p = (Pais)query.uniqueResult();
		return p;
	}

}
