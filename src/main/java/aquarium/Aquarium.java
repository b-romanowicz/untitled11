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
 * Akwarium to prostopad�o�cian o okre�lonych wymiarach. Obiekty w nim si� znajduj�ce mog� znajdowa� si� na pozycjach o wsp�rz�dnych x od 0 do x-1,
 * y od 0 do y-1, z od 0 do z-1. W akwarium zagregowane s� obiekty zajmuj�ce si� obs�ug� dzia�ania symulacji akwarium.
 * @author jakkard
 * @version 1.0
 */
public class Aquarium {

	/**
	 * D�ugo�� akwarium (prostopad�o�cianu). Jest to wsp�rz�dna w przedziale <0, x-1>.
	 */
	private final int x;
	
	/**
	 * Szeroko�� akwarium (prostopad�o�cianu). Jest to wsp�rz�dna w przedziale <0, y-1>.
	 */
	private final int y;
	
	/**
	 * Wysoko�� akwarium (prostopad�o�cianu). Jest to wsp�rz�dna w przedziale <0, z-1>.
	 */
	private final int z;
	
	/**
	 * Zagregowany kreator organizm�w w tym akwarium.
	 */
	private OrganismCreator organismCreator;
	
	/**
	 * Zagregowany kreator pokarmu w tym akwarium.
	 */
	private FoodCreator foodCreator;
	
	/**
	 * Zagregowane narz�dzie ruchu organizm�w w tym akwarium.
	 */
	private MovementUtility movementUtility;
	
	/**
	 * Zagregowane narz�dzie obs�ugi zdarze� losowych w tym akwarium.
	 */
	private EventUtility eventUtility;
	
	/**
	 * Zagregowane narz�dzie zapisu danych dla tego akwarium.
	 */
	private DataUtility dataUtility;
	
	/**
	 * Ilo�� ryb w akwarium (bez rapaciousFish (@see Aquarium#rapaciousFishNumber)).
	 */
	private int fishNumber;
	
	/**
	 * Ilo�� drapie�nych ryb w akwarium.
	 */
	private int rapaciousFishNumber;
	
	/**
	 * Ilo�� �limak�w w akwarium.
	 */
	private int snailNumber;
	
	/**
	 * Ilo�� krewetek w akwarium.
	 */
	private int prawnNumber;
	
	/**
	 * Ilo�� karmy w akwarium.
	 */
	private int fodderNumber;
	
	/**
	 * Ilo�� glon�w w akwarium.
	 */
	private int algaNumber;
	
	/**
	 * Lista wszystkich obiektow umieszczonych w akwarium.
	 */
	private List<IObject> objects;
	
	/**
	 * Tworzy instancje akwarium. Akwarium jest to prostopad�o�cianu o wymiarach okre�lonych parametrami.
	 * @param x d�ugo�� akwarium.
	 * @param y szeroko�� akwarium.
	 * @param z wysoko�� akwarium.
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
	 * Zwraca d�ugo�� akwarium (wsp�rz�dna x).
	 * @return d�ugo�� akwarium.
	 */
	public int getLength() {
		return x;
	}
	
	/**
	 * Zwraca szeroko�� akwarium (wsp�rz�dna y).
	 * @return szeroko�� akwarium.
	 */
	public int getWidth() {
		return y;
	}
	
	/**
	 * Zwraca wysoko�� akwarium (wsp�rz�dna z).
	 * @return wysoko�� akwarium.
	 */
	public int getHeight() {
		return z;
	}
	
	/**
	 * Zwraca zagregowany obiekt kreatora organizm�w.
	 * @return kreator organizm�w.
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
	 * Zwraca zagregowany obiekt narz�dzi ruchu organizm�w.
	 * @return narz�dzia ruchu.
	 */
	public MovementUtility getMovementUtility() {
		return movementUtility;
	}
	
	/**
	 * Zwraca zagregowany obiekt narz�dzi zdarze� losowych w akwarium.
	 * @return narz�dzia zdarze� losowych.
	 */
	public EventUtility getEventUtility() {
		return eventUtility;
	}
	
	/**
	 * Zwraca zagregowany obiekt narz�dzi zapisu danych.
	 * @return narz�dzia zapisu danych.
	 */
	public DataUtility getDataUtility() {
		return dataUtility;
	}
	
	/**
	 * Sprawdza czy jest mo�liwe doda� dany obiekt do akwarium, a je�li tak umieszcza go w akwarium.
	 * @param obj obiekt do dodania do akwarium.
	 * @return true je�li powiod�o si� dodanie obiektu do akwarium, w przeciwnym razie false.
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
	 * Sprzawdza czy jest mo�liwe usun�c dany obiekt z akwarium, a je�li tak usuwa go.
	 * @param obj obiekt do usuni�cia z akwarium.
	 * @return true je�li powiod�o si� usuni�cie obiektu z akwarium, w przeciwnym razie false.
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
	 * Zwraca ilo�� ryb w akwarium z pomini�ciem ryb drapie�nych (@see #getRapaciousFishNumber()).
	 * @return ilo�� ryb.
	 */
	public int getFishNumber() {
		return fishNumber;
	}
	
	/**
	 * Zwraca ilo�� ryb drapie�nych w akwarium.
	 * @return ilo�� ryb drapie�nych.
	 */
	public int getRapaciousFishNumber() {
		return rapaciousFishNumber;
	}
	
	/**
	 * Zwraca ilo�� �limak�w w akwarium.
	 * @return ilo�� �limak�w.
	 */
	public int getSnailNumber() {
		return snailNumber;
	}
	
	/**
	 * Zwraca ilo�� krewetek w akwarium.
	 * @return ilo�� krewetek.
	 */
	public int getPrawnNumber() {
		return prawnNumber;
	}
	
	/**
	 * Zwraca ilo�� karmy w akwarium.
	 * @return ilo�� karmy.
	 */
	public int getFodderNumber() {
		return fodderNumber;
	}
	
	/**
	 * Zwraca ilo�� glon�w w akwarium.
	 * @return ilo�� glon�w.
	 */
	public int getAlgaNumber() {
		return algaNumber;
	}
	
	/**
	 * Zwraca list� zawieraj�c� tylko same organizmy w akwarium.
	 * @return lista organizm�w.
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
	 * Zwraca pierwszy obiekt z listy, kt�ry w akwarium znajduj� sie na pozycji o danych wsp�rz�dnych.
	 * @param x wsp�rz�dna x.
	 * @param y wsp�rz�dna y.
	 * @param z wsp�rz�dna z.
	 * @return obiekt znajduj�cy si� na pozycji o tych wsp�rz�dnych. Je�li nie ma tam �adnego obiektu zwraca null.
	 */
	public IObject getObjectAt(int x, int y, int z) {
		for(IObject object : objects)
			if(object.getX()==x && object.getY()==y && object.getZ()==z) return object;
		return null;
	}
	
	/**
	 * Sprawdza, czy �aden obiekt w akwarium nie znajduje si� na pozycji o danych wsp�rz�dnych.
	 * @param x wsp�rz�dna x.
	 * @param y wsp�rz�dna y.
	 * @param z wsp�rz�dna z.
	 * @return true je�li �aden obiekt nie znajduje si� na tej pozycji, w przeciwnym wypadku false.
	 */
	public boolean emptyPosAt(int x, int y, int z) {
		for(IObject object : objects)
			if(object.getX()==x && object.getY()==y && object.getZ()==z) return false;
		return true;
	}
	
	/**
	 * Sprawdza, czy w akwarium na pozycji o danych wsp�rz�dnych znajduje si� jakiekolwiek pokarm.
	 * @param x wsp�rz�dna x.
	 * @param y wsp�rz�dna y.
	 * @param z wsp�rz�dna z.
	 * @return true je�li jaki� pokarm znajduje si� na tej pozycji, w przeciwnym wypadku false.
	 */
	public boolean isFoodAt(int x, int y, int z) {
		for(IObject object : objects) 
			if(object.getX()==x && object.getY()==y && object.getZ()==z)
				if(object instanceof Food) return true;
		return false;
	}
	
	/**
	 * Powoduje psucie si� wszystkich pokarm�w w akwarium.
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
	 * Sprawdza, czy jaki� typ organizm�w zdominowa�a akwarium, tzn jest ich wi�cej, ni� �wier� obj�to�ci przestrzeni akwarium.
	 * @return true je�li kt�ry� typ organizm�w dominuje liczebnie, w przeciwnym wypadku false.
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