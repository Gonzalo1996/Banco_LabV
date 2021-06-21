package dominio;

import javax.persistence.*;

public class Localidad {
	@Id
	private Integer id;
	
	private String nombre;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idProvincia")
	private Provincia provincia;
	
	
	public Localidad() {
		
	}


	public Localidad(Integer id, String nombre, Provincia provincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	@Override
	public String toString() {
		return nombre;
	}	
}
