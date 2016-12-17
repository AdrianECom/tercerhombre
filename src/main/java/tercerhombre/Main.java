package tercerhombre;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;

import tercerhombre.consultas.Consulta;
import tercerhombre.consultas.ConsultaQue;
import tercerhombre.consultas.ConsultaQuien;
import tercerhombre.consultas.ConsultaSi;
import tercerhombre.consultas.Modificador;
import tercerhombre.io.Buffer;
import tercerhombre.io.FicheroSalida;
import tercerhombre.io.LectorConsultas;
import tercerhombre.personaje.Personaje;

public class Main {
	
	public static FicheroSalida salida;
	public static FicheroSalida salidaMetadatos;
	
	private static final int ULTIMO_ACTO = 5;

	// ------------------------------------

    public static final void main(String[] args) {
    	
    	List<Consulta> consultas = new LinkedList<>();
    	salida = new FicheroSalida("output.txt");
    	salidaMetadatos = new FicheroSalida("metadata.txt");
    	LectorConsultas lc = new LectorConsultas();
    	
    	for (String fichero : args) {
			
	        try {
	        	
	        	consultas.addAll(lc.leerFichero(fichero));
	            
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
        
    	}
        
        Main.ejecutar(consultas);
    }
    
    // ------------------------------------

    public static boolean comprobarFin(KieSession kSession){
    	Collection<? extends Object> list = kSession.getObjects(new ObjectFilter() {
			@Override
			public boolean accept(Object arg0) {
				return arg0 instanceof Fin;
			}
		});
    	
    	return ! list.isEmpty();
    }
 
    // ------------------------------------

    public static void ejecutar(List<Consulta> consultas){
    	
		// load up the knowledge base
	    KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
	    	    
	    // RECORREMOS CONSULTAS
	    for (Consulta consulta : consultas) {
	    	
	    	int acto = consulta.getActo();
	    	
	    	// Mensaje por si nos pasamos de acto.
			if(acto > ULTIMO_ACTO){
	    		
	    		salida.print("# SOLO SE PUEDEN REALIZAR CONSULTAS HASTA : Acto" +ULTIMO_ACTO+".\n");
	    		
	    	}else{
	    		
	    		KieSession kSession = kContainer.newKieSession("ksession-rules");
	    		
				Collection<Rule> rules = kSession.getKieBase().getKiePackage("rules").getRules();
				
				for (Rule r : rules)
					salidaMetadatos.print(r.getMetaData().toString()+"\n");
				
				salidaMetadatos.guardar();
				
	    		
	    		if(consulta instanceof ConsultaSi){
	    			
	    			/*
	    			 * Creamos un Modificador a partir de la consulta SI.
	    			 */
	    			
	    			ConsultaSi consultaSi = (ConsultaSi) consulta;
	    			
	    			Modificador modificador = new Modificador(consultaSi.getNombre(), consultaSi.getPropiedad());
	    			
	    			if(modificador.hasError())
	    				salida.print("# CONSULTA 'SI' NO SE HA ESCRITO CORRECTAMENTE.\n");
	    			else
	    				kSession.insert(modificador);
	    			
	    			
	    			/*
	    			 * Tras procesar la consulta SI, procesaremos la subconsulta.
	    			 * Ponemos la subconsulta como la consulta principal a tratar.
	    			 */
	    			consulta = consultaSi.getSubconsulta();
	    		}

		    	// Insertamos buffer y nos quedamos con su manejador. 
		    	FactHandle bufferHandle = kSession.insert(new Buffer());
				
		    	
		    	boolean fin = false;
		    	
				/*
				 * Si por ejemplo piden acto 4,
				 * necesitamos disparar las reglas del acto 0, del acto 1,
				 * del acto 2, del acto 3 y del acto 4.
				 */
		    	
				for (int i = 0; !fin && i <= acto; i++) {

					kSession.getAgenda().getAgendaGroup("g"+i).setFocus();
					kSession.fireAllRules();

				    fin = comprobarFin(kSession);
				}
				
				if(consulta instanceof ConsultaQue){
					// recuperamos el buffer.
					Buffer resultado = (Buffer) kSession.getObject(bufferHandle);
					salida.print(resultado.toString()+"\n");
				}
								
				if(consulta instanceof ConsultaQuien){		    	

			    	ConsultaQuien consultaQuien = (ConsultaQuien)consulta;
			    	Personaje personajeEncontrado = null;
			    	
			    	// buscar personaje
			    	for (Object o: kSession.getObjects()) {
			    		if(o instanceof Personaje){
			    			
			    			Personaje p = (Personaje) o;
			    			
					    	if(p.getNombre().equals(consultaQuien.getNombre()))
					    		personajeEncontrado = p;
			    		}
					}
			    	
			    	if(personajeEncontrado != null){
			    		salida.print("En el Acto "+acto+". ");
			    		salida.print(personajeEncontrado.toString()+"\n");
			    	}else
			    		salida.print("# NO SE SABE NADA DEL PERSONAJE " + consultaQuien.getNombre() + " EN EL ACTO " + consultaQuien.getActo() +".\n");
			    }
			    
			    kSession.dispose();
			    
	    	}
		}
	    
	    salida.guardar();
	    
    }
    
     

    // ------------------------------------

    


    
}
