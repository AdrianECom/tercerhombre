package tercerhombre.consultas;

public class ConsultaSi extends Consulta {
	
	private Consulta subconsulta;
	private String nombre;
	private String propiedad;

	public ConsultaSi(String nombre, String propiedad, Consulta subconsulta) {
		super(subconsulta.getActo());
		
		this.subconsulta = subconsulta;
		this.nombre = nombre;
		this.propiedad = propiedad;
	}

	public Consulta getSubconsulta() {
		return subconsulta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPropiedad() {
		return propiedad;
	}
	
	

}
