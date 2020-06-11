package main.java.objects;

import main.java.aquarium.Aquarium;
import main.java.objects.Organism;

public class Prawn extends Organism {

    public Prawn(Aquarium aquarium) {
        super(aquarium);
    }

    @Override
    public void move() {
    	aquarium.getMovementUtility().movePrawn(this);
    }
    
    public boolean reproduce(Prawn prawn) {
    	Organism organism = (Organism) prawn;
    	if(hunger<=50 || organism.getHunger()<=50) return false;
    	int x = organism.getX();
		int y = organism.getY();
		//int z = organism.getZ();
		int speed = (this.speed + organism.getSpeed())/2;
		hunger-=50;
		int organismHunger=organism.getHunger()-50;
		organism.setHunger(organismHunger);
    	aquarium.getOrganismCreator().createPrawn(x, y, speed);
    	System.out.println(this.getClass().getSimpleName() + " rozmnozyl sie");
		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " rozmnozyl sie");
    	return true;
    }
}
