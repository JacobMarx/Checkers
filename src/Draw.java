import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JPanel;

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
		
	}
		

}
