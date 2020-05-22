package main.java.objects;

import main.java.objects.Position;

public abstract class Food implements IObject{

	private Position position;
	
	public Position getPosition()
	{
		return position;
	}
	
	public abstract void feed();
	
}
