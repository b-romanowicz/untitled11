package main.java.objects;

import main.java.aquarium.Aquarium;

/**
 * Klasa abstrakcyjna organizmu, implementuje funkcjonalnoœæ wszystkich organizmów. Jest to odczuwanie g³odu, czyli zmniejszenie siê poziomu
 * zaspkojenia g³odu oraz zjedzenie pokarmu. Posiada abstrakcyjn¹ metodê odpowiedzialn¹ za poruszanie siê organizmów.
 * @author jakkard
 * @version 1.0
 */
public abstract class Organism implements IObject {
	
	/**
	 * Akwarium, w którym znajduje siê obiekt.
	 */
	protected Aquarium aquarium;
	
	/**
	 * Wspó³rzêdna x pozycji w przestrzeni akwarium na jakiej znajduje siê organizm.
	 */
	protected int x;
	
	/**
	 * Wspó³rzêdna y pozycji w przestrzeni w akwarium na jakiej znajduje siê organizm.
	 */
	protected int y;
	
	/**
	 * Wspó³rzêdna z pozycji w przestrzeni w akwarium na jakiej znajduje siê organizm.
	 */
	protected int z;
    
	/**
     * Prêdkoœæ poruszania siê organizmu po akwarium, tzn. o tyle mo¿e nast¹piæ zmiana wspó³rzêdnej sk³adowej (modu³ jednowymiarowego wektora). 
     */
	protected int speed;
    
	/**
	 * Iloœæ punktów zaspokojenia g³odu, który posiada organizm w przedziale <1,100>
	 */
	protected int hunger;
    
	/**
	 * Zwraca wspó³rzêdn¹ x pozycji organizmu znajduj¹cego siê w przestrzeni akwarium.
	 * @return wspó³rzêdna x w przestrzeni
	 */
    @Override
	public int getX() {
    	return x;
	}
    
    /**
     * Przypisuje wspó³rzêdna x pozycji organizmu.
     * @param x wspó³rzêdna x w przestrzeni akwarium.
     */
    public void setX(int x) {
    	this.x = x;
    }
    
    /**
	 * Zwraca wspó³rzêdn¹ y pozycji organizmu znajduj¹cego siê w przestrzeni akwarium.
	 * @return wspó³rzêdna y w przestrzeni
	 */
    @Override
	public int getY() {
    	return y;
	}
    
    /**
     * Przypisuje wspó³rzêdna y pozycji organizmu.
     * @param y wspó³rzêdna y w przestrzeni akwarium.
     */
    public void setY(int y) {
    	this.y = y;
    }
    
    /**
	 * Zwraca wspó³rzêdn¹ z pozycji organizmu znajduj¹cego siê w przestrzeni akwarium.
	 * @return wspó³rzêdna z w przestrzeni
	 */
    @Override
	public int getZ() {
    	return z;
	}
    
    /**
     * Przypisuje wspó³rzêdna z pozycji organizmu.
     * @param z wspó³rzêdna z w przestrzeni akwarium.
     */
    public void setZ(int z) {
    	this.z = z;
    }
    
    /**
     * Zwraca iloœæ punktów zaspokojenia g³odu organizmu.
     * @return iloœæ punktów zaspokojenia g³odu
     */
    public int getHunger() {
    	return hunger;
    }
    
    /**
     * Przypisuje organizmowi iloœæ punktów zaspokojenia g³odu.
     * @param hunger nowa iloœæ punktów zaspokojenia g³odu
     */
    public void setHunger(int hunger) {
    	this.hunger = hunger;
    }
    
    /**
     * Zwraca prêdkoœæ z jak¹ organizm mo¿e poruszaæ siê w przestrzeni akwarium.
     * @return prêdkoœæ organizmu.
     */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Przypisuje organizmowi prêdkoœæ z jak¹ mo¿e poruszaæ siê w przestrzeni akwarium.
	 * @param speed nowa prêdkoœæ organizmu.
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * Powoduje spadek iloœci punktów zaspokojenia g³odu organizmu, a jeœli spadnie on do 0 organizm umiera.
	 */
    public void feelHunger() {
    	hunger--;
    	if(hunger<=0) {
    		this.die(); 
    		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " zdechl z glodu");
    	}
    }
    
    /**
     * Usuwa byt organizmu z akwarium.
     */
    public void die() {
    	aquarium.remove(this);
    }
    
    /**
     * Powoduje zjedzenie pokarmu podanego w parametrze prez organizm, a przez to przywrócenie pewnej iloœci punktów zaspokojenia g³odu.
     * @param food pokarm do zjedzenia
     */
    public void eat(Food food) {
		food.feed(this);
		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " zjadl " + food.getClass().getSimpleName());
		}        
    
    /**
     * Przemieszczenie organizmu na inn¹ pozycjê w przestrzeni akwarium.
     */
    public abstract void move();
}
    
