package main.java.objects;

import main.java.aquarium.Aquarium;

public abstract class Food implements IObject{
	
	protected Aquarium aquarium;
	protected int x;
	protected int y;
	protected int z;
	protected int lifetime;
	protected int satisfaction;
	
	public Food(int satisfaction, Aquarium aquarium, int x, int y, int z) {
		this.aquarium = aquarium;
		this.x = x;
		this.y = y;
		this.z = z;
		this.satisfaction = satisfaction;
	}
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getZ() {
		return z;
	}
	
	public void feed(Organism organism) {
		int hunger = organism.getHunger();
		hunger+=satisfaction;
		if(hunger>100) hunger=100;
		organism.setHunger(hunger);
		aquarium.remove(this);
	}
	
	public void spoil() {
		lifetime--;
		if(lifetime<=0) aquarium.remove(this);
	}
}
