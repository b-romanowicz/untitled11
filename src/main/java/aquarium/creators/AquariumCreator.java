package main.java.aquarium.creators;

import main.java.aquarium.Aquarium;

public class AquariumCreator {

	private int x;
	private int y;
	private int z;
	
	public AquariumCreator(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Aquarium createAquarium() {
		Aquarium aquarium = new Aquarium(x, y, z);
		aquarium.getDataUtility().createFiles("data.csv", "events.txt"); 
		return aquarium;
	}
}

