package dao.metier;


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

	public ClientMetier(int id, String nom, String prenom, int noRue, String voie, int codePost, String ville,
			String pays) {
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
	public boolean equals(Object o) {
		
		ClientMetier m = (ClientMetier) o;
		if(o == null) {
			return false;
		}
		if(this.getClass()==m.getClass()) {
			if(m.getId() == this.getId()) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", no_rue=" + noRue + ", voie=" + voie
				+ ", codepost=" + codePost + ", ville=" + ville + ", pays=" + pays + "]";
	}


}