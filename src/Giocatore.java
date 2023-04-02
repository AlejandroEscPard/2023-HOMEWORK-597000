// package it.uniroma3.diadia.giocatore


/**
 * Questa classe gestiona il giocatore
 *
 * @author  AlejandroEscrivaPardo
 * @see Giocatore
 * @version base
 */

public class Giocatore {

	
	private int CFU;
	private Borsa borsa;
	
	public Giocatore() {
		this.borsa = new Borsa();
	}
	
	public void setCFU(int cfu){
		this.CFU=cfu;
	}
		
	public void setBorsa(Borsa borsa){
		this.borsa=borsa;
	}	
	
	public int getCFU(){
		return this.CFU;
	}
	
	public Borsa getBorsa(){
		return this.borsa;
	}

	}	

