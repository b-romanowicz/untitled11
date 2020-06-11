package main.java.objects;

import main.java.aquarium.Aquarium;

public class Alga extends Food{

	private static final int algaLifetime=5;
	
	public Alga(int satisfaction, Aquarium aquarium, int x, int y, int z) {
		super(satisfaction, aquarium, x, y, z);
		lifetime = algaLifetime;
	}
}
