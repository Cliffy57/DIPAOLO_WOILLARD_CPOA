package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import normalisation.*;

public class TestNormalisationVille {

//	les noms de ville commencent par une majuscule ; quand le nom de ville contient une préposition le,
//	lès, sous, sur, à, aux, la préposition est précédée et suivie de tirets (Montigny-lès-Metz) ; les St/Ste ne sont
//	pas abrégés et sont suivis d'un tiret (Saint-Julien-lès-Metz)


	@Test
	public void testMajuscule() {

		String ville = "paris";
		assertEquals("Paris", NormalisationVille.normalisation(ville));

	}
	@Test
	public void testPrepositionlès() {

		String ville = "Montigny lès Metz";
		assertEquals("Montigny-lès-Metz", NormalisationVille.normalisation(ville));

	}
	@Test
	public void testPrepositionsous() {

		String ville = "Ville sous Anjou";
		assertEquals("Ville-sous-Anjou", NormalisationVille.normalisation(ville));

	}
	@Test
	public void testPrepositionsur() {

		String ville = "Sainte-Marthe sur le-lac";
		assertEquals("Sainte-Marthe-sur-le-lac", NormalisationVille.normalisation(ville));

	}
	@Test
	public void testPrepositionà() {

		String ville = "Montigny à Metz";
		assertEquals("Montigny-à-Metz", NormalisationVille.normalisation(ville));

	}
	@Test
	public void testPrepositionaux() {

		String ville = "Montigny aux Metz";
		assertEquals("Montigny-aux-Metz", NormalisationVille.normalisation(ville));

	}
	@Test
	public void testSaint() {
		String ville = "St JulienlesMetz";
		assertEquals("Saint-JulienlesMetz", NormalisationVille.normalisation(ville));

	}
	@Test
	public void testSaintTiret() {
		String ville = "St-JulienlesMetz";
		assertEquals("Saint-JulienlesMetz", NormalisationVille.normalisation(ville));

	}
	@Test
	public void testSainteTiret() {
		String ville = "Ste-Marthesurlelac";
		assertEquals("Sainte-Marthesurlelac", NormalisationVille.normalisation(ville));

	}
	@Test
	public void testSainte() {
		String ville = "Ste Marthesurlelac";
		assertEquals("Sainte-Marthesurlelac", NormalisationVille.normalisation(ville));

	}
	@Test
	public void testNull() {
		String ville = null;
		assertNull(NormalisationVille.normalisation(ville));
	}
	@Test
	public void testVIde() {
		String ville = "";
		assertEquals("", NormalisationVille.normalisation(ville));
	}
	@Test
	public void testTrim() {
		String ville = "  Paris    ";
		assertEquals("Paris", NormalisationVille.normalisation(ville));
	}

}
//aux = -aux- cheateaux en bain = chate-aux--en-bain