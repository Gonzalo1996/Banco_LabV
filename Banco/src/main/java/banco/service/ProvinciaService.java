package banco.service;

import java.util.List;

import banco.model.Provincia;

public interface ProvinciaService {
	
	public List<Provincia> listProvincias();
	public Provincia obtenerProvincia(int p_id);
}
