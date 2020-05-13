package object.organism;


import object.Position;

public class Fish extends Organism {
    
    	private Position position;
    	private int age;
    	private int hunger;
    	private int size;
    	private int temperature;
    	@Override
    	public void getPosition() {
    	
    	}
        
    	@Override
    	public void getAge() {

    	}
    	
    	@Override
        public void setAge() {
    		
        }
    	
    	@Override
        public int getHunger() {

            return 0;
        }
    	
    	@Override
        public void setHunger() {
    		
        }
    	
        public int setSize()
        {

            return 0;
        }
        
        public void getSize() {
        	
        }
        
        public void move() {
        	
        }
        
        public void eat() {
        	
        }
        
    	public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        
    }

