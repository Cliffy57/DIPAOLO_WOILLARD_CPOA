package dao.listememoire;

import dao.ClientDAO;
import dao.metier.ClientMetier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListeMemoireClientDAO implements ClientDAO {

    private static ListeMemoireClientDAO instance;

    private final List<ClientMetier> donnees;

    private ListeMemoireClientDAO() {

        this.donnees = new ArrayList<ClientMetier>();

    }

    public static ListeMemoireClientDAO getInstance() {

        if (instance == null) {
            instance = new ListeMemoireClientDAO();
        }

        return instance;
    }

    @Override
    public boolean create(ClientMetier objet) {

        objet.setId(1);

        while (this.donnees.contains(objet)) {

            objet.setId(objet.getId() + 1);
        }
        boolean ok = this.donnees.add(objet);

        return ok;
    }

    @Override
    public boolean update(ClientMetier objet) {


        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {

            this.donnees.set(idx, objet);
        }

        return true;
    }

    @Override
    public boolean delete(ClientMetier objet) {

        ClientMetier supprime;

        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
        } else {
            supprime = this.donnees.remove(idx);
        }

        return objet.equals(supprime);
    }

    @Override
    public ClientMetier getById(int id) {

        int idx = this.donnees.indexOf(new ClientMetier(id, "test", null, 0, null, 0, null, null));
        if (idx == -1) {
            throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
        } else {
            return this.donnees.get(idx);
        }
    }

    @Override
    public ArrayList<ClientMetier> findAll() {
        return (ArrayList<ClientMetier>) this.donnees;
    }

    @Override
    public boolean ifExist(ClientMetier objet) {

        {

            boolean existe = false;
            Iterator<ClientMetier> iterator = this.donnees.iterator();
            while (iterator.hasNext() && !existe) {
                if (Objects.equals(objet.getNom(), iterator.next().getNom()) &&
                        Objects.equals(objet.getPrenom(), iterator.next().getPrenom()) &&
                        Objects.equals(objet.getCodePost(), iterator.next().getCodePost()) &&
                        Objects.equals(objet.getPays(), iterator.next().getPays()) &&
                        Objects.equals(objet.getVille(), iterator.next().getVille()) &&
                        Objects.equals(objet.getNoRue(), iterator.next().getNoRue()) &&
                        Objects.equals(objet.getVoie(), iterator.next().getVoie())) {
                    existe = true;
                }
            }
            return existe;
        }

    }

}
