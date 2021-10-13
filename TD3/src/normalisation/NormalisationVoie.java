package normalisation;

public class NormalisationVoie {

	
	public static String normalisation(String str) {

		if(str != null && str != "") {
			
			str = str.trim();
			if(str.contains(" boul "))
			{
				str = str.replace(" boul ", " boulevard ");
			}
		}

		return str;
			
	}
}
