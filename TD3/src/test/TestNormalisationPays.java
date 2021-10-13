package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import normalisation.*;

public class TestNormalisationPays {

	
	@Test
	public void testBelgium() {
		String pays ="belgium";
		assertEquals("Belgique",NormalisationPays.normalisation(pays));
	}
	@Test
	public void testLetzebuerg() {
		String pays ="letzebuerg";
		assertEquals("Luxembourg",NormalisationPays.normalisation(pays));
	}
	@Test
	public void testSwitzerland() {
		String pays ="Switzerland";
		assertEquals("Suisse",NormalisationPays.normalisation(pays));
	}
	@Test
	public void testSchweiz() {
		String pays ="Schweiz";
		assertEquals("Suisse",NormalisationPays.normalisation(pays));
	}
	public void testChaineVide() {
		String pays ="";
		assertEquals("",NormalisationPays.normalisation(pays));
	}
	
}
