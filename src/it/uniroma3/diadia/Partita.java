package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;
/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private Labirinto lab;
	private Giocatore giocatore;
	Attrezzo lanterna;
	Attrezzo osso;

	public Partita(){
		lab = new Labirinto();
		giocatore = new Giocatore();
		giocatore.setCFU(10);
	}
	
	public Partita(Labirinto labirinto){
		lab = labirinto;
		giocatore = new Giocatore();
		giocatore.setCFU(10);
	}
	
	public void setLabirinto(Labirinto labirinto){
		lab = labirinto;

	}
	/**
	 * Ritorna la stanza vincente
	 */
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	/**
	 * Modifica la stanza corrente
	 */
	public void setStanzaCorrente(Stanza direzione) {
		this.stanzaCorrente = direzione;
		int cfu = giocatore.getCFU();
		giocatore.setCFU(cfu--);
	}

	/**
	 * Ritorna la stanza corrente
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		boolean out = false;
		if (this.getStanzaCorrente() == this.getStanzaVincente()) {
			out = true;
			return out;
		}
		else {
			out = false;
			return out;
		}
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		boolean out = false;
		if (finita == true || vinta() || giocatore.getCFU() == 0) {
			out = true;
			return out;
		}
		return out;
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	/**
	 * Ritorna el giocatore de la partida
	 */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	/**
	 * Ritorna la borsa sul giovatore
	 */
	public Borsa getBorsa() {
		return this.giocatore.getBorsa();
	}

	/**
	 * Ritorna true c'é il giocatore sei vivo e false c'é e morto
	 */
	public boolean giocatoreIsVivo() {
		if (giocatore.getCFU()>0) {
			return true;
		}
		else {
			return false;
		}

	}
}
