package servicio;

import java.util.ArrayList;

import dao.GeneroDao;
import dominio.Genero;

public class GeneroServicio {

	
	private GeneroDao dataAccess = null;

	public void setDataAccess(GeneroDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	
	public ArrayList<Genero> obtenerGenero() {
		return dataAccess.obtenerGenero();
	}
	
	
	public  Genero obtenerGenero(Integer nroGenero) {
		return dataAccess.obtenerGenero(nroGenero);
	} 
	
}