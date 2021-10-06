package connexion;

import java.util.Scanner;

import dao.metier.AbonnementMetier;
import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import dao.metier.RevueMetier;

public class MainClass {

	public static void LaunchSQL() {
		System.out.println("Quel table voulez-vous :\n" + "(1) Abonnement\n" + "(2) Client\n" + "(3) Periodicite\n"
				+ "(4) Revue\n" + "(5) Retour\n" +"(6) Quitter");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			AbonnementMetier.abonnementLaunchSQL();
			break;
		case 2:
			ClientMetier.clientLaunchSQL();
			break;
		case 3:
			PeriodiciteMetier.periodiciteLaunchSQL();
			break;
		case 4:
			RevueMetier.revueLaunchSQL();
			break;
		case 5:
			ChoixSGBD();
			break;
		case 6:
			break;
		default:
			LaunchSQL();
		}
	}

	public static void LaunchListeMemoire() {
		System.out.println("Quel table voulez-vous :\n" + "(1) Abonnement\n" + "(2) Client\n" + "(3) Periodicite\n"
				+ "(4) Revue\n" + "(5) Retour\n" +"(6) Quitter");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			AbonnementMetier.abonnementLaunchListeMemoire();
			break;
		case 2:
			ClientMetier.clientLaunchListeMemoire();
			break;
		case 3:
			PeriodiciteMetier.periodiciteLaunchListeMemoire();
			break;
		case 4:
			RevueMetier.revueListeMemoire();
			break;
		case 5:
			ChoixSGBD();
			break;
		case 6 :
			break;
		default:
			LaunchListeMemoire();
		}
	}
	
	public static void ChoixSGBD() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choisissez votre SGBD:\n" + "(1) SQL\n" + "(2) ListeMemoire\n" + "(3) Partir");
		int res = scanner.nextInt();
		switch(res) {
		case 1 : LaunchSQL();
				break;
		case 2 : LaunchListeMemoire();
			break;
		case 3:
			break;
		default:
			ChoixSGBD();
			break;
		}
		scanner.close();
		
	}
	
	public static void main(String[] args) {

		ChoixSGBD();
		
	}
	
}
