package main.java.object;

public class Fish extends main.java.object.Organism {
    
		private int speed;
		private int temperature;
		
		public Fish(int age, int size) {
    		
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
			
		}
        
        @Override
		public void eat() {
			
		}        
    }

