package jcolonia.daw2022.fichaDeRol;

public enum AtaquesSanador implements Ataque {
	Curar,
	Escudo_reflectante,
	Pacificar,
	Vuelo;
	
	public Ataque[] getValues() {
        return values();
    }
}
