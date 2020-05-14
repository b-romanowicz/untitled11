package main.java.object.utilities;

import main.java.object.Fish;
import main.java.object.Organism;
import main.java.object.Position;

public class MovementUtility {

	int maxX;
	int maxY;
	int maxZ;
	
	public MovementUtility() {
		
	}
	
	public void moveFish(Fish fish) {
		Position pos = fish.getPosition();
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
	}
}
