package normalisation;


public class normalisationCodePost {

public static String normalisation(String str) {
	
	str = str.trim();
	char firstLetter = str.charAt(0);
	if(str.length()!=5)
	{
		str = str.replaceFirst(Character.toString(firstLetter),"0");
	}
	if(str.contains("L-"))
	{
		str = str.replace(" lès ", "-lès-");
	}
	
	
	return str;
		
}

}