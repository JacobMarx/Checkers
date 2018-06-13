/* This class draws the board and pieces for the Checkers game
 * Date: June 13, 2018
 * Authors: Jacob Marx and Vivek Kumar
 * Supervisor: Jason Galbraith
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Stroke;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Draw extends JPanel{
	
	public void paintComponent(Graphics g) {//Draws the board + pieces for the game
		super.paintComponent(g);
		
		
		if (Main.twoForwardLeftAI == true) {
			g.setColor(Color.PINK);
			g.drawRect(((Main.columnAI - 1) * 70) + 30, ((Main.rowAI - 1) * 70) + 30, 70, 70);
			g.drawRect(((Main.columnAI - 1) * 70) + 30, ((Main.rowAI - 1) * 70) + 30, 69, 69);
			g.drawRect(((Main.columnAI - 1) * 70) + 30, ((Main.rowAI - 1) * 70) + 30, 68, 68);
		}
		if (Main.twoForwardRightAI == true) {
			g.setColor(Color.PINK);
			g.drawRect(((Main.columnAI + 1) * 70) + 30, ((Main.rowAI - 1) * 70) + 30, 70, 70);
			g.drawRect(((Main.columnAI + 1) * 70) + 30, ((Main.rowAI - 1) * 70) + 30, 69, 69);
			g.drawRect(((Main.columnAI + 1) * 70) + 30, ((Main.rowAI - 1) * 70) + 30, 68, 68);
		}
		if (Main.twoForwardLeftJumpAI == true) {
			g.setColor(Color.PINK);
			g.drawRect(((Main.columnAI - 2) * 70) + 30, ((Main.rowAI - 2) * 70) + 30, 70, 70);
			g.drawRect(((Main.columnAI - 2) * 70) + 30, ((Main.rowAI - 2) * 70) + 30, 69, 69);
			g.drawRect(((Main.columnAI - 2) * 70) + 30, ((Main.rowAI - 2) * 70) + 30, 68, 68);
		}
		if (Main.twoForwardRightJumpAI == true) {
			g.setColor(Color.PINK);
			g.drawRect(((Main.columnAI + 2) * 70) + 30, ((Main.rowAI - 2) * 70) + 30, 70, 70);
			g.drawRect(((Main.columnAI + 2) * 70) + 30, ((Main.rowAI - 2) * 70) + 30, 69, 69);
			g.drawRect(((Main.columnAI + 2) * 70) + 30, ((Main.rowAI - 2) * 70) + 30, 68, 68);
		}
		if (Main.twoBackwardLeftJumpAI == true) {
			g.setColor(Color.PINK);
			g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 70, 70);
			g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 69, 69);
			g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 68, 68);
		}
		if (Main.twoBackwardRightJumpAI == true) {
			g.setColor(Color.PINK);
			g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 70, 70);
			g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 69, 69);
			g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 68, 68);
		}
		if (Main.twoBackwardLeftAI == true) {
			g.setColor(Color.PINK);
			g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 70, 70);
			g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 69, 69);
			g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 68, 68);
		}
		if (Main.twoBackwardRightAI == true) {
			g.setColor(Color.PINK);
			g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 70, 70);
			g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 69, 69);
			g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 68, 68);
		}
		//Checker board
		//creates white backboard for checker board
		g.setColor(Color.WHITE); 
		g.fillRect(30, 30, 560, 560);
		g.setColor(Color.WHITE);

		//creates the black squares for the checker board
		for (int a = 100; a <= 550 ; a = a + 140) {
			for (int b = 30; b <= 550; b = b + 140) {
				g.setColor(Color.BLACK); 
				g.fillRect(a, b, 70, 70);
			}
		}
		for (int a = 30; a < 550; a = a + 140) {
			for (int b = 100; b < 550; b = b + 140) {
				g.setColor(Color.BLACK);
				g.fillRect(a, b, 70, 70);
			}
		}
	
		//Game Pieces
		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				if (Main.cells[a][b] == 1) { //Draws Player 1 Pieces
					g.setColor(Color.YELLOW);
					g.fillOval(((a * 70) + 30) + 15, ((b * 70) + 30) + 15, 40, 40);
				}
				else if (Main.cells[a][b] == 2) { //Draws Player 2 Pieces
					g.setColor(Color.RED);
					g.fillOval(((a * 70) + 30) + 15, ((b * 70) + 30) + 15, 40, 40);
				}
				else if (Main.cells[a][b] == 3) { //Draws Player 1 King w/ White Dot
					g.setColor(Color.YELLOW);
					g.fillOval(((a * 70) + 30) + 15, ((b * 70) + 30) + 15, 40, 40);
					g.setColor(Color.WHITE);
					g.fillOval(((a * 70) + 30) + 25, ((b * 70) + 30) + 25, 20, 20);
				}
				else if (Main.cells[a][b] == 4) { //Draws Player 2 King w/ White Dot
					g.setColor(Color.RED);
					g.fillOval(((a * 70) + 30) + 15, ((b * 70) + 30) + 15, 40, 40);
					g.setColor(Color.WHITE);
					g.fillOval(((a * 70) + 30) + 25, ((b * 70) + 30) + 25, 20, 20);
				}
			}
		}
		//Highlighted squares
		if (Main.cellColor == true) { //Begin highlighting squares and possible moves (if applicable)
			//highlights first selected piece - Color Green
			g.setColor(Color.GREEN);
			g.drawRect((Main.column * 70) + 30, (Main.row * 70) + 30, 70, 70);
			g.drawRect((Main.column * 70) + 30, (Main.row * 70) + 30, 69, 69);
			g.drawRect((Main.column * 70) + 30, (Main.row * 70) + 30, 68, 68);
			
			//Blue - Player 1 & Pink - Player 2
			if (Main.forwardRight == true) { //Highlights fowardRight column w/ 3 layers for emphasis - Color Blue
				g.setColor(Color.BLUE);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 70, 70);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 69, 69);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 68, 68);
			}
			if (Main.backwardRight == true) {
				g.setColor(Color.BLUE);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 70, 70);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 69, 69);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 68, 68);
			}
			if (Main.forwardLeft == true) {
				g.setColor(Color.BLUE);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 70, 70);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 69, 69);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 68, 68);
			}
			if (Main.backwardLeft == true) {
				g.setColor(Color.BLUE);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 70, 70);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 69, 69);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 68, 68);
			}
			if (Main.forwardRightJump == true) {
				g.setColor(Color.BLUE);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 70, 70);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 69, 69);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 68, 68);
			}
			if (Main.backwardRightJump == true) {
				g.setColor(Color.BLUE);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 70, 70);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 69, 69);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 68, 68);
			}
			if (Main.forwardLeftJump == true) {
				g.setColor(Color.BLUE);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 70, 70);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 69, 69);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 68, 68);
			}
			if (Main.backwardLeftJump == true) {
				g.setColor(Color.BLUE);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 70, 70);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 69, 69);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 68, 68);
			}
			if (Main.twoForwardLeft == true) {
				g.setColor(Color.PINK);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 70, 70);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 69, 69);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 68, 68);
			}
			if (Main.twoBackwardLeft == true) {
				g.setColor(Color.PINK);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 70, 70);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 69, 69);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 68, 68);
			}
			if (Main.twoForwardRight == true) {
				g.setColor(Color.PINK);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 70, 70);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 69, 69);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 68, 68);
			}
			if (Main.twoBackwardRight == true) {
				g.setColor(Color.PINK);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 70, 70);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 69, 69);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 68, 68);
			}
			if (Main.twoForwardRightJump == true) {
				g.setColor(Color.PINK);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 70, 70);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 69, 69);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 68, 68);
			}
			if (Main.twoBackwardRightJump == true) {
				g.setColor(Color.PINK);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 70, 70);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 69, 69);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 68, 68);
			}
			if (Main.twoForwardLeftJump == true) {
				g.setColor(Color.PINK);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 70, 70);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 69, 69);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 68, 68);
			}
			if (Main.twoBackwardLeftJump == true) {
				g.setColor(Color.PINK);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 70, 70);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 69, 69);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 68, 68);
			}
		return;
		}	
	}
}