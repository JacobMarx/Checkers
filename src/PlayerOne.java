
public class PlayerOne extends CPieces {

	public static int[] piecesrowsone = new int[12];
	public static int[] piecescolumnsone = new int[12];
	
	public void PlayerOne() {
		
		for (int i = 0; i < piecesrowsone.length; i ++) {
			if (i >= 0 && i <= 3) {
				piecesrowsone[i] = 0;
			}
			if (i >= 5 && i <= 7) {
				piecesrowsone[i] = 1;
			}
			if (i >= 8 && i <= 11) {
				piecesrowsone[i] = 2;
			}
		
		}
		for (int j = 0; j < piecescolumnsone.length; j++) {
			if (j >= 0 && j <= 3) {
				piecescolumnsone[j] = 2 * j + 1;
			}
			if (j >= 4 && j <= 7) {
				piecescolumnsone[j] = 2 * j - 10;
			}
			if (j >= 8 && j <= 11) {
				piecescolumnsone[j] = 2 * j - 17;
			}
		}
		
		for (int i = 0; i < piecesrowsone.length; i++) {
			piecesrowsone[i] = x;
		}
		
		for (int i = 0; i < piecescolumnsone.length; i++) {
			piecescolumnsone[i] = y;
		}
		
	}
	
	public static int getPOnex(int row) {
		return piecesrowsone[row];
	}
	
	public static int getPOney(int column) {
		return piecescolumnsone[column];
	}
	
}
