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

/**
 * Akwarium to prostopad³oœcian o okreœlonych wymiarach. Obiekty w nim siê znajduj¹ce mog¹ znajdowaæ siê na pozycjach o wspó³rzêdnych x od 0 do x-1,
 * y od 0 do y-1, z od 0 do z-1. W akwarium zagregowane s¹ obiekty zajmuj¹ce siê obs³ug¹ dzia³ania symulacji akwarium.
 * @author jakkard
 * @version 1.0
 */
public class Aquarium {

	/**
	 * D³ugoœæ akwarium (prostopad³oœcianu). Jest to wspó³rzêdna w przedziale <0, x-1>.
	 */
	private final int x;
	
	/**
	 * Szerokoœæ akwarium (prostopad³oœcianu). Jest to wspó³rzêdna w przedziale <0, y-1>.
	 */
	private final int y;
	
	/**
	 * Wysokoœæ akwarium (prostopad³oœcianu). Jest to wspó³rzêdna w przedziale <0, z-1>.
	 */
	private final int z;
	
	/**
	 * Zagregowany kreator organizmów w tym akwarium.
	 */
	private OrganismCreator organismCreator;
	
	/**
	 * Zagregowany kreator pokarmu w tym akwarium.
	 */
	private FoodCreator foodCreator;
	
	/**
	 * Zagregowane narzêdzie ruchu organizmów w tym akwarium.
	 */
	private MovementUtility movementUtility;
	
	/**
	 * Zagregowane narzêdzie obs³ugi zdarzeñ losowych w tym akwarium.
	 */
	private EventUtility eventUtility;
	
	/**
	 * Zagregowane narzêdzie zapisu danych dla tego akwarium.
	 */
	private DataUtility dataUtility;
	
	/**
	 * Iloœæ ryb w akwarium (bez rapaciousFish (@see Aquarium#rapaciousFishNumber)).
	 */
	private int fishNumber;
	
	/**
	 * Iloœæ drapie¿nych ryb w akwarium.
	 */
	private int rapaciousFishNumber;
	
	/**
	 * Iloœæ œlimaków w akwarium.
	 */
	private int snailNumber;
	
	/**
	 * Iloœæ krewetek w akwarium.
	 */
	private int prawnNumber;
	
	/**
	 * Iloœæ karmy w akwarium.
	 */
	private int fodderNumber;
	
	/**
	 * Iloœæ glonów w akwarium.
	 */
	private int algaNumber;
	
	/**
	 * Lista wszystkich obiektow umieszczonych w akwarium.
	 */
	private List<IObject> objects;
	
	/**
	 * Tworzy instancje akwarium. Akwarium jest to prostopad³oœcianu o wymiarach okreœlonych parametrami.
	 * @param x d³ugoœæ akwarium.
	 * @param y szerokoœæ akwarium.
	 * @param z wysokoœæ akwarium.
	 */
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
	
	/**
	 * Zwraca d³ugoœæ akwarium (wspó³rzêdna x).
	 * @return d³ugoœæ akwarium.
	 */
	public int getLength() {
		return x;
	}
	
	/**
	 * Zwraca szerokoœæ akwarium (wspó³rzêdna y).
	 * @return szerokoœæ akwarium.
	 */
	public int getWidth() {
		return y;
	}
	
	/**
	 * Zwraca wysokoœæ akwarium (wspó³rzêdna z).
	 * @return wysokoœæ akwarium.
	 */
	public int getHeight() {
		return z;
	}
	
	/**
	 * Zwraca zagregowany obiekt kreatora organizmów.
	 * @return kreator organizmów.
	 */
	public OrganismCreator getOrganismCreator() {
		return organismCreator;
	}
	
	/**
	 * Zwraca zagregowany obiekt kreatora pokarmu.
	 * @return kreator pokarmu.
	 */
	public FoodCreator getFoodCreator() {
		return foodCreator;
	}
	
	/**
	 * Zwraca zagregowany obiekt narzêdzi ruchu organizmów.
	 * @return narzêdzia ruchu.
	 */
	public MovementUtility getMovementUtility() {
		return movementUtility;
	}
	
	/**
	 * Zwraca zagregowany obiekt narzêdzi zdarzeñ losowych w akwarium.
	 * @return narzêdzia zdarzeñ losowych.
	 */
	public EventUtility getEventUtility() {
		return eventUtility;
	}
	
	/**
	 * Zwraca zagregowany obiekt narzêdzi zapisu danych.
	 * @return narzêdzia zapisu danych.
	 */
	public DataUtility getDataUtility() {
		return dataUtility;
	}
	
	/**
	 * Sprawdza czy jest mo¿liwe dodaæ dany obiekt do akwarium, a jeœli tak umieszcza go w akwarium.
	 * @param obj obiekt do dodania do akwarium.
	 * @return true jeœli powiod³o siê dodanie obiektu do akwarium, w przeciwnym razie false.
	 */
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
	
	/**
	 * Sprzawdza czy jest mo¿liwe usun¹c dany obiekt z akwarium, a jeœli tak usuwa go.
	 * @param obj obiekt do usuniêcia z akwarium.
	 * @return true jeœli powiod³o siê usuniêcie obiektu z akwarium, w przeciwnym razie false.
	 */
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
	
	/**
	 * Zwraca iloœæ ryb w akwarium z pominiêciem ryb drapie¿nych (@see #getRapaciousFishNumber()).
	 * @return iloœæ ryb.
	 */
	public int getFishNumber() {
		return fishNumber;
	}
	
	/**
	 * Zwraca iloœæ ryb drapie¿nych w akwarium.
	 * @return iloœæ ryb drapie¿nych.
	 */
	public int getRapaciousFishNumber() {
		return rapaciousFishNumber;
	}
	
	/**
	 * Zwraca iloœæ œlimaków w akwarium.
	 * @return iloœæ œlimaków.
	 */
	public int getSnailNumber() {
		return snailNumber;
	}
	
	/**
	 * Zwraca iloœæ krewetek w akwarium.
	 * @return iloœæ krewetek.
	 */
	public int getPrawnNumber() {
		return prawnNumber;
	}
	
	/**
	 * Zwraca iloœæ karmy w akwarium.
	 * @return iloœæ karmy.
	 */
	public int getFodderNumber() {
		return fodderNumber;
	}
	
	/**
	 * Zwraca iloœæ glonów w akwarium.
	 * @return iloœæ glonów.
	 */
	public int getAlgaNumber() {
		return algaNumber;
	}
	
	/**
	 * Zwraca listê zawieraj¹c¹ tylko same organizmy w akwarium.
	 * @return lista organizmów.
	 */
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
	
	/**
	 * Zwraca pierwszy obiekt z listy, który w akwarium znajdujê sie na pozycji o danych wspó³rzêdnych.
	 * @param x wspó³rzêdna x.
	 * @param y wspó³rzêdna y.
	 * @param z wspó³rzêdna z.
	 * @return obiekt znajduj¹cy siê na pozycji o tych wspó³rzêdnych. Jeœli nie ma tam ¿adnego obiektu zwraca null.
	 */
	public IObject getObjectAt(int x, int y, int z) {
		for(IObject object : objects)
			if(object.getX()==x && object.getY()==y && object.getZ()==z) return object;
		return null;
	}
	
	/**
	 * Sprawdza, czy ¿aden obiekt w akwarium nie znajduje siê na pozycji o danych wspó³rzêdnych.
	 * @param x wspó³rzêdna x.
	 * @param y wspó³rzêdna y.
	 * @param z wspó³rzêdna z.
	 * @return true jeœli ¿aden obiekt nie znajduje siê na tej pozycji, w przeciwnym wypadku false.
	 */
	public boolean emptyPosAt(int x, int y, int z) {
		for(IObject object : objects)
			if(object.getX()==x && object.getY()==y && object.getZ()==z) return false;
		return true;
	}
	
	/**
	 * Sprawdza, czy w akwarium na pozycji o danych wspó³rzêdnych znajduje siê jakiekolwiek pokarm.
	 * @param x wspó³rzêdna x.
	 * @param y wspó³rzêdna y.
	 * @param z wspó³rzêdna z.
	 * @return true jeœli jakiœ pokarm znajduje siê na tej pozycji, w przeciwnym wypadku false.
	 */
	public boolean isFoodAt(int x, int y, int z) {
		for(IObject object : objects) 
			if(object.getX()==x && object.getY()==y && object.getZ()==z)
				if(object instanceof Food) return true;
		return false;
	}
	
	/**
	 * Powoduje psucie siê wszystkich pokarmów w akwarium.
	 */
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

	/**
	 * Sprawdza, czy jakiœ typ organizmów zdominowa³a akwarium, tzn jest ich wiêcej, ni¿ æwieræ objêtoœci przestrzeni akwarium.
	 * @return true jeœli któryœ typ organizmów dominuje liczebnie, w przeciwnym wypadku false.
	 */
	public boolean specimenDominates() {
		int size = x*y*z/4;
		if(fishNumber>size) {
			System.out.println("Fish zdominowal akwarium");
			dataUtility.saveToTxt("Fish zdominowal akwarium");
			return true;
		}
		if(rapaciousFishNumber>size) {
			System.out.println("RapaciousFish zdominowal akwarium");
			dataUtility.saveToTxt("RapaciousFish zdominowal akwarium");
			return true;
		}
		if(snailNumber>size) {
			System.out.println("Snail zdominowal akwarium");
			dataUtility.saveToTxt("Snail zdominowal akwarium");
			return true;
		}
		if(prawnNumber>size) {
			System.out.println("Prawn zdominowal akwarium");
			dataUtility.saveToTxt("Prawn zdominowal akwarium");
			return true;
		}
		return false;
	}
}