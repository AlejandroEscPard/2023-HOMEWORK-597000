package it.uniroma3.diadia.giocatore;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {

	Borsa borsa;
	Attrezzo pala, martillo, spada;
	
	@BeforeEach
	void setUp() {
		borsa = new Borsa(2);
		pala = new Attrezzo("Pala", 2);
		martillo = new Attrezzo("Martillo", 2);
		spada = new Attrezzo("Spada", 2);
	}
	
	public void testAddAttrezzo() {
		//Añadimos correctamente
		borsa.addAttrezzo(pala);
		assertEquals(pala, borsa.getAttrezzo("Pala"));
		
		//Borsa llena 
		borsa = new Borsa(2);
		borsa.addAttrezzo(pala);
		borsa.addAttrezzo(martillo);
		assertNull(borsa.addAttrezzo(spada));	
	}
	
	public void testgetPesoMax() {
		//Comprobamos que deuelve bien el resultado
		assertEquals(10,borsa.getPesoMax());
	}
	
	public void testgetAttrezzo() {
		//Añadimos attrezo y comprobamos que da correcto.
		borsa = new Borsa(1);
		borsa.addAttrezzo(martillo);
		assertEquals(martillo, borsa.getAttrezzo("Martillo"));
		
		//Attrezo no existe
		borsa = new Borsa(1);
		borsa.addAttrezzo(spada);
		assertNull(borsa.getAttrezzo("Martillo"));		
	}

}
