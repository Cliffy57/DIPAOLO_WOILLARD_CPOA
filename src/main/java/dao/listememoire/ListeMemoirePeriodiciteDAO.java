package dao.listememoire;

import dao.PeriodiciteDAO;
import dao.metier.PeriodiciteMetier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListeMemoirePeriodiciteDAO implements PeriodiciteDAO {

    private static ListeMemoirePeriodiciteDAO instance;

    private final List<PeriodiciteMetier> donnees;

    private ListeMemoirePeriodiciteDAO() {

        this.donnees = new ArrayList<PeriodiciteMetier>();

        this.donnees.add(new PeriodiciteMetier(1, "Mensuel"));
        this.donnees.add(new PeriodiciteMetier(2, "Quotidien"));
    }

    public static ListeMemoirePeriodiciteDAO getInstance() {

        if (instance == null) {
            instance = new ListeMemoirePeriodiciteDAO();
        }

        return instance;
    }

    @Override
    public boolean create(PeriodiciteMetier objet) {

        objet.setId(1);

        while (this.donnees.contains(objet)) {
            objet.setId(objet.getId() + 1);
        }
        boolean ok = this.donnees.add(objet);

        return ok;
    }

    @Override
    public boolean update(PeriodiciteMetier objet) {


        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {

            this.donnees.set(idx, objet);
        }

        return true;
    }

    @Override
    public boolean delete(PeriodiciteMetier objet) {

        PeriodiciteMetier supprime;

        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
        } else {
            supprime = this.donnees.remove(idx);
        }

        return objet.equals(supprime);
    }

    @Override
    public PeriodiciteMetier getById(int id) {

        int idx = this.donnees.indexOf(new PeriodiciteMetier(id, "Mensuel"));
        if (idx == -1) {
            throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
        } else {
            return this.donnees.get(idx);
        }
    }

    @Override
    public ArrayList<PeriodiciteMetier> findAll() {
        return (ArrayList<PeriodiciteMetier>) this.donnees;
    }

    @Override
    public boolean ifExist(PeriodiciteMetier objet) {

        boolean existe = false;
        Iterator<PeriodiciteMetier> iterator = this.donnees.iterator();
        while (iterator.hasNext() && !existe) {
            if (Objects.equals(objet.getLibelle(), iterator.next().getLibelle())) {
                existe = true;
            }
        }
        return existe;
    }

}
