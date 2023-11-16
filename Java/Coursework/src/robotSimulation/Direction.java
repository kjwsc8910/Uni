package robotSimulation;
	
public enum Direction {
	North,
	East,
	South,
	West;
	
	/**
	 * 
	 * @return random Direction
	 */
	public static Direction randomDirection() {
		return values()[(int)(Math.random() * values().length)];
	}
	
	/**
	 * 
	 * @return The next direction
	 */
	public Direction next() {
		return values()[(ordinal()+1)%values().length];
	}
}
