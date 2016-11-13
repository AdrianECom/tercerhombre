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
		KieSession kSession = kContainer.newKieSession("ksession-rules");
	
	    // go !
		
		Main.insertarPersonajes(kSession);
		
	    kSession.fireAllRules();
    }
    
    // ------------------------------------
    
    public static void insertarPersonajes(KieSession ks){
    	
    	// ANNA
    	
    	Personaje.nuevo().
    	setActo(0).
    	setNombre("Anna").
    	setGenero(Genero.MUJER).
    	setActividad(null).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(null).
    	setUbicacion(Ubicacion.CEMENTERIO)
    	.fin();
    	
    	Personaje.nuevo().
    	setActo(1).
    	setNombre("Anna").
    	setGenero(Genero.MUJER).
    	setActividad(null).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(null).
    	setUbicacion(null)
    	.fin();
    	
    	// LIME
    	
    	Personaje.nuevo().
		setActo(0).
    	setNombre("Lime").
    	setGenero(Genero.HOMBRE).
    	setActividad(null).
    	setEstadoSalud(EstadoSalud.MUERTO).
    	setNacionalidad(Nacionalidad.ESTADOSUNIDOS).
    	setUbicacion(Ubicacion.CEMENTERIO)
    	.fin();
    	
    	Personaje.nuevo().
		setActo(1).
    	setNombre("Lime").
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadIlegal.TRAFICANTE).
    	setEstadoSalud(EstadoSalud.MUERTO).
    	setNacionalidad(Nacionalidad.ESTADOSUNIDOS).
    	setUbicacion(Ubicacion.CEMENTERIO)
    	.fin();
    	
    	// CALLOWAY
    	
    	Personaje.nuevo().
		setActo(0).
    	setNombre("Calloway").
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.POLICIA).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.GRANBRETAÑA).
    	setUbicacion(Ubicacion.CEMENTERIO)
    	.fin();
    	
    	Personaje.nuevo().
		setActo(1).
    	setNombre("Calloway").
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.POLICIA).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.GRANBRETAÑA).
    	setUbicacion(Ubicacion.PUB)
    	.fin();
    	
    	// CRABBIN
    	
    	Personaje.nuevo().
		setActo(1).
    	setNombre("Crabbin").
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.DIRECTIVO).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.GRANBRETAÑA).
    	setUbicacion(Ubicacion.HOTELSACHER)
    	.fin();
    	
    	// KARL
    	
    	Personaje.nuevo().
		setActo(0).
    	setNombre("Karl").
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.PORTERO).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.AUSTRIA).
    	setUbicacion(Ubicacion.CASALIME)
    	.fin();
    	
    	Personaje.nuevo().
		setActo(1).
    	setNombre("Karl").
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.PORTERO).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.AUSTRIA).
    	setUbicacion(Ubicacion.CASALIME)
    	.fin();
    	
    	// KURTZ
    	
    	Personaje.nuevo().
		setActo(1).
    	setNombre("Kurtz").
    	setGenero(Genero.HOMBRE).
    	setActividad(null).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.AUSTRIA).
    	setUbicacion(Ubicacion.CAFEMOZART)
    	.fin();
    	
    	// MARTINS
    	
    	Personaje.nuevo().
		setActo(0).
    	setNombre("Martins").
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.ESCRITOR).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.ESTADOSUNIDOS).
    	setUbicacion(Ubicacion.CEMENTERIO)
    	.fin();
    	
    	Personaje.nuevo().
		setActo(1).
    	setNombre("Martins").
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.ESCRITOR).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.ESTADOSUNIDOS).
    	setUbicacion(Ubicacion.CAFEMOZART)
    	.fin();
    	
    	// PAINE
    	
    	Personaje.nuevo().
		setActo(0).
    	setNombre("Paine").
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.POLICIA).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.GRANBRETAÑA).
    	setUbicacion(Ubicacion.CEMENTERIO)
    	.fin();
    	
    	Personaje.nuevo().
		setActo(1).
    	setNombre("Paine").
    	setGenero(Genero.HOMBRE).
    	setActividad(ActividadLegal.POLICIA).
    	setEstadoSalud(EstadoSalud.VIVO).
    	setNacionalidad(Nacionalidad.GRANBRETAÑA).
    	setUbicacion(Ubicacion.HOTELSACHER)
    	.fin();
    	    	
    	
    	
    	// TODO: relaciones
    	
    	
    	
    	// Insertar
    	for (Personaje p : Personaje.getAll()) {
			ks.insert(p);
		}
    	
    }
}


