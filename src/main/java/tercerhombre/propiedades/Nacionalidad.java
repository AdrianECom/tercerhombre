package tercerhombre.propiedades;

public enum Nacionalidad {
	AUSTRIA, GRANBRETANA, RUSIA,
	ESTADOSUNIDOS, RUMANIA, ALEMANIA;
	
	public String toString() {
		switch (this) {
		case AUSTRIA:
			return "austriaca";
		case GRANBRETANA:
			return "británica";
		case RUSIA:
			return "rusa";
		case ESTADOSUNIDOS:
			return "estadounidense";
		case ALEMANIA:
			return "alemana";
		case RUMANIA:
			return "rumana";
		default:
			return null;
		}
	};
}
