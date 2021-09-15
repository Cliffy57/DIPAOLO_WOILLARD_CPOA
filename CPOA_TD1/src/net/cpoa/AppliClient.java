package moduBdD;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppliClient {
	public static void launch() {
		System.out.print("Voulez-vous :\n"
				+ "(1) Ajouter\n"
				+ "(2) Modifier\n"
				+ "(3) Supprimer\n");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
				System.out.print("Saisissez la valeur de l'ID\n");
				int ID = scanner.nextInt();
				System.out.print("Saisissez la valeur du nom\n");
				String nom  = scanner.next();
				System.out.print("Saisissez la valeur du prenom\n");
				String prenom  = scanner.next();
				System.out.print("Saisissez la valeur du numéro de rue\n");
				int no_rue  = scanner.nextInt();
				System.out.print("Saisissez la valeur de la voie\n");
				String voie  = scanner.next();
				System.out.print("Saisissez la valeur du code postal\n");
				int codepost  = scanner.nextInt();
				System.out.print("Saisissez la valeur de la ville\n");
				String ville  = scanner.next();
				System.out.print("Saisissez la valeur du pays\n");
				String pays  = scanner.next();
				AjouterClient.insertClient(ID, nom, prenom, no_rue, voie, codepost, ville, pays);
			break;
		case 2:
			
			System.out.print("Saisissez la valeur de l'ID à modifier\n");
			int IDold = scanner.nextInt();
			System.out.print("Saisissez la valeur du nouveau ID\n");
			int IDnew = scanner.nextInt();
			System.out.print("Saisissez la valeur du nom\n");
			String Newnom  = scanner.next();
			System.out.print("Saisissez la valeur du prenom\n");
			String Newprenom  = scanner.next();
			System.out.print("Saisissez la valeur du numéro de rue\n");
			int Newno_rue  = scanner.nextInt();
			System.out.print("Saisissez la valeur de la voie\n");
			String Newvoie  = scanner.next();
			System.out.print("Saisissez la valeur du code postal\n");
			int Newcodepost  = scanner.nextInt();
			System.out.print("Saisissez la valeur de la ville\n");
			String Newville  = scanner.next();
			System.out.print("Saisissez la valeur du pays\n");
			String Newpays  = scanner.next();
			ModifierClient.modifieClient(IDnew, Newnom, Newprenom, Newno_rue, Newvoie, Newcodepost, Newville, Newpays, IDold);
			break;
		case 3:
			
			System.out.print("Saisissez la valeur de l'ID à supprimer\n");
			int IDsuppr = scanner.nextInt();
			SupprimerClient.deleteClient(IDsuppr);
			break;
			

		default:
			
			break;
		}
	
	
}
}
