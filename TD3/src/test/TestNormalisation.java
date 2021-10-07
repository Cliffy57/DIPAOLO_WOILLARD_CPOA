package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import normalisation.NormalisationPays;

public class TestNormalisation {

	@Test
	public void testPaysNULL() {
		String pays = null;
		assertNull(NormalisationPays.normalisation(pays));
	}
	
	@Test
	public void testPaysTrim() {
		String pays ="    pays                ";
		assertEquals("pays", NormalisationPays.normalisation(pays));
	}
}
