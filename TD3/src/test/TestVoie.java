package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import normalisation.NormalisationPays;
import normalisation.NormalisationVoie;

public class TestVoie {

	@Test
	public void TestNormalisationVoieBoul1() {
		String voie = "3, boul du roi";
		assertEquals("3, boulevard du roi",NormalisationVoie.normalisation(voie));
	}
	
	@Test
	public void TestNormalisationVoieBoul2() {
		String voie = "3, boul. du roi";
		assertEquals("3, boulevard du roi",NormalisationVoie.normalisation(voie));
	}
	
	@Test
	public void TestNormalisationVoieBoul3() {
		String voie = "3, bd du roi";
		assertEquals("3, boulevard du roi",NormalisationVoie.normalisation(voie));
	}
	
	@Test
	public void TestNormalisationVoieAv() {
		String voie = "3, av du roi";
		assertEquals("3, avenue du roi",NormalisationVoie.normalisation(voie));
	}
	
	@Test
	public void TestNormalisationVoieFaub1() {
		String voie = "3, faub. du roi";
		assertEquals("3, faubourg du roi",NormalisationVoie.normalisation(voie));
	}
	
	@Test
	public void TestNormalisationVoieFaub2() {
		String voie = "3, fg du roi";
		assertEquals("3, faubourg du roi",NormalisationVoie.normalisation(voie));
	}
	
	@Test
	public void TestNormalisationVoiePlace() {
		String voie = "3, pl du roi";
		assertEquals("3, place du roi",NormalisationVoie.normalisation(voie));
	}
	
	@Test
	public void TestNormalisationVoieNumero() {
		String voie = "3 place du roi";
		assertEquals("3, place du roi",NormalisationVoie.normalisation(voie));
	}
	
	@Test
	public void TestNormalisationVoieNormal() {
		String voie = "3, place du roi";
		assertEquals("3, place du roi",NormalisationVoie.normalisation(voie));
	}
	
	@Test
	public void TestNormalisationVoieNumeroNULL() {
		String voie = null;
		assertNull(null,NormalisationVoie.normalisation(voie));
	}
	
	@Test
	public void TestNormalisationVoieNumerovide() {
		String voie = "";
		assertEquals("",NormalisationVoie.normalisation(voie));
	}
	
	@Test
	public void TestNormalisationVoieNumeroTrim() {
		String voie ="   3, place du roi          ";
		assertEquals("3, place du roi",NormalisationVoie.normalisation(voie));
	}
	
	
	
}
