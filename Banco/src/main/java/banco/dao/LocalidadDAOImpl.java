package banco.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import banco.model.Localidad;

@Repository
public class LocalidadDAOImpl implements LocalidadDAO{

	private static final Logger logger = LoggerFactory.getLogger(LocalidadDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Localidad> listLocalidades() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Localidad> localidadList = session.createQuery("FROM Localidad").list();

		for (Localidad l : localidadList) {
			logger.info("Localidad List::" + l);
		}
		return localidadList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Localidad> listLocalidades_x_Prov(int prov) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Localidad> LocalidadList = session.createQuery("FROM Localidad WHERE idProvincia = " + prov).list();

		for (Localidad l : LocalidadList) {
			logger.info("Localidad List::" + l);
		}
		return LocalidadList;
	}

	@Override
	public Localidad obtenerLocalidad(int l_id) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Localidad as p WHERE p.id = :l_id";
		Query query = session.createQuery(hql);
		query.setParameter("l_id", l_id);
		Localidad l = (Localidad)query.uniqueResult();
		return l;
	}

}
