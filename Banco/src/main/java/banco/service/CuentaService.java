package banco.service;
import java.util.List;

import banco.model.Cuenta;

public interface CuentaService 
{
	public List<Cuenta> listCuentas();
	public Cuenta obtenerCuenta(int nroCuenta);
}