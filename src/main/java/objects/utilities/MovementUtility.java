package main.java.objects.utilities;

import java.util.Random;

import main.java.aquarium.Aquarium;
import main.java.objects.Snail;
import main.java.objects.Fish;
import main.java.objects.IObject;
import main.java.objects.Organism;
import main.java.objects.Prawn;

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
	
	private int randomCoordinate(Organism organism, char c) {
		int speed = organism.getSpeed();
		int currentCoord = 0;
		int allowedUpperCoord = 0;
		int allowedLowerCoord = 0;
		if(c == 'x') {
			currentCoord = organism.getX();
			allowedUpperCoord = maxX - 1 - currentCoord;
			allowedLowerCoord = organism.getX();
		}
		if(c == 'y') {
			currentCoord = organism.getY();
			allowedUpperCoord = maxY - 1 - currentCoord;
			allowedLowerCoord = organism.getY();
		}
		if(c == 'z') {
			currentCoord = organism.getZ();
			allowedUpperCoord = maxZ - 1 - currentCoord;
			allowedLowerCoord = organism.getZ();
		}
		if(speed < allowedUpperCoord) allowedUpperCoord = speed;
		if(speed < allowedLowerCoord) allowedLowerCoord = speed;
		int newCoord = currentCoord + random.nextInt(allowedUpperCoord+allowedLowerCoord+1)-allowedLowerCoord;
		return newCoord;
	}
	
	public void moveFish(Fish fish) {
		int newX, newY, newZ;
		do { 
			newX = randomCoordinate(fish, 'x');
			newY = randomCoordinate(fish, 'y');
			newZ = randomCoordinate(fish, 'z');
		} while(newX==fish.getX() && newY==fish.getY() && newZ==fish.getZ());
		IObject obj = aquarium.getObjectAt(newX, newY, newZ);
		if(!(aquarium.emptyPosAt(newX, newY, newZ) && obj == null)) InteractionUtility.interact(fish, obj);
		fish.setX(newX);
		fish.setY(newY);
		fish.setZ(newZ);
	}	
	
	public void moveSnail(Snail snail) {
		int currX=snail.getX(), currY=snail.getY(), currZ=snail.getZ();
		int newX, newY, newZ;
		if((currX==0 && currY==0) || (currX==0 && currY==maxY-1) || (currX==maxX-1 && currY==0) || (currX==maxX-1 && currY==maxY-1)) {
			do {
				newX = randomCoordinate(snail, 'x');
				newY = randomCoordinate(snail, 'y');
				newZ = randomCoordinate(snail, 'z');
			} while(newX==currX && newY==currY && newZ==currZ || ((newX==1 && newY==1) || 
					(newX==1 && newY==maxY-2) || (newX==maxX-2) && (newY==0) || (newX==maxX-2 && newY==maxY-2)));
			IObject obj = aquarium.getObjectAt(newX, newY, newZ);
			if(!(aquarium.emptyPosAt(newX, newY, newZ) && obj == null)) InteractionUtility.interact(snail, obj);
			snail.setX(newX);
			snail.setY(newY);
			snail.setZ(newZ);
		}
		else {
			if(currX==0 || currX==maxX-1) {
				do {	
					newY = randomCoordinate(snail, 'y');
					newZ = randomCoordinate(snail, 'z');
				} while(newY==currY && newZ==currZ);
				IObject obj = aquarium.getObjectAt(currX, newY, newZ);
				if(!(aquarium.emptyPosAt(currX, newY, newZ) && obj == null)) InteractionUtility.interact(snail, obj);
				snail.setX(currX);
				snail.setY(newY);
				snail.setZ(newZ);
			}
			if(currY==0 || currY==maxY-1) {	
				do {	
					newX = randomCoordinate(snail, 'x');
					newZ = randomCoordinate(snail, 'z');
				}
				while(newX==currX && newZ==currZ);
				IObject obj = aquarium.getObjectAt(newX, currY, newZ);
				if(!(aquarium.emptyPosAt(newX, currY, newZ) && obj == null)) InteractionUtility.interact(snail, obj);
				snail.setX(currX);
				snail.setY(currY);
				snail.setZ(newZ);
			}
		}
	}
	
	public void movePrawn(Prawn prawn) {
		int newX, newY;
		do { 
			newX = randomCoordinate(prawn, 'x');
			newY = randomCoordinate(prawn, 'y');
		} while(newX==prawn.getX() && newY==prawn.getY());
		IObject obj = aquarium.getObjectAt(newX, newY, 0);
		if(!(aquarium.emptyPosAt(newX, newY, 0) && obj == null)) InteractionUtility.interact(prawn, obj);
		prawn.setX(newX);
		prawn.setY(newY); 
	}
}	
