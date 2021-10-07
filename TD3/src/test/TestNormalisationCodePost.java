package test;

import org.junit.Test;

public class TestNormalisationCodePost {

//	les codes postaux français sont sur cinq chiffres, en ajoutant le 0 non significatif si nécessaire, et les
//	indicatifs de pays sont supprimés (8200 → 08200, L-2270 → 2270)


	
	@Test
	public void testSainte() {
		String ville = "SteMarthesurlelac";
		assertEquals("Sainte-MarthesurleLac", normalisationVille, normalisation(ville));

	}

}
