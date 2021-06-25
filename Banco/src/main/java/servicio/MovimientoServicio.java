package servicio;

import java.util.ArrayList;
import java.util.List;

import dao.MovimientoDao;
import dominio.Movimiento;

public class MovimientoServicio {

	private MovimientoDao dataAccess = null;
	
	public void setDataAccess(MovimientoDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	public void insertarMovimiento(Movimiento movimiento) {
		 dataAccess.insertarMovimiento(movimiento);;
	}
	
	public ArrayList<Movimiento> obtenerMovimientos() {
		return dataAccess.obtenerMovimientos();
	}
	
	public List<Object[]> obtenerMovimientosAtributos(){
		return dataAccess.obtenerMovimientosAtributos();
	}
	
	public Movimiento obtenerMovimientoPorId(Integer id){
		return dataAccess.obtenerMovimientoPorId(id);
	}
	
	public List<Object[]> obtenerMovimientoAtributo(int id){
		return dataAccess.obtenerMovimientoAtributo(id);
	}
	
	public ArrayList<Object[]> obtenerMovimientoPorCuenta(Integer nroCuenta) {
		return dataAccess.obtenerMovimientoPorCuenta(nroCuenta);
	}
	
	public void actualizarDetalleMovimiento(Integer id, String detalle) {
		dataAccess.actualizarDetalleMovimiento(id, detalle);
	}
}
