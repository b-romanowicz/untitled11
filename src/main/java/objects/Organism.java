package main.java.objects;

import main.java.aquarium.Aquarium;

public abstract class Organism implements IObject {
	
	protected Aquarium aquarium;
	protected int x;
	protected int y;
	protected int z;
    protected int speed;
    protected int hunger;
    
    public Organism(Aquarium aquarium) {
    	this.aquarium = aquarium;
    }
    
    @Override
	public int getX() {
    	return x;
	}
    
    public void setX(int x) {
    	this.x = x;
    }
    
    @Override
	public int getY() {
    	return y;
	}
    
    public void setY(int y) {
    	this.y = y;
    }
    
    @Override
	public int getZ() {
    	return z;
	}
    
    public void setZ(int z) {
    	this.z = z;
    }
    
    public int getHunger() {
    	return hunger;
    }
    
    public void setHunger(int hunger) {
    	this.hunger = hunger;
    }
    
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
    public void feelHunger() {
    	hunger--;
    	if(hunger<=0) {
    		this.die(); 
    		System.out.println(this.getClass().getSimpleName() + " zdechl z glodu"); 
    		aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " zdechl z glodu");
    	}
    }
    
    public void die() {
    	aquarium.remove(this);
    }
    
    public void eat(IObject object) {
		if(object instanceof Food) {
			Food food = (Food) object;
			food.feed(this);
			aquarium.getDataUtility().saveToTxt(this.getClass().getSimpleName() + " zjadl " + food.getClass().getSimpleName());
			System.out.println(this.getClass().getSimpleName() + " zjadl " + food.getClass().getSimpleName());
			}
		}        
    
    /*protected boolean tryToReproduce(Integer x, Integer y, Integer z, Integer speed, Organism organism) {
    	if(hunger<=50 || organism.getHunger()<=50) return false;
    	x = organism.getX();
		y = organism.getY();
		z = organism.getZ();
		speed = (this.speed + organism.getSpeed())/2;
		hunger-=50;
		int organismHunger=organism.getHunger()-50;
		organism.setHunger(organismHunger);
		return true;
    }*/
   
    public abstract void move();
}
    
