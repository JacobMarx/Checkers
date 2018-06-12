/* This class sets the appropriate pieces for the Checkers game
 * Date: June 13, 2018
 * Authors: Jacob Marx and Vivek Kumar
 * Supervisor: Jason Galbraith
 */
public class CPieces{
	
	//Create arrays for both sets of pieces
	public static int[] twopieces = new int[12]; 
	public static int[] onepieces = new int[12];
	
	public CPieces() {
		
		//First, set all of the pieces to empty
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Main.cells[i][j] = 0;
			}
		}
		
		//Second, set all the white rectangles to 9, to ensure a piece never moves there
		for (int i = 0; i < 8; i = i + 2) {
			for (int j = 0; j < 8; j = j + 2) {
				Main.cells[i][j] = 9;
			}
		}
		
		for (int i = 1; i < 8; i = i + 2) {
			for (int j = 1; j < 8; j = j + 2) {
				Main.cells[i][j] = 9;
			}
		}
		
		//Third, set all the Player 1 Pieces to 1 and Player 2 Pieces to 2
		for (int i = 0; i < 12; i++) {
			onepieces[i] = 1;
			twopieces[i] = 2;
		}
		//Set the pieces based on the starting set-up of the game
		Main.cells[1][0] = onepieces[0];
		Main.cells[3][0] = onepieces[1];
		Main.cells[5][0] = onepieces[2];
		Main.cells[7][0] = onepieces[3];
		Main.cells[0][1] = onepieces[4];
		Main.cells[2][1] = onepieces[5];
		Main.cells[4][1] = onepieces[6];
		Main.cells[6][1] = onepieces[7];
		Main.cells[1][2] = onepieces[8];
		Main.cells[3][2] = onepieces[9];
		Main.cells[5][2] = onepieces[10];
		Main.cells[7][2] = onepieces[11];
		
		Main.cells[0][5] = twopieces[0];
		Main.cells[2][5] = twopieces[1];
		Main.cells[4][5] = twopieces[2];
		Main.cells[6][5] = twopieces[3];
		Main.cells[1][6] = twopieces[4];
		Main.cells[3][6] = twopieces[5];
		Main.cells[5][6] = twopieces[6];
		Main.cells[7][6] = twopieces[7];
		Main.cells[0][7] = twopieces[8];
		Main.cells[2][7] = twopieces[9];
		Main.cells[4][7] = twopieces[10];
		Main.cells[6][7] = twopieces[11];
	}
}