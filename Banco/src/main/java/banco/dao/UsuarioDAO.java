package banco.dao;

import java.util.List;

import banco.model.Usuario;

public interface UsuarioDAO 
{
	public List<Usuario> listUsuarios();
	public Usuario obtenerUsuario(int idUsuario);
	public int actualizarEstado(int idUsuario, Boolean estado);
}
