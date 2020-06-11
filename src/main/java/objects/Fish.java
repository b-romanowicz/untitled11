package main.java.objects;

import java.util.Random;

import main.java.aquarium.Aquarium;

public class Fish extends main.java.objects.Organism {
    
		public Fish(Aquarium aquarium) {
    		super(aquarium);
    	}

		@Override
		public void move() {
			aquarium.getMovementUtility().moveFish(this);
		}
			
		public boolean reproduce(Fish fish) {
			Organism organism = (Organism) fish;
			if(hunger<=50 || organism.getHunger()<=50) return false;
	    	int x = organism.getX();
			int y = organism.getY();
			int z = organism.getZ();
			int speed = (this.speed + organism.getSpeed())/2;
			hunger-=50;
			int organismHunger=organism.getHunger()-50;
			organism.setHunger(organismHunger);
			if(this instanceof RapaciousFish && fish instanceof RapaciousFish) {
				aquarium.getOrganismCreator().createRapaciousFish(x, y, z, speed);
				System.out.println("RapaciousFish sie rozmnozyly");
				aquarium.getDataUtility().saveToTxt("RapaciousFish rozmnozyly sie");
				return true;
			}
			if((!(this instanceof RapaciousFish) && fish instanceof RapaciousFish) || 
					(this instanceof RapaciousFish && !(fish instanceof RapaciousFish)) ) {
				Random random = new Random();
				int r = random.nextInt(2);
				if(r==0) {
					aquarium.getOrganismCreator().createFish(x, y, z, speed);
					System.out.println("RapaciousFish i Fish sie rozmnozyly na Fish");
					aquarium.getDataUtility().saveToTxt("RapaciousFish i Fish rozmozyly sie na Fish");
					return true;
				}
				else if(r==1) {
					aquarium.getOrganismCreator().createRapaciousFish(x, y, z, speed);
					System.out.println("RapaciousFish i Fish sie rozmnozyly na RapaciousFish");
					aquarium.getDataUtility().saveToTxt("RapaciousFish i Fish rozmozyly sie na RapaciousFish");
					return true;
				}
			}
			aquarium.getOrganismCreator().createFish(x, y, z, speed);
			System.out.println("Fish sie rozmnozyly");
			return true;
			}
		}

