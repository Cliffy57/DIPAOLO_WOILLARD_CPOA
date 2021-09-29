package net.cpoa;

import java.util.Scanner;

import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.AbonnementMetier;
import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import dao.metier.RevueMetier;

public class MainClass {
	
	public static void LaunchSQL() {
		System.out.println("Quel table voulez-vous :\n"
				+ "(1) Abonnement\n"
				+ "(2) Client\n"
				+ "(3) Periodicite\n"
				+ "(4) Revue\n");
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
		case 4 :
			RevueMetier.revueLaunchSQL();
			break;
		default:
			LaunchSQL();
		}
	}
	
	public static void LaunchListeMemoire() {
		
	}
			
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);	
		System.out.println("Choissisez votre SGBD");
		int res = scanner.nextInt();
		switch(res) {
		case 1 : LaunchSQL();
				break;
		case 2 : PeriodiciteMetier.periodiciteLaunchListeMemoire(); 
			break;
		default :
			break;
		}

	}
	
}
	
