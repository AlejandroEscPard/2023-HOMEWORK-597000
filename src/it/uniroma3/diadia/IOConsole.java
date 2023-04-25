package it.uniroma3.diadia;
import java.util.Scanner;
public class IOConsole implements IO {
	@Override
	/**
	 * Stampa un mensaggio
	 */
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	/**
	 * Leggere un mensaggio.
	 */
	@Override
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		return riga;
	}
}