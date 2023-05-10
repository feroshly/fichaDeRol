
package jcolonia.daw2022.fichaDeRol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Comprovamos que se ejecutan correctamente los metodos de la clase Equipo.
 * @author <a href= "mailto:luisbienal@gmail.com">Luis G. Contreras</a>
 */
class EquipoTest {

	/**
	 * Objeto de tipo Equipo basico para pruebas.
	 */
	private Equipo equipo;

	/**
	 * @throws java.lang.Exception La excepcion
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception La excepcion
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception La excepcion
	 */
	@BeforeEach
	void setUp() throws Exception {
		equipo = new Equipo();
	}

	/**
	 * @throws java.lang.Exception La excepcion
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void test(){
//	fail("No implementado aun");
//	}

	/**
	 * Añade un personaje y consulta del numero de personajes.
	 */
	@Test
	@DisplayName("Numero personaje añadido")
	void testAñadirNuevoPersonaje() {
		// Añadir un nuevo personaje al equipo
		PersonajeFicha nuevoPersonaje = new PersonajeFicha();

		equipo.añadirNuevoPersonaje(nuevoPersonaje);

		// Comprobar que el equipo tiene 1 personaje y que es el que acabamos de añadir
		assertEquals(1, equipo.consultarNumeroDePersonajes());
	}

	/**
	 * Añade 3 personaje y consulta del numero de personajes.
	 */
	@Test
	@DisplayName("Numero de Personajes correcto")
	void testConsultarNumeroDePersonajes() {
		//Añadir un nuevo personaje al equipo
		PersonajeFicha nuevoPersonajeA = new PersonajeFicha();
		PersonajeFicha nuevoPersonajeB = new PersonajeFicha();
		PersonajeFicha nuevoPersonajeC = new PersonajeFicha();
	
		//Comprobar que el equipo tiene 1 personaje y que es el que acabamos de añadir
		equipo.añadirNuevoPersonaje(nuevoPersonajeA);
		equipo.añadirNuevoPersonaje(nuevoPersonajeB);
		equipo.añadirNuevoPersonaje(nuevoPersonajeC);
	
		equipo.consultarNumeroDePersonajes();
		assertEquals(3, equipo.consultarNumeroDePersonajes());
	}

	/**
	 * Crea un personaje y asigna valor a sus distintos campos.
	 * Luego llama al personaje que se encuentra en la primera posicion
	 * y luego comprueba que los campos de ambos coinciden respectivamente. 
	 */
	@Test
	@DisplayName("Nuevo Personaje2 Francisco → Aragorn")
	void testAñadirNuevoPersonaje2() {
		// Añadir un nuevo personaje al equipo
		PersonajeFicha nuevoPersonajeTest = new PersonajeFicha();
		String nombreJugadorTest = "Francisco";
		String nombrePersonajeTest = "Aragorn";
		RasgoProfesiones profesionTest = RasgoProfesiones.Guerrero;
		RasgoRazas razaTest = RasgoRazas.Humano;
		RasgoArmaduras armaduraTest = RasgoArmaduras.Cuero;
		RasgoArmas armaTest = RasgoArmas.Espada;

		nuevoPersonajeTest.setNombreJugador(nombreJugadorTest);
		nuevoPersonajeTest.setNombrePersonaje(nombrePersonajeTest);
		nuevoPersonajeTest.setProfesion(profesionTest);
		nuevoPersonajeTest.setRaza(razaTest);
		nuevoPersonajeTest.setArmadura(armaduraTest);
		nuevoPersonajeTest.setArma(armaTest);

		equipo.añadirNuevoPersonaje(nuevoPersonajeTest);
		
		PersonajeFicha respuesta = equipo.consultarPersonajePorNumero(0);//Las listas siempre empiezan por cero
		
		// Comprobar que el equipo tiene 1 personaje y que es el que acabamos de añadir
		assertSame(nuevoPersonajeTest,respuesta);//compruba el id intrinseco a cada objeto creado, esto ya son filigranas
		
		assertEquals(nombreJugadorTest, respuesta.getNombreJugador());
		assertEquals(nombrePersonajeTest, respuesta.getNombrePersonaje());
		assertEquals(profesionTest, respuesta.getProfesion());
		assertEquals(razaTest, respuesta.getRaza());
		assertEquals(armaduraTest, respuesta.getArmadura());
		assertEquals(armaTest, respuesta.getArma());
	}

	/**
	 * Usamos un bucle para crear un numero variable de personajes en base un parametro de entrada
	 * y comprobamos que coinciden con el numero de personajes almacenados.
	 * @param numPersonajes El numero de personajes correspondiente
	 */
	@ParameterizedTest
	@DisplayName("Comparaion Honesta satisfactoria")
	@CsvSource({ "0", "1", "2", "3", "4", "5" }) //Valores de entrada a probar
	void testConsultarNumeroDePersonajes2(int numPersonajes) {
	
		for (int i = 0; i < numPersonajes; i++) {
			equipo.añadirNuevoPersonaje(new PersonajeFicha());
		}
		assertEquals(numPersonajes, equipo.consultarNumeroDePersonajes());
	}

	/**
	 * Usamos un bucle para crear un numero variable de personajes en base un parametro de entrada
	 * y comprobamos que no coinciden con el numero incorrecto de personajes esperados tambien como parametro.
	 * @param numPersonajes El numero de personajes
	 * @param numPersonajesMalEsperado El numero incorrecto
	 */
	@ParameterizedTest
	@CsvSource({ "1, 2", "3, 4", "5, 6" })
	@DisplayName("Comparacion tramposa satisfactoria")
	void testConsultarNumeroDePersonajes3(int numPersonajes, int numPersonajesMalEsperado) {
		
		for (int i = 0; i < numPersonajes; i++) {
			equipo.añadirNuevoPersonaje(new PersonajeFicha());
		}
		int numPersonajesReal = equipo.consultarNumeroDePersonajes();
		assertNotEquals(numPersonajesMalEsperado, numPersonajesReal);
	}

}
