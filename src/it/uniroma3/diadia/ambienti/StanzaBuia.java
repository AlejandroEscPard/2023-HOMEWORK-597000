package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class StanzaBuia extends Stanza {
	Partita partita = new Partita();
	IO ioconsole = new IOConsole();
	private String attrezzo;
	public StanzaBuia(String nome) {
		super(nome);
		String attrezzo = "linterna";
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getDescrizione() {
		
		
		if (this.partita.getStanzaCorrente().hasAttrezzo(this.attrezzo)) {
			return this.toString();
		}
		else {
			return "Quie c`é un buio pesto";
		}
		
		
	}
	

}