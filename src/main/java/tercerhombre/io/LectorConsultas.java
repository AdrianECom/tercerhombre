package tercerhombre.io;

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
import tercerhombre.consultas.ConsultaSi;

public class LectorConsultas {
	
	// PATRONES
	private Pattern patronQue;
	private Pattern patronQuien;
	private Pattern patronSi; 
	
	public LectorConsultas(){
		patronQue = Pattern.compile("[Qq]u[ée]");
		patronQuien = Pattern.compile("[Qq]ui[ée]n");
		patronSi = Pattern.compile("[Ss]i");
	}

	/*
	 * Esta función identifica el tipo de consulta QUE/QUIN y devuelve una Consulta.
	 */
	private Consulta identificarConsulta(String cadena) throws FileNotFoundException {

		Matcher matchQue = patronQue.matcher(cadena);
		Matcher matchQuien = patronQuien.matcher(cadena);
		Matcher matchSi = patronSi.matcher(cadena);
		
		// Leemos la consulta
		
		Consulta consulta = null;

		if (matchQuien.find()) {
			consulta = procesarQuien(cadena);
		}else if (matchQue.find()) {
			consulta = procesarQue(cadena);
		}
		
		/* si resulta que la consulta es Consulta SI, entonces,
		 * la que se había detectado antes era la subconsulta del SI.
		 */
		if (consulta != null && matchSi.find()) {
			return procesarSi(cadena, consulta);
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
	private static Consulta procesarQue(String cadena) throws FileNotFoundException {

		Pattern patternActo = Pattern.compile("hasta [Aa]cto(\\d{1}|[Ff]inal)");
		Matcher matchActo = patternActo.matcher(cadena);

		if (matchActo.find()) {
			String acto = matchActo.group(1);
			System.out.println("QUE");
			
			int actoInt = 0;
			
			try {
				actoInt = Integer.parseInt(acto);
			} catch (Exception e) {
				if(acto.toLowerCase().compareTo("final") == 0)
					actoInt = 5;
				else
					return null;
			}
			
			
			return new ConsultaQue(actoInt);
		}
		
		return null;
	}

	/*
	 * Esta función se encarga de procesar una consulta QUIEN.
	 */
	private static Consulta procesarQuien(String cadena) throws FileNotFoundException {

		Pattern patternPersona = Pattern.compile("es ([a-zA-Z]+|[Tt]ercer [Hh]ombre) hasta");
		Matcher matchPersona = patternPersona.matcher(cadena);
		Pattern patternActo = Pattern.compile("hasta [Aa]cto(\\d{1})");
		Matcher matchActo = patternActo.matcher(cadena);

		if (matchPersona.find()) {
			String nombre = matchPersona.group(1);
			
			if (matchActo.find()) {
				String acto = matchActo.group(1);
				System.out.println("QUIEN");
				return new ConsultaQuien(Integer.parseInt(acto),nombre);
			}
		}

		
		return null;
	}
	
	/*
	 * Esta función se encarga de procesar una consulta SI.
	 */
	private static Consulta procesarSi(String cadena, Consulta subconsulta) throws FileNotFoundException {

		Pattern patternEs = Pattern.compile("([a-zA-Z]+) es ([a-zA-Z]+),");
		Matcher matchEs = patternEs.matcher(cadena);

		if (matchEs.find()) {
			String nombre = matchEs.group(1);
			String propiedad = matchEs.group(2);
			System.out.println("SI");
			return new ConsultaSi(nombre, propiedad, subconsulta);
		}
		
		return null;
	}
	
}
