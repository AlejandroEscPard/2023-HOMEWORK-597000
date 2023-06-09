package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
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

	private Partita partita;
	private IO ioconsole;
	private Labirinto labirinto;
	
	public DiaDia(IO io2, Labirinto lab) {
		
		this.partita = new Partita(new Labirinto());
		this.ioconsole = io2;
	}
	
	public void DiaDialab(IO io2, Labirinto lab) {
		this.labirinto = lab;
		this.partita = new Partita(new Labirinto());
		this.ioconsole = io2;
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
		IO io = new IOConsole();
		Labirinto monolocale = new LabirintoBuilder()
				.addStanzaDiPartenza("salotto")
				.addStanzaVincente("salotto")
				.getLabirinto();
		
		Labirinto bilocale = new LabirintoBuilder()
				.addStanzaDiPartenza("salotto")
				.addStanzaVincente("camera")
				.addAttrezzo("camera","letto", 10)
				.addAdiacenza("salotto", "camera", "nord")
				.getLabirinto();
		
		Labirinto trilocale = new LabirintoBuilder()
				.addStanzaDiPartenza("salotto")
				.addStanza("cucina")
				.addAttrezzo("cucina","pentola", 1) // dove? fa riferimento all’ultima stanza aggiunta: la “cucina”
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto();
		
		DiaDia gioco = new DiaDia(io, monolocale);
		gioco.gioca();
	}


}