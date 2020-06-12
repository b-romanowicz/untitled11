package main.java.objects.creators;

import java.util.Random;

import main.java.aquarium.Aquarium;
import main.java.objects.Fish;
import main.java.objects.Prawn;
import main.java.objects.RapaciousFish;
import main.java.objects.Snail;

/**
 * Obiekt s³u¿¹cy do tworzenia organizmów oraz umieszczenia ich w akwarium. Umo¿liwia równie¿ stworzenie organizmów o parametrach losowych.
 * @author jakkard
 * @version 1.0
 */
public class OrganismCreator {
	
	/**
	 * Akwarium, do którego organizmy bêdzie tworzyæ kreator.
	 */
	private Aquarium aquarium;
	
	/**
	 * Obiekt klasy random, generator pseudolosowoœci.
	 */
	private Random random;
	
	/**
	 * Tworzy instancjê kreatora organizmów.
	 * @param aquarium akwarium, w którym kreator bêdzie tworzy³ organizmy.
	 */
	public OrganismCreator(Aquarium aquarium) {
		this.aquarium = aquarium;
		random = new Random();
	} 
	
	/**
	 * Tworz¹ca rybê i umiesza j¹ na pozycji w przestrzeni akwarium.
	 * @param x wspó³rzêdna x pozycji.
	 * @param y wspó³rzêdna y pozycji.
	 * @param z wspó³rzêdna z pozycji.
	 * @param speed prêdkoœæ poruszania siê ryby po przestrzeni akwarium.
	 * @return obiekt stworzonej ryby.
	 */
	public Fish createFish(int x, int y, int z, int speed) {
		Fish fish = new Fish(aquarium);
		aquarium.add(fish);
		fish.setX(x);
		fish.setY(y);
		fish.setZ(z);
		fish.setSpeed(speed);
		fish.setHunger(50);
		return fish;
	}
	
	/**
	 * Tworzy krewetkê i umiesza j¹ na pozycji na pod³o¿u akwarium (wspó³rzêdna z zawsze = 0).
	 * @param x wspó³rzêdna x pozycji.
	 * @param y wspó³rzêdna y pozycji.
	 * @param speed prêdkoœæ poruszania siê krewetki po pod³o¿u akwarium.
	 * @return obiekt stworzonej krewetki.
	 */
	public Prawn createPrawn(int x, int y, int speed) {
		Prawn prawn = new Prawn(aquarium);
		aquarium.add(prawn);
		prawn.setX(x);
		prawn.setY(y);
		prawn.setZ(0);
		prawn.setSpeed(speed);
		prawn.setHunger(50);
		return prawn;
	}
	
	/**
	 * Tworzy drapie¿n¹ rybê i umiesza j¹ na pozycji w przestrzeni akwarium.
	 * @param x wspó³rzêdna x pozycji.
	 * @param y wspó³rzêdna y pozycji.
	 * @param z wspó³rzêdna z pozycji.
	 * @param speed prêdkoœæ poruszania siê drapie¿nej ryby po przestrzeni akwarium.
	 * @return obiekt stworzonej drapie¿nej ryby.
	 */
	public RapaciousFish createRapaciousFish(int x, int y, int z, int speed) {
		RapaciousFish rapaciousFish = new RapaciousFish(aquarium);
		aquarium.add(rapaciousFish);
		rapaciousFish.setX(x);
		rapaciousFish.setY(y);
		rapaciousFish.setZ(z);
		rapaciousFish.setSpeed(speed);
		rapaciousFish.setHunger(50);
		return rapaciousFish;
	}
	
	/**
	 * Metoda tworz¹ca œlimaka i umiesza go na pozycji w przestrzeni akwarium.
	 * @param x wspó³rzêdna x pozycji.
	 * @param y wspó³rzêdna y pozycji.
	 * @param z wspó³rzêdna z pozycji.
	 * @param speed prêdkoœæ poruszania siê œlimaka po œcianach akwarium.
	 * @return obiekt stworzonego œlimaka.
	 */
	public Snail createSnail(int x, int y, int z, int speed) {
		Snail snail = new Snail(aquarium);
		aquarium.add(snail);
		snail.setX(x);
		snail.setY(y);
		snail.setZ(z);
		snail.setSpeed(speed);
		snail.setHunger(50);
		return snail;
	
	}
	
	/**
	 * Tworzy podane iloœci organizmów i umiesza je na losowych pozycjach (odpowiednich dla danych typów organizmów)
	 * w przestrzeni (dla ryb równie¿ losowa prêdkoœæ z przedzia³u). 
	 * @param fishNum iloœæ ryb (bez drapie¿nych ryb) do stworzenia.
	 * @param rapaciousFishNum iloœæ drapie¿nych ryb, do stworzenia.
	 * @param snailNum iloœæ œlimakó do stworzenia.
	 * @param prawnNum iloœæ krewetek do stworzenia.
	 */
	public void createOrganisms(int fishNum, int rapaciousFishNum, int snailNum, int prawnNum)
	{
		for(int i=0; i<fishNum; i++) {
			int x = random.nextInt(aquarium.getLength());
			int y = random.nextInt(aquarium.getWidth());
			int z = random.nextInt(aquarium.getHeight());
			int speed = random.nextInt(3)+1;
			this.createFish(x, y, z, speed);
		}
		for(int i=0; i<rapaciousFishNum; i++) {
			int x = random.nextInt(aquarium.getLength());
			int y = random.nextInt(aquarium.getWidth());
			int z = random.nextInt(aquarium.getHeight());
			int speed = random.nextInt(3)+1;
			this.createRapaciousFish(x, y, z, speed);
		}
		for(int i=0; i<snailNum; i++) {
			int x, y, z;
			int randomPlane = random.nextInt(4);
			if(randomPlane == 0) {
				x = 0;
				y = random.nextInt(aquarium.getWidth());
			}
			else if(randomPlane == 1) {
				y = 0;
				x = random.nextInt(aquarium.getLength());
			}
			else if(randomPlane == 2) {
				x = aquarium.getLength()-1;
				y = random.nextInt(aquarium.getWidth());
			}
			else {
				y = aquarium.getWidth()-1;
				x = 0;
			}
			z = random.nextInt(aquarium.getHeight());
			this.createSnail(x, y, z, 1);
		}
		for(int i=0; i<prawnNum; i++) {
			int x = random.nextInt(aquarium.getLength());
			int y = random.nextInt(aquarium.getWidth());
			this.createPrawn(x, y, 1);
		}
		
	}
}
