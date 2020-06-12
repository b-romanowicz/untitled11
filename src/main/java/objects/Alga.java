package main.java.objects;

import main.java.aquarium.Aquarium;

/**
 * Glon jest obiektem, kt�ry jedz� �limaki oraz krewetki. Mo�e by� umiejscowiony jedynie na �cianach oraz na pod�o�y akwarium, czyli tam gdzie
 * znajduj� si� odpowiednio �limaki i krewetki. W akwarium pojawia si� w zdarzeniu losowym, w kt�rym akwarium obro�nie glonem.
 * Jak ka�dy pokarm psuje si� w ka�dej iteracji, i zostaje usuni�ty z akwarium, gdy popsuje si� ca�kowicie.
 * @author jakkard
 * @version 1.0
 */
public class Alga extends Food{
	
	/**
	 * Statyczna zmienna, oznaczaj�ca czas istnienia ka�dego pokarmu tego typu.
	 */
	private static final int algaLifetime=5;
	
	/**
	 * Tworzy instancj� klasy glonu.
	 * @param satisfaction ilo�� punkt�w zspokojenia g�odu, kt�re przywraca jedz�cemu.
	 * @param aquarium akwarium, w kt�rym b�dzie znajdowa� si� glon.
	 * @param x wsp�rz�dna x obiektu.
	 * @param y wsp�rz�dna y obiektu.
	 * @param z wsp�rz�dna z obiektu.
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
