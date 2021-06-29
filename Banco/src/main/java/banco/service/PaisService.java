package banco.service;

import java.util.List;

import banco.model.Pais;;

public interface PaisService 
{
	public List<Pais> listPais();
	public Pais obtenerPais(int p_id);
}
