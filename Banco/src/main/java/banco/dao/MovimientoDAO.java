package banco.dao;

import java.util.List;

import banco.model.Movimiento;

public interface MovimientoDAO 
{
	public List<Movimiento> listMovimientos();
	public Movimiento obtenerMovimiento(int id);
}
