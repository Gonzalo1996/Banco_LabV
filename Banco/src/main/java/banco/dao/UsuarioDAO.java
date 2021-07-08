package banco.dao;

import java.util.List;

import banco.model.Usuario;

public interface UsuarioDAO 
{
	public List<Usuario> listUsuarios();
	public Usuario obtenerUsuario(int idUsuario);
	public Usuario obtenerUsuarioLogin(String nombreUsuario, Integer dni, String contrasenia);
	public int actualizarEstado(int idUsuario, Boolean estado);
	public int actualizarEstadoPorDni(int dni, Boolean estado);
	public Boolean estadoUsuario(Integer dni);
	public Usuario obtenerPorDni(int dni);
	public int bajaUsuario(Integer dni);
	public void guardarUsuario(Usuario usuario);
}
