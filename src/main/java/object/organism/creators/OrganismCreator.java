package object.organism.creators;

import object.Snail;
import object.organism.Fish;
import object.organism.Prawn;
import object.organism.RapaciousFish;

public class OrganismCreator {

	public OrganismCreator() 
	{
		
	}

	public Fish createFish()
	{

		return null;
	}
	
	public Prawn createPrawn()
	{

		return null;
	}
	
	public RapaciousFish createRapaciousFish()
	{

		return null;
	}

	public Snail createSnail()
	{

		return null;
	}

	public Object createOrganisms(int fishNum, int prawnNum, int rapaciousFishNum, int snailNum)
	{
		for(int i=0; i<fishNum; i++) this.createFish();
		for(int i=0; i<prawnNum; i++) this.createPrawn();
		for(int i=0; i<rapaciousFishNum; i++) this.createRapaciousFish();
		for(int i=0; i<snailNum; i++) this.createSnail();
		return null;
	}
}
