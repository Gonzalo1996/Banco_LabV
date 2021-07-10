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
	public void guardarCuenta(Cuenta cuenta, int dni, String cbu, String alias) throws Exception {
		Usuario usuario = usuarioService.obtenerPorDni(dni);
		
		if (usuario == null || !usuario.getEstado())
			throw new Exception("El dni ingresado no corresponde a un usuario activo.");
		
		Long cantCuentas = this.obtenerCantidadCuentas(dni);
		if (cantCuentas == 4)
			throw new Exception("El cliente ya posee 4 cuentas asignadas.");
		
		if(obtenerPorCbu(cbu) != null)
			throw new Exception("El CBU ingresado pertenece a otra cuenta");
		
		if(obtenerPorAlias(alias) != null)
			throw new Exception("El alias  pertenece a otra cuenta");
		
		cuenta.setCliente(usuario.getCliente());
		cuentaDao.guardarCuenta(cuenta);
	}
	
	@Override
	@Transactional
	public void actualizarCuenta(Cuenta cuenta) {
		this.cuentaDao.actualizarCuenta(cuenta);
	}

	@Override
	public Long obtenerCantidadCuentas(Integer dni) {
		return cuentaDao.obtenerCantidadCuentas(dni);
	}

	@Override
	public Cuenta obtenerPorCbu(String cbu) {
		return cuentaDao.obtenerPorCbu(cbu);
	}

	@Override
	public Cuenta obtenerPorAlias(String alias) {
		return cuentaDao.obtenerPorAlias(alias);
	}
	
	@Override
	public List<Cuenta> obtenerCuentasPorCliente(Integer dni) {
		return cuentaDao.obtenerCuentasPorCliente(dni);
	}

	@Override
	@Transactional
	public Long obtenerCantCuentas_sinContarBajas(Integer dni) {
		return cuentaDao.obtenerCantCuentas_sinContarBajas(dni);
	}
	
	@Override
	@Transactional
	public int bajaCuenta(Integer nroCuenta) {
		return cuentaDao.bajaCuenta(nroCuenta);
	}

	@Override
	@Transactional
	public int modificarCuenta(Integer nroCuenta, String alias, String nombre, Integer dni, Boolean estado) throws Exception{
		Usuario usuario = usuarioService.obtenerPorDni(dni);
		Cuenta cuenta = obtenerPorAlias(alias);
		
		if (usuario == null || !usuario.getEstado())
			throw new Exception("El dni ingresado no corresponde a un usuario activo.");
		
		Long cantCuentas = this.obtenerCantidadCuentas(dni);
		if (cantCuentas == 4)
			throw new Exception("El cliente ya posee 4 cuentas asignadas.");
		
		if(cuenta != null && cuenta.getNroCuenta() != nroCuenta) {
			throw new Exception("Alias ya asignado a otra cuenta");
		}
		
		return cuentaDao.modificarCuenta(nroCuenta, alias, nombre, dni, estado);
	}

	@Override
	@Transactional
	public int bajaCuentaPorDni(Integer dni) {
		return this.cuentaDao.bajaCuentaPorDni(dni);
	}
}