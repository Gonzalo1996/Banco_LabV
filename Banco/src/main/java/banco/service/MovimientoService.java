package banco.service;

import java.util.List;

import banco.model.Movimiento;

public interface MovimientoService 
{
	public List<Movimiento> listMovimientos();
	public Movimiento obtenerMovimiento(int id);
}
