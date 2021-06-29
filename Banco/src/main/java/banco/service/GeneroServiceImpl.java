package banco.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import banco.dao.GeneroDAO;
import banco.model.Genero;

@Service
public class GeneroServiceImpl implements GeneroService{

	private GeneroDAO generoDao;

	public void setGeneroDao(GeneroDAO generoDao) {
		this.generoDao = generoDao;
	}

	@Override
	@Transactional
	public List<Genero> listGeneros() {
		return generoDao.listGeneros();
	}

}
