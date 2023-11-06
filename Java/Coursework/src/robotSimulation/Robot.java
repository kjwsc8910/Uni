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
	
	public Robot(int x, int y) {
		id = ++robotCount;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Robot rob = new Robot(2, 4);
		Robot robot = new Robot(4, 8);
		System.out.print(rob.toString() + "\n");
		System.out.print(robot.toString() + "\n");
		System.out.print(Robot.robotCount);

	}
	
	public String toString() {
		return "Robot " + this.id + " is at " + this.x + ", " +this.y;
	}
	
	public static int robotCount() {
		return robotCount;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
	
}
