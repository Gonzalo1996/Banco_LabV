package banco.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import banco.dao.UsuarioDAO;
import banco.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioDAO usuarioDao;
	
	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	@Transactional
	public List<Usuario> listUsuarios() {
		return usuarioDao.listUsuarios();
	}

	@Override
	@Transactional
	public Usuario obtenerUsuario(int idUsuario) {
		return usuarioDao.obtenerUsuario(idUsuario);
	}

	@Override
	@Transactional
	public int actualizarEstado(int idUsuario, Boolean estado) {
		return usuarioDao.actualizarEstado(idUsuario, estado);
	}

	@Override
	@Transactional
	public Usuario obtenerUsuarioLogin(String nombreUsuario, Integer dni, String contrasenia) throws Exception {
		Usuario u = usuarioDao.obtenerUsuarioLogin(nombreUsuario, dni, contrasenia);
		if (u == null)
			throw new Exception("Usuario o contraseņa incorrecta");
		
		if(u.getEstado() == false)
			throw new Exception("Usuario deshabilitado");
		
		return u;
	}
	
	@Override
	@Transactional
	public void guardarUsuario(Usuario usuario, Integer dni, String correo, String cuil) throws Exception {
		
		if(obtenerPorDni(dni) != null)
			throw new Exception("DNI ya registrado");
		
		if(obtenerPorCorreo(correo) != null)
			throw new Exception("Correo ya registrado");
		
		if(obtenerPorCuil(cuil) != null)
			throw new Exception("CUIL ya registrado");

		usuarioDao.guardarUsuario(usuario);	
	}

	@Override
	@Transactional
	public Boolean estadoUsuario(Integer dni) {
		return usuarioDao.estadoUsuario(dni);
	}
	
	@Override
	@Transactional
	public Usuario obtenerPorDni(int dni) {
		return usuarioDao.obtenerPorDni(dni);
	}

	@Override
	@Transactional
	public int bajaUsuario(Integer dni) {
		return usuarioDao.bajaUsuario(dni);
	}

	@Override
	public int actualizarUsuario(int dni, Boolean estado, String contrasenia, String nombreUsuario) {
		return usuarioDao.actualizarUsuario(dni, estado, contrasenia, nombreUsuario);
	}

	@Override
	public Usuario obtenerPorCorreo(String correo) {
		return usuarioDao.obtenerPorCorreo(correo);
	}

	@Override
	public Usuario obtenerPorCuil(String cuil) {
		return usuarioDao.obtenerPorCuil(cuil);
	}
}
