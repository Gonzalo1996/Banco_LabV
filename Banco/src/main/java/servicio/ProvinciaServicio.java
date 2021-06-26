package servicio;

import java.util.ArrayList;
import java.util.List;

import dao.ProvinciaDao;
import dominio.Provincia;

public class ProvinciaServicio {

	private ProvinciaDao dataAccess = null;
	
	public void setDataAccess(ProvinciaDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	public ArrayList<Provincia> obtenerProvincias() {
		return dataAccess.obtenerProvincias();
	}
	
	public Provincia obtenerProvincia(Integer id) {
		return dataAccess.obtenerProvincia(id);
	}
	
	public ArrayList<Provincia> obtenerProvincias_x_Pais(int id){
		return dataAccess.obtenerProvincias_x_Pais(id);
	}
}