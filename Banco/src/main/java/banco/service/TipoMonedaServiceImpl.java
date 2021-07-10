package banco.service;

import org.springframework.stereotype.Service;

import banco.dao.TipoMonedaDAO;
import banco.model.TipoMoneda;

@Service
public class TipoMonedaServiceImpl implements TipoMonedaService{
	private TipoMonedaDAO tipoMoneda;

	public void setTipoMoneda(TipoMonedaDAO tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	@Override
	public TipoMoneda obtenerTipoMoneda(Integer id) {
		return tipoMoneda.obtenerTipoMoneda(id);
	}
}
