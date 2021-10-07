package normalisation;

public class NormalisationPays {

	public static String normalisation(String str) {
		
		if(str != null) {
			str = str.trim();
			switch(str) {
			case "letzebuerg" : str = "Luxembourg"; break;
			case "belgium" : str = "Belgique"; break;
			case "Switzerland" : str = "Suisse"; break;
			case "Schweiz" : str = "Suisse"; break;
			}
			return str;
		}
		else {
			return null;
		}
	}
}
