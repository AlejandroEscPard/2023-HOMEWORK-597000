 package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe che gestiona la borsa
 *
 * @author  Docente POO
 * @see Borsa
 * @version base
 */
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private ArrayList<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	IO ioconsole = new IOConsole();
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.numeroAttrezzi = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		else
			attrezzi.add(attrezzo);
			this.numeroAttrezzi++;
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for (Attrezzo attrezzi : this.attrezzi)
			if (attrezzi != null && attrezzi.getNome().equals(nomeAttrezzo))
			{
				return attrezzi;
			
			}
		return null;
			
	}
	public int getPeso() {
		int peso = 0;
		for (Attrezzo attrezzi : this.attrezzi)
			peso += attrezzi.getPeso();

		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		Attrezzo a = null;
		if ( numeroAttrezzi > 0) {
			for ( Attrezzo attrezzi : this.attrezzi) {
				Attrezzo attrezzo2 = attrezzo;
				if ( attrezzi.getNome().equals(attrezzo2)) {
					attrezzi=a;
					numeroAttrezzi--;
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append( "Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): " );
			for (Attrezzo attrezzi : this.attrezzi)
				s.append(attrezzi);
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezziordinato = new ArrayList<>(this.attrezzi);
		
		Collections.sort(attrezziordinato, new Comparator<Attrezzo>() {
		
			@Override
			public int compare(Attrezzo attrezzo1, Attrezzo attrezzo2) {
			
				int comparepeso = Integer.compare(attrezzo1.getPeso(), attrezzo2.getPeso());
					if (comparepeso == 0) {
						//Iguali peso, compare nome
						return attrezzo1.getNome().compareTo(attrezzo2.getNome());
					}
			return comparepeso;
			}
		});
		return attrezziordinato;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> attrezziordinato = new TreeSet<>(new Comparator<Attrezzo>(){
				
			@Override
			public int compare(Attrezzo attrezzo1, Attrezzo attrezzo2) {
			
				return attrezzo1.getNome().compareTo(attrezzo2.getNome());
			}
		});
	
		return attrezziordinato;
	}
	
	public HashMap<Integer, Set<Attrezzo>> getContenutoRaggruperPeso(){
		
		HashMap<Integer, Set<Attrezzo>> mappa = new HashMap<>();
		
		for (Attrezzo attrezzo : attrezzi) {
			
			int peso = attrezzo.getPeso();
			
			Set<Attrezzo> attrezziStessoPeso = mappa.getOrDefault(peso,  new HashSet<>());
			attrezziStessoPeso.add(attrezzo);
			mappa.put(peso,  attrezziStessoPeso);
		}
	
		
		return mappa;
	}
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> ordinatopesonome = new TreeSet<Attrezzo>(new Comparator<Attrezzo>() {
		@Override
		
		public int compare (Attrezzo attrezzo1, Attrezzo attrezzo2) {
			int comparePeso = Integer.compare(attrezzo1.getPeso(), attrezzo2.getPeso());
			if (comparePeso == 0) {
				return attrezzo1.getNome().compareTo(attrezzo2.getNome());
			}
			return comparePeso;
		}
		});
		
		return ordinatopesonome;
	}
}