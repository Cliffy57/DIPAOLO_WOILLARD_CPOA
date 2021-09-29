package dao.metier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import dao.Persistance;
import dao.factory.DAOFactory;

public class PeriodiciteMetier 
{
    private int id;
    private String libelle;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public PeriodiciteMetier(int id, String libelle)
    {
        this.setId(id);
        this.setLibelle(libelle);
    }
    
    public PeriodiciteMetier() {
		// TODO Auto-generated constructor stub
	}
	@Override
    public String toString() {
        return "Periodicite [ID=" + id + ", libelle=" + libelle + "]";
    }

    public static void periodiciteLaunchSQL() {
		DAOFactory factory = DAOFactory.getDAOFactory(Persistance.MYSQL);
		System.out.println("Voulez-vous :\n"
				+ "(1) Ajouter\n"
				+ "(2) Modifier\n"
				+ "(3) Supprimer\n");
		Scanner scannerStr = new Scanner(System.in).useDelimiter("\n");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
				System.out.println("Saisissez la valeur de l'ID\n");
				int id = scanner.nextInt();
				System.out.println("Saisissez la valeur du libellé\n");
				String libelle= scannerStr.next();
				factory.getPeriodiciteDAO().create(new PeriodiciteMetier(id, libelle) );
			break;
		case 2:
			
				System.out.println("Saisissez la valeur de l'ID à modifier\n");
				int newId = scanner.nextInt();
				System.out.println("Saisissez la valeur du libellé ID\n");
				String newLibelle = scannerStr.next();
				factory.getPeriodiciteDAO().update(new PeriodiciteMetier(newId, newLibelle));
			break;
		case 3:
			
				System.out.println("Saisissez la valeur de l'ID à supprimer\n");
				int IDsuppr = scanner.nextInt();
				factory.getPeriodiciteDAO().delete(factory.getPeriodiciteDAO().getById(IDsuppr));
			break;
			

		default:
			
			break;
		}
	scanner.close();
	scannerStr.close();
	
}
    
    public static void periodiciteLaunchListeMemoire() {
    	
    	DAOFactory factory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
		System.out.println("Voulez-vous :\n"
				+ "(1) Ajouter\n"
				+ "(2) Modifier\n"
				+ "(3) Supprimer\n");
		Scanner scannerStr = new Scanner(System.in).useDelimiter("\n");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
				System.out.println("Saisissez la valeur de l'ID\n");
				int id = scanner.nextInt();
				System.out.println("Saisissez la valeur du libellé\n");
				String libelle= scannerStr.next();
				factory.getPeriodiciteDAO().create(new PeriodiciteMetier(id, libelle) );
				
			break;
		case 2:
			
				System.out.println("Saisissez la valeur de l'ID à modifier\n");
				int newId = scanner.nextInt();
				System.out.println("Saisissez la valeur du libellé ID\n");
				String newLibelle = scannerStr.next();
				factory.getPeriodiciteDAO().update(new PeriodiciteMetier(newId, newLibelle));
			break;
		case 3:
			
				System.out.println("Saisissez la valeur de l'ID à supprimer\n");
				int IDsuppr = scanner.nextInt();
				factory.getPeriodiciteDAO().delete(factory.getPeriodiciteDAO().getById(IDsuppr));
			break;
			
		case 4 : 
			
			Iterator<PeriodiciteMetier> iterator = factory.getPeriodiciteDAO().findAll().iterator();
			while(iterator.hasNext())
			{
				System.out.println(iterator.next());
			}
			break;
			
		default:
			
			break;
		}
	scanner.close();
	scannerStr.close();
    }

}