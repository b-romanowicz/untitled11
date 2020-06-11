package main.java.objects;

import main.java.aquarium.Aquarium;
import main.java.objects.Organism;

public class Snail extends Organism {

	public Snail(Aquarium aquarium) {
		super(aquarium);
	}

	public void reproduceItself() {
		aquarium.getOrganismCreator().createSnail(x, y, z, speed);
		hunger-=50;
		System.out.println(this.getClass().getSimpleName() + " sam sie rozmnozyl");
		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " sam sie rozmnozyl");
	}
	
	@Override
	public void move() {
		aquarium.getMovementUtility().moveSnail(this);
		if(hunger>=80) reproduceItself();
	}
	
	public boolean reproduce(Snail snail) {
    	Organism organism = (Organism) snail;
    	if(hunger<=50 || organism.getHunger()<=50) return false;
    	int x = organism.getX();
		int y = organism.getY();
		int z = organism.getZ();
		int speed = (this.speed + organism.getSpeed())/2;
		hunger-=50;
		int organismHunger=organism.getHunger()-50;
		organism.setHunger(organismHunger);
    	aquarium.getOrganismCreator().createSnail(x, y, z, speed);
    	System.out.println(this.getClass().getSimpleName() + " rozmnozyl sie");
		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " rozmnozyl sie");
    	return true;
    }
}
