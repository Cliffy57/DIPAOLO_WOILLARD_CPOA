package dao.listememoire;

import dao.RevueDAO;
import dao.metier.RevueMetier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListeMemoireRevueDAO implements RevueDAO {

    private static ListeMemoireRevueDAO instance;

    private final List<RevueMetier> donnees;

    private ListeMemoireRevueDAO() {

        this.donnees = new ArrayList<RevueMetier>();

    }

    public static ListeMemoireRevueDAO getInstance() {

        if (instance == null) {
            instance = new ListeMemoireRevueDAO();
        }

        return instance;
    }

    @Override
    public boolean create(RevueMetier objet) {

        objet.setId(1);

        while (this.donnees.contains(objet)) {

            objet.setId(objet.getId() + 1);
        }
        boolean ok = this.donnees.add(objet);

        return ok;
    }

    @Override
    public boolean update(RevueMetier objet) {

        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {

            this.donnees.set(idx, objet);
        }

        return true;
    }

    @Override
    public boolean delete(RevueMetier objet) {

        RevueMetier supprime;

        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
        } else {
            supprime = this.donnees.remove(idx);
        }

        return objet.equals(supprime);
    }

    @Override
    public RevueMetier getById(int id) {

        int idx = this.donnees.indexOf(new RevueMetier(id, "test", null, 0, null, 0));
        if (idx == -1) {
            throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
        } else {
            return this.donnees.get(idx);
        }
    }

    @Override
    public ArrayList<RevueMetier> findAll() {
        return (ArrayList<RevueMetier>) this.donnees;
    }

    @Override
    public boolean ifExist(RevueMetier objet) {

        boolean existe = false;
        Iterator<RevueMetier> iterator = this.donnees.iterator();
        while (iterator.hasNext() && !existe) {
            if (Objects.equals(objet.getVisuel(), iterator.next().getVisuel()) &&
                    Objects.equals(objet.getDescription(), iterator.next().getDescription()) &&
                    Objects.equals(objet.getIdPeriodicite(), iterator.next().getIdPeriodicite()) &&
                    Objects.equals(objet.getTitre(), iterator.next().getTitre()) &&
                    Objects.equals(objet.getTarifNumero(), iterator.next().getTarifNumero())) {
                existe = true;
            }
        }
        return existe;
    }

}
