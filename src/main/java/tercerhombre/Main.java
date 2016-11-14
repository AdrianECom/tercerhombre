package tercerhombre;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import tercerhombre.personaje.Personaje;
import tercerhombre.propiedades.Actividad;
import tercerhombre.propiedades.ActividadIlegal;
import tercerhombre.propiedades.ActividadLegal;
import tercerhombre.propiedades.EstadoSalud;
import tercerhombre.propiedades.Genero;
import tercerhombre.propiedades.Nacionalidad;
import tercerhombre.propiedades.Ubicacion;

public class Main {

	// ------------------------------------

    public static final void main(String[] args) {
        try {
            Main.inicio();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    // ------------------------------------

    public static void inicio(){

		// load up the knowledge base
	    KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules0");

	    // go !

		Main.insertarPersonajes(kSession);

	    kSession.fireAllRules();
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
    	setUbicacion(Ubicacion.CEMENTERIO);


    	// LIME

    	Personaje lime = Personaje.nuevo().
		setActo(0).
    	setNombre(Personaje.lime).
    	setGenero(Genero.HOMBRE).
    	setActividad(null).
    	setEstadoSalud(EstadoSalud.MUERTO).
    	setNacionalidad(Nacionalidad.ESTADOSUNIDOS).
    	setUbicacion(Ubicacion.CEMENTERIO);


    	// CALLOWAY

    	Personaje calloway = Personaje.nuevo().
		setActo(0).
    	setNombre(Personaje.calloway).
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.POLICIA).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.GRANBRETAÑA).
    	setUbicacion(Ubicacion.CEMENTERIO);


    	// CRABBIN

    // 	Personaje crabbin = Personaje.nuevo().
		// setActo(1).
    // 	setNombre(Personaje.crabbin).
    // 	setGenero(Genero.HOMBRE).
    // 	setActividad(ActividadLegal.DIRECTIVO).
    // 	setEstadoSalud(EstadoSalud.VIVO).
    // 	setNacionalidad(Nacionalidad.GRANBRETAÑA).
    // 	setUbicacion(Ubicacion.HOTELSACHER);

    	// KARL

    	Personaje karl = Personaje.nuevo().
		setActo(0).
    	setNombre(Personaje.karl).
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.PORTERO).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.AUSTRIA).
    	setUbicacion(Ubicacion.CASALIME);


    	// KURTZ

    // 	Personaje kurtz = Personaje.nuevo().
		// setActo(1).
    // 	setNombre(Personaje.kurtz).
    // 	setGenero(Genero.HOMBRE).
    // 	setActividad(null).
    // 	setEstadoSalud(EstadoSalud.VIVO).
    // 	setNacionalidad(Nacionalidad.AUSTRIA).
    // 	setUbicacion(Ubicacion.CAFEMOZART);

    	// MARTINS

    	Personaje martins = Personaje.nuevo().
		setActo(0).
    	setNombre(Personaje.martins).
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.ESCRITOR).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.ESTADOSUNIDOS).
    	setUbicacion(Ubicacion.CEMENTERIO);


    	// PAINE

    	Personaje paine = Personaje.nuevo().
		setActo(0).
    	setNombre(Personaje.paine).
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.POLICIA).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.GRANBRETAÑA).
    	setUbicacion(Ubicacion.CEMENTERIO);


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
