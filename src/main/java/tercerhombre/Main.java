package tercerhombre;

import java.util.Collection;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import tercerhombre.consultas.Consulta;
import tercerhombre.consultas.ConsultaQue;
import tercerhombre.consultas.ConsultaQuien;
import tercerhombre.personaje.Personaje;
import tercerhombre.propiedades.ActividadLegal;
import tercerhombre.propiedades.EstadoSalud;
import tercerhombre.propiedades.Genero;
import tercerhombre.propiedades.Nacionalidad;
import tercerhombre.propiedades.Ubicacion;

public class Main {
	
	public static FicheroSalida salida;
	public static boolean esQue = false;
	
	private static final int ULTIMO_ACTO = 1;

	// ------------------------------------

    public static final void main(String[] args) {
        try {
        	salida = new FicheroSalida("src/main/resources/output.txt");
        	LectorConsultas lc = new LectorConsultas();
        	List<Consulta> consultas = lc.leerFichero("src/main/resources/input.txt");
            Main.ejecutar(consultas);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    // ------------------------------------

    /*
     * Esta funcion se usa para imprimir dentro de las reglas en las consultas QUE.
     */
    public static void print(String s){
    	if(esQue)
    		salida.print(s);
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
		    	
		    	System.out.println("CONSULTA: " + consulta.getClass().getName());
		    	System.out.println("\n##############################\n");
		    	
				Main.insertarPersonajes(kSession);
				
				/*
				 * Si el Acto es 0, lanzar función para imprimir todo lo anterior.
				 * y después lanzar las reglas.
				 */
				
				if(consulta instanceof ConsultaQue ){
					imprimirAnteriorActo0();
					esQue = true;
				}
				
				/*
				 * Si por ejemplo piden acto 4,
				 * necesitamos disparar las reglas del acto 0, del acto 1,
				 * del acto 2, del acto 3 y del acto 4.
				 */
				
				
				
				for (int i = 0; i <= consulta.getActo(); i++) {
						
					kSession.getAgenda().getAgendaGroup("g"+i).setFocus();
	
					System.out.println("ACTO:" + i);
				    kSession.fireAllRules();
				}
				
				if(esQue)
					salida.print("\n");
				
				esQue = false;
				
				if(consulta instanceof ConsultaQuien){		    	
			    	System.out.println("\n##############################\n");
			    	System.out.println("CONSULTA QUIEN:\n");
			    	
			    	ConsultaQuien consultaQuien = (ConsultaQuien)consulta;
			    	
			    	for (Personaje p: (Collection<Personaje>)kSession.getObjects()) {
				    	if(p.getNombre().equals(consultaQuien.getNombre())){
				    		salida.print(p.toString()+"\n");
				    	}
					}
			    		
			    }
			    
			    
			    
			    kSession.dispose();
			    
			    System.out.println("\n##############################\n");
	    	}
		}
	    
	    salida.guardar();
	    
	    
		

    }

    // ------------------------------------
    
    public static void imprimirAnteriorActo0(){
    	
    }
    
    // ------------------------------------
    
    public static void insertarPersonajes(KieSession ks){


    	// Estado inicial de los personajes
    	    	
    	// ANNA

    	Personaje anna = Personaje.nuevo().
    	setNombre(Personaje.anna).
    	setGenero(Genero.MUJER).
    	setActividad(null).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(null).
    	setUbicacion(Ubicacion.CEMENTERIO);


    	// LIME

    	Personaje lime = Personaje.nuevo().
    	setNombre(Personaje.lime).
    	setGenero(Genero.HOMBRE).
    	setActividad(null).
    	setEstadoSalud(EstadoSalud.MUERTO).
    	setNacionalidad(Nacionalidad.ESTADOSUNIDOS).
    	setUbicacion(Ubicacion.CEMENTERIO);


    	// CALLOWAY

    	Personaje calloway = Personaje.nuevo().
    	setNombre(Personaje.calloway).
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.POLICIA).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.GRANBRETANA).
    	setUbicacion(Ubicacion.CEMENTERIO);


    	// CRABBIN

    // 	Personaje crabbin = Personaje.nuevo().
    // 	setNombre(Personaje.crabbin).
    // 	setGenero(Genero.HOMBRE).
    // 	setActividad(ActividadLegal.DIRECTIVO).
    // 	setEstadoSalud(EstadoSalud.VIVO).
    // 	setNacionalidad(Nacionalidad.GRANBRETANA).
    // 	setUbicacion(Ubicacion.HOTELSACHER);

    	// KARL

    	Personaje karl = Personaje.nuevo().
    	setNombre(Personaje.karl).
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.PORTERO).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.AUSTRIA).
    	setUbicacion(Ubicacion.CASALIME);


    	// KURTZ

//     	Personaje kurtz = Personaje.nuevo().
//     	setNombre(Personaje.kurtz).
//     	setGenero(Genero.HOMBRE).
//     	setActividad(null).
//     	setEstadoSalud(EstadoSalud.VIVO).
//     	setNacionalidad(Nacionalidad.AUSTRIA).
//     	setUbicacion(Ubicacion.CAFEMOZART);

    	// MARTINS

    	Personaje martins = Personaje.nuevo().
    	setNombre(Personaje.martins).
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.ESCRITOR).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.ESTADOSUNIDOS).
    	setUbicacion(Ubicacion.CASALIME);


    	// PAINE

//    	Personaje paine = Personaje.nuevo().
//    	setNombre(Personaje.paine).
//    	setGenero(Genero.HOMBRE).
//    	setActividad(ActividadLegal.POLICIA).
//    	setEstadoSalud(EstadoSalud.VIVO).
//    	setNacionalidad(Nacionalidad.GRANBRETANA).
//    	setUbicacion(Ubicacion.CEMENTERIO);


    	// Relaciones iniciales

    	martins.getConoce_a().add(lime);
//    	martins.getConoce_a().add(karl);
    	martins.getBusca_a().add(lime);
    	martins.getAmigo_de().add(lime);

    	lime.getConoce_a().add(martins);
    	lime.getConoce_a().add(karl);
    	lime.getAmigo_de().add(martins);
    	lime.getQuiere_a().add(anna);

    	anna.getAmigo_de().add(lime);
    	anna.getConoce_a().add(lime);
    	anna.getQuiere_a().add(lime);

//    	calloway.getAmigo_de().add(paine);
//    	calloway.getConoce_a().add(paine);
//    	calloway.getTrabaja_con().add(paine);

    	karl.getConoce_a().add(lime);
//    	karl.getConoce_a().add(martins);

    	// Insertar

    	ks.insert(anna);
    	ks.insert(lime);
    	ks.insert(calloway);
    	ks.insert(karl);
    	ks.insert(martins);
//    	ks.insert(paine);

    }
}
