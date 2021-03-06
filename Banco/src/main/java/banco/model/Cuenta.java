package banco.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cuenta implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nroCuenta;
	private String nombreCuenta;
	
	@Column(unique=true)
	private String cbu;
	@Column(unique=true)
	private String alias;
	private Double saldo;
	private Boolean estado;
	private Date fechaCreacion;
	
    @ManyToOne
	@JoinColumn(name="moneda")
	private TipoMoneda tipoMoneda;
	
    @ManyToOne
	@JoinColumn(name="dni")
	private Cliente cliente;
	
	public Cuenta(){
	
	}

	public Cuenta(String cbu, String alias, TipoMoneda tipoMoneda, Double saldo, Boolean estado,
			Cliente cliente, Date fechacreacion, String nombreCuenta) {
		this.cbu = cbu;
		this.alias = alias;
		this.tipoMoneda = tipoMoneda;
		this.saldo = saldo;
		this.estado = estado;
		this.cliente = cliente;
		this.fechaCreacion = fechacreacion;
		this.nombreCuenta =  nombreCuenta;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(Integer nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public TipoMoneda getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(TipoMoneda tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return nroCuenta + alias + cbu;
	}
}