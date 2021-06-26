package servicio;
import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.PaisDao;
import dominio.Pais;

public class PaisServicio {
	
	private PaisDao dataAccess = null;

	public void setDataAccess(PaisDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	public ArrayList<Pais> obtenerPaises(){
		return dataAccess.obtenerPaises();
	}

	public Pais obtenerPais(Integer id) {
		return dataAccess.obtenerPais(id);
	}
}


