package banco.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer idUsuario;
	private String contrasenia;
	private String nombreUsuario;
	private Boolean estado;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="dni")
	private Cliente cliente;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="tipoUsuarioId")
	private TipoUsuario tipoUsuario;
	
	public Usuario() {
	}

	public Usuario(String contrasenia, String nombreUsuario, Boolean estado, Cliente cliente, TipoUsuario tipoUsuario) {
		this.contrasenia = contrasenia;
		this.nombreUsuario = nombreUsuario;
		this.estado = estado;
		this.cliente = cliente;
		this.tipoUsuario = tipoUsuario;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", contrasenia=" + contrasenia + ", nombreUsuario=" + nombreUsuario
				+ ", estado=" + estado + ", cliente=" + cliente + ", tipoUsuario=" + tipoUsuario + "]";
	}
}
