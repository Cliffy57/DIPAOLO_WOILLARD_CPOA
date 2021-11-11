package dao.listememoire;

import dao.AbonnementDAO;
import dao.metier.AbonnementMetier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListeMemoireAbonnementDAO implements AbonnementDAO {

    private static ListeMemoireAbonnementDAO instance;

    private final List<AbonnementMetier> donnees;

    private ListeMemoireAbonnementDAO() {

        this.donnees = new ArrayList<AbonnementMetier>();

    }

    public static ListeMemoireAbonnementDAO getInstance() {

        if (instance == null) {
            instance = new ListeMemoireAbonnementDAO();
        }

        return instance;
    }

    @Override
    public boolean create(AbonnementMetier objet) {

        objet.setId(1);

        while (this.donnees.contains(objet)) {

            objet.setId(objet.getId() + 1);
        }
        boolean ok = this.donnees.add(objet);

        return ok;
    }

    @Override
    public boolean update(AbonnementMetier objet) {

        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {

            this.donnees.set(idx, objet);
        }

        return true;
    }

    @Override
    public boolean delete(AbonnementMetier objet) {

        AbonnementMetier supprime;

        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
        } else {
            supprime = this.donnees.remove(idx);
        }

        return objet.equals(supprime);
    }

    @Override
    public AbonnementMetier getById(int id) {

        int idx = this.donnees.indexOf(new AbonnementMetier(id, null, null, 0, 0));
        if (idx == -1) {
            throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
        } else {
            return this.donnees.get(idx);
        }
    }

    @Override
    public ArrayList<AbonnementMetier> findAll() {
        return (ArrayList<AbonnementMetier>) this.donnees;
    }

    @Override
    public boolean ifExist(AbonnementMetier objet) {
        {
            boolean existe = false;
            Iterator<AbonnementMetier> iterator = this.donnees.iterator();
            while (iterator.hasNext() && !existe) {
                if (Objects.equals(objet.getDateDebut(), iterator.next().getDateDebut()) &&
                        Objects.equals(objet.getDateFin(), iterator.next().getDateFin()) &&
                        Objects.equals(objet.getIdClient(), iterator.next().getIdClient()) &&
                        Objects.equals(objet.getIdRevue(), iterator.next().getIdRevue())) {
                    existe = true;
                }
            }
            return existe;
        }

    }

}
