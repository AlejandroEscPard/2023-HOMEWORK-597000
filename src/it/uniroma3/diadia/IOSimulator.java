package it.uniroma3.diadia;
import java.util.LinkedList;
import java.util.Scanner;
public class IOSimulator implements IO {
	public LinkedList<String> arrayout;
	public IOSimulator() {
	}
	@Override
	/**
	 * Stampa un mensaggio
	 */
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
		arrayout.add(msg);
		
	}
	/**
	 * Leggere un mensaggio.
	 */
	@Override
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		arrayout.add(riga);
		return riga;
	}
	public void stampamessagi(){
		
		for (String b : arrayout) {
			System.out.print(b);
		}
		
	}
}
	