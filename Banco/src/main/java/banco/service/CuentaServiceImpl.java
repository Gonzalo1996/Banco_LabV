package banco.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import banco.dao.CuentaDAO;
import banco.model.Cuenta;

@Service
public class CuentaServiceImpl implements CuentaService{
	
	private CuentaDAO cuentaDao;

	public void setCuentaDao(CuentaDAO cuentaDao) {
		this.cuentaDao = cuentaDao;
	}

	@Override
	@Transactional
	public List<Cuenta> listCuentas() {
		return cuentaDao.listCuentas();
	}

	@Override
	@Transactional
	public Cuenta obtenerCuenta(int nroCuenta) {
		return cuentaDao.obtenerCuenta(nroCuenta);
	}
}