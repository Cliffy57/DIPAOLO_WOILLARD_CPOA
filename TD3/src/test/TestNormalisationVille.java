package test;

import org.junit.Test;

public class TestNormalisationVille {

	// l�s, sous, sur, �, aux (Montigny-l�s-Metz) ;
	// St/Ste (Saint-Julien-l�s-Metz)

	@Test
	public void testMajuscule() {

		String ville = "paris";
		assertEquals("Paris", normalisationVille.normalisation(ville));

	}
	@Test
	public void testPrepositionl�s() {

		String ville = "Montigny l�s Metz";
		assertEquals("Montigny-l�s-Metz", normalisationVille.normalisation(ville));

	}
	@Test
	public void testPrepositionsous() {

		String ville = "Ville sous Anjou";
		assertEquals("Ville-sous-Anjou", normalisationVille.normalisation(ville));

	}
	@Test
	public void testPrepositionsur() {

		String ville = "Sainte-Marthe sur le-lac";
		assertEquals("SainteMarthe-sur-leLac", normalastionVille, normalisation(ville));

	}
	@Test
	public void testPreposition�() {

		String ville = "Montigny � Metz";
		assertEquals("Montigny-�-Metz", normalisationVille.normalisation(ville));

	}
	@Test
	public void testPrepositionaux() {

		String ville = "Montigny aux Metz";
		assertEquals("Montigny-aux-Metz", normalisationVille.normalisation(ville));

	}
	@Test
	public void testSaint() {
		String ville = "StJulienl�sMetz";
		assertEquals("Saint-Julienl�sMetz", normalastionVille, normalisation(ville));

	}
	@Test
	public void testSainte() {
		String ville = "SteMarthesurlelac";
		assertEquals("Sainte-MarthesurleLac", normalastionVille, normalisation(ville));

	}

}
//aux = -aux- cheateaux en bain = chate-aux--en-bain
