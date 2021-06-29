package banco.dao;

import java.util.List;
import banco.model.Cuenta;

public interface CuentaDAO 
{
	public List<Cuenta> listCuentas();
	public Cuenta obtenerCuenta(int nroCuenta);
}
