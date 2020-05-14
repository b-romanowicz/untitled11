package main.java.object;



public abstract class Organism implements Object {
	
	@Override
	public abstract Position getPosition();
    public abstract int getAge();
    public abstract void setAge();
    public abstract int getHunger();
    public abstract void setHunger();
    public abstract void move();
    public abstract void eat();
    
}
    
