package main.java.aquarium;

import java.util.LinkedList;
import java.util.List;

public class Aquarium {

	private final int x;
	private final int y;
	private final int z;
	
	private List<Object> objects;
	
	public Aquarium(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		objects = new LinkedList<>();
	}
	
	public int getLength() {
		return x;
	}
	
	public int getWidth() {
		return y;
	}

	public int getHeight() {
		return z;
	}

	public boolean add(Object obj) {
		if(obj != null && !objects.contains(obj)) {
			objects.add(obj);
			return true;
		}
		return false;
	}
	
	public boolean remove(Object obj) {
		if(obj != null && objects.contains(obj)) {
			objects.remove(obj);
			return true;
		}
		return false;
	}
	
}