import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main implements MouseListener{
	
	JFrame frame = new JFrame();
	
	boolean[][] cells = new boolean[8][8];
	
	Draw draw = new Draw();
	
	//Panel game = new Panel();

	Container south = new Container();
	Container east = new Container();
	Container easts = new Container();
	Container centers = new Container();
	Container wests = new Container();
	
	JTextField playerOne = new JTextField("Player One");
	JTextField playerTwo = new JTextField("Player Two");
	
	JButton twoPlayer = new JButton("2 Player");
	JButton vsAi = new JButton("Computer");
	JButton start = new JButton("Start");
	JButton end = new JButton("End");
	JButton reset = new JButton("Reset");
	JButton info = new JButton("Welcome to Checkers. Select your Preferences.");
	
	public Main() {
		frame.setSize(1000,1200);
		frame.setLayout(new BorderLayout());
		
		frame.add(draw, BorderLayout.CENTER);
		draw.addMouseListener(this);

		
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
		
		frame.add(info, BorderLayout.EAST);
		
		south.add(centers, BorderLayout.CENTER);
		south.add(wests, BorderLayout.WEST);
		frame.add(south, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.repaint();
		
	}

	public void Move() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent event) 
	{
	}

	@Override
	public void mouseEntered(MouseEvent event)
	{	
	}

	@Override
	public void mouseExited(MouseEvent event) 
	{
	}

	@Override
	public void mousePressed(MouseEvent event) 
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent event) 
	{
		double width = 70;

		double height = 70;

		int column = Math.min(cells[0].length, (int)((event.getX() - 30)/ width));
		int row = Math.min(cells.length , (int)((event.getY() - 30)/ height));
		System.out.println(column + "," + row);
		cells[row][column] = !cells[row][column];
		frame.repaint();
	}

	public static void main(String[] args) {
		new Main();

	}

}
