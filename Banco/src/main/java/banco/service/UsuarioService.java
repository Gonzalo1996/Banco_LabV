package banco.service;

import java.util.List;

import banco.model.Usuario;

public interface UsuarioService 
{
	public List<Usuario> listUsuarios();
	public Usuario obtenerUsuario(int idUsuario);
	public Usuario obtenerUsuarioLogin(String nombreUsuario, Integer dni, String contrasenia) throws Exception;
	public int actualizarEstado(int idUsuario, Boolean estado);
	public int actualizarUsuario(int dni, Boolean estado, String contrasenia);
	public Boolean estadoUsuario(Integer dni);
	public void guardarUsuario(Usuario usuario, Integer dni, String correo, String cuil) throws Exception ;
	public Usuario obtenerPorDni(int dni);
	public Usuario obtenerPorCorreo(String correo);
	public Usuario obtenerPorCuil(String cuil);
	public int bajaUsuario(Integer dni);
}
