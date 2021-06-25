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
	public ArrayList<Usuario> obtenerUsuarios() {
		return (ArrayList<Usuario>) this.hibernateTemplate.loadAll(Usuario.class);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Usuario obtenerUsuarioPorId(Integer id) {
		return this.hibernateTemplate.get(Usuario.class, id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void actualizarEstadoUsuario(Integer idUsuario, Boolean estado) {
		Usuario user = obtenerUsuarioPorId(idUsuario);
		user.setEstado(estado);
		this.hibernateTemplate.update(user);
	}
}