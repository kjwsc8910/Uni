/**
 * 
 */
package robotSimulation;

/**
 *
 */
public class Robot {

	private static int robotCount = 0;
	private int id, x, y;
	private RobotArena arena;
	private Direction direction;
	
	/**
	 * A constructor for the Robot that sets its position and updates
	 * the number of robots
	 * @param x Position of the robot
	 * @param y Position of the robot
	 * @param direction the robot is facing
	 */
	public Robot(int x, int y, Direction direction) {
		id = ++robotCount;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Robot rob = new Robot(2, 4, Direction.North);
		Robot robot = new Robot(4, 8, Direction.West);
		System.out.print(rob.toString() + "\n");
		System.out.print(robot.toString() + "\n");
		System.out.print(Robot.robotCount);
		rob.tryToMove();
		robot.tryToMove();
	}
	
	/**
	 * display the Robot in the canvas
	 * @param c the canvas used
	 */
	public void displayRobot (ConsoleCanvas c) {
		c.showIt(this.x + 1, this.y + 1, 'R');
	}
	
	/**
	 * Attempts to move the Robot
	 */
	public void tryToMove () {
		int nX = x, nY = y;
		if(direction == Direction.North) ++nY;
		if(direction == Direction.East) ++nX;
		if(direction == Direction.South) --nY;
		if(direction == Direction.West) --nX;
		if(canMoveHere(nX, nY)) {
			x = nX;
			y = nY;
			return;
		}
		direction = direction.next();
		tryToMove();
	}
	
	/**
	 * Checks if the robot can move to a location
	 * @param x position
	 * @param y position
	 * @return
	 */
	public boolean canMoveHere (int x, int y) {
		if((x < 0 || y < 0) || (x >= this.arena.sizeX() || y >= this.arena.sizeY())) return false;
		return arena.isFree(x, y);
	}
	
	/**
	 * @Returns the information about a Robot in string form
	 */
	public String toString() {
		return "Robot " + this.id + " is at " + this.x + ", " +this.y + " Facing " + this.direction;
	}
	
	/**
	 * Makes robotCount Readable
	 * @return
	 */
	public static int robotCount() {
		return robotCount;
	}
	
	/**
	 * Makes x position Readable
	 * @return
	 */
	public int x() {
		return x;
	}
	
	/**
	 * Makes y position Readable
	 * @return
	 */
	public int y() {
		return y;
	}
	
	/**
	 * Allows another object to set the Robots arena
	 * @param arena
	 */
	public void setArena(RobotArena arena) {
		this.arena = arena;
	}
	
}
