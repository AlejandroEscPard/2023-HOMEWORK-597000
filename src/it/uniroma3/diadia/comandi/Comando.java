package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public interface Comando {

	public String nome = null;
	public String param = null;
	public String direzione = null;

	public void esegui(Partita partita);

	public static String getNome() {
		return nome;
	}

	public static String getParametro() {
		return param;
	}

	public default boolean sconosciuto() {
		return (nome == null);
	}

	void setParametro(String parametro) ;
	
	
}