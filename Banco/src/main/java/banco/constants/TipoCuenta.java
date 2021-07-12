package banco.constants;

public enum TipoCuenta {
	
	CAJA_AHORRO_PESOS(1),
	CAJA_AHORRO_DOLARES(2);
	
	private final Integer id;

	TipoCuenta(int i) {
		this.id = i;
	}

	public Integer getId() {
		return id;
	}
}
