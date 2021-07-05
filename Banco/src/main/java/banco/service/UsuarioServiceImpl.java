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
		
		return u;
	}
	
	@Override
	@Transactional
	public void guardarUsuario(Usuario usuario) {
		usuarioDao.guardarUsuario(usuario);	
	}

	@Override
	public Boolean estadoUsuario(Integer dni) {
		return usuarioDao.estadoUsuario(dni);
	}
	
	@Override
	public Usuario obtenerPorDni(int dni) {
		return usuarioDao.obtenerPorDni(dni);
	}
}
