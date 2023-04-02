import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitaTest {
	Partita partita;
	Giocatore giocatore;
	Stanza stanzaCorrente;
	Stanza stanzaVicente;
	
	@BeforeEach
	void setUp() {
		partita = new Partita();
		stanzaCorrente = new Stanza("Principio");
		stanzaVicente = new Stanza("Final");
	}
	
	@Test
	public void testvinta() {
		partita.setStanzaCorrente(stanzaVicente);
		assertTrue(partita.vinta());
	}

	@Test
	public void testgetStanzaCorrente() {
		partita.setStanzaCorrente(stanzaVicente);
		assertEquals(stanzaVicente, partita.getStanzaCorrente());
	}
	
	@Test
	public void testsetStanzaCorrente() {
		partita.setStanzaCorrente(stanzaCorrente);
		assertEquals(stanzaCorrente, partita.getStanzaCorrente());
	}
	@Test
	public void testsetFinita() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	

	
	@Test 
	public void testisFinita() {
		//finita=true
		partita.setFinita();
		giocatore.setCFU(1);
		partita.setStanzaCorrente(stanzaCorrente);
		assertTrue(partita.isFinita());
		//finita=false
		partita.setFinita();
		giocatore.setCFU(1);
		partita.setStanzaCorrente(stanzaCorrente);
		assertFalse(partita.isFinita());
		//cfu==0
		partita.setFinita();
		giocatore.setCFU(0);
		partita.setStanzaCorrente(stanzaCorrente);
		assertTrue(partita.isFinita());
		//StanzaCorrente=stanzavicente
		partita.setFinita();
		giocatore.setCFU(1);
		partita.setStanzaCorrente(stanzaVicente);
		assertTrue(partita.isFinita());
	}
}
