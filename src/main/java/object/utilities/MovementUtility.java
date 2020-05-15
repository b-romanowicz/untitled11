package main.java.object.utilities;

import java.util.Random;

import main.java.object.Fish;
import main.java.object.Position;
import main.java.aquarium.Aquarium;

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
		Position pos = fish.getPosition();
		int speed = fish.getSpeed();
		int currentCoord = 0;
		int allowedUpperCoord = 0;
		int allowedLowerCoord = 0;
		if(c == 'x') {
			currentCoord = pos.getX();
			allowedUpperCoord = maxX - 1 - currentCoord;
			allowedLowerCoord = pos.getX();
		}
		if(c == 'y') {
			currentCoord = pos.getY();
			allowedUpperCoord = maxY - 1 - currentCoord;
			allowedLowerCoord = pos.getY();
		}
		if(c == 'z') {
			currentCoord = pos.getZ();
			allowedUpperCoord = maxZ - 1 - currentCoord;
			allowedLowerCoord = pos.getZ();
		}
		if(speed < allowedUpperCoord) allowedUpperCoord = speed;
		if(speed < allowedLowerCoord) allowedLowerCoord = speed;
		int newCoord = currentCoord + random.nextInt(allowedUpperCoord+allowedLowerCoord+1)-allowedLowerCoord;
		return newCoord;
	}
	
	public void moveFish(Fish fish) {
		Position pos = fish.getPosition();
		int x = randomCoordinate(fish, 'x');
		int y = randomCoordinate(fish, 'y');
		int z = randomCoordinate(fish, 'z');
		if( x!=pos.getX() && y!=pos.getY() && z!=pos.getZ()) {
			pos.setX(x);
			pos.setY(y);
			pos.setZ(z);
		}
	}
}
