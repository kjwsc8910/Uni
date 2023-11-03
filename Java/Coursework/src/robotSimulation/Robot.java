/**
 * 
 */
package robotSimulation;

/**
 * 
 */
public class Robot {

	private static int robots = 0;
	private int id, x, y;
	
	public Robot(int x, int y) {
		id = ++robots;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Robot rob = new Robot(2, 4);
		System.out.print(rob.id);
	}

}
