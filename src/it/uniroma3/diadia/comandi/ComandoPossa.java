package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.attrezzi.*;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.*;

public class ComandoPossa implements Comando {
	Partita partita = new Partita();
	IO ioconsole = new IOConsole();
	Stanza stanzacorrente = this.partita.getStanzaCorrente();
	String nome;
	
	
	public void esegui(Partita partita) {
		ioconsole.mostraMessaggio("Che attrezzo voblie possare?");
		nome = ioconsole.leggiRiga();
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nome);
		
			
		this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
		ioconsole.mostraMessaggio("Attrezzo aggiuntato alla stanza");
		
			
		
		return;

			
		}
	

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
}