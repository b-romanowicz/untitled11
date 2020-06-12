package main.java.objects;

import main.java.aquarium.Aquarium;

/**
 * Obiekt drapie¿nej ryby dziedziczy po klasie rodzica - ryby. Ró¿ni siê tym, ¿e poziom zaspokojenia g³odu spada szybciej ni¿ u normalnych
 * organizmów. Mo¿e zjadaæ równie¿ inne organizmy.
 * @author jakkard
 * @version 1.0
 */
public class RapaciousFish extends Fish{
	
	/**
	 * Tworzy instancjê drapie¿nej ryby.
	 * @param aquarium akwarium, w którym zostanie umieszczona drapie¿na ryba.
	 */
	public RapaciousFish(Aquarium aquarium) {
		super(aquarium);
	}
	
	/**
     * Powoduje zabicie i zjedzenie organizmu podanego w parametrze prez drapie¿na rybê, co powoduje przywrócenie pewnej iloœci punktów zaspokojenia g³odu. 
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
	 * Powoduje spadek iloœci zaspokojenia g³odu drapie¿nej ryby, ale w szybszym tempie ni¿ organizmowi (@see main.java.objects.Organism.#feelHunger()).
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
