  package jcolonia.daw2022.fichaDeRol;

import java.util.Vector;


/**
 * Almacena y gestiona una coleccion de fichas de personaje.
 * Durante una sesion.
 * @author <a href= "mailto:luisbienal@gmail.com">Luis G. Contreras</a>
 */
public class Equipo {
	/**
	 * Lista para almacenar los personajes.
	 */
	private Vector<PersonajeFicha> listaDePersonajes;

	/**
	 * Inicializa la lista de personajes.
	 */
	public Equipo(){
		listaDePersonajes=new Vector<>();
	}
	
	/**
	 * Añade un nuevo personaje y lo almacena en la lista de personaje.
	 * @param nuevoPersonaje el nuevo personaje creado
	 */
	public void añadirNuevoPersonaje(PersonajeFicha nuevoPersonaje) {
		listaDePersonajes.add(nuevoPersonaje);
	}
	
	/**
	 * Le indicas un numero de personaje 
	 * y te devuelve una ficha de personaje.
	 * @param posicion La posicion
	 * @return El personaje correspondiente
	 **/
	public PersonajeFicha consultarPersonajePorNumero(int posicion) {
		return listaDePersonajes.get(posicion);
	}
	
	/**
	 * Te devuelve el numero de personajes que hay en guardadas en listaDatos.
	 * @return listaDatos
	 */
	public int consultarNumeroDePersonajes() {
		return listaDePersonajes.size();
	}
	
	/**
	 * Pasa de tipo dato de tipoX a tipo String.
	 * Devuelvela lista con el texto introducido hasta ahora.
	 * @return rasgoText 
	 */
	public Vector<String> tipoXToText(){
		Vector<String> rasgoText = new Vector<String>();
		for (PersonajeFicha rasgos : listaDePersonajes) {
			rasgoText.add(rasgos.toString());
		}
		return rasgoText;
	}
	
	/**
	 * Recoge un equipo y
	 * lo pasa al formato adecuado para el archivo CSV:
	 * Cada ficha conformaria 1 unica linea 
	 * con todos los campos del personaje separados por hastag #.
	 * y devuelve dicha coleccion
	 * @return camposCsv una colección de campos formateados en formato CSV.
	 */
	public Vector<String> formatearEquipoToCsv(){
		Vector<String> camposCsv = new Vector<String>();
		for (PersonajeFicha datos : listaDePersonajes) {
			camposCsv.add(datos.toStringCsv());
		}
		return camposCsv;
	}


}