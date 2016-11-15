package tercerhombre.consultas;

public abstract class Consulta {

	private int acto;
	
	public int getActo() {
		return this.acto;
	}
	
	public Consulta(int acto) {
		this.acto = acto;
	}
}
