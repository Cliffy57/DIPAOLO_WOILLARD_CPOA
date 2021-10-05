package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import dao.PeriodiciteDAO;
import dao.metier.PeriodiciteMetier;

public class ListeMemoirePeriodiciteDAO implements PeriodiciteDAO {

	private static ListeMemoirePeriodiciteDAO instance;

	private List<PeriodiciteMetier> donnees;

	public static ListeMemoirePeriodiciteDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoirePeriodiciteDAO();
		}

		return instance;
	}

	private ListeMemoirePeriodiciteDAO() {

		this.donnees = new ArrayList<PeriodiciteMetier>();

		this.donnees.add(new PeriodiciteMetier(1, "Mensuel"));
		this.donnees.add(new PeriodiciteMetier(2, "Quotidien"));
	}

	@Override
	public boolean create(PeriodiciteMetier objet) {

		objet.setId(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {
			objet.setId(objet.getId() + 1);
		}
		boolean ok = this.donnees.add(objet);

		return ok;
	}

	@Override
	public boolean update(PeriodiciteMetier objet) {

		// Ne fonctionne que si l'objet métier est bien fait...
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

		// Ne fonctionne que si l'objet métier est bien fait...
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
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new PeriodiciteMetier(id, "Mensuel"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<PeriodiciteMetier> findAll() {
		return (ArrayList<PeriodiciteMetier>) this.donnees;
	}

}
