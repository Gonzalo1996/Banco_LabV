package banco.dao;

import java.util.List;
import banco.model.Cuenta;

public interface CuentaDAO 
{
	public List<Cuenta> listCuentas();
	public Cuenta obtenerCuenta(int nroCuenta);
	public Cuenta obtenerPorCbu(String cbu);
	public Cuenta obtenerPorAlias(String cbu);
	public void guardarCuenta(Cuenta cuenta);
	public void actualizarCuenta(Cuenta cuenta);
	public Long obtenerCantidadCuentas(Integer dni);
	public int bajaCuenta(Integer nroCuenta);
	public int modificarCuenta(Integer nroCuenta, String alias, String nombre, Integer dni, Boolean estado);
	public List<Cuenta> obtenerCuentasPorCliente(Integer dni);
	public Long obtenerCantCuentas_sinContarBajas(Integer dni);
}
