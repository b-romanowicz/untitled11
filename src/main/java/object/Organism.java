package main.java.object;

public abstract class Organism extends Object {
	
	private int age;
	private int size;
	private int hunger;

    public int getAge() {
    	return age;
    }
    public void setAge(int age) {
    	this.age = age;
    }
    
    public int getSize() {
		return size;
	}
    
    public void setSize(int size) {
    	this.size = size;
    }
    
    public int getHunger() {
		return hunger;
	}
    
    public void setHunger(int hunger) {
    	this.hunger = hunger;
    }
    
    @Override
    public void move() {
    	
    }

    public abstract void eat();
    
}
    
