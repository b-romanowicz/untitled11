package main.java.objects.creators;

import java.util.Random;

import main.java.aquarium.Aquarium;
import main.java.objects.Alga;
import main.java.objects.Fodder;

/**
 * Obiekt s�u��cy do tworzenia pokarmu w akwarium, kt�ry umieszcza na losowych pozycjach, je�li nie ma tam ju� innego pokarmu. 
 * @author jakkard
 * @version 1.0
 */
public class FoodCreator {
	
	/**
	 * Obiekt klasy random, generator pseudolosowo�ci.
	 */
	private Random random;
	
	/**
	 * Akwarium, do kt�rego po�ywienie b�dzie tworzy� kreator.
	 */
	private Aquarium aquarium;
	
	/**
	 * Ilo�� punkt�w zaspokojenia g�odu jak� b�dzie posiada� pokarm stworzony przez ten kreator.
	 */
	private final int satisfaction;
	
	/**
	 * Tworzy instancj� klasy kreatora pokarmu.
	 * @param aquarium akwarium, w kt�rym kreator b�dzie tworzy� pokarm.
	 * @param satisfaction sta�a dla wszystich pokarm�w tworzonych przez kreator ilo�� zaspokajanych punkt�w g�odu.
	 */
	public FoodCreator(Aquarium aquarium, int satisfaction) {
		random = new Random();
		this.aquarium = aquarium;
		this.satisfaction = satisfaction;
	}
	
	/**
	 * Tworzy dan� ilo�� karmy i umieszcza j� na losowych pozycjach w przestrzeni akwarium, je�li nie ma tam ju� innego po�ywienia.
	 * @param amount ilo�� tworzonych obiekt�w karmy.
	 */
	public void createFodder(int amount) {
		for(int i = 0; i<amount; i++) {
			int x = random.nextInt(aquarium.getLength());
			int y = random.nextInt(aquarium.getWidth());
			int z = random.nextInt(aquarium.getHeight());
			if(!aquarium.isFoodAt(x, y, z))	{
				Fodder fodder = new Fodder(satisfaction, aquarium, x, y, z);
				aquarium.add(fodder);
			}
		}
	}
	
	/**
	 * Tworzy dan� ilo�� glon�w i umieszcza je na losowych pozycjach na �cianach lub pod�o�u akwarium, je�li nie znajduje si� tam ju� inny pokarm.
	 * @param amount Ilo�� tworzonych obiekt�w glon�w.
	 */
	public void createAlga(int amount) {
		for(int i = 0; i<amount; i++) {
			int x, y, z;
			int randomPlane = random.nextInt(5);
			switch(randomPlane) {
			case 0:
				x = 0;
				y = random.nextInt(aquarium.getWidth());
				z = random.nextInt(aquarium.getHeight());
				 break;
			case 1:
				y = 0;
				x = random.nextInt(aquarium.getLength());
				z = random.nextInt(aquarium.getHeight());
				 break;
			case 2:
				x = aquarium.getLength()-1;
				y = random.nextInt(aquarium.getWidth()); 
				z = random.nextInt(aquarium.getHeight());
				break;
			case 3:	
				y = aquarium.getWidth()-1;
				x = 0; 
				z = random.nextInt(aquarium.getHeight());
				break;
			default: 
				z=0;
				x = random.nextInt(aquarium.getLength())+1;
				y = random.nextInt(aquarium.getLength())+1;
				break;
			}
			if(!aquarium.isFoodAt(x, y, z))	{
				Alga alga = new Alga(satisfaction, aquarium, x, y, z);
				aquarium.add(alga);
			}
		}
	}
}
