package main.java.object;

public class Fish extends main.java.object.Organism {
    
		private Position position;
		private int speed;
		private int temperature;
        private int age;
        private int hunger;
		
		public Fish(int age, int size) {
    		
    	}
		
		@Override
		public Position getPosition() {
			return position;
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

		@Override
		public int getAge() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setAge() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getHunger() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setHunger() {
			// TODO Auto-generated method stub
			
		}
        
    }

