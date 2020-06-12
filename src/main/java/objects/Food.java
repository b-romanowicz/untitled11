package main.java.objects;

import main.java.aquarium.Aquarium;

/**
 * Abstrakcyjna klasa pokarmu. Implementuje funkcjonalno�� wsp�ln� dla wszystkich pokarm�w. Jest to nakarmienie jakiego� obiektu oraz psucie si�.
 * @author jakkard
 * @version 1.0
 */
public abstract class Food implements IObject{
	
	/**
	 * Akwarium, w kt�rym znajduje si� obiekt.
	 */
	protected Aquarium aquarium;
	
	/**
	 * Wsp�rz�dna x pozycji w przestrzeni akwarium na jakiej znajduje si� pokarm.
	 */
	protected int x;
	
	/**
	 * Wsp�rz�dna y pozycji w przestrzeni akwarium na jakiej znajduje si� pokarm.
	 */
	protected int y;
	
	/**
	 * Wsp�rz�dna z pozycji w przestrzeni akwarium na jakiej znajduje si� pokarm.
	 */
	protected int z;
    
	/**
	 * Okres �ycia po�ywienia, wyra�ony w liczbie iteracji.
	 */
	protected int lifetime;
	
	/**
	 * Ilo�� punkt�w g�odu, kt�re przywraca to po�ywienie.
	 */
	protected int satisfaction;
	
	/**
	 * Zwraca wsp�rz�dn� x pozycji pokarmu znajduj�cego si� w przestrzeni akwarium.
	 * @return wsp�rz�dna x w przestrzeni.
	 */
	@Override
	public int getX() {
		return x;
	}
	
	/**
	 * Zwraca wsp�rz�dn� y pozycji pokarmu znajduj�cego si� w przestrzeni akwarium.
	 * @return wsp�rz�dna y w przestrzeni.
	 */
	@Override
	public int getY() {
		return y;
	}
	
	/**
	 * Zwraca wsp�rz�dn� z pozycji pokarmu znajduj�cego si� w przestrzeni akwarium.
	 * @return wsp�rz�dna z w przestrzeni.
	 */
	@Override
	public int getZ() {
		return z;
	}
	
	/**
	 * Przywraca punkty g�odu organizmowi, kt�ry zjad� ten pokarm oraz usuwa ten pokarm z akwarium.
	 * @param organism organizm, kt�ry zjad� ten pokarm.
	 */
	public void feed(Organism organism) {
		int hunger = organism.getHunger();
		hunger+=satisfaction;
		if(hunger>100) hunger=100;
		organism.setHunger(hunger);
		aquarium.remove(this);
	}
	
	/**
	 * Imituje psucie si� pokarmu, tzn. zmniejsza si� okres �ycia pokarmu. Je�li spadnie do 0 nast�puje usuni�cie pokarmu z akwarium.
	 */
	public void spoil() {
		lifetime--;
		if(lifetime<=0) aquarium.remove(this);
	}
}
