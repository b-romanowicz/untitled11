package main.java.objects;

import main.java.aquarium.Aquarium;

public class RapaciousFish extends Fish{

	public RapaciousFish(Aquarium aquarium) {
		super(aquarium);
	}
	
	@Override
	public void eat(IObject object) {
		if(object instanceof Food) super.eat(object);
		if(object instanceof Organism) 
			if(hunger<30) {	
				Organism organism = (Organism) object;
				hunger+=20;
				if(hunger>100) hunger=100;
				organism.die();
				System.out.println(this.getClass().getSimpleName() + " zjadl " + organism.getClass().getSimpleName());
				aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " zjadl " + organism.getClass().getSimpleName());
			}
		}
	
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
