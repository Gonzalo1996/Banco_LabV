package banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import banco.dao.CuentaDAO;
import banco.model.Cuenta;
import banco.model.Usuario;

@Service
public class CuentaServiceImpl implements CuentaService{
	
	private CuentaDAO cuentaDao;
	@Autowired private UsuarioService usuarioService;

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

	@Override
	public void guardarCuenta(Cuenta cuenta, int dni) throws Exception {
		Usuario usuario = usuarioService.obtenerPorDni(dni);
		if (usuario == null || !usuario.getEstado())
			throw new Exception("El dni ingresado no corresponde a un usuario activo.");
		
		Long cantCuentas = this.obtenerCantidadCuentas(dni);
		if (cantCuentas == 4)
			throw new Exception("El cliente ya posee 4 cuentas asignadas.");
		
		cuenta.setCliente(usuario.getCliente());
		cuentaDao.guardarCuenta(cuenta);
	}

	@Override
	public Long obtenerCantidadCuentas(Integer dni) {
		return cuentaDao.obtenerCantidadCuentas(dni);
	}
}