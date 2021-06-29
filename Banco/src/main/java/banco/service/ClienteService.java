package banco.service;

import java.util.List;

import banco.model.Cliente;

public interface ClienteService 
{
	public List<Cliente> listClientes();
	public Cliente obtenerCliente(int dni);
}
