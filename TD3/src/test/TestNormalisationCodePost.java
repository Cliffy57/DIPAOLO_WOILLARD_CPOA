package test;


import static org.junit.Assert.assertEquals;
import normalisation.*;
import org.junit.Test;


public class TestNormalisationCodePost {

//	les codes postaux français sont sur cinq chiffres, en ajoutant le 0 non significatif si nécessaire, et les
//	indicatifs de pays sont supprimés (8200 → 08200, L-2270 → 2270)


	
	@Test
	public void test0() {
		String codepost = "8200";
		assertEquals("08200", normalisationCodePost.normalisation(codepost));

	}
	@Test
	public void testIndicatif() {
		String codepost = "L-2270";
		assertEquals("2270", normalisationCodePost.normalisation(codepost));

	}
	
	

}
