package main.java.objects;

import main.java.aquarium.Aquarium;

public class Fodder extends Food {
	
	private static final int fodderLifetime=5;
	
	public Fodder(int satisfaction, Aquarium aquarium, int x, int y, int z) {
		super(satisfaction, aquarium, x, y, z);
		lifetime=fodderLifetime;
	}
}

