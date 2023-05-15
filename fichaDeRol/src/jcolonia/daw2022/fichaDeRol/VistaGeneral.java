package jcolonia.daw2022.fichaDeRol;

import java.util.Scanner;

/**
 * Gestiona la entrada y salida de informacion por consola.
 * @author <a href= "mailto:luisbienal@gmail.com">Luis G. Contreras</a>
 */
public class VistaGeneral {
	/**
	 * Texto para la peticion al usuario.
	 */
	private static final String TextoPeticion = "Introduzca un numero:\n";
	
	/**
	 * Elemento de entrada por consola.
	 */
	private static Scanner entrada;

	/**
	 * Inicializa el la entrada de texto por consola.
	 */
	public VistaGeneral() {
		entrada= new Scanner(System.in);
	}

	/**
	 * Cuando se introduce texto, devuelve el texto en forma de coleccion.
	 * @return listadoEntada la coleccion el texto.
	 */
	public String cargar() {
		String texto;
		texto = entrada.nextLine();	
		return texto;
	}	
	
	/**
	 * Gestiona la entrada de informacion por la consola de forma unica y global.
	 * Si no se introduce ningun dato devuelve igualmente un espacio.
	 * @return entrada La informacion correspondiente
	 */
	public static Scanner getEntrada(){
		if(entrada==null){
			entrada = new Scanner(System.in);
		}
		return entrada;
	}

	/**
	 * Devuelve un numero entero que ha pedido al usuario.
	 * @return numero El numero devuelto
	 */
	public static int pedirEntero() {
		int numero = 0;
		String entrada;
		Scanner sc = getEntrada();
		System.out.printf(TextoPeticion);

		entrada = sc.nextLine();
		numero = Integer.parseInt(entrada);
		return numero;
	}

	/**
	 * Hace una peticion al usuario.
	 * Despues devuelve un numero entero que ha
	 * pedido al usuario.
	 * @param pregunta Lo que pregunta
	 * @return numero El numero
	 */
	public static int pedirEntero(String pregunta) {
		int numero;
		String entrada;
		Scanner sc = getEntrada();;

		System.out.printf("%s %n", pregunta);

		entrada = sc.nextLine();
		numero = Integer.parseInt(entrada);
		return numero;
	}

	/**
	 * Devuelve un numero entero (delimitado entre 2 valores) que ha pedido al
	 * usuario y controla una serie de excepciones.
	 * 
	 * @param pregunta La pregunta
	 * @param valorMinimo El valor mas pequeño
	 * @param valorMaximo El valor mas grande
	 * @return numero El numero devuelto
	 * @throws VistaGeneralException La excepcion
	 */
	public static int pedirEntero(String pregunta, int valorMinimo, int valorMaximo) throws VistaGeneralException{
		int contadorFallos=0;
		int numero = 0;
		String entrada = null;
		boolean salir = false;
		Scanner sc = getEntrada();
		do {
			try {
				System.out.printf("%s %n", pregunta);
				entrada = sc.nextLine();
				numero = Integer.parseInt(entrada);
				if (numero < valorMinimo || numero > valorMaximo) {
					System.out.printf("%nIntroduzca un numero menor de [%s] y mayor de [%s] %n", valorMinimo, valorMaximo);
				}
				else {
					salir=true;
				}
			} catch (NumberFormatException e) {
				System.err.printf("%nNo puedes introducir letras, solo numeros %n");
				contadorFallos++;
			}
			if(contadorFallos>=3){
				throw new VistaGeneralException("Excedido el numero maximo de fallos");
			}
		} while (!salir);
		
		return numero;
	}

	/**
	 * Devuelve un numero entero (delimitado entre 2 valores) que ha pedido al
	 * usuario y controla una serie de excepciones.
	 * 
	 * @param valorMinimo El valor mas pequeño
	 * @param valorMaximo El valor mas grande
	 * @return numero El numero devuelto
	 * @throws VistaGeneralException La excepcion
	 */
	public static int pedirEnteroAlt(int valorMinimo, int valorMaximo) throws VistaGeneralException{
		int contadorFallos=0;
		int numero = 0;
		String entrada = null;
		boolean salir = false;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				entrada = sc.nextLine();
				numero = Integer.parseInt(entrada);
				if (numero < valorMinimo || numero > valorMaximo) {
					System.out.printf("%nIntroduzca un numero menor de [%s] y mayor de [%s] %n", valorMinimo, valorMaximo);
				}
				else {
					salir=true;
				}
			} catch (NumberFormatException e) {
				System.err.printf("%nNo puedes introducir letras, solo numeros %n");
				contadorFallos++;
			}
			if(contadorFallos>=3){
				throw new VistaGeneralException("Excedido el numero maximo de fallos");
			}
		} while (!salir);
		
		return numero;
	}


}
