package tercerhombre;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import tercerhombre.consultas.Consulta;
import tercerhombre.consultas.ConsultaQue;
import tercerhombre.consultas.ConsultaQuien;

public class LectorConsultas {

	/*
	 * Esta función identifica el tipo de consulta QUE/QUIN y devuelve una Consulta.
	 */
	private static Consulta identificarConsulta(String archivo) throws FileNotFoundException {

		// PATRONES
		Pattern patronQue = Pattern.compile("Qué");
		Matcher matchQue = patronQue.matcher(archivo);
		Pattern patronQuien = Pattern.compile("Quién");
		Matcher matchQuien = patronQuien.matcher(archivo);
		
		
		// Leemos la consulta
		
		Consulta consulta = null;

		if (matchQue.find()) {
			System.out.println("QUE");
			consulta = procesarQue(archivo);
		} else if (matchQuien.find()) {
			System.out.println("QUIEN");
			consulta = procesarQuien(archivo);
		}
		
		return consulta;

	}

	/*
	 * Esta es la función principal. Lee todas las líneas del fichero 
	 * y devuelve una lista de Consultas.
	 */
	public List<Consulta> leerFichero(String archivo) throws IOException {
		String cadena;
		
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		
		List<Consulta> consultas = new ArrayList<Consulta>();
		
		while ((cadena = b.readLine()) != null) {	
			Consulta c = identificarConsulta(cadena);
		
			if(c!=null)
				consultas.add(c);			
		}
		
		b.close();
		
		return consultas;
	}

	/*
	 * Esta función se encarga de procesar una consulta QUE.
	 */
	private static Consulta procesarQue(String archivo) throws FileNotFoundException {

		Pattern patternActo = Pattern.compile("hasta (\\d{1})");
		Matcher matchActo = patternActo.matcher(archivo);

		if (matchActo.find()) {
			String acto = matchActo.group(1);
//			System.out.println(acto);
			
			return new ConsultaQue(Integer.parseInt(acto));
		}
		
		return null;
	}

	/*
	 * Esta función se encarga de procesar una consulta QUIEN.
	 */
	private static Consulta procesarQuien(String archivo) throws FileNotFoundException {

		Pattern patternPersona = Pattern.compile("es ([a-zA-Z]+) hasta");
		Matcher matchPersona = patternPersona.matcher(archivo);
		Pattern patternActo = Pattern.compile("hasta (\\d{1})");
		Matcher matchActo = patternActo.matcher(archivo);

		if (matchPersona.find()) {
			String nombre = matchPersona.group(1);
			System.out.println(nombre);
			
			if (matchActo.find()) {
				String acto = matchActo.group(1);
//				System.out.println(acto);
				
				return new ConsultaQuien(Integer.parseInt(acto),nombre);
			}
		}

		
		return null;
		
	}

	public LectorConsultas(){

	}
	
}
