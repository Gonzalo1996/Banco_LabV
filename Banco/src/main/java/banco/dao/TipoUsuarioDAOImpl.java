package banco.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import banco.model.TipoMoneda;
import banco.model.TipoUsuario;

@Repository
public class TipoUsuarioDAOImpl implements TipoUsuarioDAO{

	private static final Logger logger = LoggerFactory.getLogger(TipoUsuarioDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public TipoUsuario obtenerTipoUsuario(Integer id) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "FROM TipoUsuario as t WHERE t.id = :id";
		Query query = session.createQuery(q);
		query.setParameter("id", id);
		TipoUsuario t = (TipoUsuario)query.uniqueResult();
		session.close();
		return t;
	}
}
