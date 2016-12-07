package tercerhombre.consultas;

import tercerhombre.propiedades.ActividadIlegal;
import tercerhombre.propiedades.ActividadLegal;
import tercerhombre.propiedades.EstadoSalud;
import tercerhombre.propiedades.Genero;
import tercerhombre.propiedades.Nacionalidad;
import tercerhombre.propiedades.Ubicacion;

/*
 * La clase Modificador, representa la modificación de un personaje,
 * incluye su nombre, el tipo de la propiedad modificada, y la propiedad.
 */
public class Modificador {
	
	private String nombre, propiedad;
	private Class tipo;
	private Enum propiedadEnumerado;
	private boolean error;

	public Modificador(String nombre, String propiedad) {
		error = false;
		this.nombre = nombre;
		this.propiedad = propiedad;
		
		String propiedadMayusculas = propiedad.toUpperCase();
		
		/*
		 * Aquí convertimos el string al enumerado correspondiente.
		 */
		
		try {
			propiedadEnumerado = ActividadIlegal.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			error = true;
		}
		
		try {
			propiedadEnumerado = ActividadLegal.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			error = true;
		}
		
		try {
			propiedadEnumerado = EstadoSalud.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			error = true;
		}
		
		try {
			propiedadEnumerado = Genero.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			error = true;
		}
		
		try {
			propiedadEnumerado = Nacionalidad.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			error = true;
		}
		
		try {
			propiedadEnumerado = Ubicacion.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			error = true;
		}
		
		
		/*
		 * Obtenemos el tipo de ese enumerado. Así sabemos cuál
		 * es la propiedad que estamos modificando.
		 */
		tipo = propiedadEnumerado.getClass();
		
//		System.out.println("MODIFICADOR");
//		System.out.println(nombre);
//		System.out.println(propiedad);
//		System.out.println(tipo);
//		System.out.println("");
				
	}
	
	public boolean isError() {
		return error;
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
