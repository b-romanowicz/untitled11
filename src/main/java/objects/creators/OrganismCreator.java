package main.java.objects.creators;

import java.util.Random;

import main.java.aquarium.Aquarium;
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
		fish.setHunger(50);
		return fish;
	}
	
	public Prawn createPrawn(int x, int y, int speed) {
		Prawn prawn = new Prawn(aquarium);
		aquarium.add(prawn);
		prawn.setX(x);
		prawn.setY(y);
		prawn.setZ(0);
		prawn.setSpeed(speed);
		prawn.setHunger(50);
		return prawn;
	}
	
	public RapaciousFish createRapaciousFish(int x, int y, int z, int speed) {
		RapaciousFish rapaciousFish = new RapaciousFish(aquarium);
		aquarium.add(rapaciousFish);
		rapaciousFish.setX(x);
		rapaciousFish.setY(y);
		rapaciousFish.setZ(z);
		rapaciousFish.setSpeed(speed);
		rapaciousFish.setHunger(50);
		return rapaciousFish;
	}

	public Snail createSnail(int x, int y, int z, int speed) {
		Snail snail = new Snail(aquarium);
		aquarium.add(snail);
		snail.setX(x);
		snail.setY(y);
		snail.setZ(z);
		snail.setSpeed(speed);
		snail.setHunger(50);
		return snail;
	
	}

	public void createOrganisms(int fishNum, int rapaciousFishNum, int snailNum, int prawnNum)
	{
		for(int i=0; i<fishNum; i++) {
			int x = random.nextInt(aquarium.getLength());
			int y = random.nextInt(aquarium.getWidth());
			int z = random.nextInt(aquarium.getHeight());
			int speed = random.nextInt(3)+1;
			this.createFish(x, y, z, speed);
		}
		for(int i=0; i<rapaciousFishNum; i++) {
			int x = random.nextInt(aquarium.getLength());
			int y = random.nextInt(aquarium.getWidth());
			int z = random.nextInt(aquarium.getHeight());
			int speed = random.nextInt(3)+1;
			this.createRapaciousFish(x, y, z, speed);
		}
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
			this.createSnail(x, y, z, 1);
		}
		for(int i=0; i<prawnNum; i++) {
			int x = random.nextInt(aquarium.getLength());
			int y = random.nextInt(aquarium.getWidth());
			this.createPrawn(x, y, 1);
		}
		
	}
}
