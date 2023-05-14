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
		String riga;
		ioconsole = new IOConsole();
		Borsa borsa = partita.getBorsa();
		ioconsole.mostraMessaggio("Come vuoi il contenutto della borsa?:");
		ioconsole.mostraMessaggio("1-OrdinatoPerPeso / 2-OrdinatoPerNome / 3-RaggruppatoPerPeso");
		riga = ioconsole.leggiRiga();	
		
		if (riga.equals("1")) {
			ioconsole.mostraMessaggio(borsa.getContenutoOrdinatoPerPeso().toString());
		}else if (riga.equals("2")) {
			ioconsole.mostraMessaggio(borsa.getContenutoOrdinatoPerNome().toString());
		}else {
			ioconsole.mostraMessaggio(borsa.getContenutoOrdinatoPerPeso().toString());
		}
		
	}


	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
}