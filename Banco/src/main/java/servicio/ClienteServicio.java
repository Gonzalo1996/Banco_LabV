package servicio;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;

import dominio.Cliente;



public class ClienteServicio {
	
	
private ClienteDao dataAccess = null;
	
	public void setDataAccess(ClienteDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	public void insertarCliente(Cliente cliente) {
		 dataAccess.insertarCliente(cliente);
	}
	
	public  Cliente obtenerCliente(Integer dni) {
		return dataAccess.obtenerCliente(dni);
	}
	
	public  ArrayList<Cliente> obtenerClientes() {
		return dataAccess.obtenerClientes();
	}
	
	
	public List<Object[]> obtenerClienteAtributos(Integer dni) {
		return dataAccess.obtenerClienteAtributos(dni);
	}

}
