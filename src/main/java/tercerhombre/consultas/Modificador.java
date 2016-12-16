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

	public Modificador(String nombre, String propiedad) {
		this.nombre = nombre;
		this.propiedad = propiedad;
		
		tipo = null;
		propiedadEnumerado = null;
		
		String propiedadMayusculas = propiedad.toUpperCase();
		
		/*
		 * Aquí convertimos el string al enumerado correspondiente.
		 */
		
		try {
			propiedadEnumerado = ActividadIlegal.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			
		}
		
		try {
			propiedadEnumerado = ActividadLegal.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			
		}
		
		try {
			propiedadEnumerado = EstadoSalud.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			
		}
		
		try {
			propiedadEnumerado = Genero.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			
		}
		
		try {
			propiedadEnumerado = Nacionalidad.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			
		}
		
		try {
			propiedadEnumerado = Ubicacion.valueOf(propiedadMayusculas);
		} catch (Exception e) {
			
		}
		
		
		/*
		 * Obtenemos el tipo de ese enumerado. Así sabemos cuál
		 * es la propiedad que estamos modificando.
		 */
		if(propiedadEnumerado != null)
			tipo = propiedadEnumerado.getClass();
				
//		 System.out.println("MODIFICADOR");
//		 System.out.println(nombre);
//		 System.out.println(propiedad);
//		 System.out.println(tipo);
//		 System.out.println("");
				
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Class getTipo() {
		return tipo;
	}
	
	public boolean hasError() {
		return tipo == null;
	}
	
	public Enum getPropiedad() {
		return propiedadEnumerado;
	}
}
