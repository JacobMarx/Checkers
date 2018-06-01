import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main implements MouseListener, ActionListener{
	
	public static boolean cellColor = false;
	public static boolean forwardRight = false;
	public static boolean forwardLeft = false;
	public static boolean forwardRightJump = false;
	public static boolean forwardLeftJump = false;
	public static boolean twoForwardRight = false;
	public static boolean twoForwardLeft = false;
	public static boolean twoForwardRightJump = false;
	public static boolean twoForwardLeftJump = false;
	public static boolean playMade = false;
	public static int column;
	public static int row;
	
	int move = 0;
	int moveCounter = 0;
	int piecesCounter = 0;
	
	double width = 70;
	double height = 70;

	JFrame frame = new JFrame();
	
	Draw draw = new Draw();

	public static int[][] cells = new int[8][8];
	int twoPlayer_state = 0;
	int vsAi_state = 0;
	int playerMove = 1;

	Container south = new Container();
	Container east = new Container();
	Container easts = new Container();
	Container centers = new Container();
	Container wests = new Container();
	
	JLabel playerOne = new JLabel("Player One");
	JLabel playerTwo= new JLabel("Player Two");
	
	JButton twoPlayer = new JButton("2 Player");
	JButton vsAi = new JButton("Computer");
	JButton start = new JButton("Start");
	JButton end = new JButton("End");
	JButton reset = new JButton("Reset");
	JButton info = new JButton("Welcome to Checkers. Select your Preferences.");
	
	public Main() {
		frame.setSize(1000,800);
		frame.setLayout(new BorderLayout());
		
		frame.add(draw, BorderLayout.CENTER);
		draw.addMouseListener(this);

		new CPieces();
		
		south.setLayout(new BorderLayout());
		south.add(easts, BorderLayout.EAST);
		
		wests.setLayout(new GridLayout(3,1));
		wests.add(playerOne);
		wests.add(playerTwo);
		
		centers.setLayout(new GridLayout(2,1));
		centers.add(twoPlayer);
		centers.add(vsAi);
		twoPlayer.addActionListener(this);
		vsAi.addActionListener(this);
		
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
	if (moveCounter == 0) {
		if (event.getX() <= 560 && event.getY() <= 560) {
			column = Math.min(cells[0].length, (int)((event.getX() - 30)/ width));
			row = Math.min(cells.length , (int)((event.getY() - 30)/ height));
			
			if (cells[column][row] == 1 || cells[column][row] == 2) {
				if (playerMove == 1 && cells[column][row] == 1) {
					cellColor = true;
					draw.repaint();
					if ((column + 1) <= 7 && (row + 1) <= 7) {
						if (cells[column + 1][row + 1] == 0) {
							forwardRight = true;
							draw.repaint();
						}	
					}
					if ((column - 1) >= 0 && (row + 1) <= 7) {
						if (cells[column - 1][row + 1] == 0) {
							forwardLeft = true;
							draw.repaint();
						}
					}
					if ((column + 2) <= 7 && (row + 2) <= 7) {
						if (cells[column + 1][row + 1] == 2 && cells[column + 2][row + 2] == 0) {
							forwardRightJump = true;
							draw.repaint();
						}
					}
					if ((column - 2) >= 0 && (row + 2) <= 7) {
						if (cells[column - 1][row + 1] == 2 && cells[column - 2][row + 2] == 0) {
							forwardLeftJump = true;
							draw.repaint();
						}
					}
					
					if (forwardRight == true || forwardLeft == true || forwardRightJump == true || forwardLeftJump == true) {
						moveCounter = 1;
					}
					if (forwardRight == false && forwardLeft == false && forwardRightJump == false && forwardLeftJump == false) {
						moveCounter = 0;
					}
						
				}
				else if (playerMove == 2 && cells[column][row] == 2) {
					cellColor = true;
					draw.repaint();
					if ((column + 1) <= 7 && (row - 1) >= 0) {
						if (cells[column + 1][row - 1] == 0) {
							twoForwardRight = true;
							draw.repaint();
						}
					}
					if ((column - 1) >= 0 && (row - 1) >= 0) {
						if (cells[column - 1][row - 1] == 0) {
							twoForwardLeft = true;
							draw.repaint();
						}
					}
					if ((column + 2) <= 7 && (row - 2) >= 0) {
						if (cells[column + 1][row - 1] == 1 && cells[column + 2][row - 2] == 0) {
							twoForwardRightJump = true;
							draw.repaint();
						}
					}
					if ((column - 2) >= 0 && (row - 2) >= 0) {
						if (cells[column - 1][row - 1] == 1 && cells[column - 2][row - 2] == 0) {
							twoForwardLeftJump = true;
							draw.repaint();
						}
					}
					if (forwardRight == true || forwardLeft == true || twoForwardRightJump == true || twoForwardLeftJump == true) {
						moveCounter = 1;
					}
					if (forwardRight == false && forwardLeft == false && twoForwardRightJump == false && twoForwardLeftJump == false) {
						moveCounter = 0;
					}
				}
			}
		}
	}
	if (moveCounter == 1) {
		if (event.getX() <= 560 && event.getY() <= 560) {
			int secondColumn;
			int secondRow;
			secondColumn = Math.min(cells[0].length, (int)((event.getX() - 30)/ width));
			secondRow = Math.min(cells.length , (int)((event.getY() - 30)/ height));
			if (cells[secondColumn][secondRow] == 0) {
				if (playerMove == 1 && (forwardRight == true || forwardLeft == true || forwardRightJump == true || forwardLeftJump == true)) {
					if ((column + 1) <= 7 && (row + 1) <= 7) {
						if (secondColumn == column + 1 && secondRow == row + 1) {
							cells[column][row] = 0;
							cells[column + 1][row + 1] = 1;
							//kingStatus();
						}
					}
					if ((column - 1) >= 0 && (row + 1) <= 7) {
						if (secondColumn == column - 1 && secondRow == row + 1) {
							cells[column][row] = 0;
							cells[column - 1][row + 1] = 1;
							//kingStatus();
						}
					}
					if ((column + 2) <= 7 && (row + 2) <= 7) {
						if (secondColumn == column + 2 && secondRow == row + 2) {
							cells[column][row] = 0;
							cells[column + 2][row + 2] = 1;
							cells[column + 1][row + 1] = 0;
							//kingStatus();
						}
					}
					if ((column - 2) >= 0 && (row + 2) <= 7) {
						if (secondColumn == column - 2 && secondRow == row + 2) {
							cells[column][row] = 0;
							cells[column - 2][row + 2] = 1;
							cells[column - 1][row + 1] = 0;
							//kingStatus();
						}
					}
					if ((secondColumn == column - 1 && secondRow == row + 1) || (secondColumn == column + 1 && secondRow == row + 1) || (secondColumn == column + 2 && secondRow == row + 2) || (secondColumn == column - 2 && secondRow == row + 2)) {
						cellColor = false;
						forwardRight = false;
						forwardLeft = false;
						forwardRightJump = false;
						forwardLeftJump = false;
						playerMove = 2;
						moveCounter = 0;
						draw.repaint();
					}
					else if (!(secondColumn == column - 1 && secondRow == row + 1) && !(secondColumn == column + 1 && secondRow == row + 1) && !(secondColumn == column + 2 && secondRow == row + 2) && !(secondColumn == column - 2 && secondRow == row + 2)) {
						cellColor = false;
						forwardRight = false;
						forwardLeft = false;
						forwardRightJump = false;
						forwardLeftJump = false;
						playerMove = 1;
						moveCounter = 0;
						draw.repaint();
					}
				}
				else if (playerMove == 2 && (twoForwardRight == true || twoForwardLeft == true)) {
					if ((column + 1) <= 7 && (row - 1) >= 0)	{
						if (secondColumn == column + 1 && secondRow == row - 1) {
							cells[column][row] = 0;
							cells[column + 1][row - 1] = 2;
							//kingStatus();
						}
					}
					if ((column - 1) >= 0 && (row - 1) >= 0)	{
						if (secondColumn == column - 1 && secondRow == row - 1) {
							cells[column][row] = 0;
							cells[column - 1][row - 1] = 2;
							//kingStatus();
						}
					}
					if ((secondColumn == column + 1 && secondRow == row - 1) || (secondColumn == column - 1 && secondRow == row - 1)) {
						cellColor = false;
						twoForwardRight = false;
						twoForwardLeft = false;
						playerMove = 1;
						moveCounter = 0;
						draw.repaint();
					}
					else if (!(secondColumn == column + 1 && secondRow == row - 1) && !(secondColumn == column - 1 && secondRow == row - 1)) {
						cellColor = false;
						twoForwardRight = false;
						twoForwardLeft = false;
						playerMove = 2;
						moveCounter = 0;
						draw.repaint();
					}
				}
			}
		}	
	}
		
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(twoPlayer)) {
			if (twoPlayer_state == 0) {
				twoPlayer.setBackground(Color.GREEN);
				twoPlayer.setOpaque(true);
				twoPlayer_state = 1;
				frame.repaint();
				return;
			}
			if (twoPlayer_state == 1) {
				twoPlayer.setBackground(Color.LIGHT_GRAY);
				twoPlayer.setOpaque(true);
				twoPlayer_state = 0;
				frame.repaint();
				return;
			}
		}
		if (e.getSource().equals(vsAi)) {
			if (vsAi_state == 0) {
				vsAi.setBackground(Color.GREEN);
				vsAi.setOpaque(true);
				vsAi_state = 1;
				frame.repaint();
				return;
			}
			if (vsAi_state == 1) {
				vsAi.setBackground(Color.LIGHT_GRAY);
				vsAi.setOpaque(true);
				vsAi_state = 0;
				frame.repaint();
				return;
			}
		}
		
	}


	public static void main(String[] args) {
		new Main();

	}
	
	public void kingStatus() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (cells[i][j] == 1 && j == 7) {
					cells[i][j] = 3;
				}
				if (cells[i][j] == 2 && j == 0) {
					cells[i][j] = 4;
				}
			}
		}
	}
	
	public void checkWin() {
		if (playerMove == 2) {
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells.length; j++) {
					if (cells[i][j] == 2 || cells[i][j] == 4) {
						piecesCounter++;
						if (piecesCounter >= 1) {
							//player two wins!!!!!!!!!!!!!!!!!!!!
							piecesCounter = 0;
						}
					}
				}
			}
		}
		if (playerMove == 1) {
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells.length; j++) {
					if (cells[i][j] == 1 || cells[i][j] == 3) {
						piecesCounter++;
						if (piecesCounter >= 1) {
							//player one wins!!!!!!!!!!!!!!!!!!!!
							piecesCounter = 0;
						}
					}
				}
			}
		}
	}

	
}

/* 
	//frame.repaint();
	if ( (cells[column][row] == 1) || (cells[column][row] == 2)){
		if (playerMove == 1 && cells[column][row] == 1) {
			//while (playMade == false) {
					cellColor = true;
					frame.repaint();
					
				
					//if (((column + 1) <= 7 ) && ((row + 1) <= 7)) {
					//	if (cells[column + 1][row + 1] == 0) {
							System.out.println("compton");
							forwardRight = true;
							
							frame.repaint();
							
					//	}
				
					//}
					if (((column + 1) >= 0) && ((row + 1) <= 7)) {
						if (cells[column - 1][row + 1] == 0) {
							forwardLeft = true;
							frame.repaint();

						}
					}
					//playMade = true;
	
			//}
			//playerMove = 2;
		}
		forwardRight = false;
		forwardLeft = false;
		cellColor = false;

		
	/*	if (playerMove == 2 && cells[column][row] == 2) {
			if (((Main.column + 1) <= 7 && (Main.column + 1) >= 0 && (Main.row + 1) <= 7 && (Main.row + 1) >= 0) &&
					 ((Main.column - 1) <= 7 && (Main.column - 1) >= 0 && (Main.row - 1) <= 7 && (Main.row - 1) >= 0)) {
				cellColor = true;
				if (cells[column - 1][row - 1] == 0) {
					twoForwardLeft = true;
				}
				if (cells[column + 1][row - 1] == 0) {
					twoForwardRight = true;
				}
				frame.repaint();
			}
						
		}
		playerMove = 1;
		twoForwardLeft = false;
		twoForwardRight = false;		
		cellColor = false;
	}
	
}*/ 