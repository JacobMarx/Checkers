import java.awt.Color;

public class PlayerOne extends CPieces {

	int[] piecesrows = new int[12];
	int[] piecescolumns = new int[12];
	
	public void PlayerOne() {
		
		for (int i = 0; i < piecesrows.length; i ++) {
			if (i >= 0 && i <= 4) {
				piecesrows[i] = 0;
			}
			if (i >= 5 && i <= 8) {
				piecesrows[i] = 1;
			}
			if (i >= 9 && i <= 12) {
				piecesrows[i] = 2;
			}
		
		}
		for (int j = 0; j < piecescolumns.length; j++) {
			if (j >= 0 && j <= 4) {
				piecescolumns[j] = 2 * j + 1;
			}
			if (j >= 5 && j <= 8) {
				piecescolumns[j] = 2 * j - 10;
			}
			if (j >= 9 && j <= 12) {
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
