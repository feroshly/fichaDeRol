package jcolonia.daw2022.fichaDeRol;

import java.util.ArrayList;

/**
 * Gestiona el menu principal.
 * @author <a href= "mailto:luisbienal@gmail.com">Luis G. Contreras</a>
 */
public class VistaMenu extends VistaGeneral{	
	/**
	 * Lista con opciones para que el usuario elija.
	 */
	private ArrayList<String> listaOpciones;

	/**
	 * Inicializa el menu y sus elementos.
	 * @param opcionesMenuEjemplo las opciones correspondientes
	 * @param <T> el tipo correspondiente
	 */
	public <T> VistaMenu (T[] opcionesMenuEjemplo){

		listaOpciones=new ArrayList<>();
		for(T linea: opcionesMenuEjemplo){
			listaOpciones.add(linea.toString());
		}
	}
	
	/**
	 * Muestra las lista de opciones del menu por pantalla.
	 */
	public void mostrarOpciones() {
		int i =0;
		for(String linea: listaOpciones){
			System.out.printf("[%d] %s%n",++i,linea);
		}
		System.out.println("[0] Salir");
	}
	
	/**
	 * Pide al usuario que seleccione una opcion del menu intoduciendo un numero por consola.
	 * @return numOpcion El numero de la opcion seleccionada
	 */
	public int pedirOpcion() {
		int numOpcion=0;
		try{
			numOpcion=VistaGeneral.pedirEntero("Introduzca la opcion deseada", 0, listaOpciones.size());
		
		}catch(VistaGeneralException e){
			//Se captura la excpecionpero no le pedimos al programa hacer nada nada, solo continua normalmente, lo que le lleva ejecutar la accion asociada a 0 que es salir.
		}
		return numOpcion;
	}

}
