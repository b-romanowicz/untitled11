package main.java.sample;

import java.util.Arrays;
import java.util.List;

import main.java.aquarium.Aquarium;
import main.java.aquarium.creators.AquariumCreator;
import main.java.objects.Organism;

public class Main  {
	
	private Aquarium aquarium;
	private int maxIterNum;
	
	public Main(AquariumCreator aquariumCreator, int maxIterNum) {
		aquarium = aquariumCreator.createAquarium();
		this.maxIterNum = maxIterNum;
	}
	
	private boolean specimenDominates() {
		int size = aquarium.getLength()*aquarium.getWidth()*aquarium.getHeight()/4;
		if(aquarium.getFishNumber()>size) {
			System.out.println("Fish zdominowal akwarium");
			return true;
		}
		if(aquarium.getRapaciousFishNumber()>size) {
			System.out.println("RapaciousFish zdominowal akwarium");
			return true;
		}
		if(aquarium.getSnailNumber()>size) {
			System.out.println("Snail zdominowal akwarium");
			return true;
		}
		if(aquarium.getPrawnNumber()>size) {
			System.out.println("Prawn zdominowal akwarium");
			return true;
			}
		return false;
	}
	
	public void run(int fishNum, int rapaciousFishNum, int snailNumber, int prawnNumber) {
		int iters = maxIterNum;
		aquarium.getOrganismCreator().createOrganisms(fishNum, rapaciousFishNum, snailNumber, prawnNumber);
		do {
			aquarium.getDataUtility().saveToTxt(maxIterNum-iters+1 + ":");
			System.out.println(maxIterNum - iters + 1);
			List<Organism> organisms = aquarium.getOrganisms();
			System.out.println("Ryby: " + aquarium.getFishNumber() + " Drapiezne: " + aquarium.getRapaciousFishNumber() + " Slimaki: " + aquarium.getSnailNumber() + " Krewetki: " + aquarium.getPrawnNumber());
			System.out.println("Karma: " + aquarium.getFodderNumber() + " Glony: " + aquarium.getAlgaNumber());
			for(Organism organism : organisms) { 
				//System.out.println(organism.getClass().getSimpleName() + ": x: " + organism.getX() + " y: " + organism.getY() + " z: " + organism.getZ());
				organism.move();
				organism.feelHunger();
			}
			aquarium.spoilFood();
			aquarium.getEventUtility().randomEvent();
			//if(aquarium.getFishNumber() + aquarium.getRapaciousFishNumber() + aquarium.getPrawnNumber() + aquarium.getSnailNumber() 
				//> aquarium.getLength() + aquarium.getWidth() + aquarium.getHeight()) break;
			List<String> strings = Arrays.asList("" + (maxIterNum-iters+1), "" + aquarium.getFishNumber(), "" + aquarium.getRapaciousFishNumber(), 
					"" + aquarium.getSnailNumber(), "" + aquarium.getPrawnNumber(), 
					"" + aquarium.getFodderNumber(), "" + aquarium.getAlgaNumber());
			aquarium.getDataUtility().saveToCsv(strings);
			if(specimenDominates()) break;
		} while(--iters>0);
	}
	
	private static int checkDimension(String arg) {
		try {
            int integer = Integer.parseInt(arg);
            if(integer<2) return 5;
            return integer;
		} catch (NumberFormatException e) {
            return 5;
		}
	}
	
	private static int checkPopulation(String arg, int size) {
		try {
            int integer = Integer.parseInt(arg);
            if(integer<0) return 0;
            if(integer>size) return size;
            return integer;
		} catch (NumberFormatException e) {
			return 2;
		}
	}
	
	private static int checkMaxIters(String arg) {
		try {
            int integer = Integer.parseInt(arg);
            if(integer<0) return 50;
            return integer;
		} catch (NumberFormatException e) {
			return 100;
		}
	}
	
    public static void main(String[] args) {
    	int length;
    	if(args.length<1) length = 5;
    	else length = checkDimension(args[0]);
    	int width;
    	if(args.length<2) width=5;
    	else width = checkDimension(args[1]);
	    int height;
	    if(args.length<3) height=5;
	    else height = checkDimension(args[2]);
	    int size = length*width*height/5;
	    int fishNumber;
	    if(args.length<4) fishNumber=2;
	    else fishNumber = checkPopulation(args[3], size);
	    int rapaciousFishNumber;
	    if(args.length<5) rapaciousFishNumber=2;
	    else rapaciousFishNumber = checkPopulation(args[4], size);
	    int snailNumber;
	    if(args.length<6) snailNumber=2;
	    else snailNumber = checkPopulation(args[5], size);
	    int prawnNumber;
	    if(args.length<7) prawnNumber=2;
	    else prawnNumber = checkPopulation(args[6], size);
	    int maxIters;
	    if(args.length<8) maxIters=100;
	    else maxIters = checkMaxIters(args[7]);
	    AquariumCreator aquariumCreator = new AquariumCreator(length, width, height);
	    Main simulation = new Main(aquariumCreator, maxIters);
	    simulation.run(fishNumber, rapaciousFishNumber, snailNumber, prawnNumber);
    }
}
