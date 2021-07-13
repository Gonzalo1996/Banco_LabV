package banco.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
	public class Provincia implements Serializable
	{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@Column
	private String nombre;
	
    @OneToOne(cascade= {CascadeType.ALL})
	private Pais pais;
	
	
	public Provincia() {
		
	}
	
	public Provincia(String nombre, Pais pais) 
	{
		this.nombre = nombre;
		this.pais = pais;
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
	
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
