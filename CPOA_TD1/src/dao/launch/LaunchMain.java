package dao.launch;

import java.util.Scanner;

public class LaunchMain {

	public static void LaunchSQL() {
		System.out.println("Quel table voulez-vous :\n" + "(1) Abonnement\n" + "(2) Client\n" + "(3) Periodicite\n"
				+ "(4) Revue\n" + "(5) Retour\n" + "(6) Quitter");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			LaunchAbonnement.abonnementLaunchSQL();
			break;
		case 2:
			LaunchClient.clientLaunchSQL();
			break;
		case 3:
			LaunchPeriodicite.periodiciteLaunchSQL();
			break;
		case 4:
			LaunchRevue.revueLaunchSQL();
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
				+ "(4) Revue\n" + "(5) Retour\n" + "(6) Quitter");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			LaunchAbonnement.abonnementLaunchListeMemoire();
			break;
		case 2:
			LaunchClient.clientLaunchListeMemoire();
			break;
		case 3:
			LaunchPeriodicite.periodiciteLaunchListeMemoire();
			break;
		case 4:
			LaunchRevue.revueListeMemoire();
			break;
		case 5:
			ChoixSGBD();
			break;
		case 6:
			break;
		default:
			LaunchListeMemoire();
		}
	}

	public static void ChoixSGBD() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Choisissez votre SGBD:\n" + "(1) SQL\n" + "(2) ListeMemoire\n" + "(3) Partir");
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			LaunchSQL();
			break;
		case 2:
			LaunchListeMemoire();
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
