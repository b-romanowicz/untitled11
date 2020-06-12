package main.java.aquarium.creators;

import main.java.aquarium.Aquarium;

/**
 * Kreator akwarium tworzy obiekty akwarium o podanych wymiarach oraz obiekty narzêdzi obs³uguj¹cych dzia³anie symulacji akwarium. Tworzy równie¿
 * pliki csv oraz txt, do których zapisywane bêda dane symulacji.
 * @author jakkard
 * @version 1.0
 */
public class AquariumCreator {

	/**
	 * D³ugoœæ akwarium, jakie stworzy ten kreator.
	 */
	private int x;
	
	/**
	 * Szerokoœæ akwarium, jakie stworzy ten kreator.
	 */
	private int y;
	
	/**
	 * Wysokoœæ akwarium, jakie stworzy ten kreator.
	 */
	private int z;
	
	/**
	 * Tworzy instancjê klasy, mog¹c¹ stworzyæ akwarium o danych wymiarach.
	 * @param x d³ugoœæ tworzonych akwarium.
	 * @param y szerokoœæ tworzonych akwarium.
	 * @param z wysokoœæ tworzonych akwarium.
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

