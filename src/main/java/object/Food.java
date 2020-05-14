package main.java.object;

public abstract class Food implements Object{

	private Position position;
	
	public Position getPosition()
	{
		return position;
	}
	
	public abstract void feed();
	
}
