package jcolonia.daw2022.fichaDeRol;

/**
 * Pide al usuario informacin para que rellenar una serie de campos de una ficha
 * de personaje.
 * @author <a href= "mailto:luisbienal@gmail.com">Luis G. Contreras</a>
 */
public class VistaAltas extends VistaGeneral{

	/**
	 * Muestra un aviso cuando el usuario introduce un valor incorrecto.
	 * @param textoAviso el texto correspondiente
	 */
	private static void mostrarAviso(String textoAviso) {
		System.out.printf("Introduzca un valor correcto ¡ATENCIÓN: %s!%n%n", textoAviso);
	}

	/**
	 * Pide que escribas el nombre del jugador y te lo devuelve;
	 * @return  nombreJugador el nombre correspondiente
	 * @throws VistaGeneralException cuando el usuario pulsa F para salir
	 */
	private String preguntarNombreJugador()  throws VistaGeneralException{
		String peticionNombreJugador = "Por favor introduce un NOMBRE para el JUGADOR";
		String avisoNombreMal = String.format("Nombre introducido invalido, no introduzca numeros");// formateo el aviso
		System.out.printf("Pulse enter para finalizar cada linea." + "%nF para salir.%n%n");
		System.out.printf("%s:%n", peticionNombreJugador);
		String nombreJugador;

		nombreJugador = cargar();
		if (nombreJugador.compareTo("F")==0) {//La clave
		    throw new VistaGeneralException("Cancelado por el usuario");
		}
		
		boolean salir = false;// bandera
		//ControlBuclePrincipal cosaBucle=new ControlBuclePrincipal();
		
		do {//
			for (int i = 0; i < nombreJugador.length(); i++) {//Entrada solo texto nunca numero
				char c = nombreJugador.charAt(i);
				if ((c == ' ') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {// if si no esta entre tal y tal
					// esto hace que se convierta la primera en mayuscula
					nombreJugador = nombreJugador.toUpperCase().charAt(0)
							+ nombreJugador.substring(1, nombreJugador.length()).toLowerCase();
					salir = true;
				}else {// else mostrar aviso
					salir = false;
					mostrarAviso(avisoNombreMal);
					System.out.printf("	%s:%n", peticionNombreJugador);
					nombreJugador =cargar();// Esto que el mensaje de arriba se repita hasta el infinito.
					if (nombreJugador.compareTo("F")==0) {//La clave
						throw new VistaGeneralException("Cancelado por el usuario");
					}
				}
			}
		} while (salir == false);
		return nombreJugador;
	}

	/**
	 * Pide que escribas el nombre del personaje y te lo devuelve;
	 * @return nombrePersonaje el nombre correspondiente
	 * @throws VistaGeneralException cuando el usuario pulsa F para salir
	 */
	private String preguntarNombrePersonaje() throws VistaGeneralException{

		String peticionNombrePersonaje = "Por favor introduce un NOMBRE para el PERSONAJE";		
		String avisoNombreMal = String.format("Nombre introducido invalido, no introduzca numeros");// formateo el aviso
		System.out.printf("Pulse enter para finalizar cada linea." + "%nF para salir.%n%n");
		System.out.printf("%s:%n", peticionNombrePersonaje);
		String nombrePersonaje;

		
		boolean salir = false;// bandera
//		ControlBuclePrincipal cosaBucle=new ControlBuclePrincipal();
		
		nombrePersonaje = cargar();
		if (nombrePersonaje.compareTo("F")==0) {//La clave
			throw new VistaGeneralException("Cancelado por el usuario");
		}
		do {//
			for (int i = 0; i < nombrePersonaje.length(); i++) {//Entrada solo texto nunca numero
				char c = nombrePersonaje.charAt(i);
				if ((c == ' ') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {// if si no esta entre tal y tal
					// esto hace que se convierta la primera en mayuscula
					nombrePersonaje = nombrePersonaje.toUpperCase().charAt(0)
							+ nombrePersonaje.substring(1, nombrePersonaje.length()).toLowerCase();
					salir = true;
				}else {// else mostrar aviso
					salir = false;
					mostrarAviso(avisoNombreMal);
					System.out.printf("	%s:%n", peticionNombrePersonaje);
					nombrePersonaje = cargar();// Esto que el mensaje de arriba se repita hasta el infinito.---------
					if (nombrePersonaje.compareTo("F")==0) {//La clave
						throw new VistaGeneralException("Cancelado por el usuario");
					}
				}
			}
		} while (salir == false);
		return nombrePersonaje;
	}
	

	/**
	 * Muestra por pantalla un menu con profesiones a elegir y devuelve la
	 * profesiones elejida por el usuario.
	 * @return nuevaProfesion La profesion correspondiente
	 */
	private RasgoProfesiones preguntarProfesion() {
		String peticionProfesion = "Escoje una PROFESION para el personaje";
		System.out.printf("	%s:%n", peticionProfesion);
		// --PROFESIONES elegir
		RasgoProfesiones[] profesion;
		profesion = RasgoProfesiones.values();
		VistaMenu menuProfesion = new VistaMenu(profesion);
		// Prep
		menuProfesion.mostrarOpciones();

		RasgoProfesiones nuevaProfesion;
		nuevaProfesion = profesion[menuProfesion.pedirOpcion() - 1];
		//preguntarProfesionAtaques(nuevaProfesion);
		System.out.printf("%s%n%n",nuevaProfesion);
		return nuevaProfesion;
	}
	
	private Ataque preguntarProfesionAtaques(RasgoProfesiones nuevaProfesion){
		String peticionAtaqueProfesion = "Escoje una ATAQUE de PROFESION para el personaje";
		System.out.printf("	%s:%n", peticionAtaqueProfesion);
		//T ataqueDeProfesion;
		Ataque ataqueDeProfesion;
		
	    if(nuevaProfesion.toString().equals("Asesino")) {
	    //ataqueDeProfesion = (T)  preguntarMostrarAtaquesAsesino();
        ataqueDeProfesion =  preguntarMostrarAtaquesAsesino();
	    }
	    else if(nuevaProfesion.toString().equals("Sanador")) {
	        ataqueDeProfesion =  preguntarMostrarAtaquesSanador();
	    }
	    else if(nuevaProfesion.toString().equals("Guerrero")) {
	        ataqueDeProfesion =  preguntarMostrarAtaquesGuerrero();
	    }
	    else if(nuevaProfesion.toString().equals("Mago")) {
	        ataqueDeProfesion = preguntarMostrarAtaquesMago();
	    }
	    else {
	        ataqueDeProfesion = null;
	    }
		//--------------------------------------------------//
		
//	    if(nuevaProfesion.toString().equals("Asesino")) {
//	        ataqueDeProfesion = (T) preguntarMostrarAtaquesAsesino();
//	    }
//	    else if(nuevaProfesion.toString().equals("Sanador")) {
//	        ataqueDeProfesion = (T) preguntarMostrarAtaquesSanador();
//	    }
//	    else if(nuevaProfesion.toString().equals("Guerrero")) {
//	        ataqueDeProfesion = (T) preguntarMostrarAtaquesGuerrero();
//	    }
//	    else if(nuevaProfesion.toString().equals("Mago")) {
//	        ataqueDeProfesion = (T) preguntarMostrarAtaquesMago();
//	    }
//	    else {
//	        ataqueDeProfesion = null;
//	    }
		//--------------------------------------------------//
	    return ataqueDeProfesion;
	}
	

	private AtaquesAsesino preguntarMostrarAtaquesAsesino() {
		AtaquesAsesino []asesinoAtaques;
		asesinoAtaques=AtaquesAsesino.values();
		VistaMenu menuAtaques=new VistaMenu(asesinoAtaques);
		menuAtaques.mostrarOpciones();
		
		AtaquesAsesino nuevoAtaqueAsesino=asesinoAtaques[menuAtaques.pedirOpcion()-1];
		System.out.printf("%s%n%n", asesinoAtaques);
		return nuevoAtaqueAsesino;
	}
	
	private AtaquesSanador preguntarMostrarAtaquesSanador() {
		AtaquesSanador []sanadorAtaques;
		sanadorAtaques=AtaquesSanador.values();
		VistaMenu menuSanadorAtaques=new VistaMenu(sanadorAtaques);
		menuSanadorAtaques.mostrarOpciones();
		
		AtaquesSanador nuevoAtaqueSanador=sanadorAtaques[menuSanadorAtaques.pedirOpcion()];
		System.out.printf("%s%n%n", sanadorAtaques);
		return nuevoAtaqueSanador;
	}

	private AtaquesGuerrero preguntarMostrarAtaquesGuerrero() {
		AtaquesGuerrero []guerreroAtaques;
		guerreroAtaques=AtaquesGuerrero.values();
		VistaMenu menuGuerreroAtaques= new VistaMenu(guerreroAtaques);
		menuGuerreroAtaques.mostrarOpciones();
		
		AtaquesGuerrero nuevoAtaqueGuerrero=guerreroAtaques[menuGuerreroAtaques.pedirOpcion()-1];
		System.out.printf("%s%n%n",nuevoAtaqueGuerrero);		
		return nuevoAtaqueGuerrero;
	}

	private AtaquesMago preguntarMostrarAtaquesMago() {
		AtaquesMago []magoAtaques;
		magoAtaques= AtaquesMago.values();
		VistaMenu menuAtaquesMago=new VistaMenu(magoAtaques);
		menuAtaquesMago.mostrarOpciones();
		
		AtaquesMago nuevaAtaqueMago = magoAtaques[menuAtaquesMago.pedirOpcion() - 1];
		System.out.printf("%s%n%n",nuevaAtaqueMago);
		return nuevaAtaqueMago;
	}

	/**
	 * Muestra por pantalla un menu con razas a elegir y devuelve la raza elejida
	 * por el usuario.
	 * 
	 * @return nuevaRaza La raza correspondiente
	 */
	private RasgoRazas preguntarRaza() {
		String peticionRaza= "Escoje una RAZA para el personaje";
		System.out.printf("	%s:%n", peticionRaza);		
		// --RAZA elegir
		RasgoRazas[] raza;
		raza = RasgoRazas.values();
		VistaMenu menuRaza = new VistaMenu(raza);
		// Prep
		
		menuRaza.mostrarOpciones();
		RasgoRazas nuevaRaza = raza[menuRaza.pedirOpcion() - 1];
		System.out.printf("%s%n%n",nuevaRaza);
		return nuevaRaza;
	}

	/**
	 * Muestra por pantalla un menu con armadura a elegir y devuelve la armadura
	 * elejida por el usuario.
	 * 
	 * @return nuevaArmadura La armadura correspondiente
	 */
	private RasgoArmaduras preguntarArmadura() {
		String peticionArmadura = "Escoje una ARMADURA para el personaje";
		System.out.printf("	%s:%n", peticionArmadura);		
		// --ARMADURA elegir
		RasgoArmaduras[] armadura;
		armadura = RasgoArmaduras.values();
		VistaMenu menuArmadura = new VistaMenu(armadura);
		// Prep
		menuArmadura.mostrarOpciones();
		RasgoArmaduras nuevaArmadura = armadura[menuArmadura.pedirOpcion() - 1];
		
		System.out.printf("%s%n%n",nuevaArmadura);
		return nuevaArmadura;
	}

	/**
	 * Muestra por pantalla un menu con arma a elegir y devuelve la arma elejida por
	 * el usuario.
	 * 
	 * @return nuevaArma La armadura correspondiente
	 */
	private RasgoArmas preguntarArma() {
		String peticionArma = "Escoje un ARMA para el personaje";
		System.out.printf("	%s:%n", peticionArma);
		// --ARMA elegir
		RasgoArmas[] arma;
		arma = RasgoArmas.values();
		VistaMenu menuArma = new VistaMenu(arma);
		// Prep
		menuArma.mostrarOpciones();
		RasgoArmas nuevaArma = arma[menuArma.pedirOpcion() - 1];
		
		System.out.printf("%s%n%n",nuevaArma);
		return nuevaArma;
	}

	/**
	 * Guarda las elecciones del usuario en los distintos campos de la ficha de
	 * personaje.
	 * 
	 * @return nuevoPersonaje
	 * @throws VistaGeneralException La excepcion
	 */
	public PersonajeFicha cargarPersonaje() throws VistaGeneralException {
		PersonajeFicha nuevoPersonaje = new PersonajeFicha();
		nuevoPersonaje.setNombreJugador(preguntarNombreJugador());
		nuevoPersonaje.setNombrePersonaje(preguntarNombrePersonaje());
		nuevoPersonaje.setProfesion(preguntarProfesion());

		RasgoProfesiones profesionElegida;		
		profesionElegida = nuevoPersonaje.getProfesion();
		
		
		nuevoPersonaje.setProfesionAtaque(preguntarProfesionAtaques(profesionElegida));
		nuevoPersonaje.setRaza(preguntarRaza());
		nuevoPersonaje.setArmadura(preguntarArmadura());
		nuevoPersonaje.setArma(preguntarArma());
		return nuevoPersonaje;
	}

}
