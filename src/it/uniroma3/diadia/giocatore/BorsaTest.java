package it.uniroma3.diadia.giocatore;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {

	Borsa borsa;
	Attrezzo pala, martillo, spada, spadaoro, martillooro, palaoro;

	@BeforeEach
	void setUp() {
		borsa = new Borsa(2);
		pala = new Attrezzo("Pala", 5);
		martillo = new Attrezzo("Martillo", 3);
		spada = new Attrezzo("Spada", 8);
	}
	@Test
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
	@Test
	public void testgetPesoMax() {
		//Comprobamos que deuelve bien el resultado
		assertEquals(10,borsa.getPesoMax());
	}
	@Test
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
	@Test
	public void testContenutoOrdinatoPerPesoNome() {
		borsa = new Borsa(2);

		this.borsa.addAttrezzo(martillo);
		this.borsa.addAttrezzo(pala);
		this.borsa.addAttrezzo(spada);
		SortedSet<Attrezzo> attrezziOrdinati = borsa.getContenutoOrdinatoPerNome();
		SortedSet<Attrezzo> attrezziAspetati = new TreeSet<>();

		attrezziAspetati.add(martillo);
		attrezziAspetati.add(pala);
		attrezziAspetati.add(spada);

		assertEquals(attrezziOrdinati, attrezziAspetati);
	}
	@Test
	public void testContenutoVuoto() {
		borsa = new Borsa();


		List<Attrezzo> borsaordinata = (List<Attrezzo>) new Borsa();
		borsaordinata = this.borsa.getContenutoOrdinatoPerPeso();

		assertTrue(borsaordinata.isEmpty());

	}

	@Test
	public void testContenutoSortedPerNome() {
		borsa = new Borsa();

		this.borsa.addAttrezzo(spada);
		this.borsa.addAttrezzo(martillo);
		this.borsa.addAttrezzo(pala);
		SortedSet<Attrezzo> borsaordinata = (SortedSet<Attrezzo>) new Borsa();
		borsaordinata = this.borsa.getContenutoOrdinatoPerNome();

		assertEquals(((List<Attrezzo>) borsaordinata).get(0), martillo);
		assertEquals(((List<Attrezzo>) borsaordinata).get(1), pala);
		assertEquals(((List<Attrezzo>) borsaordinata).get(2), spada);
	}
	@Test
	public void testgetContenutoRaggruperPeso() {
		borsa = new Borsa();

		pala = new Attrezzo("Pala", 5);
		martillo = new Attrezzo("Martillo", 3);
		spada = new Attrezzo("Spada", 8);
		palaoro =new Attrezzo("PalaOro", 8);
		spadaoro = new Attrezzo("SpadaOro", 3);
		martillooro = new Attrezzo("MartilloOro", 5);

		this.borsa.addAttrezzo(spada);
		this.borsa.addAttrezzo(martillo);
		this.borsa.addAttrezzo(pala);
		this.borsa.addAttrezzo(palaoro);
		this.borsa.addAttrezzo(martillooro);
		this.borsa.addAttrezzo(spadaoro);

		Map<Integer, Set<Attrezzo>> attrezziordinato = borsa.getContenutoRaggruperPeso();

		Map<Integer, Set<Attrezzo>> attrezziAspeto = borsa.getContenutoRaggruperPeso();
		Set<Attrezzo> attrezziPeso3 = new HashSet<>();
		Set<Attrezzo> attrezziPeso8 = new HashSet<>();
		Set<Attrezzo> attrezziPeso5 = new HashSet<>();

		attrezziPeso3.add(martillo);
		attrezziPeso3.add(spadaoro);

		attrezziPeso8.add(martillo);
		attrezziPeso8.add(martillo);

		attrezziPeso5.add(martillo);
		attrezziPeso5.add(martillo);

		attrezziAspeto.put(5, attrezziPeso5);
		attrezziAspeto.put(3, attrezziPeso3);
		attrezziAspeto.put(8, attrezziPeso8);

		assertEquals(attrezziordinato, attrezziAspeto );

	}
	@Test
	public void testgetSortedOrdinatoPerPeso() {
		borsa = new Borsa();

		pala = new Attrezzo("Pala", 5);
		martillo = new Attrezzo("Martillo", 3);
		spada = new Attrezzo("Spada", 8);

		this.borsa.addAttrezzo(spada);
		this.borsa.addAttrezzo(martillo);
		this.borsa.addAttrezzo(pala);


		SortedSet<Attrezzo> attrezziordinato = borsa.getSortedSetOrdinatoPerPeso();

		SortedSet<Attrezzo> attrezziaspeto = new TreeSet<>(new Comparator<Attrezzo>() {
			@Override
			public int compare(Attrezzo attrezzo1, Attrezzo attrezzo2) {
				int comparePeso = Integer.compare(attrezzo1.getPeso(), attrezzo2.getPeso());
				if (comparePeso == 0) {
					return attrezzo1.getNome().compareTo(attrezzo2.getNome());
				}
				return comparePeso;
			}
		});
		
		attrezziaspeto.add(martillo);
		attrezziaspeto.add(pala);
		attrezziaspeto.add(spada);

		assertEquals(attrezziordinato, attrezziaspeto);
	}
}
