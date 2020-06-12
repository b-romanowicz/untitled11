package main.java.objects.utilities;

import main.java.objects.Alga;
import main.java.objects.Fish;
import main.java.objects.Fodder;
import main.java.objects.IObject;
import main.java.objects.Organism;
import main.java.objects.Prawn;
import main.java.objects.RapaciousFish;
import main.java.objects.Snail;

/**
 * Statyczna klasa determinuj¹ca zachowanie obiektów w czasie interakcji z innymi obiektami.
 * @author jakkard
 * @version
 */
public class InteractionUtility {
	
	/**
	 * Sprawdzaja jakie interakcje mog¹ zajœæ miêdzy obiektami i odpowiednio je wywo³uje.
	 * @param obj1 jeden obiekt, który wchodzi w interakcje.
	 * @param obj2 drugi obiekt, który wchodzi w interakcje.
	 */
	public static void interact(IObject obj1, IObject obj2) {
		if(obj1 instanceof Prawn && obj2 instanceof Prawn) {
			Prawn prawn1 = (Prawn) obj1;
			Prawn prawn2 = (Prawn) obj2;
			prawn1.reproduce(prawn2);
		}
		if(obj1 instanceof Snail && obj2 instanceof Snail) {
			Snail snail1 = (Snail) obj1;
			Snail snail2 = (Snail) obj2;
			snail1.reproduce(snail2);
		}
		if(obj1 instanceof Fish && obj2 instanceof Fish) {	
			Fish fish1 = (Fish) obj1;
			Fish fish2 = (Fish) obj2;
			if(fish1.reproduce(fish2)) return;
		}
		if((obj1 instanceof Fish && obj2 instanceof Fodder) || (obj2 instanceof Fodder && obj1 instanceof Fish)) {
			Fish fish;
			Fodder fodder;
			if(obj1 instanceof Fish) {
				fish = (Fish) obj1;
				fodder = (Fodder) obj2;
			}
			else {
				fish = (Fish) obj2;
				fodder = (Fodder) obj1;
			}
			fish.eat(fodder);
		}
		if((obj1 instanceof RapaciousFish && obj2 instanceof Organism) || (obj1 instanceof Organism && obj2 instanceof RapaciousFish)) {
			RapaciousFish rapaciousFish;
			Organism organism;
			if(obj1 instanceof RapaciousFish ) {
				rapaciousFish = (RapaciousFish) obj1;
				organism = (Organism) obj2;
			}
			else {
				organism = (Organism) obj1;
				rapaciousFish = (RapaciousFish) obj2;
			}
			rapaciousFish.eat(organism);
		}
		if(((obj1 instanceof Snail || obj1 instanceof Prawn) && obj2 instanceof Alga) || ((obj2 instanceof Snail || obj2 instanceof Prawn)
				&& obj1 instanceof Alga)) {
			Alga alga;
			if(obj1 instanceof Snail) {
				Snail snail = (Snail) obj1;
				alga = (Alga) obj2;
				snail.eat(alga);
			}
			else if(obj1 instanceof Prawn){
				Prawn prawn = (Prawn) obj1;
				alga = (Alga) obj2;
				prawn.eat(alga);
			}
			else {
				if(obj2 instanceof Prawn) {
					Prawn prawn = (Prawn) obj2;
					alga = (Alga) obj1;
					prawn.eat(alga);
				}
				else {
					Snail snail = (Snail) obj2;
					alga = (Alga) obj1;
					snail.eat(alga);
				}
			}
		}
	}
}
