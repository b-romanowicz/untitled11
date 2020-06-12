package main.java.objects;

import main.java.aquarium.Aquarium;

/**
 * Abstrakcyjna klasa pokarmu. Implementuje funkcjonalnoœæ wspóln¹ dla wszystkich pokarmów. Jest to nakarmienie jakiegoœ obiektu oraz psucie siê.
 * @author jakkard
 * @version 1.0
 */
public abstract class Food implements IObject{
	
	/**
	 * Akwarium, w którym znajduje siê obiekt.
	 */
	protected Aquarium aquarium;
	
	/**
	 * Wspó³rzêdna x pozycji w przestrzeni akwarium na jakiej znajduje siê pokarm.
	 */
	protected int x;
	
	/**
	 * Wspó³rzêdna y pozycji w przestrzeni akwarium na jakiej znajduje siê pokarm.
	 */
	protected int y;
	
	/**
	 * Wspó³rzêdna z pozycji w przestrzeni akwarium na jakiej znajduje siê pokarm.
	 */
	protected int z;
    
	/**
	 * Okres ¿ycia po¿ywienia, wyra¿ony w liczbie iteracji.
	 */
	protected int lifetime;
	
	/**
	 * Iloœæ punktów g³odu, które przywraca to po¿ywienie.
	 */
	protected int satisfaction;
	
	/**
	 * Zwraca wspó³rzêdn¹ x pozycji pokarmu znajduj¹cego siê w przestrzeni akwarium.
	 * @return wspó³rzêdna x w przestrzeni.
	 */
	@Override
	public int getX() {
		return x;
	}
	
	/**
	 * Zwraca wspó³rzêdn¹ y pozycji pokarmu znajduj¹cego siê w przestrzeni akwarium.
	 * @return wspó³rzêdna y w przestrzeni.
	 */
	@Override
	public int getY() {
		return y;
	}
	
	/**
	 * Zwraca wspó³rzêdn¹ z pozycji pokarmu znajduj¹cego siê w przestrzeni akwarium.
	 * @return wspó³rzêdna z w przestrzeni.
	 */
	@Override
	public int getZ() {
		return z;
	}
	
	/**
	 * Przywraca punkty g³odu organizmowi, który zjad³ ten pokarm oraz usuwa ten pokarm z akwarium.
	 * @param organism organizm, który zjad³ ten pokarm.
	 */
	public void feed(Organism organism) {
		int hunger = organism.getHunger();
		hunger+=satisfaction;
		if(hunger>100) hunger=100;
		organism.setHunger(hunger);
		aquarium.remove(this);
	}
	
	/**
	 * Imituje psucie siê pokarmu, tzn. zmniejsza siê okres ¿ycia pokarmu. Jeœli spadnie do 0 nastêpuje usuniêcie pokarmu z akwarium.
	 */
	public void spoil() {
		lifetime--;
		if(lifetime<=0) aquarium.remove(this);
	}
}
