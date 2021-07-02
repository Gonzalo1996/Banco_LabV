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
		Session session = this.sessionFactory.getCurrentSession();
		List<Usuario> usuarioList = session.createQuery("FROM Usuario").list();

		for (Usuario p : usuarioList) {
			logger.info("Usuario List::" + p);
		}
		return usuarioList;
	}

	@Override
	public Usuario obtenerUsuario(int p_id) {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "FROM Usuario as u WHERE u.idUsuario = :p_id";
		Query query = session.createQuery(q);
		query.setParameter("p_id", p_id);
		Usuario u = (Usuario)query.uniqueResult();
		return u;
	}
	
	@Override
	public int actualizarEstado(int p_idUsuario, Boolean p_estado) {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "UPDATE Usuario set estado = :p_estado WHERE idUsuario= :p_idUsuario";
		Query query = session.createQuery(q);
		query.setParameter("p_idUsuario", p_idUsuario);
		query.setParameter("p_estado", p_estado);
		return query.executeUpdate();
	}

	@Override
	public List<Object[]> obtenerUsuarioLogin(String nombreUsuario, Integer dni, String contrasenia) {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "SELECT u.idUsuario, u.contrasenia, u.nombreUsuario, u.tipoUsuario.id, u.cliente.dni"
				+ " FROM Usuario as u INNER JOIN u.cliente INNER JOIN u.tipoUsuario "
				+ "WHERE u.cliente.dni = :dni AND u.contrasenia = :contrasenia AND u.nombreUsuario= :nombreUsuario";
		Query query = session.createQuery(q);
		query.setParameter("nombreUsuario", nombreUsuario);
		query.setParameter("dni", dni);
		query.setParameter("contrasenia", contrasenia);
		return (List<Object[]>)query.list();
	}
	
	@Override
	public void guardarUsuario(Usuario usuario) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(usuario);
		logger.info("Usuario saved successfully, Usuario Details="+ usuario);
	}
}