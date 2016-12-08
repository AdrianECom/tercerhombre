package tercerhombre.propiedades;

public enum Ubicacion {
	ESTACION, PLAZA, CASALIME, CASAANNA, HOTELSACHER, TEATROJOSEPH, 
	CASANOVACLUB, CONFERENCIA, CASAWINKEL, SECTORRUSO, 
	CAFEMARC, COMISARIA, CEMENTERIO, CAFEMOZART, 
	FUERADEVIENA, NORIA, PUB, CLOACAS, PUENTE, HOSPITAL;
	
	public String toString() {
		switch (this) {
		case ESTACION:
			return " la Estación";
		case PLAZA:
			return " la Plaza";
		case CASALIME:
			return " la casa de Lime";
		case CASAANNA:
			return " la casa de Anna";
		case HOTELSACHER:
			return "l hotel Sacher";
		case TEATROJOSEPH:
			return "l teatro Joseph";
		case CASANOVACLUB:
			return "l Club Casanova";
		case CONFERENCIA:
			return " la conferencia";
		case CASAWINKEL:
			return " la casa del Dr. Winkel";
		case SECTORRUSO:
			return "l Sector Ruso";
		case CAFEMARC:
			return "l Cafe Marc";
		case COMISARIA:
			return " la comisaria";
		case CEMENTERIO:
			return "l cementerio";
		case CAFEMOZART:
			return "l Cafe Mozart";
		case FUERADEVIENA:
			return " fuera de Viena";
		case NORIA:
			return " la Noria";
		case PUB:
			return "l Pub";
		case CLOACAS:
			return " las cloacas";
		case PUENTE:
			return "l Puente";
		case HOSPITAL:
			return "l Hospital";
		default:
			return null;
		}
	};
}

