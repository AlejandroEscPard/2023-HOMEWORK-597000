package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class LabirintoBuilderTest {
	LabirintoBuilder lab;
	Stanza stanza1,stanza2;
	Attrezzo attrezzo ;
	

	@BeforeEach
	void setUp() {
		lab = new LabirintoBuilder();
		stanza1 = new Stanza("Prueba1");
		stanza2 = new Stanza("Prueba2");
		attrezzo = new Attrezzo("Pala", 2);
	}
	
	@Test
	void testaddStanza() {
		lab.addStanza(stanza1.getNome());
		assertTrue(lab.getLabirinto().stanze.contains(stanza1));
	}
	
	@Test
	void testaddAdiacenza() {
		lab.addStanza(stanza1.getNome());
		lab.addStanza(stanza2.getNome());
		lab.addAdiacenza(stanza1.getNome(), stanza2.getNome(), "Nord");
		assertEquals(lab.getLabirinto().getStance("Prueba1").getStanzaAdiacente("Nord"), "Prueba2" );
	}
	
	@Test
	void testaddStanzaDiPartenza() {
		lab.addStanzaDiPartenza(stanza1.getNome());
		assertEquals(lab.getLabirinto().getstanzadipartenza(), stanza1);
	}

	@Test
	void testaddStanzaVincente() {
		lab.addStanzaVincente(stanza1.getNome());
		assertEquals(lab.getLabirinto().getstanzavincente(), stanza1);
	}
	
	@Test
	void testgetLabirinto() {
		lab.addStanza(stanza1.getNome());
		lab.addStanza(stanza2.getNome());
		lab.addStanzaVincente(stanza1.getNome());
		lab.addStanzaDiPartenza(stanza1.getNome());
		lab.addAdiacenza(stanza1.getNome(), stanza2.getNome(), "Nord");
		assertEquals(lab.getLabirinto(), lab);
	}
	
	@Test
	void testaddAttrezzo() {
		lab.addStanza(stanza1.getNome());
		lab.addAttrezzo(stanza1.getNome(), "Pala", 2);
		
		assertEquals(lab.getLabirinto().getStance("Prueba1").getAttrezzo("Pala"), attrezzo);
	}
}
