package banco.dao;

import java.util.List;

import banco.model.Pais;

public interface PaisDAO {
	public List<Pais> listPais();
	public Pais obtenerPais(int p_id);

}
