package moduBdD;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppliAbonnement {
	
	public static void launch() {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
				System.out.print("Saisissez la valeur de la date de début (sous la forme dd/MM/yyyy)\n");
				LocalDate dateDebut= LocalDate.parse(scanner.next(),formatage)  ;
				System.out.print("Saisissez la valeur de la date de fin (sous la forme dd/MM/yyyy)\n");
				LocalDate dateFin= LocalDate.parse(scanner.next(),formatage)  ;
				System.out.print("Saisissez la valeur de l'ID du Client\n");
				int IDclient= scanner.nextInt();
				System.out.print("Saisissez la valeur de l'ID de la revue\n");
				int IDrevue= scanner.nextInt();
				AjouterAbonnement.insertAbonnement(ID, dateDebut, dateFin, IDclient, IDrevue);
			break;
		case 2:
			
			System.out.print("Saisissez la valeur de l'ID à modifier\n");
			int IDold = scanner.nextInt();
			System.out.print("Saisissez la valeur du nouveau ID\n");
			int IDnew = scanner.nextInt();
			System.out.print("Saisissez la valeur de la date de début (sous la forme dd/MM/yyyy)\n");
			LocalDate dateDebutNew= LocalDate.parse(scanner.next(),formatage)  ;
			System.out.print("Saisissez la valeur de la date de fin (sous la forme dd/MM/yyyy)\n");
			LocalDate dateFinNew= LocalDate.parse(scanner.next(),formatage)  ;
			System.out.print("Saisissez la valeur de l'ID du Client\n");
			int IDclientNew= scanner.nextInt();
			System.out.print("Saisissez la valeur de l'ID de la revue\n");
			int IDrevueNew= scanner.nextInt();
			ModifierAbonnement.modifierAbonnement(IDnew, IDold, IDclientNew, IDrevueNew, dateDebutNew, dateFinNew);
			break;
		case 3:
			
			System.out.print("Saisissez la valeur de l'ID à supprimer\n");
			int IDsuppr = scanner.nextInt();
			SupprimerAbonnement.deleteAbonnement(IDsuppr);
			break;
			

		default:
			
			break;
		}
	
	
}
}
