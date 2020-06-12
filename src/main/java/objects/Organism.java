package main.java.objects;

import main.java.aquarium.Aquarium;

/**
 * Klasa abstrakcyjna organizmu, implementuje funkcjonalno�� wszystkich organizm�w. Jest to odczuwanie g�odu, czyli zmniejszenie si� poziomu
 * zaspkojenia g�odu oraz zjedzenie pokarmu. Posiada abstrakcyjn� metod� odpowiedzialn� za poruszanie si� organizm�w.
 * @author jakkard
 * @version 1.0
 */
public abstract class Organism implements IObject {
	
	/**
	 * Akwarium, w kt�rym znajduje si� obiekt.
	 */
	protected Aquarium aquarium;
	
	/**
	 * Wsp�rz�dna x pozycji w przestrzeni akwarium na jakiej znajduje si� organizm.
	 */
	protected int x;
	
	/**
	 * Wsp�rz�dna y pozycji w przestrzeni w akwarium na jakiej znajduje si� organizm.
	 */
	protected int y;
	
	/**
	 * Wsp�rz�dna z pozycji w przestrzeni w akwarium na jakiej znajduje si� organizm.
	 */
	protected int z;
    
	/**
     * Pr�dko�� poruszania si� organizmu po akwarium, tzn. o tyle mo�e nast�pi� zmiana wsp�rz�dnej sk�adowej (modu� jednowymiarowego wektora). 
     */
	protected int speed;
    
	/**
	 * Ilo�� punkt�w zaspokojenia g�odu, kt�ry posiada organizm w przedziale <1,100>
	 */
	protected int hunger;
    
	/**
	 * Zwraca wsp�rz�dn� x pozycji organizmu znajduj�cego si� w przestrzeni akwarium.
	 * @return wsp�rz�dna x w przestrzeni
	 */
    @Override
	public int getX() {
    	return x;
	}
    
    /**
     * Przypisuje wsp�rz�dna x pozycji organizmu.
     * @param x wsp�rz�dna x w przestrzeni akwarium.
     */
    public void setX(int x) {
    	this.x = x;
    }
    
    /**
	 * Zwraca wsp�rz�dn� y pozycji organizmu znajduj�cego si� w przestrzeni akwarium.
	 * @return wsp�rz�dna y w przestrzeni
	 */
    @Override
	public int getY() {
    	return y;
	}
    
    /**
     * Przypisuje wsp�rz�dna y pozycji organizmu.
     * @param y wsp�rz�dna y w przestrzeni akwarium.
     */
    public void setY(int y) {
    	this.y = y;
    }
    
    /**
	 * Zwraca wsp�rz�dn� z pozycji organizmu znajduj�cego si� w przestrzeni akwarium.
	 * @return wsp�rz�dna z w przestrzeni
	 */
    @Override
	public int getZ() {
    	return z;
	}
    
    /**
     * Przypisuje wsp�rz�dna z pozycji organizmu.
     * @param z wsp�rz�dna z w przestrzeni akwarium.
     */
    public void setZ(int z) {
    	this.z = z;
    }
    
    /**
     * Zwraca ilo�� punkt�w zaspokojenia g�odu organizmu.
     * @return ilo�� punkt�w zaspokojenia g�odu
     */
    public int getHunger() {
    	return hunger;
    }
    
    /**
     * Przypisuje organizmowi ilo�� punkt�w zaspokojenia g�odu.
     * @param hunger nowa ilo�� punkt�w zaspokojenia g�odu
     */
    public void setHunger(int hunger) {
    	this.hunger = hunger;
    }
    
    /**
     * Zwraca pr�dko�� z jak� organizm mo�e porusza� si� w przestrzeni akwarium.
     * @return pr�dko�� organizmu.
     */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Przypisuje organizmowi pr�dko�� z jak� mo�e porusza� si� w przestrzeni akwarium.
	 * @param speed nowa pr�dko�� organizmu.
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * Powoduje spadek ilo�ci punkt�w zaspokojenia g�odu organizmu, a je�li spadnie on do 0 organizm umiera.
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
     * Powoduje zjedzenie pokarmu podanego w parametrze prez organizm, a przez to przywr�cenie pewnej ilo�ci punkt�w zaspokojenia g�odu.
     * @param food pokarm do zjedzenia
     */
    public void eat(Food food) {
		food.feed(this);
		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " zjadl " + food.getClass().getSimpleName());
		}        
    
    /**
     * Przemieszczenie organizmu na inn� pozycj� w przestrzeni akwarium.
     */
    public abstract void move();
}
    
