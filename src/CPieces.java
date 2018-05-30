
public class CPieces{
	
	public static int[] twopieces = new int[12];
	public static int[] onepieces = new int[12];
	//public static int[][] board = new int[8][8];

	
	/*public CPieces() {
		startup();
		
		
	}*/
	
	public CPieces() {
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Main.cells[i][j] = 0;
			}
		}
		
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
		
		for (int i = 0; i < 12; i++) {
			onepieces[i] = 1;
			twopieces[i] = 2;
		}
		
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
