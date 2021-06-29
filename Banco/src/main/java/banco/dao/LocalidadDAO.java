package banco.dao;

import java.util.List;

import banco.model.Localidad;

public interface LocalidadDAO {

	public List<Localidad> listLocalidades();
	public List<Localidad> listLocalidades_x_Prov(int prov);
	public Localidad obtenerLocalidad(int l_id);
}
