package banco.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import banco.dao.PaisDAO;
import banco.model.Pais;

@Service
public class PaisServiceImpl implements PaisService{
	
	private PaisDAO paisDao;

	public void setPaisDao(PaisDAO paisDao) {
		this.paisDao = paisDao;
	}

	@Override
	@Transactional
	public List<Pais> listPais() {
		return paisDao.listPais();
	}

	@Override
	@Transactional
	public Pais obtenerPais(int p_id) {
		return paisDao.obtenerPais(p_id);
	}

}
