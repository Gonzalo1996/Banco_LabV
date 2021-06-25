package servicio;

import java.util.ArrayList;

import dao.UsuarioDao;
import dominio.Usuario;

public class UsuarioServicio{

	private UsuarioDao dataAccess = null;

	public void setDataAccess(UsuarioDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	public ArrayList<Usuario> obtenerUsuarios() {
		return dataAccess.obtenerUsuarios();
	}

	public Usuario obtenerUnRegistro(String nombreUser) {
		return dataAccess.obtenerUsuarioPorNombre(nombreUser);
	}

	public void insertarUsuario(Usuario usuario) {
		 dataAccess.insertarUsuario(usuario);
	}

	public void eliminarUsuario(Integer idUser) {
		dataAccess.eliminarUsuario(idUser);
		
	}

	public void actualizarUsuario(Usuario usuario) {
		dataAccess.actualizarUsuario(usuario);
	}
}
