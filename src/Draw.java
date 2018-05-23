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
		g.setColor(Color.WHITE);
		g.fillRect(30, 30, 560, 560);
		g.setColor(Color.WHITE);
		
		//checker board
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
	
		//top game pieces
		
		/*
		for (int l = 0; l < 12; l++) {
			System.out.println(l);
		    g.setColor(Color.YELLOW);
			g.fillOval((PlayerOne.getPOney(l) * 70) + 45, (PlayerOne.getPOnex(l) * 70) + 45, 40, 40);
		}
		*/
		
		for (int a = 30; a < 550; a = a + 140) {
			for (int b = 100; b <=100; b = b + 140) {
				g.setColor(Color.YELLOW);
				g.fillOval(a + 15, b + 15, 40, 40);
			}
		}
		for (int a = 100; a <= 550; a = a + 140) {
			for (int b = 30; b < 280; b = b + 140) {
				g.setColor(Color.YELLOW);
				g.fillOval(a + 15, b + 15, 40, 40);
			}
		}
		
		
		//bottom game pieces
		for (int a = 30; a < 550; a = a + 140) {
			for (int b = 380; b <=520; b = b + 140) {
				g.setColor(Color.RED);
				g.fillOval(a + 15, b + 15, 40, 40);
			}
		}
		for (int a = 100; a <= 550; a = a + 140) {
			for (int b = 450; b <= 450; b = b + 140) {
				g.setColor(Color.RED);
				g.fillOval(a + 15, b + 15, 40, 40);
			}
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
			
		}
		
	}

}
