package banco.service;
import java.util.List;

import banco.model.Cuenta;

public interface CuentaService 
{
	public List<Cuenta> listCuentas();
	public Cuenta obtenerCuenta(int nroCuenta);
	public void guardarCuenta(Cuenta cuenta, int dni, String cbu, String alias) throws Exception;
	public void actualizarCuenta(Cuenta cuenta);
	public Long obtenerCantidadCuentas(Integer dni);
	public Cuenta obtenerPorCbu(String cbu);
	public Cuenta obtenerPorAlias(String alias);
	public int bajaCuenta(Integer nroCuenta);
	public int modificarCuenta(Integer nroCuenta, String alias, String nombre, Integer dni, Boolean estado) throws Exception;
	public List<Cuenta> obtenerCuentasPorCliente(Integer dni);
	public Long obtenerCantCuentas_sinContarBajas(Integer dni);
}
