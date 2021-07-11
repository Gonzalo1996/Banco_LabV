package banco.service;

import org.springframework.stereotype.Service;

import banco.dao.TipoUsuarioDAO;
import banco.model.TipoUsuario;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService{

	private TipoUsuarioDAO tipoUsuario;
	
	public void setTipoUsuario(TipoUsuarioDAO tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public TipoUsuario obtenerTipoUsuario(Integer id) {
		return tipoUsuario.obtenerTipoUsuario(id);
	}
}
