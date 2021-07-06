package banco.service;
import java.util.List;

import banco.model.Cuenta;

public interface CuentaService 
{
	public List<Cuenta> listCuentas();
	public Cuenta obtenerCuenta(int nroCuenta);
	public void guardarCuenta(Cuenta cuenta, int dni, String cbu, String alias) throws Exception;
	public Long obtenerCantidadCuentas(Integer dni);
	public Cuenta obtenerPorCbu(String cbu);
	public Cuenta obtenerPorAlias(String alias);

}
