package dao.listememoire;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import dao.RevueDAO;
import dao.metier.ClientMetier;
import dao.metier.RevueMetier;

public class ListeMemoireRevueDAO implements RevueDAO {

	private static ListeMemoireRevueDAO instance;

	private List<RevueMetier> donnees;

	public static ListeMemoireRevueDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireRevueDAO();
		}

		return instance;
	}

	private ListeMemoireRevueDAO() {

		this.donnees = new ArrayList<RevueMetier>();

		//this.donnees.add(new RevueMetier(2,"testo","sterone",2,"rick",2));
		//this.donnees.add(new RevueMetier(6, "Quotidien","de malchanceux", 4,"salsifie", 3));
	}

	@Override
	public boolean create(RevueMetier objet) {

		objet.setId(1);
		// Ne fonctionne que si l'objet m�tier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId(objet.getId() + 1);
		}
		boolean ok = this.donnees.add(objet);

		return ok;
	}

	@Override
	public boolean update(RevueMetier objet) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
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

		// Ne fonctionne que si l'objet m�tier est bien fait...
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
		// Ne fonctionne que si l'objet m�tier est bien fait...
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
				RevueMetier r = iterator.next();
				if(		Objects.equals(objet.getVisuel(), r.getVisuel()) &&
						Objects.equals(objet.getDescription(), r.getDescription()) &&
						Objects.equals(objet.getIdPeriodicite(), r.getIdPeriodicite()) &&
						Objects.equals(objet.getTitre(), r.getTitre()) &&
						Objects.equals(objet.getTarifNumero(), r.getTarifNumero()) )
				{
					existe = true;
				}
			}
			return existe;
		}

}
