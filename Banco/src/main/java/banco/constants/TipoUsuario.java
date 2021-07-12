package banco.constants;

public enum TipoUsuario {

	ADMIN(1),
	CLIENTE(2);
	
	private final Integer id;

	TipoUsuario(int i) {
		this.id = i;
	}

	public Integer getId() {
		return id;
	}
	
}
