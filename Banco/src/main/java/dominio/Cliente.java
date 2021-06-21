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
    private String direccion;
    
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idLocalidad")
    private Localidad localidad;
    
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idGenero")
    private Genero genero;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="idUsuario")
    private Usuario usuario;
    
    public Cliente() {
    	
    }
    
	public Cliente(Integer dni, Integer cuil, String nombre, String apellido, Date fechaNacimiento, String correo,
			Localidad localidad, Usuario usuario, String direccion, Genero genero) {
		super();
		this.dni = dni;
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.localidad = localidad;
		this.usuario = usuario;
		this.direccion = direccion;
		this.genero = genero;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
    
}
