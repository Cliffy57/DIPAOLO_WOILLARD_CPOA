package dao.metier;

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
		Scanner scanner = new Scanner(System.in).useDelimiter("\n");
		int res = scanner.nextInt();
		switch (res) {
		case 1:
				System.out.println("Saisissez la valeur de l'ID\n");
				int id = scanner.nextInt();
				System.out.println("Saisissez la valeur du libellé\n");
				String libelle= scanner.next();
				factory.getPeriodiciteDAO().create(new PeriodiciteMetier(id, libelle) );
			break;
		case 2:
			
				System.out.println("Saisissez la valeur de l'ID à modifier\n");
				int newId = scanner.nextInt();
				System.out.println("Saisissez la valeur du libellé ID\n");
				String newLibelle = scanner.next();
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
	
	
}

}