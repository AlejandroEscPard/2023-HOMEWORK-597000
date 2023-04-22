 package it.uniroma3.diadia;
 import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = "[2023-HOMEWORK1] 597000\n \n"+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole ioconsole;

	public DiaDia() {
		this.partita = new Partita();
		this.ioconsole = new IOConsole();
	}

	public void gioca() {
		String istruzione; 
		

		ioconsole.mostraMessaggio(MESSAGGIO_BENVENUTO);;		
		do		
			istruzione = ioconsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);




		//OK
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} 

		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());


		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi")) 
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa")) 
			this.posa(comandoDaEseguire.getParametro());

		else
			ioconsole.mostraMessaggio("Comando sconosciuto");

		if (this.partita.vinta()) {
			ioconsole.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			ioconsole.mostraMessaggio(elencoComandi[i]+" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			ioconsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			ioconsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
		}
		ioconsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		ioconsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}


	private void prendi(String nome) {
		Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nome);
		Stanza stanzacorrente = this.partita.getStanzaCorrente();
		if ( attrezzo == null ) {
			ioconsole.mostraMessaggio("Attrezzo non trovato");
		}
		else {
			if ( this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
				stanzacorrente.removeAttrezzo(attrezzo);
				ioconsole.mostraMessaggio("Attrezzo aggiuntato a la borsa");
			}
			else {
				ioconsole.mostraMessaggio("Borsa piena");
			}
		}
	}

	private void posa(String nome) {
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nome);
		Stanza stanzacorrente = this.partita.getStanzaCorrente();
		if ( attrezzo == null ) {
			ioconsole.mostraMessaggio("Attrezzo non trovato in la borsa");
		}
		else {
			if ( stanzacorrente.addAttrezzo(attrezzo)) {
				this.partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
				ioconsole.mostraMessaggio("Attrezzo aggiuntato alla stanza");
			}
			else {
				ioconsole.mostraMessaggio("La stanza e piena");

			}
		}
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}


}