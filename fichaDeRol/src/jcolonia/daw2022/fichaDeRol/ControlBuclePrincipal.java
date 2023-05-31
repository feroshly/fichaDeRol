package jcolonia.daw2022.fichaDeRol;

import java.util.Vector;

/**
 * Gestiona el bucle principal del que dependen el resto de funcionalidades.
 * @author <a href= "mailto:luisbienal@gmail.com">Luis G. Contreras</a>
 */
public class ControlBuclePrincipal {
	
	/**
	 * Lista de textos asociados a cada una de las opciones para elegir en el menu.
	 */
	private final String[] OPCIONES_MENU = { "Crear personaje", "Mostrar personajes", "Exportar equipo a base de datos (En proceso)",
			"Importar equipo desde base de datos (En proceso)" };

	/**
	 * Lista de textos que se mostrara dependiendo de cual opcion del menu
	 * selecciones previamente.
	 */
	private final String[] RESPUESTAS_SUBTITULO = { "Seleccionaste Opción uno", "Seleccionaste Opción dos",
			"Seleccionaste Opción tres", "Seleccionaste opcion cuatro" };
	/**
	 * Coleccion donde se almacenan personajes en cada inicio del programa.
	 */
	Equipo equipoPrincipal;


	/**
	 * Inicializa los elementos con un equipo vacío y una lista de nuevos personajes también vacía.
	 */
	public ControlBuclePrincipal() {
		equipoPrincipal = new Equipo();
	}

	/**
	 * El nucleo del programa que inicia un menú principal.
	 * Pone en marcha el MENU PRINCIPAL y permite seleccionar distintas opciones.
	 * 1-Crear un personaje y que se pertenecera al equipo.
	 * 2-Mostrar por pantalla el equipo de personajes.
	 * 3-Exportar el equipo a un archivo CSV.
	 * 4-Importar el equipo desde el archivo CSV.
	 */
	private void buclePrincipal() {
		boolean salir;
		int respuesta;
		VistaMenu menu = new VistaMenu(OPCIONES_MENU);

		salir = false;
		do {
			System.out.printf("-----------------%n");
			System.out.printf("MENU PRINCIPAL%n");
			System.out.printf("-----------------%n");
			menu.mostrarOpciones();
			respuesta = menu.pedirOpcion();
			switch (respuesta) {
			case 1:
				System.out.printf("%s%n", RESPUESTAS_SUBTITULO[0]);
				opcionCrearPersonaje();
				break;

			case 2:
				System.out.printf("%s%n", RESPUESTAS_SUBTITULO[1]);
				opciónListadoTextos();
				break;

			case 3:
				System.out.printf("%s%n", RESPUESTAS_SUBTITULO[2]);
				opciónExportarTextos();
				break;

			case 4:
				System.out.printf("%s%n", RESPUESTAS_SUBTITULO[3]);
				opcionImportarTextos();
				break;

			case 0:
				salir = true;

			default:
				System.out.printf("\nSe acabo el programa\n\n");
			}
		} while (!salir);
	}

	/**
	 * Crea un personaje.
	 * Para ello pide al usuario que escriba textos y le hace elegir entre varias opciones 
	 * para rellenar la ficha de personaje.
	 */
	private void opcionCrearPersonaje() {
		PersonajeFicha nuevoPersonaje;
		VistaAltas vistaA = new VistaAltas();

		try {
		    nuevoPersonaje = vistaA.cargarPersonaje();
		    // ------Para guardarlo en lista y visualizarlo.
		    equipoPrincipal.añadirNuevoPersonaje(nuevoPersonaje);
		} catch (VistaGeneralException e) {
		    System.out.printf("Alta abortada: %s%n",e.getMessage());
		} catch (RuntimeException e) {
			System.out.printf("Alta abortada: %s%n",e.getMessage());
			//Da error por que se resta 1 al array de opciones
			//Esto es problematico al aplicarse al array de un enum ya que no existe menos que cero.
			//Aunque no lo sea a la hora de mostrar el menu principal por que ocurre dentro de un switch,
			//por que en el switch exite un "case 0:"
		}
	}

	/**
	 * Muestra por pantalla el equipo.
	 */
	private void opciónListadoTextos() {
		VistaListadoTextos listado = new VistaListadoTextos(equipoPrincipal);
		listado.mostrar();
	}

	/**
	 * Lee un archivo CSV especificado y lo copia en un lista para mostrarlo por
	 * pantalla con un formato adecuado.
	 */
	private void opcionImportarTextos() {
		PersonajeFicha fichaRecuperado=new PersonajeFicha();
		equipoPrincipal=fichaRecuperado.importarPersonajeFichaCsvToEquipo();
	}

	/**
	 * Crea un archivo CSV con todos los personajes(el equipo) creados en esa sesion.
	 */
	private void opciónExportarTextos() {
		
		Vector <String> listaTodosPersonajes=equipoPrincipal.formatearEquipoToCsv();
		AccesoDatos.exportarEquipoToCsv(listaTodosPersonajes, "LaFichaDePersonajeGuardada.csv");
	}


	/**
	 * Pone en marcha todo
	 * @param args Los argumentos
	 */
	public static void main(String[] args) {
		ControlBuclePrincipal control = new ControlBuclePrincipal();
		control.buclePrincipal();
		
	}

}
