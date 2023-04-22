package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {
	Labirinto lab;
	Stanza stanze1,stanze2;
	Stanza stanzavincente;
	Stanza stanzadipartenza;
	
	@BeforeEach
	void setUp() {
		lab = new Labirinto();
	
	}

	@Test
	public void testsetstanzavincente(Stanza nome) {
	    lab.setstanzavincente(stanzavincente);
		assertEquals(stanzavincente, lab.getstanzavincente());
	}
	
	@Test
	public void testgetstanzavincente() {
		lab.setstanzavincente(stanzavincente);
		assertEquals(stanzavincente, lab.getstanzavincente());
	}
	
	@Test
	public void testsetstanzadipartenza(Stanza nome) {
	    lab.setstanzadipartenza(stanzadipartenza);
		assertEquals(stanzavincente, lab.getstanzavincente());
	}
	
	@Test
	public void testgetstanzadipartenza() {
		lab.setstanzadipartenza(stanzadipartenza);
		assertEquals(stanzavincente, lab.getstanzavincente());
	}
}
