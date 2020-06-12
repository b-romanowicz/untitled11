package main.java.objects;

import main.java.aquarium.Aquarium;

/**
 * Karma to obiekt, kt�rym �ywi� si� ryby. W akwarium pojawia si� w zdarzeniu losowym, kt�re imituje czynno�� dokarmiania.
 * Jak ka�dy pokarm psuje si� w ka�dej iteracji, i zostaje usuni�ty z akwarium, gdy popsuje si� ca�kowicie.
 * @author jakkard
 * @version 1.0
 */
public class Fodder extends Food {
	
	/**
	 * Statyczna zmienna, oznaczaj�ca czas istnienia ka�dego pokarmu tego typu.
	 */
	private static final int fodderLifetime=5;
	
	/**
	 * Tworzy instancj� klasy karmy.
	 * @param satisfaction ilo�� punkt�w zaspokojenia g�odu, kt�re przywraca jedz�cemu.
	 * @param aquarium akwarium, w kt�rym b�dzie znajdowa� si� obiekt.
	 * @param x wsp�rz�dna x pozycji obiektu w akwarium.
	 * @param y wsp�rz�dna y pozycji obiektu w akwarium.
	 * @param z wsp�rz�dna z pozycji obiektu w akwarium.
	 */
	public Fodder(int satisfaction, Aquarium aquarium, int x, int y, int z) {
		super.satisfaction=satisfaction;
		super.aquarium=aquarium;
		super.x=x;
		super.y=y;
		super.z=z;
		lifetime=fodderLifetime;
	}
}

