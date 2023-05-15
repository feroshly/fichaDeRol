package jcolonia.daw2022.fichaDeRol;

public enum AtaquesGuerrero  implements Ataque{
	Carga_imparable,
	Berserker,
	Ataque_Potente,
	Combo_Picadora_de_carne;
	
	public Ataque[] getValues() {
        return values();
    }
}
