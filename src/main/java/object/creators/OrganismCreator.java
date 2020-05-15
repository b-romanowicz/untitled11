package main.java.object.creators;

import java.util.Random;

import main.java.aquarium.Aquarium;
import main.java.object.Fish;
import main.java.object.Position;
import main.java.object.Prawn;
import main.java.object.RapaciousFish;
import main.java.object.Snail;

public class OrganismCreator {
	
	private Aquarium aquarium;
	private Random random;
	
	public OrganismCreator(Aquarium aquarium) {
		this.aquarium = aquarium;
		random = new Random();
	}

	public Fish createFish(int x, int y, int z, int speed) {
		Fish fish = new Fish(aquarium);
		Position position = new Position(x, y, z);
		aquarium.add(fish);
		fish.setPosition(position);
		fish.setSpeed(speed);
		return fish;
	}
	
	public Prawn createPrawn() {

		return null;
	}
	
	public RapaciousFish createRapaciousFish() {

		return null;
	}

	public Snail createSnail() {
		return null;
	
	}

	public void createOrganisms(int fishNum, int prawnNum, int rapaciousFishNum, int snailNum)
	{
		for(int i=0; i<fishNum; i++) {
			int x = random.nextInt(aquarium.getLength());
			int y = random.nextInt(aquarium.getWidth());
			int z = random.nextInt(aquarium.getHeight());
			int speed = random.nextInt(3)+1;
			this.createFish(x, y, z, speed);
		}
		//for(int i=0; i<prawnNum; i++) this.createPrawn();
		//for(int i=0; i<rapaciousFishNum; i++) this.createRapaciousFish();
		//for(int i=0; i<snailNum; i++) this.createSnail();
	}
}
