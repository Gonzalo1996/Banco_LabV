package dominio;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cuenta {
	@Id
	private Integer nroCuenta;
	private String nombreCuenta;
	private String CBU;
	private String alias;
	private Integer moneda;
	private Double saldo;
	private Boolean estado;
	private Date fechaCreacion;
	
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="dni")
	private Cliente cliente;
	
	
	public Cuenta(){
	
	}


	public Cuenta(Integer nroCuenta, String cBU, String alias, Integer moneda, Double saldo, Boolean estado,
			Cliente cliente, Date fechacreacion, String nombreCuenta) {
		super();
		this.nroCuenta = nroCuenta;
		CBU = cBU;
		this.alias = alias;
		this.moneda = moneda;
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

	public String getCBU() {
		return CBU;
	}

	public void setCBU(String cBU) {
		CBU = cBU;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Integer getMoneda() {
		return moneda;
	}

	public void setMoneda(Integer moneda) {
		this.moneda = moneda;
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
		return "Cuenta [nroCuenta=" + nroCuenta + ", nombreCuenta=" + nombreCuenta + "]";
	}
	
}
