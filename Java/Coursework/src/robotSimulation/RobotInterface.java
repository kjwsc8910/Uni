package robotSimulation;

import java.util.Scanner;

/**
 * Simple program to show arena with multiple robots
* @author shsmchlr
 *
 */
public class RobotInterface {
	
	private Scanner s;								// scanner used for input from user
    private RobotArena myArena;				// arena in which Robots are shown
    /**
    	 * constructor for RobotInterface
    	 * sets up scanner used for input and the arena
    	 * then has main loop allowing user to enter commands
     */
    public RobotInterface() {
    	 s = new Scanner(System.in);			// set up scanner for user input
    	 myArena = new RobotArena(20, 6);	// create arena of size 20*6
    	
        char ch = ' ';
        do {
        	System.out.print("Enter (A)dd Robot, get (I)nformation, (D)isplay canvas or e(X)it > ");
        	ch = s.next().charAt(0);
        	s.nextLine();
        	switch (ch) {
    			case 'A' :
    			case 'a' :
        					myArena.addRobot();	// add a new Robot to arena
        					break;
        		case 'I' :
        		case 'i' :
        					System.out.print(myArena.toString() + "\n");
            				break;
        		case 'D' :
        		case 'd' :
        					doDisplay(); // display the canvas
        					break;
        		case 'x' : 	ch = 'X';				// when X detected program ends
        					break;
        	}
    		} while (ch != 'X');						// test if end
        
       s.close();									// close scanner
    }
    
	public static void main(String[] args) {
		RobotInterface r = new RobotInterface();	// just call the interface
	}
	
	/**
	 * Display the robot arena on the console
	 */
	void doDisplay() {
		ConsoleCanvas canvas = new ConsoleCanvas(myArena.sizeX() + 2, myArena.sizeY() + 2, "31000799");
		myArena.showRobots(canvas);
		System.out.println(canvas.toString());
	}

}