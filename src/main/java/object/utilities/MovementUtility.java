package main.java.object.utilities;

import java.util.Random;

import main.java.aquarium.Aquarium;
import main.java.objects.Fish;

public class MovementUtility {

	final private Aquarium aquarium;
	final private int maxX;
	final private int maxY;
	final private int maxZ;
	final private Random random;
	
	public MovementUtility(Aquarium aquarium) {
		random = new Random();
		this.aquarium = aquarium;
		maxX = this.aquarium.getLength();
		maxY = this.aquarium.getWidth();
		maxZ = this.aquarium.getHeight();
	}
	
	private int randomCoordinate(Fish fish, char c) {
		int speed = fish.getSpeed();
		int currentCoord = 0;
		int allowedUpperCoord = 0;
		int allowedLowerCoord = 0;
		if(c == 'x') {
			currentCoord = fish.getX();
			allowedUpperCoord = maxX - 1 - currentCoord;
			allowedLowerCoord = fish.getX();
		}
		if(c == 'y') {
			currentCoord = fish.getY();
			allowedUpperCoord = maxY - 1 - currentCoord;
			allowedLowerCoord = fish.getY();
		}
		if(c == 'z') {
			currentCoord = fish.getZ();
			allowedUpperCoord = maxZ - 1 - currentCoord;
			allowedLowerCoord = fish.getZ();
		}
		if(speed < allowedUpperCoord) allowedUpperCoord = speed;
		if(speed < allowedLowerCoord) allowedLowerCoord = speed;
		int newCoord = currentCoord + random.nextInt(allowedUpperCoord+allowedLowerCoord+1)-allowedLowerCoord;
		return newCoord;
	}
	
	public void moveFish(Fish fish) {
		int x, y, z;
		do { 
			x = randomCoordinate(fish, 'x');
			y = randomCoordinate(fish, 'y');
			z = randomCoordinate(fish, 'z');
		} while(x!=fish.getX() && y!=fish.getY() && z!=fish.getZ());
		fish.setX(x);
		fish.setY(y);
		fish.setZ(z);
	}	
}
