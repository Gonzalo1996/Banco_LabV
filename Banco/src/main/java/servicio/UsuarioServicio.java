package servicio;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
	
	public void insertarUsuario(Usuario usuario) {
		 dataAccess.insertarUsuario(usuario);
	}

	public Usuario obtenerUsuarioPorId(Integer id) {
		return dataAccess.obtenerUsuarioPorId(id);
	}
	
	public void actualizarEstadoUsuario(Integer idUsuario, Boolean estado) {
		dataAccess.actualizarEstadoUsuario(idUsuario, estado);
	}
}
