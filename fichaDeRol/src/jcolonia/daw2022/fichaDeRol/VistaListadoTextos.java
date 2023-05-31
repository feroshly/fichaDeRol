package jcolonia.daw2022.fichaDeRol;

import java.util.Vector;


/**
 * Muestra las fichas de personaje que se han guardado en el equipo principal.
 * @author <a href= "mailto:luisbienal@gmail.com">Luis G. Contreras</a>
 */
public class VistaListadoTextos{
	/**
	 * 
	 */
	private Vector<Equipo> fichaAlmacenada;

	/**
	 * Le llega un equipo(antes una coleccion) y la asigna a otra coleccion.
	 * @param listaTextos El equipo que le llega.
	 */
	public VistaListadoTextos(Equipo listaTextos) {
		fichaAlmacenada=new Vector<Equipo>();
		fichaAlmacenada.add(listaTextos);
	}

	/**
	 * Muestra por pantalla las fichas completadas hasta ahora en la misma sesion.
	 */
	public void mostrar(){
	    for (Equipo camposFicha : fichaAlmacenada) {
	        Vector<String> textoFichas = camposFicha.tipoXToText();//El @Overrride solo funciona en los objetos de clase donde este el @Overrride.
	        for (String texto : textoFichas) {
	            System.out.println(texto);
	        }
	    }
	}
	
	
}
