package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.*;

public class ComandoPrendi implements Comando {
	IOConsole ioconsole = new IOConsole();
	Partita partita = new Partita();
	Stanza stanzacorrente = this.partita.getStanzaCorrente();

	public void esegui(Partita partita) {
		String nome = null;
		Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nome);

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

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
}
