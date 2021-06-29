package banco.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import banco.dao.LocalidadDAO;
import banco.model.Localidad;

@Service
public class LocalidadServiceImpl implements LocalidadService{

	private LocalidadDAO localidadDao;

	public void setLocalidadDao(LocalidadDAO localidadDao) {
		this.localidadDao = localidadDao;
	}
	
	@Override
	@Transactional
	public List<Localidad> listLocalidades() {
		return localidadDao.listLocalidades();
	}

	@Override
	@Transactional
	public List<Localidad> listLocalidades_x_Prov(int prov) {
		return localidadDao.listLocalidades_x_Prov(prov);
	}

	@Override
	@Transactional
	public Localidad obtenerLocalidad(int l_id) {
		return localidadDao.obtenerLocalidad(l_id);
	}

}
