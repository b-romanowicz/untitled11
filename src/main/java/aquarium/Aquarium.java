package main.java.aquarium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.java.objects.Alga;
import main.java.objects.Fish;
import main.java.objects.Fodder;
import main.java.objects.Food;
import main.java.objects.IObject;
import main.java.objects.Organism;
import main.java.objects.Prawn;
import main.java.objects.RapaciousFish;
import main.java.objects.Snail;
import main.java.objects.creators.FoodCreator;
import main.java.objects.creators.OrganismCreator;
import main.java.objects.utilities.MovementUtility;
import main.java.utilities.DataUtility;
import main.java.utilities.EventUtility;

public class Aquarium {

	private final int x;
	private final int y;
	private final int z;
	private OrganismCreator organismCreator;
	private FoodCreator foodCreator;
	private MovementUtility movementUtility;
	private EventUtility eventUtility;
	private DataUtility dataUtility;
	private int fishNumber;
	private int rapaciousFishNumber;
	private int snailNumber;
	private int prawnNumber;
	private int fodderNumber;
	private int algaNumber;
	private List<IObject> objects;
	
	public Aquarium(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		organismCreator = new OrganismCreator(this);
		foodCreator = new FoodCreator(this, 20);
		movementUtility = new MovementUtility(this);
		eventUtility = new EventUtility(this);
		dataUtility = new DataUtility();
		objects = new LinkedList<>();
		fishNumber=0;
		rapaciousFishNumber=0;
		prawnNumber=0;
		snailNumber=0;
		fodderNumber=0;
		algaNumber=0;
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
	
	public FoodCreator getFoodCreator() {
		return foodCreator;
	}
	
	public MovementUtility getMovementUtility() {
		return movementUtility;
	}

	public EventUtility getEventUtility() {
		return eventUtility;
	}
	
	public DataUtility getDataUtility() {
		return dataUtility;
	}
	
	public boolean add(IObject obj) {
		if(obj != null && !objects.contains(obj)) {
			objects.add(obj);
			if(obj instanceof Fish && !(obj instanceof RapaciousFish)) fishNumber++;
			if(obj instanceof RapaciousFish) rapaciousFishNumber++;
			if(obj instanceof Snail) snailNumber++;
			if(obj instanceof Prawn) prawnNumber++;
			if(obj instanceof Fodder) fodderNumber++;
			if(obj instanceof Alga) algaNumber++;
			return true;
		} else return false;
	}
	
	public boolean remove(IObject obj) {
		if(obj != null && objects.contains(obj)) {
			objects.remove(obj);
			if(obj instanceof Fish && !(obj instanceof RapaciousFish)) fishNumber--;
			if(obj instanceof RapaciousFish) rapaciousFishNumber--;
			if(obj instanceof Snail) snailNumber--;
			if(obj instanceof Prawn) prawnNumber--;
			if(obj instanceof Fodder) fodderNumber--;
			if(obj instanceof Alga) algaNumber--;
			return true;
		} else return false;
	}
	
	public int getFishNumber() {
		return fishNumber;
	}
	
	public int getRapaciousFishNumber() {
		return rapaciousFishNumber;
	}
	
	public int getSnailNumber() {
		return snailNumber;
	}
	
	public int getPrawnNumber() {
		return prawnNumber;
	}
	
	public int getFodderNumber() {
		return fodderNumber;
	}
	
	public int getAlgaNumber() {
		return algaNumber;
	}
	
	public List<Organism> getOrganisms() {
		List<Organism> organisms = new ArrayList<>();
		for(IObject object : objects ) {
			if(object instanceof Organism) {
				Organism organism = (Organism) object;
				organisms.add(organism);
			}
		}
		return organisms;
	}

	public IObject getObjectAt(int x, int y, int z) {
		for(IObject object : objects)
			if(object.getX()==x && object.getY()==y && object.getZ()==z) return object;
		return null;
	}
	
	public boolean emptyPosAt(int x, int y, int z) {
		for(IObject object : objects)
			if(object.getX()==x && object.getY()==y && object.getZ()==z) return false;
		return true;
	}
	
	public boolean isFoodAt(int x, int y, int z) {
		for(IObject object : objects) 
			if(object.getX()==x && object.getY()==y && object.getZ()==z)
				if(object instanceof Food) return true;
		return false;
	}
	
	public void spoilFood() {
		List<Food> foodList = new ArrayList<Food>();
		for(IObject object : objects) {
			if(object instanceof Food) {
				Food food = (Food) object;
				foodList.add(food);
			}
		}
		for(Food food : foodList) {
			food.spoil();
		}
	}

	public boolean specimenDominates() {
		int size = x*y*z/4;
		if(fishNumber>size) {
			System.out.println("Fish zdominowal akwarium");
			return true;
		}
		if(rapaciousFishNumber>size) {
			System.out.println("RapaciousFish zdominowal akwarium");
			return true;
		}
		if(snailNumber>size) {
			System.out.println("Snail zdominowal akwarium");
			return true;
		}
		if(prawnNumber>size) {
			System.out.println("Prawn zdominowal akwarium");
			return true;
		}
		return false;
	}
}