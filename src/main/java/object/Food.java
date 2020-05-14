package main.java.object;

import main.java.object.Position;

public abstract class Food implements Object{

	private Position position;
	
	public Position getPosition()
	{
		return position;
	}
	
	public abstract void feed();
	
}
