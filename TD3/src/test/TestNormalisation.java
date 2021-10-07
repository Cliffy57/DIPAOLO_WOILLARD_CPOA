package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestNormalisation {

	
	public static String normalisation(String str) {
		
		str = str.trim();
		switch(str) {
		case "letzebuerg" : str = " Luxembourg"; break;
		case "belgium" : str = "Belgique"; break;
		case "Switzerland" : str = " Suisse"; break;
		case "Schweiz" : str = " Suisse"; break;
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		System.out.println(normalisation("belgium"));
	}
	
	@Test
	public void testBelgium() {
		String pays ="belgium";
		assertEquals("Belgique", normalisation(pays));
	}
	
}
