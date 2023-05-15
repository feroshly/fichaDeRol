package jcolonia.daw2022.fichaDeRol;

public enum AtaquesMago implements Ataque{
	Bola_de_fuego,
	Ventisca,
	Relampago,
	Cepo_de_hiedra;
	
	public Ataque[] getValues() {
        return values();
    }
	
}
