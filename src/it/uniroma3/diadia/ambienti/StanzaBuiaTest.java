package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	Attrezzo attrezzo;
	Stanza stanze;
	Partita partita;
	
	@BeforeEach
	void setUp() {
		attrezzo = new Attrezzo("linterna", 2);
		stanze = new Stanza("Prueba");
		partita = new Partita();
		this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
		
		
	}
	@Test
	void testgetDescrizioneConAttrezzoDesbloca() {
		this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("linterna"));
		assertNotEquals(this.partita.getStanzaCorrente().getDescrizione(), "Quie c`é un buio pesto");
		}
	
	@Test
	void testgetDescrizioneSenzaAttrezzoDesbloca() {
		
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("pase"));
		assertEquals(this.partita.getStanzaCorrente().getDescrizione(), "Quie c`é un buio pesto");
		}

}
