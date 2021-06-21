package dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dominio.Usuario;

public class UsuarioDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarUsuario(Usuario usuario) {
		this.hibernateTemplate.save(usuario);
		
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Usuario obtenerUsuarioPorNombre(String nombreUser) {
		return this.hibernateTemplate.get(Usuario.class, nombreUser);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Usuario> obtenerUsuarios() {
		return (ArrayList<Usuario>) this.hibernateTemplate.loadAll(Usuario.class);
	}

	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminarUsuario(Integer idUsuario) {
		Usuario user = new Usuario();
		user.setIdUsuario(idUsuario);
		this.hibernateTemplate.delete(user);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizarUsuario(Usuario persona) {
		this.hibernateTemplate.update(persona);
	}
}
