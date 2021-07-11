package banco.service;

import java.util.List;

import banco.model.Cuenta;
import banco.model.Movimiento;

public interface MovimientoService 
{
	public List<Movimiento> listMovimientos();
	public Movimiento obtenerMovimiento(int id);
	
	public List<Movimiento> obtenerMovimientos_x_nroCuenta(Integer nroCuenta);
	public void guardar(Movimiento movimiento);
	
	public void guardarSaldoInicial(Cuenta c);
	public void guardarTransferenciaOtros(Integer nroCuenta, String cbu, Double monto, String detalle) throws Exception;
	public void guardarTransferenciaPropias(Integer nroCuentaOrigen, Integer nroCuentaDestino, Double monto, String detalle) throws Exception;
}
