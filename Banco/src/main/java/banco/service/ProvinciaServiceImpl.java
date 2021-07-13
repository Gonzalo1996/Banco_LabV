package banco.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import banco.dao.ProvinciaDAO;
import banco.model.Provincia;

@Service
public class ProvinciaServiceImpl implements ProvinciaService{

	private ProvinciaDAO provinciaDao;

	public void setProvinciaDao(ProvinciaDAO provinciaDao) {
		this.provinciaDao = provinciaDao;
	}

	
	@Override
	@Transactional
	public List<Provincia> listProvincias() {
		return provinciaDao.listProvincias();
	}

	@Override
	@Transactional
	public Provincia obtenerProvincia(int p_id) {
		return provinciaDao.obtenerProvincia(p_id);
	}

}
