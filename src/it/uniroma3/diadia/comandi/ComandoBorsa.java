package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoBorsa implements Comando {
	private String direzione;
	IO ioconsole = new IOConsole();
	private Partita partita;

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		ioconsole = new IOConsole();
		Borsa borsa = partita.getBorsa();
		ioconsole.mostraMessaggio(borsa.toString());
		
	}


	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
}