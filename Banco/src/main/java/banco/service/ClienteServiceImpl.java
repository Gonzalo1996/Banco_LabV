package banco.service;

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
}