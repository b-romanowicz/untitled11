package main.java.objects;

import main.java.aquarium.Aquarium;

/**
 * Glon jest obiektem, który jedz¹ œlimaki oraz krewetki. Mo¿e byæ umiejscowiony jedynie na œcianach oraz na pod³o¿y akwarium, czyli tam gdzie
 * znajduj¹ siê odpowiednio œlimaki i krewetki. W akwarium pojawia siê w zdarzeniu losowym, w którym akwarium obroœnie glonem.
 * Jak ka¿dy pokarm psuje siê w ka¿dej iteracji, i zostaje usuniêty z akwarium, gdy popsuje siê ca³kowicie.
 * @author jakkard
 * @version 1.0
 */
public class Alga extends Food{
	
	/**
	 * Statyczna zmienna, oznaczaj¹ca czas istnienia ka¿dego pokarmu tego typu.
	 */
	private static final int algaLifetime=5;
	
	/**
	 * Tworzy instancjê klasy glonu.
	 * @param satisfaction iloœæ punktów zspokojenia g³odu, które przywraca jedz¹cemu.
	 * @param aquarium akwarium, w którym bêdzie znajdowaæ siê glon.
	 * @param x wspó³rzêdna x obiektu.
	 * @param y wspó³rzêdna y obiektu.
	 * @param z wspó³rzêdna z obiektu.
	 */
	public Alga(int satisfaction, Aquarium aquarium, int x, int y, int z) {
		super.satisfaction=satisfaction;
		super.aquarium=aquarium;
		super.x=x;
		super.y=y;
		super.z=z;
		lifetime = algaLifetime;
	}
}
