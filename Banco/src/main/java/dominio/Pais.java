package dominio;

import javax.persistence.*;

@Entity
public class Pais {
	
	@Id 
	private Integer id;
	private String nombre;
	
	public Pais() {
		
	}
	
	public Pais(Integer id, String nombre) {
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
