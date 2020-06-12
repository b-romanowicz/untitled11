package main.java.objects;

import java.util.Random;

import main.java.aquarium.Aquarium;

/**
 * Obiekt ryby, który porusza siê po akwarium na losow¹ pozycjê o ka¿d¹ wspó³rzêdn¹ z zakresu -speed, speed. Organizm ten ¿ywi siê karm¹. 
 * Ryba mo¿e równie¿ rozmno¿yæ siê z inn¹ ryb¹. ¯ycie obiektu determinuje poziom zaspokojenia g³odu, który pozwala na rozmna¿anie lub jeœli spadnie
 * do 0 powoduje œmieræ ryby.
 * @author jakkard
 * @version 1.0
 */
public class Fish extends main.java.objects.Organism {
    	
	/**
	 * Tworzy instancjê klasy ryby.	
	 * @param aquarium akwarium, w którym bêdzie znajdowaæ siê ryba.
	 */
	public Fish(Aquarium aquarium) {
    	super.aquarium = aquarium;
    }
	
	/**
	 * Powoduje wykonanie metody, która przemieœci rybê w przestrzeni akwarium lub spotka inny obiekt.
	 */
	@Override
	public void move() {
		aquarium.getMovementUtility().moveFish(this);
	}
	
	/**
	 * Sprawdza czy dwie ryby s¹ zdolne do rozmna¿ania, tzn. maj¹ odpowiedni poziom zaspokojenia g³odu. Jeœli tak, rozmna¿a dwie ryby co powoduje zg³odnienie obu. 
	 * Efektem rozmna¿ania jest nowa ryba na tej samej pozycji w przestrzeni akwarium co rodzic. 
	 * Ryba ta jest tego samego typu lub jeœli rodzice s¹ ró¿nego typu (ryba oraz ryba drapie¿na) typ ryby potomnej zostanie wylosowany.
	 * @param fish druga ryba do rozmna¿enia.
	 * @return true jeœli uda³o siê rozmno¿yæ lub false jeœli nie zosta³y spe³nione warunki przez któr¹œ z ryb.
	 */
	public boolean reproduce(Fish fish) {
		Organism organism = (Organism) fish;
		if(hunger<=50 || organism.getHunger()<=50) return false;
	   	int x = organism.getX();
		int y = organism.getY();
		int z = organism.getZ();
		int speed = (this.speed + organism.getSpeed())/2;
		hunger-=50;
		int organismHunger=organism.getHunger()-50;
		organism.setHunger(organismHunger);
		if(this instanceof RapaciousFish && fish instanceof RapaciousFish) {
			aquarium.getOrganismCreator().createRapaciousFish(x, y, z, speed);
			aquarium.getDataUtility().saveToTxt("RapaciousFish rozmnozyly sie");
			return true;
		}
		if((!(this instanceof RapaciousFish) && fish instanceof RapaciousFish) || 
				(this instanceof RapaciousFish && !(fish instanceof RapaciousFish)) ) {
			Random random = new Random();
			int r = random.nextInt(2);
			if(r==0) {
				aquarium.getOrganismCreator().createFish(x, y, z, speed);
				aquarium.getDataUtility().saveToTxt("RapaciousFish i Fish rozmnozyly sie na Fish");
				return true;
			}
			else if(r==1) {
				aquarium.getOrganismCreator().createRapaciousFish(x, y, z, speed);
				aquarium.getDataUtility().saveToTxt("RapaciousFish i Fish rozmnozyly sie na RapaciousFish");
				return true;
			}
		}
		aquarium.getOrganismCreator().createFish(x, y, z, speed);
		aquarium.getDataUtility().saveToTxt("Fish rozmnozyly sie");
		return true;
		}
	}

