package tercerhombre.propiedades;

public enum ActividadLegal implements Actividad {
	POLICIA, ACTRIZ, ESCRITOR, DIRECTIVO, ENFERMERO, 
	MEDICO, PORTERO, VIOLINISTA;
	
	public String toString() {
		switch (this) {
		case POLICIA:
			return "policia";
		case ACTRIZ:
			return "actriz";
		case ESCRITOR:
			return "escritor";
		case DIRECTIVO:
			return "directivo";
		case ENFERMERO:
			return "enfermero";
		case MEDICO:
			return "medico";
		case PORTERO:
			return "portero";
		case VIOLINISTA:
			return "violinista";
		default:
			return null;
		}
	};
}
