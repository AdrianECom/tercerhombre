package tercerhombre.propiedades;

public enum Relacion {
	AMIGO_DE, MATA_A, ENFRENTADO_CON, BUSCA_A, ASESINADO_POR, 
	QUIERE_A, EN_REALIDAD_ES, SOSPECHA_DE, CONOCE_A, TRABAJA_CON;
	
	public String toString(String sufijo) {
		switch (this) {
		case AMIGO_DE:
			return "es amig"+sufijo + " de";
		case CONOCE_A:
			return "conoce a";
		case MATA_A:
			return "mata a";
		case ENFRENTADO_CON:
			return "enfrentad"+sufijo + " con";
		case BUSCA_A:
			return "busca a";
		case ASESINADO_POR:
			return "asesinad"+sufijo + " por";
		case QUIERE_A:
			return "quiere a";
		case EN_REALIDAD_ES:
			return "en realidad es";
		case SOSPECHA_DE:
			return "sospecha de";
		case TRABAJA_CON:
			return "trabaja con";
		default:
			return null;
		}
	};
}
