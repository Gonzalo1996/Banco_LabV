package banco.dao;

import java.util.List;

import banco.model.Cuenta;
import banco.model.Movimiento;
import banco.model.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

@Repository
public class MovimientoDAOImpl implements MovimientoDAO{

	private static final Logger logger = LoggerFactory.getLogger(GeneroDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movimiento> listMovimientos() {
		Session session = this.sessionFactory.openSession();

		List<Movimiento> movimientoList = session.createQuery("FROM Movimiento").list();

		for (Movimiento p : movimientoList) {
			logger.info("Movimiento List::" + p);
		}
		session.close();
		return movimientoList;
	}

	@Override
	public Movimiento obtenerMovimiento(int p_id) {
		Session session = this.sessionFactory.openSession();

		String q = "FROM Movimiento as m WHERE m.id = :p_id";
		Query query = session.createQuery(q);
		query.setParameter("p_id", p_id);
		Movimiento m = (Movimiento)query.uniqueResult();
		session.close();
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movimiento> obtenerMovimientos_x_nroCuenta(Integer nroCuenta) {
		Session session = this.sessionFactory.openSession();

		String hql = "SELECT m FROM Movimiento as m JOIN m.cuenta WHERE m.cuenta.nroCuenta = :nroCuenta";
		Query query = session.createQuery(hql);
		query.setParameter("nroCuenta", nroCuenta);
		List<Movimiento> lista = (List<Movimiento>)query.list();
		session.close();
		return lista;
	}

	@Override
	public void guardar(Movimiento movimiento) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(movimiento);
		
		logger.info("Movimiento saved successfully, Movimiento Details="+ movimiento);
		session.getTransaction().commit();
		session.close();
	}
}