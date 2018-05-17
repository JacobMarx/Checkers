import java.awt.Color;

public class PlayerOne extends CPieces {

	int[] piecesrows = new int[12];
	int[] piecescolumns = new int[12];
	
	public void PlayerOne() {
		
		for (int i = 0; i < piecesrows.length -1; i ++) {
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
		for (int j = 0; j < piecescolumns.length -1; j++) {
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
		
		for (int i = 0; i < piecesrows.length -1; i++) {
			piecesrows[i] = x;
		}
		
		for (int i = 0; i < piecescolumns.length -1; i++) {
			piecescolumns[i] = y;
		}
		
	}
	
	int getPOnex(int row) {
		return piecesrows[row];
	}
	
	int getPOney(int column) {
		return piecescolumns[column];
	}
	
}
