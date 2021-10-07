package normalisation;

public class NormalisationVille {

	public static String normalisation(String str) {
		
		str = str.trim();
		char firstLetter = str.charAt(0);
		if(!(Character.isUpperCase(firstLetter)))
		{
			str = str.replaceFirst(Character.toString(firstLetter), Character.toString(Character.toUpperCase(firstLetter)));
		}
		if(str.contains(" lès "))
		{
			str = str.replace(" lès ", "-lès-");
		}
		if(str.contains(" le "))
		{
			str = str.replace(" le ", "-le-");
		}
		if(str.contains(" sous "))
		{
			str = str.replace(" sous ", "-sous-");
		}
		if(str.contains(" sur "))
		{
			str = str.replace(" sur ", "-sur-");
		}
		if(str.contains(" à "))
		{
			str = str.replace(" à ", "-à-");
		}
		if(str.contains(" aux "))
		{
			str = str.replace(" aux ", "-aux-");
		}
		if(str.contains("St ") || str.contains("St-"))
		{
			str = str.replace("St ", "Saint-");
			str = str.replace("St-", "Saint-");
		}
		if(str.contains("Ste ") || str.contains("Ste-"))
		{
			str = str.replace("Ste ", "Sainte-");
			str = str.replace("Ste-", "Sainte-");
		}
		
		return str;
			
	}

}
