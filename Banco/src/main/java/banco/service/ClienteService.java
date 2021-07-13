package banco.service;

import java.util.Date;
import java.util.List;

import banco.model.Cliente;

public interface ClienteService 
{
	public List<Cliente> listClientes();
	public Cliente obtenerCliente(int dni);
	public int modificarCliente(Integer dni, String nombre, String apellido, Date fecha, String correo, String direccion,
			Integer pais, Integer provincia, Integer localidad);
	List<Cliente> FiltradoClientes(Integer provincia, Integer localidad); 
}
