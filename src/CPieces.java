
public class CPieces {
	
	int[] twopieces = new int[12];
	int[] onepieces = new int[12];
	int[][] board = new int[8][8];

	
	public void CPieces() {
		startup();
		
		
	}
	
	public void startup() {
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = 0;
			}
		}
		
		for (int i = 0; i < 12; i++) {
			onepieces[i] = 1;
			twopieces[i] = 2;
		}
		
		onepieces[0] = board[0][1];
		onepieces[1] = board[0][3];
		onepieces[2] = board[0][5];
		onepieces[3] = board[0][7];
		onepieces[4] = board[1][0];
		onepieces[5] = board[1][2];
		onepieces[6] = board[1][4];
		onepieces[7] = board[1][6];
		onepieces[8] = board[2][1];
		onepieces[9] = board[2][3];
		onepieces[10] = board[2][5];
		onepieces[11] = board[2][7];
		
		twopieces[0] = board[5][0];
		twopieces[0] = board[5][2];
		twopieces[0] = board[5][4];
		twopieces[0] = board[5][6];
		twopieces[0] = board[6][1];
		twopieces[0] = board[6][3];
		twopieces[0] = board[6][5];
		twopieces[0] = board[6][7];
		twopieces[0] = board[7][0];
		twopieces[0] = board[7][2];
		twopieces[0] = board[7][4];
		twopieces[0] = board[7][6];

		
		
		
		
		
	}
	
	

}
