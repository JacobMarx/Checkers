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
	public static boolean backwardRight = false;
	public static boolean backwardLeft = false;
	public static boolean backwardRightJump = false;
	public static boolean backwardLeftJump = false;
	public static boolean twoForwardRight = false;
	public static boolean twoForwardLeft = false;
	public static boolean twoForwardRightJump = false;
	public static boolean twoForwardLeftJump = false;
	public static boolean twoBackwardRight = false;
	public static boolean twoBackwardLeft = false;
	public static boolean twoBackwardRightJump = false;
	public static boolean twoBackwardLeftJump = false;
	public static boolean playMade = false;
	public static int column;
	public static int row;
	
	int move = 0;
	int moveCounter = 0;
	int piecesCounter = 0;
	int twoPiecesCounter = 0;
	
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
	JLabel info = new JLabel("Welcome to Checkers");
	
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
		kingStatus();
		frame.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent event) 
	{
	if (moveCounter == 0) {
		if (event.getX() <= 560 && event.getY() <= 560) {
			column = Math.min(cells[0].length, (int)((event.getX() - 30)/ width));
			row = Math.min(cells.length , (int)((event.getY() - 30)/ height));
			
			if (cells[column][row] == 1 || cells[column][row] == 2 || cells[column][row] == 3 || cells[column][row] == 4) {
				if (playerMove == 1 && cells[column][row] == 1 && twoPlayer_state == 1 && vsAi_state == 0) {
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
						if (forwardRightJump == true || forwardLeftJump == true) {
							forwardRight = false;
							forwardLeft = false;
							moveCounter = 1;
						}
						else if (forwardRightJump == false && forwardLeftJump == false) {
							moveCounter = 1;
						}
					}
					if (forwardRight == false && forwardLeft == false && forwardRightJump == false && forwardLeftJump == false) {
						moveCounter = 0;
					}
						
				}
				else if (playerMove == 1 && cells[column][row] == 3 && twoPlayer_state == 1 && vsAi_state == 0) {
					cellColor = true;
					draw.repaint();
					if ((column + 1) <= 7 && (row + 1) <= 7) {
						if (cells[column + 1][row + 1] == 0) {
							forwardRight = true;
							draw.repaint();
						}	
					}
					if ((column + 1) <= 7 && (row - 1) >= 0) {
						if (cells[column +1][row -1] == 0) {
							backwardRight = true;
							draw.repaint();
						}
					}
					if ((column - 1) >= 0 && (row + 1) <= 7) {
						if (cells[column - 1][row + 1] == 0) {
							forwardLeft = true;
							draw.repaint();
						}
					}
					if ((column - 1) >= 0 && (row - 1) >= 0) {
						if (cells[column - 1][row -1] == 0) {
							backwardLeft = true;
							draw.repaint();
						}
					}
					if ((column + 2) <= 7 && (row + 2) <= 7) {
						if (cells[column + 1][row + 1] == 2 && cells[column + 2][row + 2] == 0) {
							forwardRightJump = true;
							draw.repaint();
						}
					}
					if ((column + 2) <= 7 && (row - 2) >= 0) {
						if (cells[column + 1][row - 1] == 2 && cells[column + 2][row - 2] == 0) {
							backwardRightJump = true;
							draw.repaint();
						}
					}
					if ((column - 2) >= 0 && (row + 2) <= 7) {
						if (cells[column - 1][row + 1] == 2 && cells[column - 2][row + 2] == 0) {
							forwardLeftJump = true;
							draw.repaint();
						}
					}
					if ((column - 2) >= 0 && (row - 2) >= 0) {
						if (cells[column - 1][row - 1] == 2 && cells[column - 2][row - 2] == 0) {
							backwardLeftJump = true;
							draw.repaint();
						}
					}
					if (forwardRight == true || forwardLeft == true || forwardRightJump == true || forwardLeftJump == true || 
							backwardRight == true || backwardLeft == true || backwardRightJump == true || backwardLeftJump == true) {
						if (forwardRightJump == true || forwardLeftJump == true || backwardRightJump == true || backwardLeftJump == true) {
							forwardRight = false;
							forwardLeft = false;
							backwardLeft = false;
							backwardRight = false;
							moveCounter = 1;
						}
						else if (forwardRightJump == false && forwardLeftJump == false && backwardRightJump == false && backwardLeftJump == false) {
							moveCounter = 1;
						}
					}
					if (forwardRight == false && forwardLeft == false && forwardRightJump == false && forwardLeftJump == false &&
							backwardRight == false && backwardLeft == false && backwardRightJump == false && backwardLeftJump == false) {
						moveCounter = 0;
					}
				}
				else if (playerMove == 2 && vsAi_state == 1 && twoPlayer_state == 0) {
					aiPlayer();
				}
				else if (playerMove == 2 && cells[column][row] == 2 && twoPlayer_state == 1 && vsAi_state == 0) {
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
					if (twoForwardRight == true || twoForwardLeft == true || twoForwardRightJump == true || twoForwardLeftJump == true) {
						if (twoForwardRightJump == true || twoForwardLeftJump == true) {
							twoForwardRight = false;
							twoForwardLeft = false;
							moveCounter = 1;
						}
						else if (twoForwardRightJump == false && twoForwardLeftJump == false) {
							moveCounter = 1;
						}
					}
					if (twoForwardRight == false && twoForwardLeft == false && twoForwardRightJump == false && twoForwardLeftJump == false) {
						moveCounter = 0;
					}
				}
				else if (playerMove == 2 && cells[column][row] == 4 && twoPlayer_state == 1 && vsAi_state == 0) {
					cellColor = true;
					draw.repaint();
					if ((column + 1) <= 7 && (row + 1) <= 7) {
						if (cells[column + 1][row + 1] == 0) {
							twoForwardRight = true;
							draw.repaint();
						}	
					}
					if ((column + 1) <= 7 && (row - 1) >= 0) {
						if (cells[column +1][row -1] == 0) {
							twoBackwardRight = true;
							draw.repaint();
						}
					}
					if ((column - 1) >= 0 && (row + 1) <= 7) {
						if (cells[column - 1][row + 1] == 0) {
							twoForwardLeft = true;
							draw.repaint();
						}
					}
					if ((column - 1) >= 0 && (row - 1) >= 0) {
						if (cells[column - 1][row -1] == 0) {
							twoBackwardLeft = true;
							draw.repaint();
						}
					}
					if ((column + 2) <= 7 && (row + 2) <= 7) {
						if (cells[column + 1][row + 1] == 1 && cells[column + 2][row + 2] == 0) {
							twoForwardRightJump = true;
							draw.repaint();
						}
					}
					if ((column + 2) <= 7 && (row - 2) >= 0) {
						if (cells[column + 1][row - 1] == 1 && cells[column + 2][row - 2] == 0) {
							twoBackwardRightJump = true;
							draw.repaint();
						}
					}
					if ((column - 2) >= 0 && (row + 2) <= 7) {
						if (cells[column - 1][row + 1] == 1 && cells[column - 2][row + 2] == 0) {
							twoForwardLeftJump = true;
							draw.repaint();
						}
					}
					if ((column - 2) >= 0 && (row - 2) >= 0) {
						if (cells[column - 1][row - 1] == 1 && cells[column - 2][row - 2] == 0) {
							twoBackwardLeftJump = true;
							draw.repaint();
						}
					}
					if (twoForwardRight == true || twoForwardLeft == true || twoForwardRightJump == true || twoForwardLeftJump == true || 
							twoBackwardRight == true || twoBackwardLeft == true || twoBackwardRightJump == true || twoBackwardLeftJump == true) {
						if (twoForwardRightJump == true || twoForwardLeftJump == true || twoBackwardRightJump == true || twoBackwardLeftJump == true) {
							twoForwardRight = false;
							twoForwardLeft = false;
							twoBackwardLeft = false;
							twoBackwardRight = false;
							moveCounter = 1;
						}
						else if (twoForwardRightJump == false && twoForwardLeftJump == false && twoBackwardRightJump == false && twoBackwardLeftJump == false) {
							moveCounter = 1;
						}
					}
					if (twoForwardRight == false && twoForwardLeft == false && twoForwardRightJump == false && twoForwardLeftJump == false &&
							twoBackwardRight == false && twoBackwardLeft == false && twoBackwardRightJump == false && twoBackwardLeftJump == false) {
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
				if (playerMove == 1 && cells[column][row] == 1 && (forwardRight == true || forwardLeft == true || forwardRightJump == true || forwardLeftJump == true) && twoPlayer_state == 1 && vsAi_state == 0) {
					if ((column + 1) <= 7 && (row + 1) <= 7) {
						if (secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) {
							cells[column][row] = 0;
							cells[column + 1][row + 1] = 1;
							//kingStatus();
						}
					}
					if ((column - 1) >= 0 && (row + 1) <= 7) {
						if (secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) {
							cells[column][row] = 0;
							cells[column - 1][row + 1] = 1;
							//kingStatus();
						}
					}
					if ((column + 2) <= 7 && (row + 2) <= 7) {
						if (secondColumn == column + 2 && secondRow == row + 2 && forwardRightJump == true) {
							cells[column][row] = 0;
							cells[column + 2][row + 2] = 1;
							cells[column + 1][row + 1] = 0;
							//kingStatus();
						}
					}
					if ((column - 2) >= 0 && (row + 2) <= 7) {
						if (secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true) {
							cells[column][row] = 0;
							cells[column - 2][row + 2] = 1;
							cells[column - 1][row + 1] = 0;
							//kingStatus();
						}
					}
					if ((secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) || (secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) || (secondColumn == column + 2 && secondRow == row + 2) && forwardRightJump == true || (secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true)) {
						cellColor = false;
						forwardRight = false;
						forwardLeft = false;
						forwardRightJump = false;
						forwardLeftJump = false;
						playerMove = 2;
						moveCounter = 0;
						draw.repaint();
						checkWin();
						kingStatus();
					}
					else if (!(secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) && !(secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) && !(secondColumn == column + 2 && secondRow == row + 2 && forwardRightJump == true) && !(secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true)) {
						cellColor = false;
						forwardRight = false;
						forwardLeft = false;
						forwardRightJump = false;
						forwardLeftJump = false;
						playerMove = 1;
						moveCounter = 0;
						draw.repaint();
						checkWin();
						kingStatus();
					}
				}
				else if (playerMove == 1 && cells[column][row] == 3 && (forwardRight == true || forwardLeft == true || forwardRightJump == true || forwardLeftJump == true || backwardRight == true || backwardLeft == true || backwardLeftJump == true || backwardRightJump == true) && twoPlayer_state == 1 && vsAi_state == 0) {
					if ((column + 1) <= 7 && (row + 1) <= 7) {
						if (secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) {
							cells[column][row] = 0;
							cells[column + 1][row + 1] = 3;
							//kingStatus();
						}
					}
					if ((column + 1) <= 7 && (row - 1) >= 0) {
						if (secondColumn == column + 1 && secondRow == row - 1 && backwardRight == true) {
							cells[column][row] = 0;
							cells[column + 1][row - 1] = 3;
							//kingStatus();
						}
					}
					if ((column - 1) >= 0 && (row + 1) <= 7) {
						if (secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) {
							cells[column][row] = 0;
							cells[column - 1][row + 1] = 3;
							//kingStatus();
						}
					}
					if ((column - 1) >= 0 && (row - 1) >= 0) {
						if (secondColumn == column - 1 && secondRow == row - 1 && backwardLeft == true) {
							cells[column][row] = 0;
							cells[column - 1][row - 1] = 3;
							//kingStatus();
						}
					}
					if ((column + 2) <= 7 && (row + 2) <= 7) {
						if (secondColumn == column + 2 && secondRow == row + 2 && forwardRightJump == true) {
							cells[column][row] = 0;
							cells[column + 2][row + 2] = 3;
							cells[column + 1][row + 1] = 0;
							//kingStatus();
						}
					}
					if ((column + 2) <= 7 && (row - 2) >= 0) {
						if (secondColumn == column + 2 && secondRow == row - 2 && backwardRightJump == true) {
							cells[column][row] = 0;
							cells[column + 2][row - 2] = 3;
							cells[column + 1][row - 1] = 0;
							//kingStatus();
						}
					}
					if ((column - 2) >= 0 && (row + 2) <= 7) {
						if (secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true) {
							cells[column][row] = 0;
							cells[column - 2][row + 2] = 3;
							cells[column - 1][row + 1] = 0;
							//kingStatus();
						}
					}
					if ((column - 2) >= 0 && (row - 2) >= 0) {
						if (secondColumn == column - 2 && secondRow == row - 2 && backwardLeftJump == true) {
							cells[column][row] = 0;
							cells[column - 2][row - 2] = 3;
							cells[column - 1][row - 1] = 0;
							//kingStatus();
						}
					}
					if ((secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) || (secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) || (secondColumn == column + 2 && secondRow == row + 2) && forwardRightJump == true || (secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true) &&
							(secondColumn == column - 1 && secondRow == row - 1 && backwardLeft == true) || (secondColumn == column + 1 && secondRow == row - 1 && backwardRight == true) || (secondColumn == column + 2 && secondRow == row - 2) && backwardRightJump == true || (secondColumn == column - 2 && secondRow == row - 2 && backwardLeftJump == true)) {
						cellColor = false;
						forwardRight = false;
						forwardLeft = false;
						forwardRightJump = false;
						forwardLeftJump = false;
						backwardRight = false;
						backwardLeft = false;
						backwardRightJump = false;
						backwardLeftJump = false;
						playerMove = 2;
						moveCounter = 0;
						draw.repaint();
						checkWin();
					}
					else if (!(secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) && !(secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) && !(secondColumn == column + 2 && secondRow == row + 2 && forwardRightJump == true) && !(secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true) && 
							!(secondColumn == column - 1 && secondRow == row - 1 && backwardLeft == true) && !(secondColumn == column + 1 && secondRow == row - 1 && backwardRight == true) && !(secondColumn == column + 2 && secondRow == row - 2 && backwardRightJump == true) && !(secondColumn == column - 2 && secondRow == row - 2 && backwardLeftJump == true)) {
						cellColor = false;
						forwardRight = false;
						forwardLeft = false;
						forwardRightJump = false;
						forwardLeftJump = false;
						backwardRight = false;
						backwardLeft = false;
						backwardRightJump = false;
						backwardLeftJump = false;
						playerMove = 1;
						moveCounter = 0;
						draw.repaint();
						checkWin();
					}
				}
				else if (playerMove == 2 && cells[column][row] == 2&&(twoForwardRight == true || twoForwardLeft == true || twoForwardRightJump == true || twoForwardLeftJump == true) && twoPlayer_state == 1 && vsAi_state == 0) {
					if ((column + 1) <= 7 && (row - 1) >= 0)	{
						if (secondColumn == column + 1 && secondRow == row - 1 && twoForwardRight == true) {
							cells[column][row] = 0;
							cells[column + 1][row - 1] = 2;
							//kingStatus();
						}
					}
					if ((column - 1) >= 0 && (row - 1) >= 0)	{
						if (secondColumn == column - 1 && secondRow == row - 1 && twoForwardLeft == true) {
							cells[column][row] = 0;
							cells[column - 1][row - 1] = 2;
							//kingStatus();
						}
					}
					if ((column + 2) <= 7 && (row - 2) >= 0) {
						if (secondColumn == column + 2 && secondRow == row - 2 && twoForwardRightJump == true) {
							cells[column][row] = 0;
							cells[column + 2][row - 2] = 2;
							cells[column + 1][row - 1] = 0;
							//kingStatus();
						}
					}
					if ((column - 2) >= 0 && (row - 2) >= 0) {
						if (secondColumn == column - 2 && secondRow == row - 2 && twoForwardLeftJump == true) {
							cells[column][row] = 0;
							cells[column - 2][row - 2] = 2;
							cells[column - 1][row - 1] = 0;
							System.out.println("I'm here");
							//kingStatus();
						}
					}
					if ((secondColumn == column + 1 && secondRow == row - 1 && twoForwardRight == true) || (secondColumn == column - 1 && secondRow == row - 1 && twoForwardLeft == true) || (secondColumn == column + 2 && secondRow == row - 2 && twoForwardRightJump == true) || (secondColumn == column - 2 && secondRow == row - 2 && twoForwardLeftJump == true)) {
						cellColor = false;
						twoForwardRight = false;
						twoForwardLeft = false;
						twoForwardRightJump = false;
						twoForwardLeftJump = false;
						playerMove = 1;
						moveCounter = 0;
						draw.repaint();
						checkWin();
						kingStatus();
					}
					else if (!(secondColumn == column + 1 && secondRow == row - 1 && twoForwardRight == true) && !(secondColumn == column - 1 && secondRow == row - 1 && twoForwardLeft == true) && !(secondColumn == column + 2 && secondRow == row - 2 && twoForwardRightJump == true) && !(secondColumn == column - 2 && secondRow == row - 2 && twoForwardLeftJump == true)) {
						cellColor = false;
						twoForwardRight = false;
						twoForwardLeft = false;
						twoForwardRightJump = false;
						twoForwardLeftJump = false;
						playerMove = 2;
						moveCounter = 0;
						draw.repaint();
						checkWin();
						kingStatus();
					}
				}
				else if (playerMove == 2 && cells[column][row] == 4 && (twoForwardRight == true || twoForwardLeft == true || twoForwardRightJump == true || twoForwardLeftJump == true || twoBackwardRight == true || twoBackwardLeft == true || twoBackwardLeftJump == true || twoBackwardRightJump == true) && twoPlayer_state == 1 && vsAi_state == 0) {
					if ((column + 1) <= 7 && (row + 1) <= 7) {
						if (secondColumn == column + 1 && secondRow == row + 1 && twoForwardRight == true) {
							cells[column][row] = 0;
							cells[column + 1][row + 1] = 4;
							//kingStatus();
						}
					}
					if ((column + 1) <= 7 && (row - 1) >= 0) {
						if (secondColumn == column + 1 && secondRow == row - 1 && twoBackwardRight == true) {
							cells[column][row] = 0;
							cells[column + 1][row - 1] = 4;
							//kingStatus();
						}
					}
					if ((column - 1) >= 0 && (row + 1) <= 7) {
						if (secondColumn == column - 1 && secondRow == row + 1 && twoForwardLeft == true) {
							cells[column][row] = 0;
							cells[column - 1][row + 1] = 4;
							//kingStatus();
						}
					}
					if ((column - 1) >= 0 && (row - 1) >= 0) {
						if (secondColumn == column - 1 && secondRow == row - 1 && twoBackwardLeft == true) {
							cells[column][row] = 0;
							cells[column - 1][row - 1] = 4;
							//kingStatus();
						}
					}
					if ((column + 2) <= 7 && (row + 2) <= 7) {
						if (secondColumn == column + 2 && secondRow == row + 2 && twoForwardRightJump == true) {
							cells[column][row] = 0;
							cells[column + 2][row + 2] = 4;
							cells[column + 1][row + 1] = 0;
							//kingStatus();
						}
					}
					if ((column + 2) <= 7 && (row - 2) >= 0) {
						if (secondColumn == column + 2 && secondRow == row - 2 && twoBackwardRightJump == true) {
							cells[column][row] = 0;
							cells[column + 2][row - 2] = 4;
							cells[column + 1][row - 1] = 0;
							//kingStatus();
						}
					}
					if ((column - 2) >= 0 && (row + 2) <= 7) {
						if (secondColumn == column - 2 && secondRow == row + 2 && twoForwardLeftJump == true) {
							cells[column][row] = 0;
							cells[column - 2][row + 2] = 4;
							cells[column - 1][row + 1] = 0;
							//kingStatus();
						}
					}
					if ((column - 2) >= 0 && (row - 2) >= 0) {
						if (secondColumn == column - 2 && secondRow == row - 2 && twoBackwardLeftJump == true) {
							cells[column][row] = 0;
							cells[column - 2][row - 2] = 4;
							cells[column - 1][row - 1] = 0;
							//kingStatus();
						}
					}
					if ((secondColumn == column - 1 && secondRow == row + 1 && twoForwardLeft == true) || (secondColumn == column + 1 && secondRow == row + 1 && twoForwardRight == true) || (secondColumn == column + 2 && secondRow == row + 2) && twoForwardRightJump == true || (secondColumn == column - 2 && secondRow == row + 2 && twoForwardLeftJump == true) &&
							(secondColumn == column - 1 && secondRow == row - 1 && twoBackwardLeft == true) || (secondColumn == column + 1 && secondRow == row - 1 && twoBackwardRight == true) || (secondColumn == column + 2 && secondRow == row - 2) && twoBackwardRightJump == true || (secondColumn == column - 2 && secondRow == row - 2 && twoBackwardLeftJump == true)) {
						cellColor = false;
						twoForwardRight = false;
						twoForwardLeft = false;
						twoForwardRightJump = false;
						twoForwardLeftJump = false;
						twoBackwardRight = false;
						twoBackwardLeft = false;
						twoBackwardRightJump = false;
						twoBackwardLeftJump = false;
						playerMove = 2;
						moveCounter = 0;
						draw.repaint();
						checkWin();
					}
					else if (!(secondColumn == column - 1 && secondRow == row + 1 && twoForwardLeft == true) && !(secondColumn == column + 1 && secondRow == row + 1 && twoForwardRight == true) && !(secondColumn == column + 2 && secondRow == row + 2 && twoForwardRightJump == true) && !(secondColumn == column - 2 && secondRow == row + 2 && twoForwardLeftJump == true) && 
							!(secondColumn == column - 1 && secondRow == row - 1 && twoBackwardLeft == true) && !(secondColumn == column + 1 && secondRow == row - 1 && twoBackwardRight == true) && !(secondColumn == column + 2 && secondRow == row - 2 && twoBackwardRightJump == true) && !(secondColumn == column - 2 && secondRow == row - 2 && twoBackwardLeftJump == true)) {
						cellColor = false;
						twoForwardRight = false;
						twoForwardLeft = false;
						twoForwardRightJump = false;
						twoForwardLeftJump = false;
						twoBackwardRight = false;
						twoBackwardLeft = false;
						twoBackwardRightJump = false;
						twoBackwardLeftJump = false;
						playerMove = 1;
						moveCounter = 0;
						draw.repaint();
						checkWin();
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
	
	public void kingStatus() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int j2 = 0; j2 < 12; j2++) {
					if (cells[i][j] == CPieces.onepieces[j2] && j == 7) {
						CPieces.onepieces[j2] = 3;
						cells[i][j] = 3;
						System.out.println("king");
					}
					if (cells[i][j] == CPieces.twopieces[j2] && j == 0) {
						CPieces.twopieces[j2] = 4;
						cells[i][j] = 4;
						System.out.println("working?");
					}
				}
			}
		}
	}
	
	public void checkWin() {
		if (playerMove == 2 || playerMove == 1) {
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells.length; j++) {
					if (cells[i][j] == 2 || cells[i][j] == 4) {
						twoPiecesCounter++;
					}
					else if (cells[i][j] == 1 || cells[i][j] == 3) {
						piecesCounter++;}
					}
				}
			}
			if (twoPiecesCounter == 0) {
				//player one wins!!!!!!!!!!!!!!!!!!!!
				twoPiecesCounter = 0;
				info.setText("Player One Wins. Game Over.");
				twoPlayer.setBackground(Color.LIGHT_GRAY);
				twoPlayer.setOpaque(true);
				twoPlayer_state = 0;
				frame.repaint();
			}
			else if (piecesCounter == 0) {
				//player two wins!!!!!!!!!!!!!!!!!!!!
				piecesCounter = 0;
				info.setText("Player Two Wins. Game Over.");
				twoPlayer.setBackground(Color.LIGHT_GRAY);
				twoPlayer.setOpaque(true);
				twoPlayer_state = 0;
				frame.repaint();
			}
		}
	
	
	public void aiPlayer() {
		aiBlock();
		aiRandom();
	}
	
	public void aiBlock() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (cells[i][j] == 2 && cells[i + 1][j - 1] == 1 && cells[i - 1][j + 1] == 0) { //p1 top right ai mid empty bot left
					if (cells[i - 2][j + 2] == 2) {//if piece from left of empty can move to empty 
						cells[i - 2][j + 2] = 0;
						cells[i - 1][j + 1] = 2;
						playerMove = 1;
						frame.repaint();
					}
					else if (cells[i][j + 2] == 2) {//if piece from right of empty can move to empty
						cells[i][j + 2] = 0;
						cells[i - 1][j + 1] = 2;
						playerMove = 1;
						frame.repaint();
					}	
					else if  (cells[i - 2][j + 2] == 4) {//same but if king 
						cells[i - 2][j + 2] = 0;
						cells[i - 1][j + 1] = 4;
						playerMove = 1;
						frame.repaint();
					}
					else if (cells[i][j + 2] == 4) {//same but if king
						cells[i][j + 2] = 0;
						cells[i - 1][j + 1] = 4;
						playerMove = 1;
						frame.repaint();
					}
				}
				if (cells[i][j] == 2 && cells[i - 1][j - 1] == 1 && cells[i + 1][j + 1] == 0) { //p1 top left ai mid empty bot right
			
				}
			}
		}
	}
	
	public void aiRandom() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
		if (cells[i][j] == 2 && (i + 1) <= 7 && (j + 1) <= 7) {
			if (cells[i + 1][j + 1] == 0) {
				cells[i][j] = 0;
				cells[i + 1][j - 1] = 2;
				frame.repaint();
				playerMove = 1;
			}	
		}
		if (cells[i][j] == 2 && (i - 1) >= 0 && (j + 1) <= 7) {
			if (cells[i - 1][j + 1] == 0) {
				cells[i][j] = 0;
				cells[i - 1][j - 1] = 2;
				frame.repaint();
				playerMove = 1;
			}
		}
		/*if (cells[i][j] == 2 && (i + 2) <= 7 && (j + 2) <= 7) {
			if (cells[i + 1][j + 1] == 2 && cells[i + 2][j + 2] == 0) {
				forwardRightJump = true;
				draw.repaint();
			}
		}
		if (cells[i][j] == 2 && (i - 2) >= 0 && (j + 2) <= 7) {
			if (cells[i - 1][j + 1] == 2 && cells[i - 2][j + 2] == 0) {
				forwardLeftJump = true;
				draw.repaint();
			}
		}*/
			}
		}
	}

	public static void main(String[] args) {
		new Main();

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