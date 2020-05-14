package main.java.object.organism.creators;

import main.java.object.Fish;
import main.java.object.Prawn;
import main.java.object.RapaciousFish;
import main.java.object.Snail;

public class OrganismCreator {

	public OrganismCreator() {
		
	}

	public Fish createFish() {

		return null;
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
		for(int i=0; i<fishNum; i++) this.createFish();
		for(int i=0; i<prawnNum; i++) this.createPrawn();
		for(int i=0; i<rapaciousFishNum; i++) this.createRapaciousFish();
		for(int i=0; i<snailNum; i++) this.createSnail();
	}
}
