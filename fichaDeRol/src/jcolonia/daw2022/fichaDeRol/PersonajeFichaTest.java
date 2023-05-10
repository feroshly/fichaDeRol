package jcolonia.daw2022.fichaDeRol;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Comprobamos que se ejecutan correctamente los metodos de la clase PersonajeFicha.
 * @author <a href= "mailto:luisbienal@gmail.com">Luis G. Contreras</a>
 */
class PersonajeFichaTest {

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

///--------------P A R A M E T R I Z A D O S------------------
	
    /**
     * Comprueba que se establece correctamente el nombre del jugador varias veces.
     * Comprueba que la profesion asignada coincide con la que te devuelve
     * cuando recuperas ese campo del jugador varias veces.
     */
	@ParameterizedTest
	@DisplayName("Nombre Personaje VARIOS Correcto")
	@CsvSource(value = { "Pedro", "Francisco", "Sandra", "Nuria"})
	public void testSetNombreJugador(String nombreJugador) {
	    PersonajeFicha personaje = new PersonajeFicha();
	    
	    personaje.setNombreJugador(nombreJugador);
	    assertEquals(nombreJugador, personaje.getNombreJugador(),"Nombre guardado y recuperado adecuadamente");
	}
	
    /**
     * Comprueba que se establece correctamente el nombre del personaje varias veces.
     * Comprueba que la profesion asignada coincide con la que te devuelve
     * cuando recuperas ese campo del personaje varias veces.
     */
	@ParameterizedTest
	@DisplayName("Nombre Personaje VARIOS Correcto")
	@CsvSource(value = { "Legolas", "Elendil", "Aranthian", "Gaelilith"})
	public void testSetNombrePersonaje(String nombrePersonaje) {
		PersonajeFicha personaje = new PersonajeFicha();
		
		personaje.setNombrePersonaje(nombrePersonaje);
		assertEquals(nombrePersonaje, personaje.getNombrePersonaje());
	}
	
	
    /**
     * Comprueba que se establece correctamente la profesion del personaje varias veces.
     * Comprueba que la profesion asignada coincide con la que te devuelve
     * cuando recuperas ese campo del personaje varias veces.
     */	
@DisplayName("Profesiones VARIAS Correcto")
	@ParameterizedTest
	@EnumSource(RasgoProfesiones.class)
	public void testSetProfesionesVARIAS(RasgoProfesiones profesion) {
	    PersonajeFicha personaje = new PersonajeFicha();
	
	    personaje.setProfesion(profesion);
	    assertEquals(profesion, personaje.getProfesion());
	}

/**
 * Comprueba que se establece correctamente la raza del personaje varias veces.
 * Comprueba que la raza asignada coincide con la que te devuelve
 * cuando recuperas ese campo del personaje varias veces.
 */
@DisplayName("Razas VARIAS Correcto")
@ParameterizedTest
@EnumSource(RasgoRazas.class)
public void testSetRazasVARIAS(RasgoRazas raza) {
	PersonajeFicha personaje = new PersonajeFicha();
	
	personaje.setRaza(raza);
	assertEquals(raza, personaje.getRaza());
}


/**
 * Comprueba que se establece correctamente la armadura del personaje varias veces.
 * Comprueba que la armadura asignada coincide con la que te devuelve
 * cuando recuperas ese campo del personaje varias veces.
 */
@DisplayName("Armaduras VARIAS Correcto")
@ParameterizedTest
@EnumSource(RasgoArmaduras.class)
public void testSetArmadurasVARIAS(RasgoArmaduras armadura) {
	PersonajeFicha personaje = new PersonajeFicha();
	
	personaje.setArmadura(armadura);
	assertEquals(armadura, personaje.getArmadura());
}

/**
 * Comprueba que se establece correctamente el arma del personaje varias veces.
 * Comprueba que el arma asignada coincide con la que te devuelve
 * cuando recuperas ese campo del personaje varias veces.
 */
@DisplayName("Armas VARIAS Correcto")
@ParameterizedTest
@EnumSource(RasgoArmas.class)
public void testSetArmasVARIAS(RasgoArmas arma) {
	PersonajeFicha personaje = new PersonajeFicha();
	
	personaje.setArma(arma);
	assertEquals(arma, personaje.getArma());
}

///----------------------------------------

//	@Test
//	void test() {
//		fail("No implementado aun");
//	}
	
	
/**
 * Comprueba que se establece correctamente el nombre del jugador.
 * Comprueba que la profesion asignada coincide con la que te devuelve
 * cuando recuperas ese campo del personaje.
 */
    @Test
    @DisplayName("Nombre jugador Correcto")
    public void testSetNombreJugador() {
        PersonajeFicha personaje = new PersonajeFicha();
        String nombreJugador = "Alberto";
        
        personaje.setNombreJugador(nombreJugador);
        
        assertEquals(nombreJugador, personaje.getNombreJugador());
    }
    
    
    /**
     * Comprueba que se establece correctamente el nombre del personaje.
     * Comprueba que la profesion asignada coincide con la que te devuelve
     * cuando recuperas ese campo del personaje.
     */
    @Test
    @DisplayName("Nombre Personaje Correcto")
    public void testSetNombrePersonaje() {
    	PersonajeFicha personaje = new PersonajeFicha();
    	String nombrePersonaje = "Fafnagar";
    	
    	personaje.setNombrePersonaje(nombrePersonaje);
    	assertEquals(nombrePersonaje, personaje.getNombrePersonaje());
    }
    
    /**
     * Comprueba que se establece correctamente la profesion del personaje.
     * Comprueba que la profesion asignada coincide con la que te devuelve
     * cuando recuperas ese campo del personaje.
     */
    @Test
    @DisplayName("Profesion Correcto")
    public void testSetProfesion() {
    	PersonajeFicha personaje = new PersonajeFicha();
    	RasgoProfesiones profesion=RasgoProfesiones.Mago;
    	personaje.setProfesion(profesion);
    	
    	assertEquals(profesion, personaje.getProfesion());
    }

    /**
     * Comprueba que se establece correctamente la raza del personaje.
     * Comprueba que la raza asignada coincide con la que te devuelve
     * cuando recuperas ese campo del personaje.
     */
    @Test
    @DisplayName("Raza Correcta")
    public void testSetRaza() {
    	PersonajeFicha personaje = new PersonajeFicha();
    	RasgoRazas raza=RasgoRazas.Elfo;
    	
    	personaje.setRaza(raza);
    	assertEquals(raza, personaje.getRaza());
    }
    
    /**
     * Comprueba que se establece correctamente la armadura del personaje.
     * Comprueba que la armadura asignada coincide con la que te devuelve
     * cuando recuperas ese campo del personaje.
     */
    @Test
    @DisplayName("Armadura Correcta")
    public void testSetArmadura() {
    	PersonajeFicha personaje = new PersonajeFicha();
    	RasgoArmaduras armadura=RasgoArmaduras.Amuleto;
    	
    	personaje.setArmadura(armadura);
    	assertEquals(armadura, personaje.getArmadura());
    }
    
    /**
     * Comprueba que se establece correctamente el arma del personaje.
     * Comprueba que el arma asignada coincide con la que te devuelve
     * cuando recuperas ese campo del personaje.
     */
    @Test
    @DisplayName("Arma Correcta")
    public void testSetArma() {
    	PersonajeFicha personaje = new PersonajeFicha();
    	RasgoArmas arma=RasgoArmas.Grimorio;
    	
    	personaje.setArma(arma);
    	assertEquals(arma, personaje.getArma());
    }

}
