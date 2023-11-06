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
	private Robot[] robots = new Robot[5];
	
	public RobotArena (int sizeX, int sizeY) {
		this.id = ++arenas;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RobotArena arena = new RobotArena(10, 20);
		arena.addRobot();
		arena.addRobot();
		System.out.print(arena.toString());
		
	}
		
	public void addRobot() {
		boolean searching = true;
		int x = 0, y = 0;
		while(searching) {
			searching = false;
			x = 1 + (int)(Math.random() * ((sizeX - 1) + 1));
			y = 1 + (int)(Math.random() * ((sizeY - 1) + 1));
			for (int i = 0; i < robots.length; ++i) {
				if(robots[i] != null) if(robots[i].x() == x && robots[i].y() == y) searching = true;
			} 
		}
		
		
		robots[Robot.robotCount()] = new Robot(x, y);
	}
	
	public String toString() {
		String output = "Arena " + this.id + " is " + this.sizeX + "x" + this.sizeY;
		for (int i = 0; i < robots.length; ++i) {
			if(robots[i] != null) output += "\n" + robots[i].toString();
		}
		return output;
	}

}
