package main.java.object.creators;

import java.util.Random;

import main.java.aquarium.Aquarium;
import main.java.object.Position;
import main.java.objects.Fish;
import main.java.objects.Prawn;
import main.java.objects.RapaciousFish;
import main.java.objects.Snail;

public class OrganismCreator {
	
	private Aquarium aquarium;
	private Random random;
	
	public OrganismCreator(Aquarium aquarium) {
		this.aquarium = aquarium;
		random = new Random();
	}

	public Fish createFish(int x, int y, int z, int speed) {
		Fish fish = new Fish(aquarium);
		aquarium.add(fish);
		fish.setX(x);
		fish.setY(y);
		fish.setZ(z);
		fish.setSpeed(speed);
		return fish;
	}
	
	public Prawn createPrawn() {

		return null;
	}
	
	public RapaciousFish createRapaciousFish() {

		return null;
	}

	public Snail createSnail(int x, int y, int z) {
		Snail snail = new Snail(aquarium);
		aquarium.add(snail);
		snail.setX(x);
		snail.setY(y);
		snail.setZ(z);
		return snail;
	
	}

	public void createOrganisms(int fishNum, int rapaciousFish, int snailNum, int prawnNum)
	{
		for(int i=0; i<fishNum; i++) {
			int x = random.nextInt(aquarium.getLength());
			int y = random.nextInt(aquarium.getWidth());
			int z = random.nextInt(aquarium.getHeight());
			int speed = random.nextInt(3)+1;
			this.createFish(x, y, z, speed);
		}
		//for(int i=0; i<rapaciousFishNum; i++) this.createRapaciousFish();
		for(int i=0; i<snailNum; i++) {
			int x, y, z;
			int randomPlane = random.nextInt(4);
			if(randomPlane == 0) {
				x = 0;
				y = random.nextInt(aquarium.getWidth());
			}
			else if(randomPlane == 1) {
				y = 0;
				x = random.nextInt(aquarium.getLength());
			}
			else if(randomPlane == 2) {
				x = aquarium.getLength()-1;
				y = random.nextInt(aquarium.getWidth());
			}
			else {
				y = aquarium.getWidth()-1;
				x = 0;
			}
			z = random.nextInt(aquarium.getHeight());
			this.createSnail(x, y, z);
		}
		//for(int i=0; i<prawnNum; i++) this.createPrawn();
	}
}
