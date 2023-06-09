package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoAiuto implements Comando {
	private String direzione;
	IO ioconsole = new IOConsole();
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "borsa"};


	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		ioconsole = new IOConsole();
		for(int i=0; i< elencoComandi.length; i++) 
			ioconsole.mostraMessaggio(elencoComandi[i]+" ");
	}


	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
}