package servicio;

import java.util.ArrayList;
import java.util.List;

import dao.CuentaDao;
import dominio.Cuenta;

public class CuentaServicio {
	
	private CuentaDao dataAccess = null;
	
	public void setDataAccess(CuentaDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	public void insertarCuenta(Cuenta cuenta) {
		 dataAccess.insertarCuenta(cuenta);
	}
	
	public ArrayList<Cuenta> obtenerCuentas() {
		return dataAccess.obtenerCuentas();
	}
	
	public List<Object[]> obtenerCuentasAtributos() {
		return dataAccess.obtenerCuentasAtributos();
	}
	
	public  Cuenta obtenerCuenta(Integer nroCuenta) {
		return dataAccess.obtenerCuenta(nroCuenta);
	}
	
	public List<Object[]> obtenerCuentaAtributo(Integer nroCuenta){
		return dataAccess.obtenerCuentaAtributo(nroCuenta);
	}
	
	public List<Object[]> obtenerCuentasPorCliente(Integer dni) {
		return dataAccess.obtenerCuentasPorCliente(dni);
	}
	
	public ArrayList<Cuenta> obtenerCuentasPorTipo(Integer moneda) { 
		return (ArrayList<Cuenta>) dataAccess.obtenerCuentasPorTipo(moneda);
	}
	
	public void actualizarEstadoCuenta(Integer nroCuenta, Boolean estado) {
		dataAccess.actualizarEstadoCuenta(nroCuenta, estado);
	}
	
	public void actualizarAlias(Integer nroCuenta, String alias) {
		dataAccess.actualizarAlias(nroCuenta, alias);
	}
}
