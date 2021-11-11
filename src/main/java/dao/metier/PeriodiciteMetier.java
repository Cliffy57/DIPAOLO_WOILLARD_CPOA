package dao.metier;


import javafx.beans.property.SimpleIntegerProperty;

public class PeriodiciteMetier {
    private int id;
    private String libelle;

    public PeriodiciteMetier(int id, String libelle) {
        this.setId(id);
        this.setLibelle(libelle);
    }

    public PeriodiciteMetier(String libelle) {
        this.setLibelle(libelle);
    }

    public PeriodiciteMetier() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SimpleIntegerProperty getIdTable() {
        return new SimpleIntegerProperty(this.id);
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {

        PeriodiciteMetier m = (PeriodiciteMetier) o;
        if (o == null) {
            return false;
        }
        if (this.getClass() == m.getClass()) {
            return m.getId() == this.getId();
        }

        return false;
    }

    @Override
    public String toString() {
        return "Periodicite [id=" + id + ", libelle=" + libelle + "]";
    }


}