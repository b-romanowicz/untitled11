package main.java.objects;

/**
 * Interfejs obiektu w akwarium.
 * @author jakkard
 * @version
 */
public interface IObject {
    
	/**
	 * Zwraca wsp�rz�dn� x pozycji obiektu znajduj�cego si� w przestrzeni akwarium.
	 * @return wsp�rz�dna x w przestrzeni
	 */
	public int getX();
	
	/**
	 * Zwraca wsp�rz�dn� y pozycji obiektu znajduj�cego si� w przestrzeni akwarium.
	 * @return wsp�rz�dna y w przestrzeni
	 */
	public int getY();
	
	/**
	 * Zwraca wsp�rz�dn� z pozycji obiektu znajduj�cego si� w przestrzeni akwarium.
	 * @return wsp�rz�dna z w przestrzeni
	 */
	public int getZ();
}
