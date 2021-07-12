package banco.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.hibernate.Query;

import banco.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

	private static final Logger logger = LoggerFactory.getLogger(GeneroDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listUsuarios() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		List<Usuario> usuarioList = session.createQuery("FROM Usuario").list();

		for (Usuario p : usuarioList) {
			logger.info("Usuario List::" + p);
		}
		session.close();
		return usuarioList;
	}

	@Override
	public Usuario obtenerUsuario(int p_id) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		String q = "FROM Usuario as u WHERE u.idUsuario = :p_id";
		Query query = session.createQuery(q);
		query.setParameter("p_id", p_id);
		Usuario u = (Usuario)query.uniqueResult();
		session.close();
		return u;
	}
	
	@Override
	public int actualizarEstado(int p_idUsuario, Boolean p_estado) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		String q = "UPDATE Usuario set estado = :p_estado WHERE idUsuario= :p_idUsuario";
		Query query = session.createQuery(q);
		query.setParameter("p_idUsuario", p_idUsuario);
		query.setParameter("p_estado", p_estado);
		int execute = query.executeUpdate();
		session.close();
		return execute;
	}

	@Override
	public Usuario obtenerUsuarioLogin(String nombreUsuario, Integer dni, String contrasenia) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "SELECT u"
				+ " FROM Usuario as u JOIN u.cliente JOIN u.tipoUsuario "
				+ "WHERE u.cliente.dni = :dni AND u.contrasenia = :contrasenia AND u.nombreUsuario= :nombreUsuario";
		Query query = session.createQuery(q);
		query.setParameter("nombreUsuario", nombreUsuario);
		query.setParameter("dni", dni);
		query.setParameter("contrasenia", contrasenia);

		Usuario u = (Usuario)query.uniqueResult();
		
		session.close();
		return u;
	}
	
	@Override
	public void guardarUsuario(Usuario usuario) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(usuario);
		
		logger.info("Usuario saved successfully, Usuario Details="+ usuario);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Boolean estadoUsuario(Integer dni) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "SELECT u.estado FROM Usuario u INNER JOIN u.cliente WHERE u.cliente.dni= :dni";
		Query query = session.createQuery(q);
		query.setParameter("dni", dni);
		Boolean estado = (Boolean)query.uniqueResult();
		session.close();
		return estado;
	}
	
	@Override
	public Usuario obtenerPorDni(int dni) {
		Session session = this.sessionFactory.openSession();

		String q = "SELECT u FROM Usuario as u JOIN u.cliente WHERE u.cliente.dni = :dni";
		Query query = session.createQuery(q);
		query.setParameter("dni", dni);
		
		Usuario u = (Usuario)query.uniqueResult();

		session.close();
		return u;
	}
	
	@Override
	public Usuario obtenerPorCorreo(String correo){
		Session session = this.sessionFactory.openSession();

		String q = "SELECT u FROM Usuario as u JOIN u.cliente WHERE u.cliente.correo = :correo";
		Query query = session.createQuery(q);
		query.setParameter("correo", correo);
		
		Usuario u = (Usuario)query.uniqueResult();

		session.close();
		return u;
	}
	
	@Override
	public Usuario obtenerPorCuil(String cuil){
		Session session = this.sessionFactory.openSession();

		String q = "SELECT u FROM Usuario as u JOIN u.cliente WHERE u.cliente.cuil = :cuil";
		Query query = session.createQuery(q);
		query.setParameter("cuil", cuil);
		
		Usuario u = (Usuario)query.uniqueResult();

		session.close();
		return u;
	}
	
	@Override
	public int bajaUsuario(Integer dni) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		String q = "UPDATE Usuario u set u.estado = false WHERE u.cliente.dni= :dni";
		Query query = session.createQuery(q);
		query.setParameter("dni", dni);
		int execute = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return execute;
	}

	@Override
	public int actualizarUsuario(int dni, Boolean estado, String contrasenia) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		String q = "UPDATE Usuario u set u.estado = :estado, u.contrasenia = :contrasenia WHERE u.cliente.dni= :dni";
		Query query = session.createQuery(q);
		query.setParameter("dni", dni);
		query.setParameter("estado", estado);
		query.setParameter("contrasenia", contrasenia);

		int execute = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return execute;
	}
}