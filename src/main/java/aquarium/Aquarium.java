package main.java.aquarium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.java.objects.IObject;
import main.java.objects.Organism;
import main.java.objects.creators.OrganismCreator;
import main.java.objects.utilities.MovementUtility;

public class Aquarium {

	private final int x;
	private final int y;
	private final int z;
	private OrganismCreator organismCreator;
	private MovementUtility movementUtility;
	
	private List<IObject> objects;
	
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

	public boolean add(IObject obj) {
		if(obj != null && !objects.contains(obj)) {
			objects.add(obj);
			return true;
		}
		return false;
	}
	
	public boolean remove(IObject obj) {
		if(obj != null && objects.contains(obj)) {
			objects.remove(obj);
			return true;
		}
		return false;
	}
	
	public List<Organism> getOrganisms() {
		List<Organism> organisms = new ArrayList<>();
		for(Object object : objects ) {
			if(object instanceof Organism) {
				Organism organism = (Organism) object;
				organisms.add(organism);
			}
		}
		return organisms;
	}
}