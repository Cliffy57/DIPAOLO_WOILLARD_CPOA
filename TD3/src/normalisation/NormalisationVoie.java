package normalisation;

public class NormalisationVoie {

	public static boolean isInt(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static String normalisation(String str) {
		
		if(str != null)
		{
			str = str.trim();
			
			if(str.contains(" boul ") || str.contains(" boul. ") || str.contains(" bd "))
			{
				str = str.replace(" boul ", "boulevard");
				str = str.replace(" boul. ", "boulevard");
				str = str.replace(" bd ", "boulevard");
			}
			
			if(str.contains(" av "))
			{
				str = str.replace(" av ", "avenue");

			}
			
			if(str.contains(" faub. ") || str.contains(" fg. "))
			{
				str = str.replace(" faub. ", "faubourg");
				str = str.replace(" fg. ", "faubourg");
			}
			
			String FirstCharToString = Character.toString(str.charAt(0));
			String SecondCharToString = Character.toString(str.charAt(1));
			
			if(isInt(FirstCharToString) && SecondCharToString ==".");
			{
				str = str.replace(FirstCharToString, FirstCharToString.concat("."));
			}
		}
		
		
		
		
		return str;
			
	}
}
