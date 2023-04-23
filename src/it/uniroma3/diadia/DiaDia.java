package it.uniroma3.diadia;
import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.comandi.*;


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
	static IO io = new IOConsole();
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
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

			System.out.println("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

			System.out.println("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */

	
	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}


}