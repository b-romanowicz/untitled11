package main.java.objects.creators;

import java.util.Random;

import main.java.aquarium.Aquarium;
import main.java.objects.Alga;
import main.java.objects.Fodder;

/**
 * Obiekt s³u¿¹cy do tworzenia pokarmu w akwarium, który umieszcza na losowych pozycjach, jeœli nie ma tam ju¿ innego pokarmu. 
 * @author jakkard
 * @version 1.0
 */
public class FoodCreator {
	
	/**
	 * Obiekt klasy random, generator pseudolosowoœci.
	 */
	private Random random;
	
	/**
	 * Akwarium, do którego po¿ywienie bêdzie tworzyæ kreator.
	 */
	private Aquarium aquarium;
	
	/**
	 * Iloœæ punktów zaspokojenia g³odu jak¹ bêdzie posiadaæ pokarm stworzony przez ten kreator.
	 */
	private final int satisfaction;
	
	/**
	 * Tworzy instancjê klasy kreatora pokarmu.
	 * @param aquarium akwarium, w którym kreator bêdzie tworzy³ pokarm.
	 * @param satisfaction sta³a dla wszystich pokarmów tworzonych przez kreator iloœæ zaspokajanych punktów g³odu.
	 */
	public FoodCreator(Aquarium aquarium, int satisfaction) {
		random = new Random();
		this.aquarium = aquarium;
		this.satisfaction = satisfaction;
	}
	
	/**
	 * Tworzy dan¹ iloœæ karmy i umieszcza j¹ na losowych pozycjach w przestrzeni akwarium, jeœli nie ma tam ju¿ innego po¿ywienia.
	 * @param amount iloœæ tworzonych obiektów karmy.
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
	 * Tworzy dan¹ iloœæ glonów i umieszcza je na losowych pozycjach na œcianach lub pod³o¿u akwarium, jeœli nie znajduje siê tam ju¿ inny pokarm.
	 * @param amount Iloœæ tworzonych obiektów glonów.
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
