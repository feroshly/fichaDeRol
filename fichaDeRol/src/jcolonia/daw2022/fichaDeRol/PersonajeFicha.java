package jcolonia.daw2022.fichaDeRol;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Almacena campos de distintos tipos que conformasn la ficha de personaje
 * y gestiona personajes o fichas de personaje.
 * @author <a href= "mailto:luisbienal@gmail.com">Luis G. Contreras</a>
 */
public class PersonajeFicha {
	
	/**
	 * El nombre del jugador.
	 */
	private String nombreJugador;
	
	/**
	 * El nombre del personaje.
	 */
	private String nombrePersonaje;
	
	/**
	 * Las diferentes profesiones a elegir por el usuario.
	 */
	private RasgoProfesiones profesion;
	
	/**
	 * Las diferentes raza a elegir por el usuario.
	 */
	private RasgoRazas raza;
	
	/**
	 * Las diferentes armadura a elegir por el usuario.
	 */
	private RasgoArmaduras armadura;
	
	/**
	 * Las diferentes arma a elegir por el usuario.
	 */
	private RasgoArmas arma;
	
	/**
	 * Inicializa los valores correspondientes.
	 */
	public PersonajeFicha() {
		super();
	}

	/**
	 * Pasa los datos del personaje a con formato de ficha de rol.
	 * Para visualizarse adecuadamente por pantalla.
	 */
	@Override
	public String toString() {

		String textoResultado="";
		
		textoResultado+=String.format("->>Ficha de Personaje:<<-%n");
		textoResultado+=String.format("  ·NOMBRE-JUGADOR:\n%s%n",nombreJugador);
		textoResultado+=String.format("  ·NOMBRE-PERSONAJE:\n%s%n", nombrePersonaje);
		textoResultado+=String.format("  ·PROFESION:\n%s%n", profesion);
		textoResultado+=String.format("  ·RAZA:\n%s%n" , raza);
		textoResultado+=String.format("  ·ARMADURA:\n%s%n" , armadura);
		textoResultado+=String.format("  ·ARMA:\n%s%n" , arma);
		textoResultado+=String.format("............\n");
		return textoResultado;
	}

	/**
	 * Pasa los datos del personaje a formato CSV: Una unica linea de texto separada por #almoadilla.
	 * @return textoResultado La linea
	 */
	public String toStringCsv(){
		String textoResultado="";
		textoResultado=String.format("%s#%s#%s#%s#%s#%s",nombreJugador, nombrePersonaje, profesion, raza, armadura, arma);
		return textoResultado;
	}

	/**
	 * Lee cada una de las lineas del archivo seleccionado
	 * y las formatea al estilo ficha de personaje de rol.
	 * @return equipoRetornado El equipo dentro del archivo Csv
	 */
	public Equipo importarPersonajeFichaCsvToEquipo(){
	    Equipo equipoRetornado = new Equipo();

	    Path refArchivo = Path.of("LaFichaDePersonajeGuardada.csv");
	    
	    try (BufferedReader in = Files.newBufferedReader(refArchivo)) {
	    	
	        String textoEntrada = in.readLine(); // Empieza a leer
	        while (textoEntrada != null) { // Seguir leyendo, Si hay una linea despues devuelve null.
	            PersonajeFicha fichaRetornada = importarLineaCsvToPersonajeFicha(textoEntrada);
	            equipoRetornado.añadirNuevoPersonaje(fichaRetornada);//la mete en equipo principal
	            textoEntrada = in.readLine(); // Para que siga leyendo en el siguiente ciclo del bucle
	        }
	    } catch (IOException e) {
	        System.err.printf("Error de escritura: %s", e.getLocalizedMessage());
	    }
	    return equipoRetornado;
	}
	
	/**
	 * Lee y Divide cada linea en secciones a partir de un separador hastag# 
	 * y rellena con cada seccion el campo correspondiente de la ficha de personaje.
	 * Devuelve la ficha de personaje completada.
	 * @param texto el texto correspondiente
	 * @return fichaInversa La ficha completada.
	 */
	public PersonajeFicha importarLineaCsvToPersonajeFicha(String texto){
		String [] seccion=texto.split("#");

		PersonajeFicha fichaInversa=new PersonajeFicha();
		
		fichaInversa.setNombreJugador(seccion[0]);
		fichaInversa.setNombrePersonaje(seccion[1]);
		
		RasgoProfesiones profesiones;
		profesiones=RasgoProfesiones.valueOf(seccion[2]);
		fichaInversa.setProfesion(profesiones);

		RasgoRazas raza;
		raza=RasgoRazas.valueOf(seccion[3]);
		fichaInversa.setRaza(raza);

		RasgoArmaduras armaduras;
		armaduras=RasgoArmaduras.valueOf(seccion[4]);
		fichaInversa.setArmadura(armaduras);
		
		RasgoArmas arma;
		arma=RasgoArmas.valueOf(seccion[5]);
		fichaInversa.setArma(arma);		
		
		return fichaInversa;
	}
	
	/**
	 * Devuelve el nombre del jugador.
	 * @return nombrePersonaje El nombre del jugador
	 */	
	public String getNombreJugador() {
		return nombreJugador;
	}
	
	/**
	 * Devuelve el nombre del personaje.
	 * @return nombrePersonaje El nombre del personaje
	 */	
	public String getNombrePersonaje() {
		return nombrePersonaje;
	}
	
	/**
	 * Devuelve la raza del personaje.
	 * @return raza La raza del personaje
	 */
	public RasgoRazas getRaza() {
		return raza;
	}

	/**
	 * Devuelve la profesion del personaje.
	 * @return profesion La profesion del personaje
	 */	
	public RasgoProfesiones getProfesion() {
		return profesion;
	}
	
	/**
	 * Devuelve la armadura del personaje.
	 * @return armadura La armadura del personaje
	 */	
	public RasgoArmaduras getArmadura() {
		return armadura;
	}

	/**
	 * Devuelve el arma del personaje.
	 * @return arma La arma del personaje
	 */	
	public RasgoArmas getArma() {
		return arma;
	}
	
	/**
	 * Asigna el nombre al Personaje
	 * @param nombrePersonaje El nombre del personaje
	 */
	public void setNombrePersonaje(String nombrePersonaje) {
		this.nombrePersonaje = nombrePersonaje;
	}
	
	/**
	 * Asigna el nombre al jugador
	 * @param nombreJugador El nombre del jugador
	 */
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	
	/**
	 * Asigna la raza al personaje
	 * @param raza La raza del personaje
	 */
	public void setRaza(RasgoRazas raza) {
		this.raza = raza;
	}

	/**
	 * Asigna la profesion al personaje
	 * @param profesion La profesion del personaje
	 */
	public void setProfesion(RasgoProfesiones profesion) {
		this.profesion = profesion;
	}
	
	/**
	 * Asigna la armadura al personaje
	 * @param armadura La armadura del personaje
	 */
	public void setArmadura(RasgoArmaduras armadura) {
		this.armadura = armadura;
	}
	
	/**
	 * Asigna el arma al personaje
	 * @param arma El arma del personaje
	 */
	public void setArma(RasgoArmas arma) {
		this.arma = arma;
	}
	
}
