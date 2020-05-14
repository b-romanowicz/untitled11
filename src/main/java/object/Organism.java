package main.java.object;

public abstract class Organism implements Object {
	
	private Position position;
	private int age;
	private int size;
	private int hunger;
	
	public Position getPosition() {
		return position;
	}
	
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
    
    public abstract void move();

    public abstract void eat();
    
}
    
