package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class StanzaBuia extends Stanza {
	Partita partita = new Partita();
	IO ioconsole = new IOConsole();
	public StanzaBuia(String nome) {
		super(nome);
		
		
	}
	
	@Override
	public String getDescrizione() {
		
		
		String attrezzo = "linterna";
		if (this.partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			return this.toString();
		}
		else {
			return "Quie c`é un buio pesto";
		}
		
		
	}
	

}