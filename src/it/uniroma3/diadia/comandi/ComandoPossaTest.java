package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPossaTest {
	private ComandoPossa comando;
	private Partita partita;
	private Attrezzo attrezzo1;
	
	@BeforeEach
	void setUp() {
		this.comando = new ComandoPossa();
		this.partita = new Partita();
		this.attrezzo1 = new Attrezzo("martello", 2);
	}
	
	/*
	@Test
	void testEseguiAttrezzoAlBorsa() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo1);
		t = "martello";
		
		
	}
*/
}
