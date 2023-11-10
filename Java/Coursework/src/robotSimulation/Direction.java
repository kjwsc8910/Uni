package robotSimulation;

public class Direction {

	private Compass currentDirection;
	
	public enum Compass {
		North(0),
		East(1),
		South(2),
		West(3);
		
		/**
		 * Allows the enmums to  store a value
		 */
		private final int value;
		private Compass(int value) {
			this.value = value;
		}
		
		/**
		 * Allows retrieval of the value from an enum
		 * @return
		 */
		public int getValue() {
			return value;
		}
		
		/**
		 * Returns a random enum direction
		 * @return
		 */
		private static Compass randomCompass() {
			return values()[(int)(Math.random() * 4)];
		}
	}
	
	/**
	 * Sets the current direction to a random one
	 * @return The current direction
	 */
	public Compass randomDirection() {
		currentDirection = Compass.randomCompass();
		return currentDirection;
	}
	
	/**
	 * Sets the current direction to the next one
	 * @return The current direction
	 */
	public Compass nextDirection() {
		return currentDirection.values()[(currentDirection.getValue() + 1) % 4];
	}
	
	public static void main(String args[]) {
		Direction dir = new Direction();
		
		System.out.println(dir.randomDirection());
		System.out.println(dir.nextDirection());
	}

}