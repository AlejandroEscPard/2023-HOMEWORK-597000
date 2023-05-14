package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class StanzaBlocata extends Stanza {
	Partita partita = new Partita();
	IO ioconsole = new IOConsole();
	private String direzioneblocata;
	private String attrezzo;
	public StanzaBlocata(String nome) {
		super(nome);
		attrezzo = "piedediporco";
		direzioneblocata = "Nord";
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
   
		
        if (this.partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
   
        	ioconsole.mostraMessaggio("Direzione Blocata!!!");
        	return this.partita.getStanzaCorrente();
        }
        else {
        	for(Stanza stanza : this.stanzeAdiacenti.values()) {
            	if (stanza.getDirezioni().equals(direzione)) {
            		return stanza;
            		
            	}
            
        	}
        }
        return null;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }
	

}