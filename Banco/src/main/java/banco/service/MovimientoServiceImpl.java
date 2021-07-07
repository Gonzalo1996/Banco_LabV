package banco.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import banco.dao.MovimientoDAO;
import banco.model.Movimiento;

@Service
public class MovimientoServiceImpl implements MovimientoService{
	
	private MovimientoDAO movimientoDao;

	public void setMovimientoDao(MovimientoDAO movimientoDao) {
		this.movimientoDao = movimientoDao;
	}

	@Override
	@Transactional
	public List<Movimiento> listMovimientos() {
		return movimientoDao.listMovimientos();
	}

	@Override
	@Transactional
	public Movimiento obtenerMovimiento(int id) {
		return movimientoDao.obtenerMovimiento(id);
	}

	@Override
	@Transactional
	public List<Movimiento> obtenerMovimientos_x_nroCuenta(Integer nroCuenta) {
		return movimientoDao.obtenerMovimientos_x_nroCuenta(nroCuenta);
	}
}