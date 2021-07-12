package banco.dao;

import java.util.Date;
import java.util.List;

import banco.model.Cliente;

public interface ClienteDAO 
{
	public List<Cliente> listClientes();
	public Cliente obtenerCliente(int dni);
	public int modificarCliente(Integer dni, String nombre, String apellido, Date fecha, String correo, String direccion,
			Integer pais, Integer provincia, Integer localidad);
	List<Cliente> FiltradoClientes(Integer dni, Integer localidad);
}
