package main.java.object;

import main.java.aquarium.Aquarium;

public abstract class Organism implements Object {
	
	protected Aquarium aquarium;
	protected Position position;
	protected int speed;
    protected int age;
    protected int hunger;
    
    public Organism(Aquarium aquarium) {
    	this.aquarium = aquarium;
    }
    
    @Override
	public Position getPosition() {
		return position;
	}
    
    @Override
    public void setPosition(Position position) {
    	this.position = position;
    }
    
	public int getAge() {
		return age;
	}
	
    public void setAge(int age) {
    	this.age = age;
    }
    
    public int getHunger() {
    	return hunger;
    }
    
    public void setHunger(int hunger) {
    	this.hunger = hunger;
    }
    
    public abstract void move();
    public abstract void eat();
    
}
    
