package banco.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Movimiento implements Serializable{
	
	@Id
	private Integer id;
	private Double monto;
	private Double saldo;
	private Date fecha;
	private String detalle;
	
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "nroCuenta")
	private Cuenta cuenta;
	
	public Movimiento() {
		
	}
	
	public Movimiento(Integer id, Double monto, Double saldo, Date fecha, String detalle, Cuenta cuenta) {
		this.id = id;
		this.monto = monto;
		this.saldo = saldo;
		this.fecha = fecha;
		this.detalle = detalle;
		this.cuenta = cuenta;
	}
	
	public Movimiento(Integer id, Double monto, Double saldo) {
		this.id = id;
		this.monto = monto;
		this.saldo = saldo;
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
