package main.java.objects.creators;

import java.util.Random;

import main.java.aquarium.Aquarium;
import main.java.objects.Alga;
import main.java.objects.Fodder;

public class FoodCreator {
	
	private Random random;
	private Aquarium aquarium;
	private final int satisfaction;
	
	public FoodCreator(Aquarium aquarium, int satisfaction) {
		random = new Random();
		this.aquarium = aquarium;
		this.satisfaction = satisfaction;
	}

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
