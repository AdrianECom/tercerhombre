package tercerhombre.propiedades;

public enum Genero {
	HOMBRE,MUJER;
	
	public String sufijo(){
		if(this == Genero.HOMBRE)
			return "o";
		else
			return "a";
	}
	
	public String un(){
		if(this == Genero.HOMBRE)
			return "un";
		else
			return "una";
	}
	
	@Override
	public String toString() {
		if(this == Genero.HOMBRE)
			return "hombre";
		else
			return "mujer";
	}
}
