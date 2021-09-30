package dao.metier;

import java.util.Iterator;
import java.util.Scanner;

import dao.Persistance;
import dao.factory.DAOFactory;

public class ClientMetier {
	private int id;
	private String nom;
	private String prenom;
	private int noRue;
	private String voie;
	private int codePost;
	private String ville;
	private String pays;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNoRue() {
		return noRue;
	}
	public void setNoRue(int noRue) {
		this.noRue = noRue;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public int getCodePost() {
		return codePost;
	}
	public void setCodePost(int codePost) {
		this.codePost = codePost;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public ClientMetier(int id, String nom, String prenom, int noRue, String voie, int codePost, String ville, String pays) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.noRue = noRue;
		this.voie = voie;
		this.codePost = codePost;
		this.ville = ville;
		this.pays = pays;
	}
	
	 public ClientMetier() {
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", no_rue=" + noRue + ", voie=" + voie
				+ ", codepost=" + codePost + ", ville=" + ville + ", pays=" + pays + "]";
	}
	
	public static void clientLaunchSQL() {
		DAOFactory factory = DAOFactory.getDAOFactory(Persistance.MYSQL);
		System.out.println("Voulez-vous :\n"
				+ "(1) Ajouter\n"
				+ "(2) Modifier\n"
				+ "(3) Supprimer\n"
				+ "(4) Tout afficher");
		Scanner scannerStr = new Scanner(System.in).useDelimiter("\n");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
				System.out.println("Saisissez la valeur de l'ID\n");
				int id = scanner.nextInt();
				System.out.println("Saisissez la valeur du nom\n");
				String nom  = scannerStr.next().trim();
				System.out.println("Saisissez la valeur du prenom\n");
				String prenom  = scannerStr.next().trim();
				System.out.println("Saisissez la valeur du numéro de rue\n");
				int no_rue  = scanner.nextInt();
				System.out.println("Saisissez la valeur de la voie\n");
				String voie  = scannerStr.next().trim();
				System.out.println("Saisissez la valeur du code postal\n");
				int codepost  = scanner.nextInt();
				System.out.println("Saisissez la valeur de la ville\n");
				String ville  = scannerStr.next().trim();
				System.out.println("Saisissez la valeur du pays\n");
				String pays  = scannerStr.next().trim();
				factory.getClientDAO().create(new ClientMetier(id, nom, prenom, no_rue, voie, codepost, ville, pays));
			break;
		case 2:
			
			System.out.println("Saisissez la valeur de l'ID à modifier\n");
			int newID = scanner.nextInt();
			System.out.println("Saisissez la valeur du nom\n");
			String Newnom  = scannerStr.next().trim();
			System.out.println("Saisissez la valeur du prenom\n");
			String Newprenom  = scannerStr.next().trim();
			System.out.println("Saisissez la valeur du numéro de rue\n");
			int Newno_rue  = scanner.nextInt();
			System.out.println("Saisissez la valeur de la voie\n");
			String Newvoie  = scannerStr.next().trim();
			System.out.println("Saisissez la valeur du code postal\n");
			int Newcodepost  = scanner.nextInt();
			System.out.println("Saisissez la valeur de la ville\n");
			String Newville  = scannerStr.next().trim();
			System.out.println("Saisissez la valeur du pays\n");
			String Newpays  = scannerStr.next().trim();
			factory.getClientDAO().update(new ClientMetier(newID, Newnom, Newprenom, Newno_rue, Newvoie, Newcodepost, Newville, Newpays));
			break;
		case 3:
			
			System.out.println("Saisissez la valeur de l'ID à supprimer\n");
			int IDsuppr = scanner.nextInt();
			factory.getClientDAO().delete(factory.getClientDAO().getById(IDsuppr));
			break;
			
		case 4 : 
			Iterator<ClientMetier> iterator = factory.getClientDAO().findAll().iterator();
			while(iterator.hasNext())
			{
				System.out.println(iterator.next());
			}
			break;
			
		default:
			
			break;
		}	
}

	public static void clientLaunchListeMemoire() {
		
		DAOFactory factory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
		System.out.println("Voulez-vous :\n"
				+ "(1) Ajouter\n"
				+ "(2) Modifier\n"
				+ "(3) Supprimer\n"
				+ "(4) Tout afficher");
		Scanner scannerStr = new Scanner(System.in).useDelimiter("\n");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
				System.out.println("Saisissez la valeur de l'ID\n");
				int id = scanner.nextInt();
				System.out.println("Saisissez la valeur du nom\n");
				String nom  = scannerStr.next().trim();
				System.out.println("Saisissez la valeur du prenom\n");
				String prenom  = scannerStr.next().trim();
				System.out.println("Saisissez la valeur du numéro de rue\n");
				int no_rue  = scanner.nextInt();
				System.out.println("Saisissez la valeur de la voie\n");
				String voie  = scannerStr.next().trim();
				System.out.println("Saisissez la valeur du code postal\n");
				int codepost  = scanner.nextInt();
				System.out.println("Saisissez la valeur de la ville\n");
				String ville  = scannerStr.next().trim();
				System.out.println("Saisissez la valeur du pays\n");
				String pays  = scannerStr.next().trim();
				factory.getClientDAO().create(new ClientMetier(id, nom, prenom, no_rue, voie, codepost, ville, pays));
			break;
		case 2:
			
			System.out.println("Saisissez la valeur de l'ID à modifier\n");
			int newID = scanner.nextInt();
			System.out.println("Saisissez la valeur du nom\n");
			String Newnom  = scannerStr.next().trim();
			System.out.println("Saisissez la valeur du prenom\n");
			String Newprenom  = scannerStr.next().trim();
			System.out.println("Saisissez la valeur du numéro de rue\n");
			int Newno_rue  = scanner.nextInt();
			System.out.println("Saisissez la valeur de la voie\n");
			String Newvoie  = scannerStr.next().trim();
			System.out.println("Saisissez la valeur du code postal\n");
			int Newcodepost  = scanner.nextInt();
			System.out.println("Saisissez la valeur de la ville\n");
			String Newville  = scannerStr.next().trim();
			System.out.println("Saisissez la valeur du pays\n");
			String Newpays  = scannerStr.next().trim();
			factory.getClientDAO().update(new ClientMetier(newID, Newnom, Newprenom, Newno_rue, Newvoie, Newcodepost, Newville, Newpays));
			break;
		case 3:
			
			System.out.println("Saisissez la valeur de l'ID à supprimer\n");
			int IDsuppr = scanner.nextInt();
			factory.getClientDAO().delete(factory.getClientDAO().getById(IDsuppr));
			break;
			
		case 4 : 
			Iterator<ClientMetier> iterator = factory.getClientDAO().findAll().iterator();
			while(iterator.hasNext())
			{
				System.out.println(iterator.next());
			}
			break;
			
		default:
			
			break;
		}	
	}
}