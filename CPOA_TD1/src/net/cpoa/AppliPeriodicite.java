package moduBdD;

import java.util.Scanner;

public class AppliPeriodicite {
	
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
					System.out.print("Saisissez la valeur du libellé\n");
					String label= scanner.next();
					AjouterPeriodicite.insertPeriodicite(ID, label);
				break;
			case 2:
				
				System.out.print("Saisissez la valeur de l'ID à modifier\n");
				int IDold = scanner.nextInt();
				System.out.print("Saisissez la valeur du nouveau ID\n");
				int IDnew = scanner.nextInt();
				System.out.print("Saisissez la valeur du nouveau libellé\n");
				String newLabel= scanner.next();
				ModifierPeriodicite.modifiePeriodicite(IDnew, newLabel, IDold);
				break;
			case 3:
				
				System.out.print("Saisissez la valeur de l'ID à supprimer\n");
				int IDsuppr = scanner.nextInt();
				SupprimerPeriodicite.deletePeriodicite(IDsuppr);
				break;
				

			default:
				
				break;
			}
		
		
	}
	

}
