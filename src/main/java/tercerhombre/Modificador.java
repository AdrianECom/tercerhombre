package tercerhombre;

import tercerhombre.propiedades.ActividadIlegal;
import tercerhombre.propiedades.ActividadLegal;
import tercerhombre.propiedades.EstadoSalud;
import tercerhombre.propiedades.Genero;
import tercerhombre.propiedades.Nacionalidad;
import tercerhombre.propiedades.Ubicacion;


public class Modificador {
	
	private String nombre, propiedad;
	private Class tipo;
	private Enum propiedadEnumerado;

	public Modificador(String nombre, String propiedad) {
		this.nombre = nombre;
		this.propiedad = propiedad;
		
		String propiedadMayusculas = propiedad.toUpperCase();
		
		try {
			propiedadEnumerado = ActividadIlegal.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			propiedadEnumerado = ActividadLegal.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			propiedadEnumerado = EstadoSalud.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			propiedadEnumerado = Genero.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			propiedadEnumerado = Nacionalidad.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			propiedadEnumerado = Ubicacion.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		tipo = propiedadEnumerado.getClass();
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Class getTipo() {
		return tipo;
	}
	
	public Enum getPropiedad() {
		return propiedadEnumerado;
	}
}
