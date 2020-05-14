package main.java.object;



public abstract class Organism implements Object {
	
	protected Position position;
	protected int speed;
    protected int age;
    protected int hunger;
	
	@Override
	public Position getPosition() {
		return position;
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
    
