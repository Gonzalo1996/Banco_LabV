package banco.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import banco.model.Provincia;

@Repository
public class ProvinciaDAOImpl implements ProvinciaDAO{

	private static final Logger logger = LoggerFactory.getLogger(ProvinciaDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	//Obtengo todas las Provincias
	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> listProvincias() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "FROM Provincia p ORDER BY p.nombre";
		List<Provincia> provinciaList = session.createQuery(q).list();

		for (Provincia p : provinciaList) {
			logger.info("Provincia List::" + p);
		}
		session.close();
		return provinciaList;
	}
	
	//Obtengo una Provincia en particular
	@Override
	public Provincia obtenerProvincia(int p_id) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		String hql = "FROM Provincia as p WHERE p.id = :p_id";
		Query query = session.createQuery(hql);
		query.setParameter("p_id", p_id);
		Provincia p = (Provincia)query.uniqueResult();
		session.close();
		return p;
	}

}
