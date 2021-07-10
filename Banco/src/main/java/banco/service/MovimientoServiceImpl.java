package banco.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import banco.dao.MovimientoDAO;
import banco.model.Cuenta;
import banco.model.Movimiento;

@Service
public class MovimientoServiceImpl implements MovimientoService{
	
	private MovimientoDAO movimientoDao;
	@Autowired private CuentaService cuentaService;

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
	public List<Movimiento> obtenerMovimientos_x_nroCuenta(Integer nroCuenta) {
		return movimientoDao.obtenerMovimientos_x_nroCuenta(nroCuenta);
	}
	
	@Override
	public void guardar(Movimiento movimiento) {
		movimientoDao.guardar(movimiento);
	}

	@Override
	@Transactional
	public void guardarTransferenciaOtros(Integer nroCuenta, String cbu, Double monto) throws Exception {
		Cuenta cuentaOrigen = this.cuentaService.obtenerCuenta(nroCuenta);
		Cuenta cuentaDestino = this.cuentaService.obtenerPorCbu(cbu);
		
		if (cuentaOrigen == null)
			throw new Exception("La cuenta origen no existe o no se encuentra activa.");

		Double saldoOrigen = cuentaOrigen.getSaldo() - monto;
		
		if (cuentaDestino == null || !cuentaDestino.getEstado())
			throw new Exception("El CBU ingresado no pertenece a ninguna cuenta activa.");
		
		if (cuentaOrigen.getNroCuenta() == cuentaDestino.getNroCuenta())
			throw new Exception("No se puede realizar una transferencia a la misma cuenta.");

		Double saldoDestino = cuentaDestino.getSaldo() + monto;
		
		if (monto <= 0)
			throw new Exception("El monto ingresado no es válido.");
		if (saldoOrigen < 0)
			throw new Exception("La cuenta no posee los fondos suficientes para realizar esta transferencia.");

		Movimiento movOrigen = new Movimiento(-monto, saldoOrigen, new Date(), "Falta poner detalle", cuentaOrigen);
		Movimiento movDestino = new Movimiento(monto, saldoDestino, new Date(), "Falta poner detalle", cuentaDestino);

		cuentaOrigen.setSaldo(saldoOrigen);
		cuentaDestino.setSaldo(saldoDestino);

		this.cuentaService.actualizarCuenta(cuentaOrigen);
		this.cuentaService.actualizarCuenta(cuentaDestino);
		this.guardar(movOrigen);
		this.guardar(movDestino);
	}

	@Override
	@Transactional
	public void guardarTransferenciaPropias(Integer nroCuentaOrigen, Integer nroCuentaDestino, Double monto) throws Exception {
		Cuenta cuentaOrigen = this.cuentaService.obtenerCuenta(nroCuentaOrigen);
		Cuenta cuentaDestino = this.cuentaService.obtenerCuenta(nroCuentaDestino);
		
		if (cuentaOrigen == null || !cuentaOrigen.getEstado())
			throw new Exception("La cuenta origen no existe o no se encuentra activa.");

		Double saldoOrigen = cuentaOrigen.getSaldo() - monto;
		
		if (cuentaDestino == null || !cuentaDestino.getEstado())
			throw new Exception("La cuenta destino no existe o no se encuentra activa.");
		
		if (cuentaOrigen.getNroCuenta() == cuentaDestino.getNroCuenta())
			throw new Exception("No se puede realizar una transferencia a la misma cuenta.");

		Double saldoDestino = cuentaDestino.getSaldo() + monto;
		
		if (monto <= 0)
			throw new Exception("El monto ingresado no es válido.");
		if (saldoOrigen < 0)
			throw new Exception("La cuenta no posee los fondos suficiente para realizar esta transferencia.");

		Movimiento movOrigen = new Movimiento(-monto, saldoOrigen, new Date(), "Falta poner detalle", cuentaOrigen);
		Movimiento movDestino = new Movimiento(monto, saldoDestino, new Date(), "Falta poner detalle", cuentaDestino);

		cuentaOrigen.setSaldo(saldoOrigen);
		cuentaDestino.setSaldo(saldoDestino);

		this.cuentaService.actualizarCuenta(cuentaOrigen);
		this.cuentaService.actualizarCuenta(cuentaDestino);
		this.guardar(movOrigen);
		this.guardar(movDestino);		
	}
}