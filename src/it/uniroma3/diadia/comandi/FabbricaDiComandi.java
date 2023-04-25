package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public interface FabbricaDiComandi {
	/**
	 * costruire il comando
	 **/
	public default Comando costruisciComando(String istruzione) {
		return null;
		
	}
}