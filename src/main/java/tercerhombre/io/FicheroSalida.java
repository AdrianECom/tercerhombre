package tercerhombre.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FicheroSalida {

	private String nombre;
	private boolean inicializado;
	private BufferedWriter b;
	
	/*
	 * Abre el fichero para escritura.
	 */
	private void inicializar(String nombre){
		this.nombre = nombre;
		try {
			b = new BufferedWriter(new FileWriter(new File(nombre)));
			inicializado = true;
		} catch (IOException e) {
			System.err.println("No se pudo crear el fichero " + nombre);
		}
	}
	
	public FicheroSalida(String nombre) {
		inicializar(nombre);
	}
	
	/*
	 * Imprime una línea simple.
	 */
	public void print(String s){
		try {
			b.write(s);
		} catch (IOException e) {
			System.err.println("No se pudo escribir en el fichero " + nombre);
		}
	}
	
	/*
	 * Guarda y cierra el fichero.
	 */
	public void guardar(){
		try {
			b.close();
		} catch (IOException e) {
			System.err.println("No se pudo cerrar el fichero " + nombre);
		}
	}
}
