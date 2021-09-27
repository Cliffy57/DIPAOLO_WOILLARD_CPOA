package dao.metier;

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



}