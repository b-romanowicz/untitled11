package main.java.aquarium.creators;

public class AquariumCreator {

	private int x;
	private int y;
	private int z;
	
	public AquariumCreator(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public main.java.aquarium.Aquarium createAquarium()
	{
		return new main.java.aquarium.Aquarium(x, y, z);
	}
}

