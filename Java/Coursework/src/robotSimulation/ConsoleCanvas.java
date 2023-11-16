package robotSimulation;

import java.util.Arrays;

public class ConsoleCanvas {

	private char[][] display;
	private int x, y;
	
	/**
	 * A constructor for ConsoleCanvas that sets its x and y size and gives it
	 * a name, It then sets up the Canvas to be surrounded with #
	 * @param x Size
	 * @param y Size
	 * @param name To display
	 */
	public ConsoleCanvas(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.display = new char[x][y];
		
		for (char[] row : this.display) {
			Arrays.fill(row, ' ');
		}
		for(int i = 0; i < x; ++i) {
			this.display[i][0] = '#';
			this.display[i][y - 1] = '#';
		}
		for(int i = 0; i < y; ++i) {
			this.display[0][i] = '#';
			this.display[x-1][i] = '#';
		}
		for(int i = 0; i < 8; ++i) {
			this.display[(x/2)-4+i][y-1] = name.charAt(i);
		}
	}
	

	
	public static void main(String[] args) {
		ConsoleCanvas c = new ConsoleCanvas(10, 5, "31000799");
		c.showIt(4, 3, 'R');
		System.out.println(c.toString());
	}
	
	/**
	 * Displays a letter at a position
	 * @param x Position
	 * @param y Position
	 * @param letter to display
	 */
	public void showIt(int x, int y, char letter) {
		this.display[x][y] = letter;
	}
	
	/**
	 * @Returns the canvas in a string form
	 */
	public String toString() {
		String result = "";
		for(int y = this.y - 1; y >= 0; --y) {
			for(int x = 0; x < this.x; ++x) {
				result += this.display[x][y];
			}
			result += "\n";
		}
		return result;
	}
	
}
