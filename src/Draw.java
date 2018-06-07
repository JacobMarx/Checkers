import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Stroke;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Draw extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//checker board
		g.setColor(Color.WHITE);
		g.fillRect(30, 30, 560, 560);
		g.setColor(Color.WHITE);

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
	
		//game pieces
		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				if (Main.cells[a][b] == 1) {
					g.setColor(Color.YELLOW);
					g.fillOval(((a * 70) + 30) + 15, ((b * 70) + 30) + 15, 40, 40);
				}
				else if (Main.cells[a][b] == 2) {
					g.setColor(Color.RED);
					g.fillOval(((a * 70) + 30) + 15, ((b * 70) + 30) + 15, 40, 40);
				}
				else if (Main.cells[a][b] == 3) {
					g.setColor(Color.YELLOW);
					g.fillOval(((a * 70) + 30) + 15, ((b * 70) + 30) + 15, 40, 40);
					g.setColor(Color.WHITE);
					g.fillRect(((a * 70) + 30) + 15, ((b * 70) + 30) + 15, 20, 20);
				}
				else if (Main.cells[a][b] == 4) {
					g.setColor(Color.RED);
					g.fillOval(((a * 70) + 30) + 15, ((b * 70) + 30) + 15, 40, 40);
					g.setColor(Color.WHITE);
					g.fillRect(((a * 70) + 30) + 15, ((b * 70) + 30) + 15, 20, 20);
				}
				
			}
		}
		
		for (int i = 0; i < 12; i++) {
			
		}
		
		if (Main.cellColor == true) {
			g.setColor(Color.GREEN);
			g.drawRect((Main.column * 70) + 30, (Main.row * 70) + 30, 70, 70);
			g.drawRect((Main.column * 70) + 30, (Main.row * 70) + 30, 69, 69);
			g.drawRect((Main.column * 70) + 30, (Main.row * 70) + 30, 68, 68);
			
			if (Main.forwardRight == true) {
				g.setColor(Color.BLUE);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 70, 70);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 69, 69);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 68, 68);
			}
			if (Main.forwardLeft == true) {
				g.setColor(Color.BLUE);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 70, 70);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 69, 69);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row + 1) * 70) + 30, 68, 68);
			}
			if (Main.forwardRightJump == true) {
				g.setColor(Color.BLUE);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 70, 70);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 69, 69);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 68, 68);
			}
			if (Main.forwardLeftJump == true) {
				g.setColor(Color.BLUE);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 70, 70);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 69, 69);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row + 2) * 70) + 30, 68, 68);
			}
			if (Main.twoForwardLeft == true) {
				g.setColor(Color.PINK);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 70, 70);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 69, 69);
				g.drawRect(((Main.column - 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 68, 68);
			}
			if (Main.twoForwardRight == true) {
				g.setColor(Color.PINK);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 70, 70);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 69, 69);
				g.drawRect(((Main.column + 1) * 70) + 30, ((Main.row - 1) * 70) + 30, 68, 68);
			}
			if (Main.twoForwardRightJump == true) {
				g.setColor(Color.PINK);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 70, 70);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 69, 69);
				g.drawRect(((Main.column + 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 68, 68);
			}
			if (Main.twoForwardLeftJump == true) {
				g.setColor(Color.PINK);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 70, 70);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 69, 69);
				g.drawRect(((Main.column - 2) * 70) + 30, ((Main.row - 2) * 70) + 30, 68, 68);
			}
		return;
		}
		
	}

}
