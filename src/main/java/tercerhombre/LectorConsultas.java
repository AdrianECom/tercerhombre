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

	private static Consulta consulta(String archivo) throws FileNotFoundException {

		Pattern patronQue = Pattern.compile("Qué");
		Matcher matchQue = patronQue.matcher(archivo);
		Pattern patronQuien = Pattern.compile("Quién");
		Matcher matchQuien = patronQuien.matcher(archivo);
		
		Consulta consulta = null;

		if (matchQue.find()) {
			System.out.println("QUE");
			consulta = Que(archivo);
		} else if (matchQuien.find()) {
			System.out.println("QUIEN");
			consulta = Quien(archivo);
		}
		
		return consulta;

	}

	public List<Consulta> LeeFichero(String archivo) throws IOException {
		String cadena;
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		
		List<Consulta> consultas = new ArrayList<Consulta>();
		
		while ((cadena = b.readLine()) != null) {	
			Consulta c = consulta(cadena);
		
			if(c!=null)
				consultas.add(c);
		}
		b.close();
		
		return consultas;
	}

	private static Consulta Que(String archivo) throws FileNotFoundException {

		Pattern acto = Pattern.compile("hasta Acto(\\d{1})");
		Matcher matchActo = acto.matcher(archivo);

		boolean matchActosi = matchActo.find();

		if (matchActosi) {
			String a2 = matchActo.group(1);
			System.out.println(a2);
			
			return new ConsultaQue(Integer.parseInt(a2));
		}
		
		return null;
	}

	private static Consulta Quien(String archivo) throws FileNotFoundException {

		Pattern persona = Pattern.compile("es (\\p{Lu}+\\p{Ll}*) hasta");
		Matcher matchPersona = persona.matcher(archivo);
		Pattern acto = Pattern.compile("hasta Acto(\\d{1})");
		Matcher matchActo = acto.matcher(archivo);

		boolean matchPersonasi = matchPersona.find();
		boolean matchActosi = matchActo.find();

		if (matchPersonasi) {
			String el2 = matchPersona.group(1);
			System.out.println(el2);
			
			if (matchActosi) {
				String a2 = matchActo.group(1);
				System.out.println(a2);
				
				new ConsultaQuien(Integer.parseInt(a2),el2);
			}
		}

		
		return null;
		
	}

	public LectorConsultas(){

	}
	
}
