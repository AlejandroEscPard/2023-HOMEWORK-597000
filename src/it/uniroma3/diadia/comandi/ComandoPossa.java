package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.*;

public class ComandoPossa implements Comando {
	private Partita partita = new Partita();
	private String nome;
	IOConsole ioconsole = new IOConsole();
	Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nome);
	Stanza stanzacorrente = this.partita.getStanzaCorrente();

	public void esegui(Partita partita) {


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

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
}