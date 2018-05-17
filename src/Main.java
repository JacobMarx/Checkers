import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	
	JFrame frame = new JFrame();
	
	Draw game = new Draw();

	Container south = new Container();
	
	Container easts = new Container();
	Container centers = new Container();
	Container wests = new Container();
	
	JTextField playerOne = new JTextField("Player One");
	JTextField playerTwo = new JTextField("Player Two");
	
	JButton twoPlayer = new JButton("2 Player");
	JButton vsAi = new JButton("Ai");
	JButton start = new JButton("Start");
	JButton end = new JButton("End");
	JButton reset = new JButton("Reset");
	
	public Main() {
		frame.setSize(1000,1200);
		frame.setLayout(new BorderLayout());
		
		frame.add(game, BorderLayout.CENTER);
		
		south.setLayout(new BorderLayout());
		south.add(easts, BorderLayout.EAST);
		
		wests.setLayout(new GridLayout(3,1));
		wests.add(playerOne);
		wests.add(playerTwo);
		
		centers.setLayout(new GridLayout(2,1));
		centers.add(twoPlayer);
		centers.add(vsAi);
		
		easts.setLayout(new GridLayout(3,1));
		easts.add(start);
		easts.add(end);
		easts.add(reset);
		
		south.add(centers, BorderLayout.CENTER);
		south.add(wests, BorderLayout.WEST);
		frame.add(south, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();

	}

}
