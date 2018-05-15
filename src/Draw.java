import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Draw extends JPanel{

	public Draw() {
		super();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.WHITE);
		for (int a = 0; a < 800 ; a = a + 200) {
			for (int b = 0; b < 800; b = b + 200) {
				g.fillRect(a, b, 100, 100);
			}
		}
		
	}

}
