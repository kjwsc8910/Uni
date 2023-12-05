package robotSimulation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple program to show arena with multiple robots
* @author shsmchlr
 *
 */
public class RobotInterface {
	
	private Scanner s;								// scanner used for input from user
    private RobotArena myArena;				// arena in which Robots are shown
    private ConsoleCanvas canvas;
    private TextFile textFile;
    /**
    	 * constructor for RobotInterface
    	 * sets up scanner used for input and the arena
    	 * then has main loop allowing user to enter commands
     */
    public RobotInterface() {
    	 s = new Scanner(System.in);			// set up scanner for user input
    	 myArena = new RobotArena(20, 6);	// create arena of size 20*6
    	 textFile = new TextFile("Text File", "txt");
    	
        char ch = ' ';
        do {
        	System.out.print("Enter (A)dd Robot, get (I)nformation, (D)isplay canvas, (M)ove all Robots Once, A(n)imate for 10 moves, Ne(w) arena, (S)ave, (L)oad or e(X)it > ");
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
        		case 'M' :
        		case 'm' :
        					myArena.moveAllRobots();
        					break;
        		case 'N' :
        		case 'n' :
        					canvas = new ConsoleCanvas(myArena.sizeX() + 2, myArena.sizeY() + 2, "31000799");
        					myArena.animate(canvas, 10);
        					break;
        		case 'W' :
        		case 'w' :
        					System.out.print("Specify Size of X Axis (min of 6): ");
        					int x = s.nextInt();
        					s.nextLine();
        					System.out.print("Specify Size of Y Axis: ");
        					int y = s.nextInt();
        					s.nextLine();
        					myArena = new RobotArena(x, y);
        					break;
        		case 'S' :
        		case 's' :
        					textFile.createFile();
        					textFile.writeAllFile(myArena.toString());
        					break;
        		case 'L' :
        		case 'l' :
        					loadArena();
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
		canvas = new ConsoleCanvas(myArena.sizeX() + 2, myArena.sizeY() + 2, "31000799");
		myArena.showRobots(canvas);
		System.out.println(canvas.toString());
	}
	
	/**
	 * Reads a .txt file and creates an arena and adds robots to match
	 */
	void loadArena() {
		ArrayList<Integer> data = new ArrayList<Integer>();
		textFile.openFile();
		textFile.getNextline();
		Pattern p = Pattern.compile("\\d+");
	    Matcher m = p.matcher(textFile.nextLine());
	    while(m.find()) {
	        data.add(Integer.parseInt(m.group()));
	    }
	    myArena = new RobotArena( data.get(1), data.get(2));
	    while(textFile.getNextline()) {
	    	p = Pattern.compile("\\d+");
		    m = p.matcher(textFile.nextLine());
		    data.clear();
		    while(m.find()) {
		        data.add(Integer.parseInt(m.group()));
		    }
		    if(textFile.nextLine().contains("North")) myArena.addRobot(data.get(0), data.get(1), Direction.North);
	    	if(textFile.nextLine().contains("East")) myArena.addRobot(data.get(0), data.get(1), Direction.East);
    		if(textFile.nextLine().contains("South")) myArena.addRobot(data.get(0), data.get(1), Direction.South);
			if(textFile.nextLine().contains("West")) myArena.addRobot(data.get(0), data.get(1), Direction.West);
		    
	    }
	}

}