package main.java.objects;

import main.java.aquarium.Aquarium;

/**
 * Karma to obiekt, którym ¿ywi¹ siê ryby. W akwarium pojawia siê w zdarzeniu losowym, które imituje czynnoœæ dokarmiania.
 * Jak ka¿dy pokarm psuje siê w ka¿dej iteracji, i zostaje usuniêty z akwarium, gdy popsuje siê ca³kowicie.
 * @author jakkard
 * @version 1.0
 */
public class Fodder extends Food {
	
	/**
	 * Statyczna zmienna, oznaczaj¹ca czas istnienia ka¿dego pokarmu tego typu.
	 */
	private static final int fodderLifetime=5;
	
	/**
	 * Tworzy instancjê klasy karmy.
	 * @param satisfaction iloœæ punktów zaspokojenia g³odu, które przywraca jedz¹cemu.
	 * @param aquarium akwarium, w którym bêdzie znajdowaæ siê obiekt.
	 * @param x wspó³rzêdna x pozycji obiektu w akwarium.
	 * @param y wspó³rzêdna y pozycji obiektu w akwarium.
	 * @param z wspó³rzêdna z pozycji obiektu w akwarium.
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

