package main.java.object;

public class Fish extends Organism {
    
		private int speed;
		private int temperature;
        private int age;
        private int size;
        private int hunger;
    	
		
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
			// TODO Auto-generated method stub
			
		}
        
        @Override
		public void eat() {
			
		}

		@Override
		public Position getPosition() {
			// TODO Auto-generated method stub
			return null;
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
		public int getSize() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setSize() {
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

