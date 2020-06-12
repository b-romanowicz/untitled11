package main.java.aquarium.creators;

import main.java.aquarium.Aquarium;

/**
 * Kreator akwarium tworzy obiekty akwarium o podanych wymiarach oraz obiekty narz�dzi obs�uguj�cych dzia�anie symulacji akwarium. Tworzy r�wnie�
 * pliki csv oraz txt, do kt�rych zapisywane b�da dane symulacji.
 * @author jakkard
 * @version 1.0
 */
public class AquariumCreator {

	/**
	 * D�ugo�� akwarium, jakie stworzy ten kreator.
	 */
	private int x;
	
	/**
	 * Szeroko�� akwarium, jakie stworzy ten kreator.
	 */
	private int y;
	
	/**
	 * Wysoko�� akwarium, jakie stworzy ten kreator.
	 */
	private int z;
	
	/**
	 * Tworzy instancj� klasy, mog�c� stworzy� akwarium o danych wymiarach.
	 * @param x d�ugo�� tworzonych akwarium.
	 * @param y szeroko�� tworzonych akwarium.
	 * @param z wysoko�� tworzonych akwarium.
	 */
	public AquariumCreator(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Tworzy akwarium.
	 * @return stworzone akwarium.
	 */
	public Aquarium createAquarium() {
		Aquarium aquarium = new Aquarium(x, y, z);
		aquarium.getDataUtility().createFiles("data.csv", "events.txt"); 
		return aquarium;
	}
}

