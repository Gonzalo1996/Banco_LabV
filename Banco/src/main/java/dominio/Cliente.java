package dominio;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Cliente {
	
	@Id
    private Integer dni;
    private Integer cuil;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String correo;
    private Localidad localidad;
    private Provincia provincia;
    private String direccion;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="idUsuario")
    private Usuario usuario;
    
    public Cliente() {
    	
    }
    
	public Cliente(Integer dni, Integer cuil, String nombre, String apellido, Date fechaNacimiento, String correo,
			Localidad localidad, Provincia provincia, Usuario usuario, String direccion) {
		super();
		this.dni = dni;
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.localidad = localidad;
		this.provincia = provincia;
		this.usuario = usuario;
		this.direccion = direccion;
	}



	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getCuil() {
		return cuil;
	}

	public void setCuil(Integer cuil) {
		this.cuil = cuil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
    
}
