package dao.metier;

public class PeriodiciteMetier 
{
    private int ID;
    private String libelle;

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public PeriodiciteMetier(int id, String libelle)
    {
        this.setID(id);
        this.setLibelle(libelle);
    }
    
    @Override
    public String toString() {
        return "Periodicite [ID=" + ID + ", libelle=" + libelle + "]";
    }



}