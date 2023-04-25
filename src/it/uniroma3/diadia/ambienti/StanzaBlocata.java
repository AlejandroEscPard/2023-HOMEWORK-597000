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
		attrezzo = "passe";
		direzioneblocata = "Nord";
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
		
        if (this.partita.getStanzaCorrente().hasAttrezzo(attrezzo) != false) {
   
        	ioconsole.mostraMessaggio("Direzione Blocata!!!");
        	return this.partita.getStanzaCorrente();
        }
        else {
        	for(int i=0; i<this.numeroStanzeAdiacenti; i++)
            	if (this.direzioni[i].equals(direzione))
            		stanza = this.stanzeAdiacenti[i];
            return stanza;
        }
        
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }
	

}