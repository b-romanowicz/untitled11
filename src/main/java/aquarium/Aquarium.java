package main.java.aquarium;

import java.util.LinkedList;
import java.util.List;

import main.java.object.creators.OrganismCreator;
import main.java.object.utilities.MovementUtility;

public class Aquarium {

	private final int x;
	private final int y;
	private final int z;
	private OrganismCreator organismCreator;
	private MovementUtility movementUtility;
	
	private List<Object> objects;
	
	public Aquarium(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		organismCreator = new OrganismCreator(this);
		movementUtility = new MovementUtility(this);
		objects = new LinkedList<>();
	}
	
	public int getLength() {
		return x;
	}
	
	public int getWidth() {
		return y;
	}

	public int getHeight() {
		return z;
	}
	
	public OrganismCreator getOrganismCreator() {
		return organismCreator;
	}
	
	public MovementUtility getMovementUtility() {
		return movementUtility;
	}

	public boolean add(Object obj) {
		if(obj != null && !objects.contains(obj)) {
			objects.add(obj);
			return true;
		}
		return false;
	}
	
	public boolean remove(Object obj) {
		if(obj != null && objects.contains(obj)) {
			objects.remove(obj);
			return true;
		}
		return false;
	}
	
}