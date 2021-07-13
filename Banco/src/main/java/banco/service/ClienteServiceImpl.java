package banco.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import banco.dao.ClienteDAO;
import banco.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	private ClienteDAO clienteDao;

	public void setClienteDao(ClienteDAO clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	@Override
	@Transactional
	public List<Cliente> listClientes() {
		return clienteDao.listClientes();
	}

	@Override
	@Transactional
	public Cliente obtenerCliente(int dni) {
		return clienteDao.obtenerCliente(dni);
	}

	@Override
	@Transactional
	public int modificarCliente(Integer dni, String nombre, String apellido, Date fecha, String correo, String direccion,
			Integer pais, Integer provincia, Integer localidad) {
		return clienteDao.modificarCliente(dni, nombre, apellido, fecha, correo, direccion, pais, provincia, localidad);
	}
	
	@Override
	public List<Cliente> FiltradoClientes(Integer provincia, Integer localidad) {
		// TODO Auto-generated method stub
		return clienteDao.FiltradoClientes(provincia, localidad);
	}
}