package tercerhombre;

import java.util.LinkedList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
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
	
	private static final int ULTIMO_ACTO = 5;

	// ------------------------------------

    public static final void main(String[] args) {
    	
    	List<Consulta> consultas = new LinkedList<>();
    	salida = new FicheroSalida("output.txt");
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

    public static void ejecutar(List<Consulta> consultas){
    	
		// load up the knowledge base
	    KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
	    	    
	    // RECORREMOS CONSULTAS
	    for (Consulta consulta : consultas) {
	    	
	    	// Mensaje por si nos pasamos de acto.
	    	if(consulta.getActo() > ULTIMO_ACTO){
	    		
	    		salida.print("# SOLO SE PUEDEN REALIZAR CONSULTAS HASTA : Acto" +ULTIMO_ACTO+"\n");
	    		
	    	}else{
	    		
	    		KieSession kSession = kContainer.newKieSession("ksession-rules");
	    		
	    		if(consulta instanceof ConsultaSi){
	    			
	    			/*
	    			 * TODO: insertar objeto a la base de hechos que modifique
	    			 * al personaje en cuestión.
	    			 */
	    			
	    			ConsultaSi consultaSi = (ConsultaSi) consulta;
	    			
	    			Modificador modificador = new Modificador(consultaSi.getNombre(), consultaSi.getPropiedad());
	    			kSession.insert(modificador);
	    			
	    			consulta = consultaSi.getSubconsulta();
	    		}

		    	// Insertamos buffer y nos quedamos con su manejador. 
		    	FactHandle bufferHandle = kSession.insert(new Buffer());
				
				/*
				 * Si por ejemplo piden acto 4,
				 * necesitamos disparar las reglas del acto 0, del acto 1,
				 * del acto 2, del acto 3 y del acto 4.
				 */
				for (int i = 0; i <= consulta.getActo(); i++) {
					kSession.getAgenda().getAgendaGroup("g"+i).setFocus();	
				    kSession.fireAllRules();
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
			    	
			    	if(personajeEncontrado != null)
			    		salida.print(personajeEncontrado.toString()+"\n");
			    	else
			    		salida.print("# NO SE SABE NADA DEL PERSONAJE " + consultaQuien.getNombre() + " EN EL ACTO " + consultaQuien.getActo() +"\n");
			    }
			    
			    kSession.dispose();
			    
	    	}
		}
	    
	    salida.guardar();
	    
    }

    // ------------------------------------
    
//    		insert(Personaje.nuevo().
//        	setNombre(Personaje.anna).
//        	setGenero(Genero.MUJER).
//        	setActividad(null).
//        	setEstadoSalud(EstadoSalud.VIVO).
//        	setNacionalidad(null).
//        	setUbicacion(Ubicacion.CEMENTERIO));

}
