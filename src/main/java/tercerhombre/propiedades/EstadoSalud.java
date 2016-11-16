package tercerhombre.propiedades;

public enum EstadoSalud {
	VIVO,MUERTO;
	
	public String toString() {
		switch (this) {
		case VIVO:
			return "viv";
		case MUERTO:
			return "muert";
		default:
			return null;
		}
	};
}
