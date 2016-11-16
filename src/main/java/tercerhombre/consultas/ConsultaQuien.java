package tercerhombre.consultas;


public class ConsultaQuien extends Consulta {
	
	private String nombre;

	public ConsultaQuien(int acto, String personaje) {
		super(acto);
		this.nombre = personaje;
	}

	public String getNombre() {
		return nombre;
	}
}
