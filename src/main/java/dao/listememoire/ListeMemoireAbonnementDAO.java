package dao.listememoire;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import dao.AbonnementDAO;
import dao.metier.AbonnementMetier;
import dao.metier.ClientMetier;

public class ListeMemoireAbonnementDAO implements AbonnementDAO {

	private static ListeMemoireAbonnementDAO instance;

	private List<AbonnementMetier> donnees;

	public static ListeMemoireAbonnementDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireAbonnementDAO();
		}

		return instance;
	}

	private ListeMemoireAbonnementDAO() {

		this.donnees = new ArrayList<AbonnementMetier>();

		//this.donnees.add(new AbonnementMetier(1, null, null, 0, 0));
		//this.donnees.add(new AbonnementMetier(2, null, null, 0, 0));
	}

	@Override
	public boolean create(AbonnementMetier objet) {

		objet.setId(1);
		// Ne fonctionne que si l'objet m�tier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId(objet.getId() + 1);
		}
		boolean ok = this.donnees.add(objet);

		return ok;
	}

	@Override
	public boolean update(AbonnementMetier objet) {

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
	public boolean delete(AbonnementMetier objet) {

		AbonnementMetier supprime;

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
	public AbonnementMetier getById(int id) {
		// Ne fonctionne que si l'objet m�tier est bien fait...
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
	public boolean ifExist(AbonnementMetier objet){
		{
				boolean existe = false;
				Iterator<AbonnementMetier> iterator = this.donnees.iterator();
				while (iterator.hasNext() && !existe) {
					if(		Objects.equals(objet.getDateDebut(), iterator.next().getDateDebut()) &&
							Objects.equals(objet.getDateFin(), iterator.next().getDateFin()) &&
							Objects.equals(objet.getIdClient(), iterator.next().getIdClient()) &&
							Objects.equals(objet.getIdRevue(), iterator.next().getIdRevue()) )
					{
						existe = true;
					}
				}
				return existe;
			}

	}

}
