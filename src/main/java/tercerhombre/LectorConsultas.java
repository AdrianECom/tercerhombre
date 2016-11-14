package tercerhombre;

import java.util.regex.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectorConsultas {

	 public static String muestraContenido(String archivo) throws FileNotFoundException, IOException {
	        String linea = null;
		 	String cadena;
	        FileReader f = new FileReader(archivo);
	        BufferedReader b = new BufferedReader(f);
	        while((cadena = b.readLine())!=null) {
	            linea = cadena;
	        }
	        b.close();
			return linea;
	    }
	 
private static void Que (String archivo) throws FileNotFoundException {
	     
		 Pattern patron = Pattern.compile("Qué");
		 Matcher match = patron.matcher(archivo);
		 boolean que = match.find();
		 System.out.println(archivo);

		 Pattern acto = Pattern.compile("hasta ([Acto]+\\d{1})");
		 Matcher matchActo = acto.matcher(archivo);

		 boolean matchActosi = matchActo.find();

		 System.out.println("Ha encontrado que? "+que);
		 System.out.println("Ha encontrado Acto? "+matchActosi);
		 
		 if (matchActosi){
			 String a2 = matchActo.group(1);
			 System.out.println(a2);
		}		 else {
			 System.out.println("No ha encontrado preguntas QUÉ");
		 }
		 
	 }
	 
	 
	 private static void Quien (String archivo) throws FileNotFoundException {
	     
		 Pattern patron = Pattern.compile("[Quién]");
		 Matcher match = patron.matcher(archivo);
		 boolean quien = match.find();
		 System.out.println(archivo);
		 Pattern persona = Pattern.compile("es (\\p{Lu}+\\p{Ll}*) hasta");
		 Matcher matchPersona = persona.matcher(archivo);
		 Pattern acto = Pattern.compile("hasta ([Acto]+\\d{1})");
		 Matcher matchActo = acto.matcher(archivo);

		 boolean matchPersonasi = matchPersona.find();
		 boolean matchActosi = matchActo.find();

		 System.out.println("Ha encontrado quien? "+quien);
		 System.out.println("Ha encontrado Persona? "+matchPersonasi);
		 System.out.println("Ha encontrado Acto? "+matchActosi);

		 
		 if (matchPersonasi){
		 String el2 = matchPersona.group(1);
		 System.out.println(el2);
		 }
		 
		 if (matchActosi){
			 String a2 = matchActo.group(1);
			 System.out.println(a2);
		}
		 else {
			 System.out.println("No ha encontrado preguntas QUIEN");
		 }
		 
	 }

	    public static void main(String[] args) throws IOException {
	        String lector = muestraContenido("C:/Users/Jesus/Desktop/lector.csv");       
	        Quien (lector);
	        Que (lector);
	    }
}
