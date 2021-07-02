package banco.dao;

import java.util.List;

import banco.model.Usuario;

public interface UsuarioDAO 
{
	public List<Usuario> listUsuarios();
	public Usuario obtenerUsuario(int idUsuario);
	public List<Object[]> obtenerUsuarioLogin(String nombreUsuario, Integer dni, String contrasenia);
	public int actualizarEstado(int idUsuario, Boolean estado);
	
	public void guardarUsuario(Usuario usuario);
}
