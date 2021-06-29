package banco.dao;

import java.util.List;

import banco.model.Cliente;

public interface ClienteDAO 
{
	public List<Cliente> listClientes();
	public Cliente obtenerCliente(int dni);
}
