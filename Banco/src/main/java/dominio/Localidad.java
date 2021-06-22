package dominio;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Localidad implements Serializable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	private String nombre;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idProvincia")
	private Provincia provincia;
	
	public Localidad() {
		
	}

	public Localidad(String nombre, Provincia provincia) {
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
