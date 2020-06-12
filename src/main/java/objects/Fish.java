package main.java.objects;

import java.util.Random;

import main.java.aquarium.Aquarium;

/**
 * Obiekt ryby, kt�ry porusza si� po akwarium na losow� pozycj� o ka�d� wsp�rz�dn� z zakresu -speed, speed. Organizm ten �ywi si� karm�. 
 * Ryba mo�e r�wnie� rozmno�y� si� z inn� ryb�. �ycie obiektu determinuje poziom zaspokojenia g�odu, kt�ry pozwala na rozmna�anie lub je�li spadnie
 * do 0 powoduje �mier� ryby.
 * @author jakkard
 * @version 1.0
 */
public class Fish extends main.java.objects.Organism {
    	
	/**
	 * Tworzy instancj� klasy ryby.	
	 * @param aquarium akwarium, w kt�rym b�dzie znajdowa� si� ryba.
	 */
	public Fish(Aquarium aquarium) {
    	super.aquarium = aquarium;
    }
	
	/**
	 * Powoduje wykonanie metody, kt�ra przemie�ci ryb� w przestrzeni akwarium lub spotka inny obiekt.
	 */
	@Override
	public void move() {
		aquarium.getMovementUtility().moveFish(this);
	}
	
	/**
	 * Sprawdza czy dwie ryby s� zdolne do rozmna�ania, tzn. maj� odpowiedni poziom zaspokojenia g�odu. Je�li tak, rozmna�a dwie ryby co powoduje zg�odnienie obu. 
	 * Efektem rozmna�ania jest nowa ryba na tej samej pozycji w przestrzeni akwarium co rodzic. 
	 * Ryba ta jest tego samego typu lub je�li rodzice s� r�nego typu (ryba oraz ryba drapie�na) typ ryby potomnej zostanie wylosowany.
	 * @param fish druga ryba do rozmna�enia.
	 * @return true je�li uda�o si� rozmno�y� lub false je�li nie zosta�y spe�nione warunki przez kt�r�� z ryb.
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

