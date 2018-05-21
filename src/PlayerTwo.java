
public class PlayerTwo extends CPieces {

	int[] piecesrowstwo = new int[12];
	int[] piecescolumnstwo = new int[12];
	
	public void PlayerOne() {
		
		for (int i = 0; i < piecesrowstwo.length; i ++) {
			if (i >= 0 && i <= 3) {
				piecesrowstwo[i] = 0;
			}
			if (i >= 5 && i <= 7) {
				piecesrowstwo[i] = 1;
			}
			if (i >= 8 && i <= 11) {
				piecesrowstwo[i] = 2;
			}
		
		}
		for (int j = 0; j < piecescolumnstwo.length; j++) {
			if (j >= 0 && j <= 3) {
				piecescolumnstwo[j] = 2 * j + 1;
			}
			if (j >= 4 && j <= 7) {
				piecescolumnstwo[j] = 2 * j - 10;
			}
			if (j >= 8 && j <= 11) {
				piecescolumnstwo[j] = 2 * j - 17;
			}
		}
		
		for (int i = 0; i < piecesrowstwo.length; i++) {
			piecesrowstwo[i] = x;
		}
		
		for (int i = 0; i < piecescolumnstwo.length; i++) {
			piecescolumnstwo[i] = y;
		}
		
	}
	
	int getPTwox(int row) {
		return piecesrowstwo[row];
	}
	
	int getPTwoy(int column) {
		return piecescolumnstwo[column];
	}
	
}
