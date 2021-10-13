package normalisation;

public class NormalisationVoie {

	
	public static String normalisation(String str) {

		if(str != null && str != "") {
			
			str = str.trim();
			if(str.contains(" boul "))
			{
				str = str.replace(" boul ", " boulevard ");
			}
			if(str.contains(" boul. "))
			{
				str = str.replace(" boul. ", " boulevard ");
			}
			if(str.contains(" bd "))
			{
				str = str.replace(" bd ", " boulevard ");
			}
			if(str.contains(" av "))
			{
				str = str.replace(" av ", " avenue ");
			}
			if(str.contains(" faub. "))
			{
				str = str.replace(" faub. ", " faubourg ");
			}
			if(str.contains(" fg "))
			{
				str = str.replace(" fg ", " faubourg ");
			}
			if(str.contains(" pl "))
			{
				str = str.replace(" pl ", " place ");
			}
			
			if(str.contains(" boul "))
			{
				str = str.replace(" boul ", " boulevard ");
			}
			char firstChar = str.charAt(0);
			
			if (Character.isDigit(firstChar)) {
				if(str.charAt(1) != '.') {
					
					String s = new StringBuilder().append(firstChar).append('.').toString();
					System.out.println(Character.toString(firstChar));
					System.out.println(s);
					str.strip().replace(Character.toString(firstChar),s);
					System.out.println(str);
				}
			}
		}

		return str;
			
	}
	
	public static void main (String[] args) {
		String caca = "3 place du roi";
		normalisation(caca);
		
	}
}
