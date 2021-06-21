package dominio;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Movimiento {
	
	@Id
	private Integer id;
	private Double monto;
	private Double saldo;
	private Date fecha;
	private String detalle;
	
	@OneToMany (cascade ={CascadeType.ALL})
	@JoinColumn(name = "nroCuenta")
	private Cuenta cuenta;
	
	public Movimiento() {
		
	}
	
	public Movimiento(Integer id, Double monto, Double saldo, Date fecha, String detalle, Cuenta cuenta) {
		super();
		this.id = id;
		this.monto = monto;
		this.saldo = saldo;
		this.fecha = fecha;
		this.detalle = detalle;
		this.cuenta = cuenta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "Movimiento [monto=" + monto + ", detalle=" + detalle + "]";
	}

}
