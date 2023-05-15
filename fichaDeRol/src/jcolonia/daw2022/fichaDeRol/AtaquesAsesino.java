package jcolonia.daw2022.fichaDeRol;

public enum AtaquesAsesino  implements Ataque{
	Veneno,
	Punto_Debil,
	Desarmar,
	Invisivilidad;
	
	public Ataque[] getValues() {
//        return AtaquesAsesino.values();
        return values();
    }
}
