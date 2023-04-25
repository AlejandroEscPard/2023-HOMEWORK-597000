package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

public class ComandoGuarda implements Comando {
	IO ioconsole = new IOConsole();
	Partita partita = new Partita();
	Labirinto lab = new Labirinto();
	
	
	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		ioconsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());	
	}


	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
	
	
}