package banco.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

import banco.model.Cuenta;

@Repository
public class CuentaDAOImpl implements CuentaDAO{

	private static final Logger logger = LoggerFactory.getLogger(GeneroDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cuenta> listCuentas() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		List<Cuenta> cuentaLista = session.createQuery("FROM Cuenta").list();
		for (Cuenta c : cuentaLista) {
			logger.info("Cuenta List::" + c);
		}
		session.close();
		return cuentaLista;
	}

	@Override
	public Cuenta obtenerCuenta(int p_nroCuenta) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "FROM Cuenta as c WHERE c.nroCuenta = :p_nroCuenta";
		Query query = session.createQuery(q);
		query.setParameter("p_nroCuenta", p_nroCuenta);
		Cuenta c = (Cuenta)query.uniqueResult();
		session.close();
		return c;
	}

}
