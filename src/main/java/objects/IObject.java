package main.java.objects;

/**
 * Interfejs obiektu w akwarium.
 * @author jakkard
 * @version
 */
public interface IObject {
    
	/**
	 * Zwraca wspó³rzêdn¹ x pozycji obiektu znajduj¹cego siê w przestrzeni akwarium.
	 * @return wspó³rzêdna x w przestrzeni
	 */
	public int getX();
	
	/**
	 * Zwraca wspó³rzêdn¹ y pozycji obiektu znajduj¹cego siê w przestrzeni akwarium.
	 * @return wspó³rzêdna y w przestrzeni
	 */
	public int getY();
	
	/**
	 * Zwraca wspó³rzêdn¹ z pozycji obiektu znajduj¹cego siê w przestrzeni akwarium.
	 * @return wspó³rzêdna z w przestrzeni
	 */
	public int getZ();
}
