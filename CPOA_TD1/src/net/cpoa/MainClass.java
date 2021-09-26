package net.cpoa;

import java.util.Scanner;

import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.ClientMetier;

public class MainClass {
	
	static DAOFactory factory = DAOFactory.getDAOFactory(Persistance.MYSQL);
	
	public static void Clientlaunch() {
		
			
			
			
			
			
			System.out.println("Voulez-vous :\n"
					+ "(1) Ajouter\n"
					+ "(2) Modifier\n"
					+ "(3) Supprimer\n");
			Scanner scanner = new Scanner(System.in).useDelimiter("\n");
			int res = scanner.nextInt();
			switch (res) {
			case 1:
					System.out.println("Saisissez la valeur de l'ID\n");
					int ID = scanner.nextInt();
					System.out.println("Saisissez la valeur du nom\n");
					String nom  = scanner.next().trim();
					System.out.println("Saisissez la valeur du prenom\n");
					String prenom  = scanner.next().trim();
					System.out.println("Saisissez la valeur du numéro de rue\n");
					int no_rue  = scanner.nextInt();
					System.out.println("Saisissez la valeur de la voie\n");
					String voie  = scanner.next().trim();
					System.out.println("Saisissez la valeur du code postal\n");
					int codepost  = scanner.nextInt();
					System.out.println("Saisissez la valeur de la ville\n");
					String ville  = scanner.next().trim();
					System.out.println("Saisissez la valeur du pays\n");
					String pays  = scanner.next().trim();
					factory.getClientDAO().create(new ClientMetier(ID, nom, prenom, no_rue, voie, codepost, ville, pays));
				break;
			case 2:
				
				System.out.println("Saisissez la valeur de l'ID à modifier\n");
				int IDold = scanner.nextInt();
				System.out.println("Saisissez la valeur du nouveau ID\n");
				int newID = scanner.nextInt();
				System.out.println("Saisissez la valeur du nom\n");
				String Newnom  = scanner.next().trim();
				System.out.println("Saisissez la valeur du prenom\n");
				String Newprenom  = scanner.next().trim();
				System.out.println("Saisissez la valeur du numéro de rue\n");
				int Newno_rue  = scanner.nextInt();
				System.out.println("Saisissez la valeur de la voie\n");
				String Newvoie  = scanner.next().trim();
				System.out.println("Saisissez la valeur du code postal\n");
				int Newcodepost  = scanner.nextInt();
				System.out.println("Saisissez la valeur de la ville\n");
				String Newville  = scanner.next().trim();
				System.out.println("Saisissez la valeur du pays\n");
				String Newpays  = scanner.next().trim();
				factory.getClientDAO().update(new ClientMetier(newID, Newnom, Newprenom, Newno_rue, Newvoie, Newcodepost, Newville, Newpays));
				break;
			case 3:
				
				System.out.println("Saisissez la valeur de l'ID à supprimer\n");
				int IDsuppr = scanner.nextInt();
				factory.getClientDAO().delete(factory.getClientDAO().getById(IDsuppr));
				break;
				
	
			default:
				
				break;
			}	
	}
			public static void main(String[] args) {
			System.out.println("Quel table voulez-vous :\n"
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
				Clientlaunch();
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
	
