package banco.helpers;

public abstract class Constantes {
	public enum TipoUsuario {
		ADMIN(1),
		CLIENTE(2);
		
		public final Integer id;

		TipoUsuario(int i) {
			this.id = i;
		}
	}

	public enum TipoCuenta {
		CAJA_AHORRO_PESOS(1),
		CAJA_AHORRO_DOLARES(2);
		
		public final Integer id;

		TipoCuenta(int i) {
			this.id = i;
		}
	}
}
