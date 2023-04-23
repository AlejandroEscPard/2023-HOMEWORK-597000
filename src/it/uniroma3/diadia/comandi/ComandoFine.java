package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoFine implements Comando {
	private IOConsole ioconsole;

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		ioconsole.mostraMessaggio("Grazie di aver giocato!"); 
		return;
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
	

}