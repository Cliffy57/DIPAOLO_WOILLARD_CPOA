package moduBdD;

import java.util.Scanner;

public class AppliRevue {
	
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
				System.out.print("Saisissez la valeur du titre\n");
				String titre  = scanner.next();
				System.out.print("Saisissez la valeur de la description\n");
				String description  = scanner.next();
				System.out.print("Saisissez la valeur du tarif\n");
				float tarif_numero  = scanner.nextFloat();
				System.out.print("Saisissez la valeur du visuel\n");
				String visuel  = scanner.next();
				System.out.print("Saisissez la valeur de l'ID_Periodicite\n");
				int IDPeriodicite = scanner.nextInt();
				
	
				AjouterRevue.insertRevue(ID, titre, description, tarif_numero, visuel, IDPeriodicite);
			break;
		case 2:
			
			System.out.print("Saisissez la valeur de l'ID à modifier\n");
			int IDold = scanner.nextInt();
			System.out.print("Saisissez la valeur du nouveau ID\n");
			int IDnew = scanner.nextInt();
			System.out.print("Saisissez la valeur du titre\n");
			String Newtitre  = scanner.next();
			System.out.print("Saisissez la valeur de la description\n");
			String Newdescription  = scanner.next();
			System.out.print("Saisissez la valeur du tarif\n");
			float Newtarif_numero  = scanner.nextFloat();
			System.out.print("Saisissez la valeur du visuel\n");
			String Newvisuel  = scanner.next();
			System.out.print("Saisissez la valeur de l'ID_Periodicite\n");
			int NewIDPeriodicite = scanner.nextInt();
			ModifierRevue.modifieRevue(IDnew, Newtitre, Newdescription, Newtarif_numero, Newvisuel, NewIDPeriodicite, IDold);
			break;
		case 3:
			
			System.out.print("Saisissez la valeur de l'ID à supprimer\n");
			int IDsuppr = scanner.nextInt();
			SupprimerRevue.deleteRevue(IDsuppr);
			break;
			

		default:
			
			break;
		}
	
	
}
}
