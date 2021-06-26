package servicio;

import java.util.ArrayList;

import dao.LocalidadDao;
import dominio.Localidad;

public class LocalidadServicio {

	private LocalidadDao dataAccess = null;
	
	public void setDataAccess(LocalidadDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	public ArrayList<Localidad> obtenerLocalidades() {
		return dataAccess.obtenerLocalidades();
	}
	
	public Localidad obtenerLocalidad(Integer id) {
		return dataAccess.obtenerLocalidad(id);
	}
	
	public ArrayList<Localidad> obtenerLocalidades_x_Provincias(int id){
		return dataAccess.obtenerLocalidades_x_Provincia(id);
	}
}
