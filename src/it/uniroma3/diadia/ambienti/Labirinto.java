 package it.uniroma3.diadia.ambienti;

import java.util.Set;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella il labirinto dil gioco
 *
 * @author  AlejandroEscrivaPardo
 * @see Labirinto
 * @version base
 */

public class Labirinto {

	
	private Stanza stanzadipartenza;
	private Stanza stanzavincente;
	public Set<Stanza> stanze;

	
	public Labirinto(){
		
		stanze = new TreeSet<>();
		stanzadipartenza = new Stanza("Atrio");
		stanzavincente = new Stanza("Salida");
	}
	

	/**
	 * specificare la stanza di uscita
	 */
	public void setstanzadipartenza(Stanza nome) {
		this.stanzadipartenza=nome;
	}
	/**
	 * specificare la stanza vicente
	 */
	public void setstanzavincente(Stanza string) {
		this.stanzavincente=string;
	}
	/**
	 * ritorna la stanza di partenza
	 */
	public Stanza getstanzadipartenza() {
		return this.stanzadipartenza;
	}
	/**
	 * ritorna la stanza vicente
	 */
	public Stanza getstanzavincente() {
		return this.stanzavincente;
	}
	/**
	 * ritorna la array gli stanze
	 */
	public Stanza getStance(String stanza) {
		for (Stanza stanza1 : stanze) {
			if (stanza1.getNome().equals(stanza) ) {
				return stanza1;
				
			}
		}
		return null;
	}
	
	public void addStanza(Stanza stanza) {
		stanze.add(stanza);
	}


	
	public  void addAttrezzo(String stanza, Attrezzo attrezzo) {
		for (Stanza s : stanze ) {
			if (s.getNome().equals(stanza)) {
				s.addAttrezzo(attrezzo);
			}
		}
	}




}
