package main.java.objects;

import main.java.aquarium.Aquarium;
import main.java.objects.Organism;

/**
 * 
 * @author jakkard
 *
 */
public class Snail extends Organism {
	
	/**
	 * Tworzy instancjê klasy œlimaka.
	 * @param aquarium akwarium, w którym bêdzie znadjowaæ siê œlimak
	 */
	public Snail(Aquarium aquarium) {
		super.aquarium=aquarium;
	}
	
	/**
	 * Œlimak rozmna¿a siê samodzielnie oraz g³odnieje. Efektem rozmna¿aniach jest nowy œlimak na tej samej pozycji.
	 */
	public void reproduceItself() {
		aquarium.getOrganismCreator().createSnail(x, y, z, speed);
		hunger-=50;
		System.out.println(this.getClass().getSimpleName() + " sam sie rozmnozyl");
		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " sam sie rozmnozyl");
	}
	
	/**
	 * Powoduje wywo³anie metody, która przemieœci œlimaka w przestrzeni akwarium lub spotka inny obiekt.
	 */
	@Override
	public void move() {
		aquarium.getMovementUtility().moveSnail(this);
	}
	
	/**
	* Sprawdza czy dwa œlimaki s¹ zdolne do romna¿ania, tzn. maj¹ odpowiedni poziom zaspokojenia g³odu. 
    * Jeœli tak rozmna¿a dwa œlimaki, co powoduje zg³odnienie obu. Efektem romna¿ania jest nowy œlimak na tej samej
    * pozycji w przestrzeni akwarium co rodzic.
    * @param snail drugi œlimak do rozmno¿enia
    * @return true jeœli uda³o siê rozmno¿yæ lub false jeœli nie zosta³y spe³nione warunki przez któregoœ ze œlimaków.
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
    	System.out.println(this.getClass().getSimpleName() + " rozmnozyl sie");
		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " rozmnozyl sie");
    	return true;
    }
}
