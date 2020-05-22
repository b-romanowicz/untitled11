package main.java.objects;

import main.java.aquarium.Aquarium;

public abstract class Organism implements IObject {
	
	protected Aquarium aquarium;
	protected int x;
	protected int y;
	protected int z;
	protected int speed;
    protected int age;
    protected int hunger;
    
    public Organism(Aquarium aquarium) {
    	this.aquarium = aquarium;
    }
    
    @Override
	public int getX() {
    	return x;
	}
    
    @Override
    public void setX(int x) {
    	this.x = x;
    }
    
    @Override
	public int getY() {
    	return y;
	}
    
    @Override
    public void setY(int y) {
    	this.y = y;
    }
    
    @Override
	public int getZ() {
    	return z;
	}
    
    @Override
    public void setZ(int z) {
    	this.z = z;
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
    
