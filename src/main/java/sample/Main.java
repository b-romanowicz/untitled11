package sample;

import java.util.LinkedList;
import java.util.List;

import main.java.aquarium.Aquarium;
import main.java.aquarium.creators.AquariumCreator;
import main.java.object.Organism;

public class Main  {
	
	private Aquarium aquarium;
	private int maxIterNum;
	
	public Main(AquariumCreator aquariumCreator, int maxIterNum) {
		aquarium = aquariumCreator.createAquarium();
		this.maxIterNum = maxIterNum;
	}
	/*
	public void run(int fishNum) {
		int iters = maxIterNum;
		aquarium.getOrganismCreator().createOrganisms(fishNum, 0, 0, 0);
		do {
			System.out.println(maxIterNum - iters);
			List<Organism> organisms = aquarium.getOrganisms();
			for(Organism organism : organisms) { 
				System.out.println(organism.getClass().getCanonicalName().toString() + ": " + organism.getPosition().toString());
				organism.move();
			}
		} while(--iters>0);
	}
	*/
	private static int checkInt(String arg) {
		try {
            int integer = Integer.parseInt(arg);
            return integer;
		} catch (NumberFormatException e) {
            System.err.println("Error: " + arg );
            return 1;
		}
	}
	
    public static void main(String[] args) {
    	/*int length = checkInt(args[0]);
    	int width = checkInt(args[1]);
    	int height = checkInt(args[2]);
    	int fishNumber = checkInt(args[3]);
    	int maxIter = checkInt(args[4]);
    	AquariumCreator aquariumCreator = new AquariumCreator(length, width, height);
    	Main simulation = new Main(aquariumCreator, maxIter);
      //  simulation.run(fishNumber);*/
    	System.out.println("dziala");
    }


}
