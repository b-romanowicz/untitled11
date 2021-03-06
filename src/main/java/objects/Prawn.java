package main.java.objects;

import main.java.aquarium.Aquarium;
import main.java.objects.Organism;

/**
 * Obiekt krewetki, kt�ry porusza si� po pod�o�u akwarium. Nast�puje to po wylosowaniu dw�ch wsp�rz�dnych x i y z zakresu -speed, speed.
 * Z pozostaje zawsze 0. �ycie organizmu determinuje poziom zaspokojenia g�odu, kt�ry pozwala na rozmna�anie si� z inn� krewetk�.
 * Je�li natomiast spadnie do 0 organizm umiera.
 * @author jakkard
 * @version 1.0
 */
public class Prawn extends Organism {
	
	/**
	 * Tworzy instancj� klasy krewetki.
	 * @param aquarium akwarium, w kt�rym zostanie umieszczona krewetka.
	 */
    public Prawn(Aquarium aquarium) {
        super.aquarium=aquarium;
    }
    
    /**
	 * Powoduje wywo�anie metody, kt�ra przemie�ci krewetk� w przestrzeni akwarium lub spotka inny obiekt.
	 */
    @Override
    public void move() {
    	aquarium.getMovementUtility().movePrawn(this);
    }
    
    /**
     * Sprawdza czy dwie krewetki s� zdolne do romna�ania, tzn. maj� odpowiedni poziom zaspokojenia g�odu. 
     * Je�li tak rozmna�a dwie krewetki, co powoduje zg�odnienie obu. Efektem romna�ania jest nowa krewetka na tej samej
     * pozycji w przestrzeni akwarium co rodzic.
     * @param prawn druga krewetka do rozmno�enia
     * @return true je�li uda�o si� rozmno�y� lub false je�li nie zosta�y spe�nione warunki przez kt�r�� z krewetek.
     */
    public boolean reproduce(Prawn prawn) {
    	Organism organism = (Organism) prawn;
    	if(hunger<=50 || organism.getHunger()<=50) return false;
    	int x = organism.getX();
		int y = organism.getY();
		//int z = organism.getZ();
		int speed = (this.speed + organism.getSpeed())/2;
		hunger-=50;
		int organismHunger=organism.getHunger()-50;
		organism.setHunger(organismHunger);
    	aquarium.getOrganismCreator().createPrawn(x, y, speed);
		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " rozmnozyl sie");
    	return true;
    }
}
