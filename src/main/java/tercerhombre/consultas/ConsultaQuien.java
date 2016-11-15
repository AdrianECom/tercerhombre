package tercerhombre.consultas;

public class ConsultaQuien extends Consulta {
	
	private String personaje;

	public ConsultaQuien(int acto, String personaje) {
		super(acto);
		this.personaje = personaje;
	}

	public String getPersonaje() {
		return personaje;
	}

}
