package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoVaiTest {

	private ComandoVai comandoVai;
	private Partita partita;
	private IOConsole ioconsole;

	@BeforeEach
	void SetUp() {
		comandoVai = new ComandoVai(null);
		partita = new Partita();
		ioconsole = new IOConsole();
	}

	@Test
	public void testEseguiDirezioneNulla() {
		
	}


}
