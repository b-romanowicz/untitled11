package main.java.objects;

import main.java.aquarium.Aquarium;
import main.java.objects.Organism;

/**
 * 
 * @author jakkard
 * @version
 */
public class Prawn extends Organism {
	
	/**
	 * Tworzy instancjê klasy krewetki.
	 * @param aquarium akwarium, w którym zostanie umieszczona krewetka.
	 */
    public Prawn(Aquarium aquarium) {
        super.aquarium=aquarium;
    }
    
    /**
	 * Powoduje wywo³anie metody, która przemieœci krewetkê w przestrzeni akwarium lub spotka inny obiekt.
	 */
    @Override
    public void move() {
    	aquarium.getMovementUtility().movePrawn(this);
    }
    
    /**
     * Sprawdza czy dwie krewetki s¹ zdolne do romna¿ania, tzn. maj¹ odpowiedni poziom zaspokojenia g³odu. 
     * Jeœli tak rozmna¿a dwie krewetki, co powoduje zg³odnienie obu. Efektem romna¿ania jest nowa krewetka na tej samej
     * pozycji w przestrzeni akwarium co rodzic.
     * @param prawn druga krewetka do rozmno¿enia
     * @return true jeœli uda³o siê rozmno¿yæ lub false jeœli nie zosta³y spe³nione warunki przez któr¹œ z krewetek.
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
    	System.out.println(this.getClass().getSimpleName() + " rozmnozyl sie");
		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " rozmnozyl sie");
    	return true;
    }
}
