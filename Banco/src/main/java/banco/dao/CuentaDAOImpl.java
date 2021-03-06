package banco.dao;

import java.util.ArrayList;
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

	private static final Logger logger = LoggerFactory.getLogger(CuentaDAOImpl.class);

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

	@Override
	public void guardarCuenta(Cuenta cuenta) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(cuenta);
		
		logger.info("Cuenta saved successfully, Cuenta Details="+ cuenta);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override	
	public void actualizarCuenta(Cuenta cuenta) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(cuenta);
		
		logger.info("Cuenta saved successfully, Cuenta Details="+ cuenta);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Long obtenerCantidadCuentas(Integer dni) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "SELECT COUNT(1) FROM Cuenta c INNER JOIN c.cliente GROUP BY c.cliente.dni HAVING c.cliente.dni= :dni";
		Query query = session.createQuery(q);
		query.setParameter("dni", dni);
		Long cant = (Long)query.uniqueResult();
		if (cant == null)return (long) 0;
		session.close();
		return cant;
	}

	@Override
	public Cuenta obtenerPorCbu(String cbu) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "FROM Cuenta as c WHERE c.cbu = :cbu";
		Query query = session.createQuery(q);
		query.setParameter("cbu", cbu);
		Cuenta c = (Cuenta)query.uniqueResult();
		session.close();
		return c;
	}

	@Override
	public Cuenta obtenerPorAlias(String alias) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "FROM Cuenta as c WHERE c.alias = :alias";
		Query query = session.createQuery(q);
		query.setParameter("alias", alias);
		Cuenta c = (Cuenta)query.uniqueResult();
		session.close();
		return c;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cuenta> obtenerCuentasPorCliente(Integer c_dni) {
		Session session = this.sessionFactory.openSession();
		String hql = "SELECT c FROM Cuenta as c JOIN c.cliente WHERE c.cliente.dni = :c_dni AND c.estado = true";
		Query query = session.createQuery(hql);
		query.setParameter("c_dni", c_dni);
		List<Cuenta> lista = (List<Cuenta>)query.list();
		session.close();
		return lista;
	}

	@Override
	public Long obtenerCantCuentas_sinContarBajas(Integer dni) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "SELECT COUNT(1) FROM Cuenta c INNER JOIN c.cliente WHERE c.estado = true GROUP BY c.cliente.dni HAVING c.cliente.dni= :dni";
		Query query = session.createQuery(q);
		query.setParameter("dni", dni);
		Long cant = (Long)query.uniqueResult();
		if (cant == null)return (long) 0;
		session.close();
		return cant;
	}
	
	@Override
	public int bajaCuenta(Integer p_nroCuenta) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "UPDATE Cuenta c set c.estado = false WHERE c.nroCuenta= :p_nroCuenta";
		Query query = session.createQuery(q);
		query.setParameter("p_nroCuenta", p_nroCuenta);
		int execute = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return execute;
	}
	
	@Override
	public int bajaCuentaPorDni(Integer dni) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "UPDATE Cuenta c set c.estado = false WHERE c.cliente.dni= :dni";
		Query query = session.createQuery(q);
		query.setParameter("dni", dni);
		int execute = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return execute;
	}
	

	@Override
	public int modificarCuenta(Integer nroCuenta, String alias, String nombre, Integer dni, Boolean estado) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "UPDATE Cuenta c set c.alias = :alias, c.nombreCuenta = :nombre, c.cliente.dni= :dni, c.estado= :estado"
				+ " WHERE c.nroCuenta= :nroCuenta";
		Query query = session.createQuery(q);
		query.setParameter("nroCuenta", nroCuenta);
		query.setParameter("alias", alias);
		query.setParameter("nombre", nombre);
		query.setParameter("dni", dni);
		query.setParameter("estado", estado);
		int execute = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return execute;
	}
	
	@Override
	public List<Cuenta> FiltradoCuentas(Integer dni, Integer tipomoneda) {
		Session session = this.sessionFactory.openSession();
		String hql = "SELECT c FROM Cuenta as c JOIN c.cliente JOIN c.tipoMoneda WHERE c.cliente.dni = :dni AND c.tipoMoneda.id= :tipomoneda";
		Query query = session.createQuery(hql);
		query.setParameter("dni", dni);
		query.setParameter("tipomoneda", tipomoneda);

		List<Cuenta> lista = (List<Cuenta>)query.list();
		session.close();
		return lista;
	}
	
}
