package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

public class ComandoNonValido implements Comando {
	IO ioconsole = new IOConsole();
	Partita partita = new Partita();
	
	
	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		ioconsole.mostraMessaggio("Comando no valido");
	}


	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
}