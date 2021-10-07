package test;

import static org.junit.Assert.assertEquals;
import normalisation.normalisationPays;
import org.junit.Test;

public class TestNormalisationPays {

	
	@Test
	public void testBelgium() {
		String pays ="belgium";
		assertEquals("Belgique",normalisationPays.normalisation(pays));
	}
	@Test
	public void testLetzebuerg() {
		String pays ="letzebuerg";
		assertEquals("Luxembourg",normalisationPays.normalisation(pays));
	}
	@Test
	public void testSwitzerland() {
		String pays ="Switzerland";
		assertEquals("Suisse",normalisationPays.normalisation(pays));
	}
	@Test
	public void testSchweiz() {
		String pays ="Schweiz";
		assertEquals("Suisse",normalisationPays.normalisation(pays));
	}
	public void testChaineVide() {
		String pays ="";
		assertEquals("",normalisationPays.normalisation(pays));
	}
	
}
