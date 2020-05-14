package aquarium.creators;

import aquarium.Aquarium;

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
	public Aquarium createAquarium()
	{
		return new Aquarium(x, y, z);
	}
}

