package tercerhombre;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import tercerhombre.personaje.Personaje;
import tercerhombre.propiedades.Actividad;
import tercerhombre.propiedades.ActividadIlegal;
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
		KieSession kSession = kContainer.newKieSession("ksession-rules");
	
	    // go !
		
		Main.insertarPersonajes(kSession);
		
	    kSession.fireAllRules();
    }
    
    // ------------------------------------
    
    public static void insertarPersonajes(KieSession ks){
    	
    	Personaje anna1 = Personaje.crear().
    	setNombre("Anna").
    	setGenero(Genero.MUJER).
    	setActividad(null).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(null).
    	setUbicacion(null);
    	
    	Personaje lime1 = Personaje.crear().
    	setNombre("Lime").
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadIlegal.TRAFICANTE).
    	setEstadoSalud(EstadoSalud.MUERTO).
    	setNacionalidad(Nacionalidad.ESTADOSUNIDOS).
    	setUbicacion(Ubicacion.CEMENTERIO);
    	
    	ks.insert(anna1);
    	ks.insert(lime1);
    	
    }
}


