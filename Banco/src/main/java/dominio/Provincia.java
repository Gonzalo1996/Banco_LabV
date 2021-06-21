package dominio;

import java.util.List;

import javax.persistence.*;

@Entity
public class Provincia {
	@Id
	private Integer id;
	
	private String nombre;
	
//	@ManyToOne(cascade = {CascadeType.ALL})
//	private List<Localidad> localidades;
	
	
	public Provincia() {
		
	}
	
	public Provincia(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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


	@Override
	public String toString() {
		return nombre;
	}
}
