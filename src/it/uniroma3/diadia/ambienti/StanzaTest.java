package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	Stanza stanza1;
	Stanza stanza2;
	Stanza stanza3;
	Stanza stanza4;
	Stanza stanzaadiacente1;
	Stanza stanzaadiacente2;
	Stanza stanzaadiacente3;
	Stanza stanzaadiacente4;
	Stanza stanzaadiacente5;
	Attrezzo attrezzo1;
	Attrezzo attrezzo2;
	Attrezzo attrezzo3;
	
	@BeforeEach
	void setUp() {
		stanza1 = new Stanza("Sala1");
		stanza2 = new Stanza("Sala2");
		stanza3 = new Stanza("Sala3");
		
		stanzaadiacente1 = new Stanza("Adiacente1");
		stanzaadiacente2 = new Stanza("Adiacente2");
		stanzaadiacente3 = new Stanza("Adiacente3");
		stanzaadiacente4 = new Stanza("Adiacente4");
		stanzaadiacente5 = new Stanza("Adiacente5");
		
		attrezzo1 = new Attrezzo("Martillo", 5);
		attrezzo2 = new Attrezzo("Pala", 10);
		attrezzo3 = new Attrezzo("Martillo", 6);
	}
	
	@Test
	void testimpostaStanzaAdiacente() {
		//Se añade correctamente
		stanza1.impostaStanzaAdiacente("nord", stanza1);
		assertEquals(stanza1.getStanzaAdiacente("nord"), stanza1);
	    //Sobrescribir correctamente
		stanza1.impostaStanzaAdiacente("nord", stanza2);
		assertEquals(stanza2, stanza1.getStanzaAdiacente("nord"));
		
		
		}
	
	@Test
	void testgetStanzaAdiacente() {
		
		//Correcto funcionamiento
		stanza1.impostaStanzaAdiacente("nord", stanzaadiacente1);
		assertEquals(stanzaadiacente1, stanza1.getStanzaAdiacente("nord"));
		
		//Probamos que la direccion no exista
		stanza1.impostaStanzaAdiacente("nord", stanzaadiacente1);		
		assertNull(stanza1.getStanzaAdiacente("nord-oest"));
	}
	
	@Test
	void testgetNome() {
		//Encuentra la sala 
		assertEquals("Sala1", stanza1.getNome());
		
		//La sala no es igual
		assertNotEquals("Sala2", stanza1.getNome());
		
		//La sala no esta inicializada
		assertNull(stanza4.getNome());
	}
	
	@Test
	void testadAttrezzo() {
		//Se añade correctamente 
		stanza1.addAttrezzo(attrezzo1);
		assertEquals(attrezzo1,stanza1.getAttrezzo("Martillo"));
		
		//SE sobrescribe correctamente
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo2);
		assertEquals(attrezzo2,stanza1.getAttrezzo("Pala"));
		
		//No se puede añadir mismo attrezo con diferentes propiedades
		stanza1.addAttrezzo(attrezzo1);
		assertNull(stanza1.addAttrezzo(attrezzo3));
		
	}

}
