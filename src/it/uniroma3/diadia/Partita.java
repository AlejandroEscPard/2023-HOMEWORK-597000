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
		
		stanzaCorrente=lab.stanze[0];
		stanzaVincente=lab.stanze[8];
		
		//Creamos los attrezzos
		
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		
    	lab.stanze[0].addAttrezzo(osso);
    	lab.stanze[2].addAttrezzo(lanterna);
    	
		//Creamos el laberinto
    	
		this.finita = false;
		

	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
		int cfu = giocatore.getCFU();
		giocatore.setCFU(cfu--);
	}

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
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public Borsa getBorsa() {
		return this.giocatore.getBorsa();
	}
	
}
