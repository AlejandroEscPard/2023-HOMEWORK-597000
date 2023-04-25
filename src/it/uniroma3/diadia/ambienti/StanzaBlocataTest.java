package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBlocataTest {

	Stanza stanze;
	Partita partita;
	
	@BeforeEach
	void setUp() {
		
		stanze = new Stanza("Prueba");
		partita = new Partita();
		
		
	}
	
	@Test
	void testgetStanzaAdiacenteConAttrezzoDesblocato() {
		Attrezzo pase = new Attrezzo("pase", 2);
		this.partita.getStanzaCorrente().addAttrezzo(pase);		
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("pase"));
		assertNotEquals(this.partita.getStanzaCorrente().getDescrizione(), "Direzione Blocata!!!");
	}

}
