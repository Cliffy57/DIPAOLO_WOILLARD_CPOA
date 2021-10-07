package test;

import org.junit.Test;

public class TestNormalisationVille {

	// lès, sous, sur, à, aux (Montigny-lès-Metz) ;
	// St/Ste (Saint-Julien-lès-Metz)

	@Test
	public void testMajuscule() {

		String ville = "paris";
		assertEquals("Paris", normalisationVille.normalisation(ville));

	}
	@Test
	public void testPrepositionlès() {

		String ville = "Montigny lès Metz";
		assertEquals("Montigny-lès-Metz", normalisationVille.normalisation(ville));

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
	public void testPrepositionà() {

		String ville = "Montigny à Metz";
		assertEquals("Montigny-à-Metz", normalisationVille.normalisation(ville));

	}
	@Test
	public void testPrepositionaux() {

		String ville = "Montigny aux Metz";
		assertEquals("Montigny-aux-Metz", normalisationVille.normalisation(ville));

	}
	@Test
	public void testSaint() {
		String ville = "StJulienlèsMetz";
		assertEquals("Saint-JulienlèsMetz", normalastionVille, normalisation(ville));

	}
	@Test
	public void testSainte() {
		String ville = "SteMarthesurlelac";
		assertEquals("Sainte-MarthesurleLac", normalastionVille, normalisation(ville));

	}

}
//aux = -aux- cheateaux en bain = chate-aux--en-bain
