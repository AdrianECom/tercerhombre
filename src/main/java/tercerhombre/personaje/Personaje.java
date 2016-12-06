package tercerhombre.personaje;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import tercerhombre.propiedades.Actividad;
import tercerhombre.propiedades.EstadoSalud;
import tercerhombre.propiedades.Genero;
import tercerhombre.propiedades.Nacionalidad;
import tercerhombre.propiedades.Relacion;
import tercerhombre.propiedades.Ubicacion;

public class Personaje {
	
	private boolean modificado;

	// -----------------------------------

	// NOMBRES

	/*
	 * Para no tener que estar usando cadenas todo el rato.
	 */

	public static String anna = "Anna";
	public static String lime = "Lime";
	public static String calloway = "Calloway";
	public static String crabbin = "Crabbin";
	public static String karl = "Karl";
	public static String kurtz = "Kurtz";
	public static String martins = "Martins";
	public static String paine = "Paine";

	// ------------------------------------

	//	PROPIEDADES

	private String nombre;
	private EstadoSalud estadoSalud;
	private Nacionalidad nacionalidad;
	private Ubicacion ubicacion;
	private Genero genero;
	private Actividad actividad;

	// ------------------------------------

	// RELACIONES

	private List<Personaje> amigo_de;
	private List<Personaje> mata_a;
	private List<Personaje> enfrentado_con;
	private List<Personaje> busca_a;
	private List<Personaje> asesinado_por;
	private List<Personaje> quiere_a;
	private List<Personaje> en_realidad_es;
	private List<Personaje> sospecha_de;
	private List<Personaje> conoce_a;
	private List<Personaje> trabaja_con;
	
	// cada personaje tendrá una lista de sus relaciones para facilitar la impresión en el fichero.
	private List<List<Personaje>> listaDeRelaciones;
	
	// ------------------------------------
	
	// LISTA DE ENUMERADOS RELACION STATIC
	
	// IMPORTANTE
	/*
	 * ESTA LISTA ES STATIC. Porque es la misma para todos los objetos Personaje.
	 */
	public static List<Relacion> listaDeRelacionesEnum = new ArrayList<Relacion>();
	
	/*
	 * Inicializamos la lista en este bloque static
	 */
	static{
		Personaje.listaDeRelacionesEnum.add(Relacion.CONOCE_A);
		Personaje.listaDeRelacionesEnum.add(Relacion.AMIGO_DE);
		Personaje.listaDeRelacionesEnum.add(Relacion.MATA_A);
		Personaje.listaDeRelacionesEnum.add(Relacion.ENFRENTADO_CON);
		Personaje.listaDeRelacionesEnum.add(Relacion.BUSCA_A);
		Personaje.listaDeRelacionesEnum.add(Relacion.ASESINADO_POR);
		Personaje.listaDeRelacionesEnum.add(Relacion.QUIERE_A);
		Personaje.listaDeRelacionesEnum.add(Relacion.EN_REALIDAD_ES);
		Personaje.listaDeRelacionesEnum.add(Relacion.SOSPECHA_DE);
		Personaje.listaDeRelacionesEnum.add(Relacion.TRABAJA_CON);
	}
		

	// ------------------------------------

	// CONSTRUCTOR

	public Personaje() {
		
		modificado = false;
		
		this.amigo_de = new ArrayList<Personaje>();
		this.mata_a = new ArrayList<Personaje>();
		this.enfrentado_con = new ArrayList<Personaje>();
		this.busca_a = new ArrayList<Personaje>();
		this.asesinado_por = new ArrayList<Personaje>();
		this.quiere_a = new ArrayList<Personaje>();
		this.en_realidad_es = new ArrayList<Personaje>();
		this.sospecha_de = new ArrayList<Personaje>();
		this.conoce_a = new ArrayList<Personaje>();
		this.trabaja_con = new ArrayList<Personaje>();
		
		this.listaDeRelaciones = new ArrayList<List<Personaje>>();
		
		// IMPORTANTE INSERTAR LISTAS Y ENUM EN EL MISMO ORDEN
		
		this.listaDeRelaciones.add(conoce_a);
		this.listaDeRelaciones.add(amigo_de);
		this.listaDeRelaciones.add(mata_a);
		this.listaDeRelaciones.add(enfrentado_con);
		this.listaDeRelaciones.add(busca_a);
		this.listaDeRelaciones.add(asesinado_por);
		this.listaDeRelaciones.add(quiere_a);
		this.listaDeRelaciones.add(en_realidad_es);
		this.listaDeRelaciones.add(sospecha_de);
		this.listaDeRelaciones.add(trabaja_con);
		
		
		
		
	}
	
	// ------------------------------------
	
	public boolean isModificado() {
		return modificado;
	}
	
	public void setModificado(boolean bool) {
		this.modificado = bool;
	}

	// ------------------------------------

	// CONSTRUCTOR STATIC

	/*
	 * Para no tener que hacer new. Ahora podemos usar esto
	 * junto con los setters encadenados para crear a los personajes
	 * más rápido.
	 */
	public static Personaje nuevo(){
		return new Personaje();
	}
	
	// ------------------------------------
	
	// TO STRING
	
	/*
	 * Imprime una relación. Por ejemplo, la relación conoce_a se imprimiría como:
	 * 
	 * Martins es conoce a Karl, conoce a Lime y conoce a Anna.
	 */
	public static String relacionToString(String nombre, Relacion r, List<Personaje> relacion, String sufijo){
		
		String s = "";
		
		// Si la relación es vacía no imprime nada.
		if(!relacion.isEmpty()){
			
			int n = relacion.size();
			
			s+=nombre+" "; // martins conoce a
			
			// para cada elemento de la lista
			for (int i = 0; i < n; i++) {
				
				
				s+= r.toString(sufijo)+" "+relacion.get(i).getNombre() ;
				
				if(n > 1 && i == n-2)
					s+= " y ";
				else if(n > 2 && i < n-1)
					s+= ", ";
			}
			
			s+=". ";
		}
		
		return s;
	}
	
	@Override
	public String toString() {
		
		String end = ". ";
		
		String sufijo = genero.sufijo();
		String un = genero.un();
		String generoStr = genero.toString();

		String nacionalidadStr = "desconocida";
		String ubicacionStr = " ubicación desconocida";
		
		if(nacionalidad != null)
			nacionalidadStr = nacionalidad.toString();
		
		if(ubicacion != null)
			ubicacionStr = ubicacion.toString();
		
		
		// En esta cadena se imprime todo.
		String total = "";
		
		total+=nombre+" está "+estadoSalud.toString()+sufijo+end;
		total+="Es "+un+ " "+ generoStr +" de nacionalidad "+nacionalidadStr+end;
		
		if(actividad != null)
			total+="Es "+un+ " "+ actividad.toString()+end;
		else
			total+="Se desconoce su actividad"+end;
		
		total+="Al final del acto va a"+ubicacionStr+end;
		
		// Se imprimen las relaciones
		for (int i = 0; i < listaDeRelaciones.size(); i++) {
			total+=relacionToString(nombre, listaDeRelacionesEnum.get(i), listaDeRelaciones.get(i), sufijo);
		}
		
		return total;
	}

	// ------------------------------------

	// GETTERS y SETTERS

	/*
	 * Los setters devuelven this, para poder
	 * encadenarlos.
	 */


	public String getNombre() {
		return nombre;
	}

	public Personaje setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public EstadoSalud getEstadoSalud() {
		return estadoSalud;
	}

	public Personaje setEstadoSalud(EstadoSalud estadoSalud) {
		this.estadoSalud = estadoSalud;
		return this;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public Personaje setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
		return this;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public Personaje setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
		return this;
	}

	public Genero getGenero() {
		return genero;
	}

	public Personaje setGenero(Genero genero) {
		this.genero = genero;
		return this;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public Personaje setActividad(Actividad actividad) {
		this.actividad = actividad;
		return this;
	}

	public List<Personaje> getAmigo_de() {
		return amigo_de;
	}

	public List<Personaje> getMata_a() {
		return mata_a;
	}

	public List<Personaje> getEnfrentado_con() {
		return enfrentado_con;
	}

	public List<Personaje> getBusca_a() {
		return busca_a;
	}

	public List<Personaje> getAsesinado_por() {
		return asesinado_por;
	}

	public List<Personaje> getQuiere_a() {
		return quiere_a;
	}

	public List<Personaje> getEn_realidad_es() {
		return en_realidad_es;
	}

	public List<Personaje> getSospecha_de() {
		return sospecha_de;
	}

	public List<Personaje> getConoce_a() {
		return conoce_a;
	}

	public List<Personaje> getTrabaja_con() {
		return trabaja_con;
	}

	public List<List<Personaje>> getListaDeRelaciones() {
		return listaDeRelaciones;
	}

	

}
