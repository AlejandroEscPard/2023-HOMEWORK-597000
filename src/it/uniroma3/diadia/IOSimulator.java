package it.uniroma3.diadia;
import java.util.Scanner;
public class IOSimulator implements IO {
	private String[] arrayout;
	private int indexin, indexout;
	public IOSimulator() {
	}
	@Override
	/**
	 * Stampa un mensaggio
	 */
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
		arrayout[indexout] = msg;
		indexout++;
		
	}
	/**
	 * Leggere un mensaggio.
	 */
	@Override
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		arrayout[indexin] = riga;
		indexin++;
		return riga;
	}
	public void stampamessagi(){
		
		for(int g = 0; g < arrayout.length;g++) {
			System.out.println(arrayout[g]);
			return;
		}
		
	}
}
	