package tercerhombre;

import java.util.Collection;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import tercerhombre.consultas.Consulta;
import tercerhombre.consultas.ConsultaQuien;
import tercerhombre.personaje.Personaje;
import tercerhombre.propiedades.ActividadLegal;
import tercerhombre.propiedades.EstadoSalud;
import tercerhombre.propiedades.Genero;
import tercerhombre.propiedades.Nacionalidad;
import tercerhombre.propiedades.Ubicacion;

public class Main {

	// ------------------------------------

    public static final void main(String[] args) {
        try {
        	LectorConsultas lc = new LectorConsultas();
        	List<Consulta> consultas = lc.LeeFichero("src/main/resources/Consultas");
            Main.inicio(consultas);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    // ------------------------------------

    public static void inicio(List<Consulta> consultas){
    	
		// load up the knowledge base
	    KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules0");

	    // go !

		Main.insertarPersonajes(kSession);

		// TODO: leer fichero
		// TODO: focus en el acto concreto
		
		/*
		 * TODO:
		 * Si por ejemplo piden acto 4,
		 * necesitamos disparar las reglas del acto 0, del acto 1,
		 * del acto 2, del acto 3 y del acto 4.
		 */
		
	    kSession.fireAllRules();
	    
	    
	    // TODO: necesito saber si hemos hecho un QUE o un QUIEN
	    
	    // TODO: de momento probamos con la PRIMERA consulta
	    
	    Consulta c = consultas.get(0);
	    
	    System.out.println("\n##############################\n");
	    
	    System.out.println("CONSULTA: " + c.getClass().toString());
	    for (Personaje p: (Collection<Personaje>)kSession.getObjects()) {
			System.out.println(p.getNombre());
		}

	    // TODO: aquí se hace el log

	    for (Personaje p : Personaje.getTodosActo(0)) {
			System.out.println(p.getNombre());
		}

    }

    // ------------------------------------

    public static void insertarPersonajes(KieSession ks){


    	// Estado inicial de los personajes

    	// ANNA

    	Personaje anna = Personaje.nuevo().
    	setActo(0).
    	setNombre(Personaje.anna).
    	setGenero(Genero.MUJER).
    	setActividad(null).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(null).
    	setUbicacion(Ubicacion.CEMENTERIO).
    	fin();


    	// LIME

    	Personaje lime = Personaje.nuevo().
		setActo(0).
    	setNombre(Personaje.lime).
    	setGenero(Genero.HOMBRE).
    	setActividad(null).
    	setEstadoSalud(EstadoSalud.MUERTO).
    	setNacionalidad(Nacionalidad.ESTADOSUNIDOS).
    	setUbicacion(Ubicacion.CEMENTERIO).
    	fin();


    	// CALLOWAY

    	Personaje calloway = Personaje.nuevo().
		setActo(0).
    	setNombre(Personaje.calloway).
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.POLICIA).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.GRANBRETANA).
    	setUbicacion(Ubicacion.CEMENTERIO).
    	fin();


    	// CRABBIN

    // 	Personaje crabbin = Personaje.nuevo().
		// setActo(1).
    // 	setNombre(Personaje.crabbin).
    // 	setGenero(Genero.HOMBRE).
    // 	setActividad(ActividadLegal.DIRECTIVO).
    // 	setEstadoSalud(EstadoSalud.VIVO).
    // 	setNacionalidad(Nacionalidad.GRANBRETAÃâA).
    // 	setUbicacion(Ubicacion.HOTELSACHER).
    // fin();

    	// KARL

    	Personaje karl = Personaje.nuevo().
		setActo(0).
    	setNombre(Personaje.karl).
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.PORTERO).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.AUSTRIA).
    	setUbicacion(Ubicacion.CASALIME).
    	fin();


    	// KURTZ

    // 	Personaje kurtz = Personaje.nuevo().
		// setActo(1).
    // 	setNombre(Personaje.kurtz).
    // 	setGenero(Genero.HOMBRE).
    // 	setActividad(null).
    // 	setEstadoSalud(EstadoSalud.VIVO).
    // 	setNacionalidad(Nacionalidad.AUSTRIA).
    // 	setUbicacion(Ubicacion.CAFEMOZART).
    // fin();

    	// MARTINS

    	Personaje martins = Personaje.nuevo().
		setActo(0).
    	setNombre(Personaje.martins).
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.ESCRITOR).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.ESTADOSUNIDOS).
    	setUbicacion(Ubicacion.CEMENTERIO).
    	fin();


    	// PAINE

    	Personaje paine = Personaje.nuevo().
		setActo(0).
    	setNombre(Personaje.paine).
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.POLICIA).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.GRANBRETANA).
    	setUbicacion(Ubicacion.CEMENTERIO).
    	fin();


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

    	calloway.getAmigo_de().add(paine);
    	calloway.getConoce_a().add(paine);
    	calloway.getTrabaja_con().add(paine);

    	karl.getConoce_a().add(lime);
//    	karl.getConoce_a().add(martins);

    	// Insertar

    	ks.insert(anna);
    	ks.insert(lime);
    	ks.insert(calloway);
    	ks.insert(karl);
    	ks.insert(martins);
    	ks.insert(paine);

    }
}
