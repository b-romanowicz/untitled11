package main.java.object;

import main.java.aquarium.Aquarium;

public class Fish extends main.java.object.Organism {
    
		private int speed;
		private int temperature;
		
		public Fish(Aquarium aquarium) {
    		super(aquarium);
    	}
		
		public int getSpeed() {
			return speed;
		}
		
		public void setSpeed(int speed) {
			this.speed = speed;
		}
    	
    	public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temp) {
            this.temperature = temp;
        }

		@Override
		public void move() {
			aquarium.getMovementUtility().moveFish(this);
		}
        
        @Override
		public void eat() {
			
		}        
    }

