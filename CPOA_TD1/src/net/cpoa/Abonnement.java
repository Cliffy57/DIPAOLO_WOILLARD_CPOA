package net.cpoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Abonnement {
	
	
	public static void insertAbonnement(int ID,LocalDate dateDebut,LocalDate dateFin,int IDclient,int IDrevue) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `dipaolo6u_cpoatdun`.`Abonnement` (`id_abonnement`, `date_debut`, `date_fin`, `id_client`, `id_revue`) "
					+ "													VALUES (?, ?, ?, ?, ?);");
			requete.setInt(1, ID);
			requete.setDate(2, java.sql.Date.valueOf(dateDebut));
			requete.setDate(3, java.sql.Date.valueOf(dateFin));
			requete.setInt(4, IDclient);
			requete.setInt(5, IDrevue);
			int res = requete.executeUpdate();
			
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}
			
	public static void modifierAbonnement(int IDnew, int IDold, int IDclient, int IDrevue ,LocalDate date_debut, LocalDate date_fin) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE `dipaolo6u_cpoatdun`.`Abonnement` SET `id_abonnement` = ?, `date_debut` = ?, `date_fin` = ?, `id_client` = ?, `id_revue` = ? WHERE `Abonnement`.`id_abonnement` = ?;");
			requete.setInt(1,IDnew);
			requete.setDate(2, java.sql.Date.valueOf(date_debut));
			requete.setDate(3, java.sql.Date.valueOf(date_fin));
            requete.setInt(4,IDclient);
            requete.setInt(5,IDnew);
			requete.setInt(6, IDrevue);
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}

	public static void deleteAbonnement(int ID) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Abonnement where id_abonnement=" + ID);
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}
			

				
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
							insertAbonnement(ID, dateDebut, dateFin, IDclient, IDrevue);
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
						modifierAbonnement(IDnew, IDold, IDclientNew, IDrevueNew, dateDebutNew, dateFinNew);
						break;
					case 3:
						
						System.out.print("Saisissez la valeur de l'ID à supprimer\n");
						int IDsuppr = scanner.nextInt();
						deleteAbonnement(IDsuppr);
						break;
						

					default:
						
						break;
					}
				
				
			}
			
		}




