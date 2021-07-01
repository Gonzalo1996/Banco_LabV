package banco.service;

import java.util.List;

import banco.model.Usuario;

public interface UsuarioService 
{
	public List<Usuario> listUsuarios();
	public Usuario obtenerUsuario(int idUsuario);
	public List<Object[]> obtenerUsuarioLogin(String nombreUsuario, Integer dni, String contrasenia);
	public int actualizarEstado(int idUsuario, Boolean estado);
}
