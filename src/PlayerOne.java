import java.awt.Color;

public class PlayerOne extends CPieces {

	int[] piecesrows = new int[11];
	int[] piecescolumns = new int[11];
	
	public void PlayerOne() {
		
		for (int i = 0; i < piecesrows.length; i ++) {
			if (i >= 0 && i <= 3) {
				piecesrows[i] = 0;
			}
			if (i >= 5 && i <= 7) {
				piecesrows[i] = 1;
			}
			if (i >= 8 && i <= 11) {
				piecesrows[i] = 2;
			}
		
		}
		for (int j = 0; j < piecescolumns.length; j++) {
			if (j >= 0 && j <= 3) {
				piecescolumns[j] = 2 * j + 1;
			}
			if (j >= 4 && j <= 7) {
				piecescolumns[j] = 2 * j - 10;
			}
			if (j >= 8 && j <= 11) {
				piecescolumns[j] = 2 * j - 17;
			}
		}
		
	}
	
	public int getPOnex() {
		return x;
	}
	
	public int getPOney() {
		return y;
	}
	
}
