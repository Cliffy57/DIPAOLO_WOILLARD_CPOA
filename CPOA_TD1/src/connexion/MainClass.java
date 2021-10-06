package connexion;

import java.util.Scanner;

import dao.metier.AbonnementMetier;
import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import dao.metier.RevueMetier;

public class MainClass {

	public static void LaunchSQL() {
		System.out.println("Quel table voulez-vous :\n" + "(1) Abonnement\n" + "(2) Client\n" + "(3) Periodicite\n"
				+ "(4) Revue\n" + "(5) Partir");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			AbonnementMetier.abonnementLaunchSQL();
			LaunchSQL();
			break;
		case 2:
			ClientMetier.clientLaunchSQL();
			LaunchSQL();
			break;
		case 3:
			PeriodiciteMetier.periodiciteLaunchSQL();
			LaunchSQL();
			break;
		case 4:
			RevueMetier.revueLaunchSQL();
			LaunchSQL();
			break;
		case 5:
			break;
		default:
			LaunchSQL();
		}
	}

	public static void LaunchListeMemoire() {
		System.out.println("Quel table voulez-vous :\n" + "(1) Abonnement\n" + "(2) Client\n" + "(3) Periodicite\n"
				+ "(4) Revue\n" + "(5) Partir");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			AbonnementMetier.abonnementLaunchListeMemoire();
			LaunchListeMemoire();
			break;
		case 2:
			ClientMetier.clientLaunchListeMemoire();
			LaunchListeMemoire();
			break;
		case 3:
			PeriodiciteMetier.periodiciteLaunchListeMemoire();
			LaunchListeMemoire();
			break;
		case 4:
			RevueMetier.revueListeMemoire();
			LaunchListeMemoire();
			break;
		case 5:
			break;
		default:
			LaunchListeMemoire();
		}
	}

	public static void main(String[] args) {

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
			main(args);
			break;
		}
		scanner.close();
	}

}
