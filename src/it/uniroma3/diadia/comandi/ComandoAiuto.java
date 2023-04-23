package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoAiuto implements Comando {
	private String direzione;
	private IOConsole ioconsole;
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};


	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			ioconsole.mostraMessaggio(elencoComandi[i]+" ");
	}


	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
}