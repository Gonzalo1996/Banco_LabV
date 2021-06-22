package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Cliente implements Serializable{
	@Id
	@Column(unique=true)
    private Integer dni;
    private Integer cuil;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String correo;
    private String direccion;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idProvincia")
    private Provincia provincia;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idLocalidad")
    private Localidad localidad;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idGenero")
    private Genero genero;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idPais")
    private Pais pais;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="idUsuario")
    private Usuario usuario;
    
    public Cliente() {
    	
    }

	public Cliente(Integer dni, Integer cuil, String nombre, String apellido, Date fechaNacimiento, String correo,
			String direccion, Pais pais, Localidad localidad, Provincia provincia, Genero genero, Usuario usuario) {
		this.dni = dni;
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.direccion = direccion;
		this.pais = pais;
		this.localidad = localidad;
		this.provincia = provincia;
		this.genero = genero;
		this.usuario = usuario;
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