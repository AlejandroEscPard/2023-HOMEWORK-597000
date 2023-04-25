package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.*;

public class ComandoPrendi implements Comando {
	IO ioconsole = new IOConsole();
	Partita partita = new Partita();
	Stanza stanzacorrente = this.partita.getStanzaCorrente();

	public void esegui(Partita partita) {
		String nome = null;
		ioconsole.mostraMessaggio("Che attrezzo voglie prendere?");
		nome = ioconsole.leggiRiga();
		
		Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nome);

		if ( attrezzo == null ) {
			ioconsole.mostraMessaggio("Attrezzo non trovato");
			return;
		}
		else {
			
			if ( this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
				partita.getStanzaCorrente().removeAttrezzo(attrezzo);
				partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				ioconsole.mostraMessaggio("Attrezzo aggiuntato a la borsa");
				return;
			}
			else {
				ioconsole.mostraMessaggio("Borsa piena");
				return;
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
}
