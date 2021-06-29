package banco.dao;

import java.util.List;
import banco.model.Genero;

public interface GeneroDAO {
	public List<Genero> listGeneros();
	public Genero obtenerGenero(int id);
}
