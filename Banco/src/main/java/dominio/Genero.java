package dominio;

import javax.persistence.*;

@Entity
public class Genero {
	
	@Id
	private Integer id;
	private String nombre;
	
	public Genero() {
		
	}
	
	public Genero(Integer id, String nombre) {
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
