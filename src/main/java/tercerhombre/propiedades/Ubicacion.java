package tercerhombre.propiedades;

public enum Ubicacion {
	PLAZA, CASALIME, CASAANNA, HOTELSACHER, TEATROJOSEPH, 
	CASANOVACLUB, CONFERENCIA, CASAWINKEL, SECTORRUSO, 
	CAFEMARC, COMISARIA, CEMENTERIO, CAFEMOZART, 
	FUERADEVIENA, NORIA, PUB, CLOACAS;
	
	public String toString() {
		switch (this) {
		case PLAZA:
			return "la Plaza";
		case CASALIME:
			return "la casa de Lime";
		case CASAANNA:
			return "la casa de Anna";
		case HOTELSACHER:
			return "el hotel Sacher";
		case TEATROJOSEPH:
			return "el teatro Joseph";
		case CASANOVACLUB:
			return "el Club Casanova";
		case CONFERENCIA:
			return "la conferencia";
		case CASAWINKEL:
			return "la casa del Dr. Winkel";
		case SECTORRUSO:
			return "el Sector Ruso";
		case CAFEMARC:
			return "el Cafe Marc";
		case COMISARIA:
			return "la comisaria";
		case CEMENTERIO:
			return "el cementerio";
		case CAFEMOZART:
			return "el Cafe Mozart";
		case FUERADEVIENA:
			return "fuera de Viena";
		case NORIA:
			return "la Noria";
		case PUB:
			return "el Pub";
		case CLOACAS:
			return "las cloacas";
		default:
			return null;
		}
	};
}

