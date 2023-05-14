 package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella il labirinto dil gioco
 *
 * @author  AlejandroEscrivaPardo
 * @see Labirinto
 * @version base
 */

public class LabirintoBuilder{

	
	private Labirinto labirinto = new Labirinto();
	
	/**
	 * specificare la stanza di uscita
	 */
	public LabirintoBuilder addStanza(String string) {
		Stanza stanza = new Stanza(string);
		labirinto.stanze.add(stanza);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String stanza1, String stanza2, String direzione) {
		Stanza s1 = new Stanza(stanza1);
		Stanza s2 = new Stanza(stanza2);
		
		for ( Stanza s : labirinto.stanze) {
			if ( s.getNome().equals(stanza1) ) {
				s.impostaStanzaAdiacente(direzione, s2);
			}
		}
		return this;
	}
	
	
	/**
	 * specificare la stanza vicente
	 */
	public LabirintoBuilder addStanzaVincente(String nome) {
		Stanza s1 = labirinto.getStance(nome);
		labirinto.setstanzavincente(s1);
		return this;
	}

	
	/**
	 * ritorna il labirinto
	 */
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public LabirintoBuilder addAttrezzo(String nomestanza, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		for (Stanza s : labirinto.stanze ) {
			if ( s.getNome().equals(nomestanza) ) {
				s.addAttrezzo(attrezzo);
			}
		}
		return this;
	}
	public LabirintoBuilder addStanzaDiPartenza(String nome) {
		
		labirinto.setstanzadipartenza(labirinto.getStance(nome));
		return this;
		
	}

}
