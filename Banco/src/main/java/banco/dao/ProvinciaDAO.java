package banco.dao;

import java.util.List;

import banco.model.Provincia;

public interface ProvinciaDAO {
	public List<Provincia> listProvincias();
	public List<Provincia> listProvincias_x_Pais(int pais);
	public Provincia obtenerProvincia(int p_id);
}
