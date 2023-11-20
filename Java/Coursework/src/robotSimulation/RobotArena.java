/**
 * 
 */
package robotSimulation;

/**
 * 
 */
public class RobotArena {
	
	private static int arenas = 0;
	private int id, sizeX, sizeY;
	private Robot[] robots = new Robot[16];
	
	/**
	 * A constructor to set up the arena
	 * @param sizeX of arena
	 * @param sizeY of arena
	 */
	public RobotArena (int sizeX, int sizeY) {
		this.id = ++arenas;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RobotArena arena = new RobotArena(20, 10);
		arena.addRobot();
		arena.addRobot();
		System.out.print(arena.toString());
		
	}
	
	/**
	 * Adds a robot to the arena in a random location
	 */
	public void addRobot() {
		boolean found = false;
		int x = 0, y = 0;
		while(!found) {
			x = (int)(Math.random() * (sizeX));
			y = (int)(Math.random() * (sizeY));
			found = isFree(x, y);
		}
		
		
		robots[Robot.robotCount()] = new Robot(x, y, Direction.randomDirection());
		robots[Robot.robotCount() - 1].setArena(this);
	}
	
	public void addRobot(int x, int y, Direction direction) {
		robots[Robot.robotCount()] = new Robot(x, y, direction);
		robots[Robot.robotCount() - 1].setArena(this);
	}
	
	/**
	 * show all the Robots in the interface
	 * @param c the canvas in which Robots are shown
	 */
	public void showRobots (ConsoleCanvas c) {
		for (int i = 0; i < robots.length; ++i) {
			if(robots[i] != null) robots[i].displayRobot(c);
		}
	}
	
	/**
	 * Checks if a robot is in a location
	 * @param x Position
	 * @param y Position
	 * @return Boolean
	 */
	public boolean isFree(int x, int y) {
		for (int i = 0; i < robots.length; ++i) {
			if(robots[i] != null) if(robots[i].x() == x && robots[i].y() == y) return false;
		}
		return true;
	}
	
	/**
	 * Runs tryToMove on all robots
	 */
	public void moveAllRobots() {
		for (int i = 0; i < robots.length; ++i) {
			if(robots[i] != null) robots[i].tryToMove();
		}
	}
	
	/**
	 * Moves all robots then displays them 10 times
	 * @param c
	 * @param x
	 */
	public void animate(ConsoleCanvas c, int x) {
		for (int i = 0; i < x; ++i) {
			c = new ConsoleCanvas(sizeX() + 2, sizeY() + 2, "31000799");
			moveAllRobots();
			showRobots(c);
			System.out.print(c.toString());
			try {
				Thread.sleep(200);
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	/**
	 * Converts the Arena and its Robots information into String Format
	 */
	public String toString() {
		String output = "Arena " + this.id + " is " + this.sizeX + "x" + this.sizeY;
		for (int i = 0; i < robots.length; ++i) {
			if(robots[i] != null) output += "\n" + robots[i].toString();
		}
		return output;
	}

	/**
	 * Makes sizeX a readable variable to other objects
	 * @return
	 */
	public int sizeX() {
		return this.sizeX;
	}
	
	/**
	 * Makes sizeY a readable variable to other objects
	 * @return
	 */
	public int sizeY() {
		return this.sizeY;
	}
}
