package tercerhombre.personaje;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import tercerhombre.propiedades.Actividad;
import tercerhombre.propiedades.EstadoSalud;
import tercerhombre.propiedades.Genero;
import tercerhombre.propiedades.Nacionalidad;
import tercerhombre.propiedades.Ubicacion;

public class Personaje {
	
	// -----------------------------------
	
	// MAPA DE PERSONAJES
	
	/*
	 * Mapa estático para guardar todos los personajes.
	 * Cada elemento del mapa contiene un array, cada posición del array 
	 * representa un acto: 0,1,2,3,4,5.
	 */
	
	private static HashMap<String, ArrayList<Personaje>> mapaPersonajes = new HashMap<String, ArrayList<Personaje>>();
	
	public static Personaje get(String nombre, int acto) {
		
		Personaje personaje = null;
		
		if(mapaPersonajes.get(nombre) != null)
			personaje = mapaPersonajes.get(nombre).get(acto);
		
		return personaje;
	}
	
	public static Collection<Personaje> getAll() {
		
		// obtenemos los arrays
		Collection<ArrayList<Personaje>> arrays = mapaPersonajes.values();
		
		// creamos un array que contendrá todos los personajes.
		ArrayList<Personaje> all = new ArrayList<Personaje>();
		
		// creamos el array único
		for (ArrayList<Personaje> a : arrays)
			all.addAll(a);
		
		return all;
	}
	
	public static void add(Personaje personaje) {
		
		String nombre = personaje.getNombre();
		int acto = personaje.getActo();
		
		// si ese personaje aún no tiene array, se crea.
		if(mapaPersonajes.get(nombre) == null){
			
			ArrayList<Personaje> array = new ArrayList<Personaje>(6);
			
			for (int i = 0; i < 6; i++)
				array.add(i, null);
			
			mapaPersonajes.put(nombre, array);
		}
		
		// insertar al personaje en el array, en el acto correspondiente.
		mapaPersonajes.get(nombre).add(acto, personaje);
		
	}
	
	// ------------------------------------

	//	PROPIEDADES

	private String nombre;
	private EstadoSalud estadoSalud;
	private Nacionalidad nacionalidad;
	private Ubicacion ubicacion;
	private Genero genero;
	private Actividad actividad;
	private int acto;

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

	// ------------------------------------

	// CONSTRUCTOR

	public Personaje() {

	}
	
	// ------------------------------------
	
	// CONSTRUCTOR STATIC
	
	/*
	 * Para no tener que hacer new. Ahora podemos usar esto
	 * junto con los setters encadenados para crear a los personajes
	 * más rápido.
	 */
	
	// crea un nuevo personaje vacío.
	public static Personaje nuevo(){
		return new Personaje();
	}
	
	// lo añade al mapa.	
	public void fin(){
		Personaje.add(this); 	
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

	public Personaje setAmigo_de(List<Personaje> amigo_de) {
		this.amigo_de = amigo_de;
		return this;
	}

	public List<Personaje> getMata_a() {
		return mata_a;
	}

	public Personaje setMata_a(List<Personaje> mata_a) {
		this.mata_a = mata_a;
		return this;
	}

	public List<Personaje> getEnfrentado_con() {
		return enfrentado_con;
	}

	public Personaje setEnfrentado_con(List<Personaje> enfrentado_con) {
		this.enfrentado_con = enfrentado_con;
		return this;
	}

	public List<Personaje> getBusca_a() {
		return busca_a;
	}

	public Personaje setBusca_a(List<Personaje> busca_a) {
		this.busca_a = busca_a;
		return this;
	}

	public List<Personaje> getAsesinado_por() {
		return asesinado_por;
	}

	public Personaje setAsesinado_por(List<Personaje> asesinado_por) {
		this.asesinado_por = asesinado_por;
		return this;
	}

	public List<Personaje> getQuiere_a() {
		return quiere_a;
	}

	public Personaje setQuiere_a(List<Personaje> quiere_a) {
		this.quiere_a = quiere_a;
		return this;
	}

	public List<Personaje> getEn_realidad_es() {
		return en_realidad_es;
	}

	public Personaje setEn_realidad_es(List<Personaje> en_realidad_es) {
		this.en_realidad_es = en_realidad_es;
		return this;
	}

	public List<Personaje> getSospecha_de() {
		return sospecha_de;
	}

	public Personaje setSospecha_de(List<Personaje> sospecha_de) {
		this.sospecha_de = sospecha_de;
		return this;
	}

	public List<Personaje> getConoce_a() {
		return conoce_a;
	}

	public Personaje setConoce_a(List<Personaje> conoce_a) {
		this.conoce_a = conoce_a;
		return this;
	}

	public List<Personaje> getTrabaja_con() {
		return trabaja_con;
	}

	public Personaje setTrabaja_con(List<Personaje> trabaja_con) {
		this.trabaja_con = trabaja_con;
		return this;
	}

	public int getActo() {
		return acto;
	}

	public Personaje setActo(int acto) {
		this.acto = acto;
		return this;
	}



}
