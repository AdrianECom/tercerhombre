package tercerhombre;

import java.util.regex.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectorConsultas {

	public static void Consulta(String archivo) throws FileNotFoundException {

		Pattern patronQue = Pattern.compile("Qué");
		Matcher matchQue = patronQue.matcher(archivo);
		Pattern patronQuien = Pattern.compile("Quién");
		Matcher matchQuien = patronQuien.matcher(archivo);

		if (matchQue.find()) {
			System.out.println("QUE");
			Que(archivo);
		} else if (matchQuien.find()) {
			System.out.println("QUIEN");
			Quien(archivo);
		}

	}

	public static void LeeFichero(String archivo) throws IOException {
		String cadena;
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			Consulta(cadena);
		}
		b.close();
	}

	private static void Que(String archivo) throws FileNotFoundException {

		Pattern acto = Pattern.compile("hasta ([Acto]+\\d{1})");
		Matcher matchActo = acto.matcher(archivo);

		boolean matchActosi = matchActo.find();

		if (matchActosi) {
			String a2 = matchActo.group(1);
			System.out.println(a2);
		}
	}

	private static void Quien(String archivo) throws FileNotFoundException {

		Pattern persona = Pattern.compile("es (\\p{Lu}+\\p{Ll}*) hasta");
		Matcher matchPersona = persona.matcher(archivo);
		Pattern acto = Pattern.compile("hasta ([Acto]+\\d{1})");
		Matcher matchActo = acto.matcher(archivo);

		boolean matchPersonasi = matchPersona.find();
		boolean matchActosi = matchActo.find();

		if (matchPersonasi) {
			String el2 = matchPersona.group(1);
			System.out.println(el2);
		}

		if (matchActosi) {
			String a2 = matchActo.group(1);
			System.out.println(a2);
		}

	}

	public static void main(String[] args) throws IOException {
		LeeFichero("C:/Users/Jesus/Desktop/lector.csv");

	}
}
