package main.java.objects;

import main.java.aquarium.Aquarium;

/**
 * 
 * @author jakkard
 *
 */
public class RapaciousFish extends Fish{
	
	/**
	 * Tworzy instancj� drapie�nej ryby.
	 * @param aquarium akwarium, w kt�rym zostanie umieszczona drapie�na ryba.
	 */
	public RapaciousFish(Aquarium aquarium) {
		super(aquarium);
	}
	
	/**
     * Powoduje zabicie i zjedzenie organizmu podanego w parametrze prez drapie�na ryb�, co powoduje przywr�cenie pewnej ilo�ci punkt�w zaspokojenia g�odu. 
     * @param organism organizm do zjedzenia
     */
	public void eat(Organism organism) {
		if(hunger<30) {	
			hunger+=20;
			if(hunger>100) hunger=100;
			organism.die();
			System.out.println(this.getClass().getSimpleName() + " zjadl " + organism.getClass().getSimpleName());
			aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " zjadl " + organism.getClass().getSimpleName());
		}
	}
	
	/**
	 * Powoduje spadek ilo�ci zaspokojenia g�odu drapie�nej ryby, ale w szybszym tempie ni� organizmowi (@see main.java.objects.Organism.#feelHunger()).
	 */
	@Override
	public void feelHunger() {
		hunger-=2;
		if(hunger<=0) {
			this.die();
			System.out.println(this.getClass().getSimpleName() + " zdechl z glodu");
			aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " zdechl z glodu");
		}
	}
}
