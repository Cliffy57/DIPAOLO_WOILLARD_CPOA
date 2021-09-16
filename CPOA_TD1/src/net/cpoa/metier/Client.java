package net.cpoa.metier;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private int no_rue;
	private String voie;
	private int codepost;
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
	public int getNo_rue() {
		return no_rue;
	}
	public void setNo_rue(int no_rue) {
		this.no_rue = no_rue;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public int getCodepost() {
		return codepost;
	}
	public void setCodepost(int codepost) {
		this.codepost = codepost;
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
	public Client(int id, String nom, String prenom, int no_rue, String voie, int codepost, String ville, String pays) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.no_rue = no_rue;
		this.voie = voie;
		this.codepost = codepost;
		this.ville = ville;
		this.pays = pays;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", no_rue=" + no_rue + ", voie=" + voie
				+ ", codepost=" + codepost + ", ville=" + ville + ", pays=" + pays + "]";
	}