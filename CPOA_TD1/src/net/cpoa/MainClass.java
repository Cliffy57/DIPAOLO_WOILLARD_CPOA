package net.cpoa;

public class MainClass {

	public static void main(String[] args) {
		public static void main(String[] args) {
		System.out.print("Quel table voulez-vous :\n"
				+ "(1) Abonnement\n"
				+ "(2) Client\n"
				+ "(3) Periodicite\n"
				+ "(4) Revue\n");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			Abonnement.launch();
			break;
		case 2:
			Client.launch();
			break;
		case 3:
			Periodicite.launch();
			break;
		case 4 :
			Revue.launch();
			break;
		default:
			System.out.println("Merci de votre visite et à bientôt");
			break;
		}

	}
	}
	

}
