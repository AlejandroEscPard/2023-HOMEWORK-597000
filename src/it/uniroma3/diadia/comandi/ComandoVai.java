package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	IO ioconsole = new IOConsole();
	Partita partita = new Partita();

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		ioconsole = new IOConsole();
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		ioconsole.mostraMessaggio("Dove vuoi andare?");
		direzione = ioconsole.leggiRiga();
		if (direzione == null) {
			ioconsole.mostraMessaggio("Devi specificare una direzione");
			return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			ioconsole.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		ioconsole.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCFU(partita.getGiocatore().getCFU()-1);
	}
	@Override
	public void setParametro(String direzione) {
    	this.direzione = direzione;
    }
}