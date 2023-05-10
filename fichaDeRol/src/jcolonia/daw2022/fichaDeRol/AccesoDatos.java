package jcolonia.daw2022.fichaDeRol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Te permite gestionar la informacion y pasarla a un archivo externo.
 * @author <a href= "mailto:luisbienal@gmail.com">Luis G. Contreras</a>
 */
public class AccesoDatos {

	/**
	 * Crea un archivo con las el equipo de personajes que llevara ese nombre y formato.
	 * @param equipoDePersonajes Lista de campos de una ficha de personaje completada
	 * @param refArchivo El nombre del archivo que va crear
	 */	
	public static void exportarEquipoToCsv(List<String> equipoDePersonajes, String refArchivo) {
	try {
//		Path nombreArchivo = Path.of(refArchivo);
		File archivo = new File(refArchivo);
		PrintWriter toFile = new PrintWriter(archivo);
		
		for (String camposFicha : equipoDePersonajes) {
			toFile.println(camposFicha);
		}
		toFile.close();
	} catch (FileNotFoundException e) {
		System.err.printf("Ruta no encontrada: %s", e.getLocalizedMessage());
	}
}

	
	
	

}
