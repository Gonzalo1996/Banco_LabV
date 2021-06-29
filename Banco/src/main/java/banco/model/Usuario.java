package banco.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer idUsuario;
	private String contrasenia;
	private Integer tipoUsuario;
	private String nombreUsuario;
	private Boolean estado;
	
	/*
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="dni")
	private Cliente cliente;
	*/
	
	public Usuario() {
	}
	
	/*
	public Usuario(Cliente cliente, String contrasenia, Integer tipoUsuario, String nombreUsuario, Boolean estado) {
		super();
		this.cliente = cliente;
		this.contrasenia = contrasenia;
		this.tipoUsuario = tipoUsuario;
		this.nombreUsuario = nombreUsuario;
		this.estado = estado;
	}
	*/

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	/*
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
*/
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
		return "Usuario [idUsuario=" + idUsuario + ", contrasenia=" + contrasenia + ", tipoUsuario=" + tipoUsuario
				+ ", nombreUsuario=" + nombreUsuario + ", estado=" + estado;
	}
	
}
