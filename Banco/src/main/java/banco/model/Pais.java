package banco.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Pais implements Serializable{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id 
	private Integer id;
	private String nombre;
	
	public Pais() {
		
	}
	
	public Pais(String nombre) {
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
