package main.java.objects;

import main.java.aquarium.Aquarium;
import main.java.objects.Organism;

/**
 * Obiekt �limaka, kt�ry porusza si� po �cianach akwarium. Nast�puje to po wylosowaniu dw�ch wsp�rz�dnych z zakresu -speed, speed, a trzecia pozostaje
 * brzegowa. Organizm ten �ywi si� glonem. Mo�e rozmno�y� si� z innym �limakiem lub rozmno�y� si� samodzielnie, je�li posiada odpowiedni
 * poziom zaspokojenia g�odu. Je�li poziom g�odu spadnie do 0 �limak umiera.
 * @author jakkard
 * @version 1.0
 */
public class Snail extends Organism {
	
	/**
	 * Tworzy instancj� klasy �limaka.
	 * @param aquarium akwarium, w kt�rym b�dzie znadjowa� si� �limak
	 */
	public Snail(Aquarium aquarium) {
		super.aquarium=aquarium;
	}
	
	/**
	 * �limak rozmna�a si� samodzielnie oraz g�odnieje. Efektem rozmna�aniach jest nowy �limak na tej samej pozycji.
	 */
	public void reproduceItself() {
		aquarium.getOrganismCreator().createSnail(x, y, z, speed);
		hunger-=50;
		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " sam sie rozmnozyl");
	}
	
	/**
	 * Powoduje wywo�anie metody, kt�ra przemie�ci �limaka w przestrzeni akwarium lub spotka inny obiekt.
	 */
	@Override
	public void move() {
		aquarium.getMovementUtility().moveSnail(this);
	}
	
	/**
	* Sprawdza czy dwa �limaki s� zdolne do romna�ania, tzn. maj� odpowiedni poziom zaspokojenia g�odu. 
    * Je�li tak rozmna�a dwa �limaki, co powoduje zg�odnienie obu. Efektem romna�ania jest nowy �limak na tej samej
    * pozycji w przestrzeni akwarium co rodzic.
    * @param snail drugi �limak do rozmno�enia
    * @return true je�li uda�o si� rozmno�y� lub false je�li nie zosta�y spe�nione warunki przez kt�rego� ze �limak�w.
    */
	public boolean reproduce(Snail snail) {
    	Organism organism = (Organism) snail;
    	if(hunger<=50 || organism.getHunger()<=50) return false;
    	int x = organism.getX();
		int y = organism.getY();
		int z = organism.getZ();
		int speed = (this.speed + organism.getSpeed())/2;
		hunger-=50;
		int organismHunger=organism.getHunger()-50;
		organism.setHunger(organismHunger);
    	aquarium.getOrganismCreator().createSnail(x, y, z, speed);
		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " rozmnozyl sie");
    	return true;
    }
}
