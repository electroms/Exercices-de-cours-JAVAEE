package fr.humanbooster.fx.honey.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.humanbooster.fx.honey.business.Cadeau;

public class CollectionDeCadeaux implements Iterator<Cadeau>, Iterable<Cadeau> {
	private List<Cadeau> cadeaux = new ArrayList<>();
	private int position = 0;

	@Override
	public boolean hasNext() {
		return position < cadeaux.size();
	}

	@Override
	public Cadeau next() {
		if (cadeaux.isEmpty()) {
			return null;
		}
		return cadeaux.get(position++);
	}

	public void ajouter(Cadeau cadeau) {
		cadeaux.add(cadeau);
	}

	@Override
	public Iterator<Cadeau> iterator() {
		return cadeaux.iterator();
	}

	
	/**
	 * @return the cadeaux
	 */
	public List<Cadeau> getCadeaux() {
		return cadeaux;
	}

	/**
	 * @param cadeaux the cadeaux to set
	 */
	public void setCadeaux(List<Cadeau> cadeaux) {
		this.cadeaux = cadeaux;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "CollectionDeCadeaux [cadeaux=" + cadeaux + "]";
	}

}
