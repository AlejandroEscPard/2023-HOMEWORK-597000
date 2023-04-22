 package it.unirom3.diadia.ambienti;

/**
 * Questa classe modella il labirinto dil gioco
 *
 * @author  AlejandroEscrivaPardo
 * @see Labirinto
 * @version base
 */

public class Labirinto {

	//Creamos las salas
	private Stanza stanzadipartenza;
	private Stanza stanzavincente;
	public Stanza stanze[];
	private int dimensioniLabirinto=9;
	
	public Labirinto(){
		
		stanze = new Stanza[dimensioniLabirinto];
		stanzadipartenza = new Stanza("Atrio");
		stanzavincente = new Stanza("Salida");

		
		//Creamos las salas
		stanze[0] = stanzadipartenza;
		stanze[1] = new Stanza("Recepcion");
		stanze[2] = new Stanza("Biblioteca");
		stanze[3] = new Stanza("DepartamentoInformtica");
		stanze[4] = new Stanza("Comedor");
		stanze[5] = new Stanza("Cafeteria");
		stanze[6] = new Stanza("Pasillo");
		stanze[7] = new Stanza("Despachos");
		stanze[8] = stanzavincente;
		
		//Adjuntamos las salas adyacentes
		
		//Sala0
		stanze[0].impostaStanzaAdiacente("Est", stanze[1]);
		stanze[0].impostaStanzaAdiacente("Nord", stanze[3]);
		
		//Sala1
		stanze[1].impostaStanzaAdiacente("Nord", stanze[4]);
		stanze[1].impostaStanzaAdiacente("Est", stanze[2]);
		stanze[1].impostaStanzaAdiacente("Oest", stanze[0]);
		
		//Sala2
		stanze[2].impostaStanzaAdiacente("Nord", stanze[5]);
		stanze[2].impostaStanzaAdiacente("Oest", stanze[1]);
		
		//Sala3
		stanze[3].impostaStanzaAdiacente("Nord", stanze[6]);
		stanze[3].impostaStanzaAdiacente("Est", stanze[4]);
		stanze[3].impostaStanzaAdiacente("Sud", stanze[0]);
		
		//Sala4
		stanze[4].impostaStanzaAdiacente("Nord", stanze[7]);
		stanze[4].impostaStanzaAdiacente("Est", stanze[5]);
		stanze[4].impostaStanzaAdiacente("Sud", stanze[1]);
		stanze[4].impostaStanzaAdiacente("Oest", stanze[3]);
		
		
		//Sala5
		stanze[5].impostaStanzaAdiacente("Nord", stanze[8]);
		stanze[5].impostaStanzaAdiacente("Sud", stanze[2]);
		stanze[5].impostaStanzaAdiacente("Oest", stanze[4]);
		
		//Sala6
		stanze[6].impostaStanzaAdiacente("Nord", stanze[8]);
		stanze[6].impostaStanzaAdiacente("Sud", stanze[2]);
		stanze[6].impostaStanzaAdiacente("Oest", stanze[4]);
		
		//Sala7
		stanze[7].impostaStanzaAdiacente("Sud", stanze[4]);
		stanze[7].impostaStanzaAdiacente("Oest", stanze[6]);
		stanze[7].impostaStanzaAdiacente("Est", stanze[8]);
		
		//Sala8
		stanze[8].impostaStanzaAdiacente("Sud", stanze[5]);
		stanze[8].impostaStanzaAdiacente("Oest", stanze[7]);
	}
	
	public void setstanzadipartenza(Stanza nome) {
		this.stanzadipartenza=nome;
	}
	
	public void setstanzavincente(Stanza nome) {
		this.stanzavincente=nome;
	}
	
	public Stanza getstanzadipartenza() {
		return this.stanzadipartenza;
	}
	
	public Stanza getstanzavincente() {
		return this.stanzavincente;
	}
	
	public Stanza[] getStance() {
		return stanze;
	}

}
