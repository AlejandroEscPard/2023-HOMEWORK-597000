package it.uniroma3.diadia.giocatore;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {

	Giocatore giocatore;
	Borsa borsa;
	
	@BeforeEach
	void setUp() {
		giocatore = new Giocatore();
		borsa = new Borsa();
	}
	
	@Test
	public void setCFU() {
		giocatore.setCFU(1);
		assertEquals(1,giocatore.getCFU());
	}
	
	@Test
	public void getCFU() {
		giocatore.setCFU(2);
		assertEquals(2,giocatore.getCFU());
	}
	
	@Test
	public void getBorsa() {
		giocatore.getBorsa();
		assertEquals(2,giocatore.getCFU());
	}
	
	@Test
	public void setBorsa() {
		giocatore.setBorsa(borsa);
		assertEquals(borsa,giocatore.getBorsa());
	}

}
