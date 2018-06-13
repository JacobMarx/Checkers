/* This program features a Checkers game with a Player vs Player or Player vs Computer option
 * This class enables all the moves for the Checkers game
 * Date: June 13, 2018
 * Authors: Jacob Marx and Vivek Kumar
 * Supervisor: Jason Galbraith
 */
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
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main implements MouseListener, ActionListener{
	//Initialize all variables, containers, labels, buttons, and frames
	
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
	public static boolean twoForwardLeftAI = false;
	public static boolean twoForwardRightAI = false;
	public static boolean twoForwardLeftJumpAI = false;
	public static boolean twoForwardRightJumpAI = false;
	public static boolean twoBackwardLeftAI = false;
	public static boolean twoBackwardRightAI = false;
	public static boolean twoBackwardLeftJumpAI = false;
	public static boolean twoBackwardRightJumpAI = false;
	public static boolean playMade = false;
	public static int column;
	public static int row;
	public static int columnAI;
	public static int rowAI;
	int secondColumn;
	int secondRow;
	
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
	JLabel info = new JLabel("Welcome to Checkers          ");
	
	public Main() {//Crate frame set up for the checkers game
		frame.setSize(1000,800);
		frame.setLayout(new BorderLayout());
		
		frame.add(draw, BorderLayout.CENTER);
		draw.addMouseListener(this);

		new CPieces(); //Call CPieces for piece set-up location
		
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
		start.addActionListener(this);
		easts.add(end);
		end.addActionListener(this);
		easts.add(reset);
		reset.addActionListener(this);
		
		frame.add(info, BorderLayout.EAST);
		
		south.add(centers, BorderLayout.CENTER);
		south.add(wests, BorderLayout.WEST);
		frame.add(south, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.repaint();
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
	public void mousePressed(MouseEvent event) {}

	@Override
	public void mouseReleased(MouseEvent event) {//On release, run through moves 
	checkWin();
	if (moveCounter == 0) { //highlights all possible moves
		checkWin();
		if (event.getX() <= 560 && event.getY() <= 560) { //uses x,y position to figure out column, row
			column = Math.min(cells[0].length, (int)((event.getX() - 30)/ width));
			row = Math.min(cells.length , (int)((event.getY() - 30)/ height));
			if (cells[column][row] == 1 || cells[column][row] == 2 || cells[column][row] == 3 || cells[column][row] == 4) {//clicked cell has a piece
				if (playerMove == 1 && cells[column][row] == 1 && twoPlayer_state == 1 && vsAi_state == 0) { //highlights moves for normal player 1 piece in PvP
					playerOneNormalHighlight();
				}
				else if (playerMove == 1 && cells[column][row] == 3 && twoPlayer_state == 1 && vsAi_state == 0) { //highlights moves for player 1 king piece in PvP
					playerOneKingHighlight();
				}
				else if (playerMove == 1 && cells[column][row] == 1 && twoPlayer_state == 0 && vsAi_state == 1) { //highlight moves for player 1 normal piece in Ai moves
					playerOneNormalHighlight();
				}
				else if (playerMove == 1 && cells[column][row] == 3 && twoPlayer_state == 0 && vsAi_state == 1) { //highlight moves for player 1 king piece in Ai moves
					playerOneKingHighlight();
				}
				else if (playerMove == 2 && cells[column][row] == 2 && twoPlayer_state == 1 && vsAi_state == 0) { //highlights moves for player 2 normal piece in PvP
					playerTwoNormalHighlight();
				}
				else if (playerMove == 2 && cells[column][row] == 4 && twoPlayer_state == 1 && vsAi_state == 0) { //highlights moves for player 2 king piece in PvP
					playerTwoKingHighlight();
				}
			}
		}
	}
	checkWin();
	if (moveCounter == 1) { //once moves are highlighted, actual moves will begin
		checkWin();
		if (event.getX() <= 560 && event.getY() <= 560) { //located column,row for second click
			secondColumn = Math.min(cells[0].length, (int)((event.getX() - 30)/ width));
			secondRow = Math.min(cells.length , (int)((event.getY() - 30)/ height));
			if (cells[secondColumn][secondRow] == 0) { //if selected move cell is empty
				if (playerMove == 1 && cells[column][row] == 1 && (forwardRight == true || forwardLeft == true || forwardRightJump == true || forwardLeftJump == true) && twoPlayer_state == 1 && vsAi_state == 0) {
					// ^makes move player 1 normal piece in PvP while a move is possible
					playerOneNormalMove();
				}
				else if (playerMove == 1 && cells[column][row] == 3 && (forwardRight == true || forwardLeft == true || forwardRightJump == true || forwardLeftJump == true || backwardRight == true || backwardLeft == true || backwardLeftJump == true || backwardRightJump == true) && twoPlayer_state == 1 && vsAi_state == 0) {
					//player 1 king piece moves
					playerOneKingMove();
				}
				if (playerMove == 1 && cells[column][row] == 1 && (forwardRight == true || forwardLeft == true || forwardRightJump == true || forwardLeftJump == true) && twoPlayer_state == 0 && vsAi_state == 1) {
					// ^makes move player 1 normal piece in PvP while a move is possible
					playerOneNormalMoveAI();
				}
				else if (playerMove == 1 && cells[column][row] == 3 && (forwardRight == true || forwardLeft == true || forwardRightJump == true || forwardLeftJump == true || backwardRight == true || backwardLeft == true || backwardLeftJump == true || backwardRightJump == true) && twoPlayer_state == 0 && vsAi_state == 1) {
					//player 1 king piece moves
					playerOneKingMoveAI();
				}
				else if (playerMove == 2 && cells[column][row] == 2 && (twoForwardRight == true || twoForwardLeft == true || twoForwardRightJump == true || twoForwardLeftJump == true) && twoPlayer_state == 1 && vsAi_state == 0) {
					//player 2 normal piece moves
					playerTwoNormalMove();
				}
				else if (playerMove == 2 && cells[column][row] == 4 && (twoForwardRight == true || twoForwardLeft == true || twoForwardRightJump == true || twoForwardLeftJump == true || twoBackwardRight == true || twoBackwardLeft == true || twoBackwardLeftJump == true || twoBackwardRightJump == true) && twoPlayer_state == 1 && vsAi_state == 0) {
					//player 2 king piece moves
					playerTwoKingMove();
				}
			}
		}	
	}
		
}
	@Override
	public void actionPerformed(ActionEvent e) { //On button click
		if (e.getSource().equals(twoPlayer)) { //When 2 Player button is clicked
			if (twoPlayer_state == 0) { //allow PvP game to start/continue
				twoPlayer.setBackground(Color.GREEN);
				twoPlayer.setOpaque(true);
				twoPlayer_state = 1;
				frame.repaint();
				return;
			}
			if (twoPlayer_state == 1) { //stop PvP game
				twoPlayer.setBackground(Color.LIGHT_GRAY);
				twoPlayer.setOpaque(true);
				twoPlayer_state = 0;
				frame.repaint();
				return;
			}
		}
		if (e.getSource().equals(vsAi)) { //When computer button is clicked
			if (vsAi_state == 0) { // allow AI game to start/continue
				vsAi.setBackground(Color.GREEN);
				vsAi.setOpaque(true);
				vsAi_state = 1;
				frame.repaint();
				return;
			}
			if (vsAi_state == 1) { //stop AI game
				vsAi.setBackground(Color.LIGHT_GRAY);
				vsAi.setOpaque(true);
				vsAi_state = 0;
				frame.repaint();
				return;
			}
		}
		if (e.getSource().equals(start) || e.getSource().equals(end) || e.getSource().equals(reset)) {
			reset();
			draw.repaint();
			playerMove = 1;
			moveCounter = 0;
			
			twoPlayer.setBackground(Color.LIGHT_GRAY);
			twoPlayer.setOpaque(true);
			twoPlayer_state = 0;
			
			vsAi.setBackground(Color.LIGHT_GRAY);
			vsAi.setOpaque(true);
			vsAi_state = 0;
			
			return;
		}
	}
	
	public void kingStatus() { //check if a piece is now a king
		for (int i = 0; i < 8; i++) { //iterate through all columns
			for (int j = 0; j < 8; j++) { //iterate through all rows
				for (int j2 = 0; j2 < 12; j2++) { //iterate through all pieces
					if (cells[i][j] == CPieces.onepieces[j2] && j == 7) { //when player one piece reaches bottom row
						CPieces.onepieces[j2] = 3; //set piece to 3 (player 1 King)
						cells[i][j] = 3;
					}
					if (cells[i][j] == CPieces.twopieces[j2] && j == 0) { //when player two piece reaches top row
						CPieces.twopieces[j2] = 4; //set piece to 4 (player 2 King)
						cells[i][j] = 4;
					}
				}
			}
		}
	}
	
	public void playerOneNormalHighlight () {
		cellColor = true;
		draw.repaint();
		checkWin();
		if ((column + 1) <= 7 && (row + 1) <= 7) { //ensures move is within boundaries
			if (cells[column + 1][row + 1] == 0) { //ensures move has no piece there
				forwardRight = true; //highlight move
				draw.repaint(); 
				checkWin(); //check for Win
			}	
		}
		if ((column - 1) >= 0 && (row + 1) <= 7) {
			if (cells[column - 1][row + 1] == 0) {
				forwardLeft = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row + 2) <= 7) { //ensures jump move is within boundaries
			if ((cells[column + 1][row + 1] == 2 || cells[column + 1][row + 1] == 4) && cells[column + 2][row + 2] == 0) { //ensures piece being jumped is occupied by opposing player piece and jump move is empty
				forwardRightJump = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row + 2) <= 7) {
			if ((cells[column - 1][row + 1] == 2 || cells[column - 1][row + 1] == 4) && cells[column - 2][row + 2] == 0) {
				forwardLeftJump = true;
				draw.repaint();
				checkWin();
			}
		}
		
		if (forwardRight == true || forwardLeft == true || forwardRightJump == true || forwardLeftJump == true) { //moves forward if move is possible
			if (forwardRightJump == true || forwardLeftJump == true) { //must make jump if a jump is possible
				forwardRight = false;
				forwardLeft = false;
				moveCounter = 1; //moves to move mode
				checkWin();
			}
			else if (forwardRightJump == false && forwardLeftJump == false) { //moves forward with normal move
				moveCounter = 1;
				checkWin();
			}
		}
		if (forwardRight == false && forwardLeft == false && forwardRightJump == false && forwardLeftJump == false) { //redo move is no moves are available on selected piece
			moveCounter = 0;
			checkWin();
		}
	}

	public void playerOneKingHighlight () {
		cellColor = true;
		draw.repaint();
		checkWin();
		if ((column + 1) <= 7 && (row + 1) <= 7) {
			if (cells[column + 1][row + 1] == 0) {
				forwardRight = true;
				draw.repaint();
				checkWin();
			}	
		}
		if ((column + 1) <= 7 && (row - 1) >= 0) {
			if (cells[column +1][row -1] == 0) {
				backwardRight = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row + 1) <= 7) {
			if (cells[column - 1][row + 1] == 0) {
				forwardLeft = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row - 1) >= 0) {
			if (cells[column - 1][row -1] == 0) {
				backwardLeft = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row + 2) <= 7) {
			if ((cells[column + 1][row + 1] == 2 || cells[column + 1][row + 1] == 4) && cells[column + 2][row + 2] == 0) {
				forwardRightJump = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row - 2) >= 0) {
			if ((cells[column + 1][row - 1] == 2 || cells[column + 1][row - 1] == 4) && cells[column + 2][row - 2] == 0) {
				backwardRightJump = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row + 2) <= 7) {
			if ((cells[column - 1][row + 1] == 2 || cells[column - 1][row + 1] == 4) && cells[column - 2][row + 2] == 0) {
				forwardLeftJump = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row - 2) >= 0) {
			if ((cells[column - 1][row - 1] == 2 || cells[column - 1][row - 1] == 4) && cells[column - 2][row - 2] == 0) {
				backwardLeftJump = true;
				draw.repaint();
				checkWin();
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
				checkWin();
			}
			else if (forwardRightJump == false && forwardLeftJump == false && backwardRightJump == false && backwardLeftJump == false) {
				moveCounter = 1;
				checkWin();
			}
		}
		if (forwardRight == false && forwardLeft == false && forwardRightJump == false && forwardLeftJump == false &&
				backwardRight == false && backwardLeft == false && backwardRightJump == false && backwardLeftJump == false) {
			moveCounter = 0;
			checkWin();
		}
	}
	
	public void playerTwoNormalHighlight () {
		cellColor = true;
		draw.repaint();
		checkWin();
		if ((column + 1) <= 7 && (row - 1) >= 0) {
			if (cells[column + 1][row - 1] == 0) {
				twoForwardRight = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row - 1) >= 0) {
			if (cells[column - 1][row - 1] == 0) {
				twoForwardLeft = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row - 2) >= 0) {
			if ((cells[column + 1][row - 1] == 1 || cells[column + 1][row - 1] == 3) && cells[column + 2][row - 2] == 0) {
				twoForwardRightJump = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row - 2) >= 0) {
			if ((cells[column - 1][row - 1] == 1  || cells[column - 1][row - 1] == 3) && cells[column - 2][row - 2] == 0) {
				twoForwardLeftJump = true;
				draw.repaint();
				checkWin();
			}
		}
		if (twoForwardRight == true || twoForwardLeft == true || twoForwardRightJump == true || twoForwardLeftJump == true) {
			if (twoForwardRightJump == true || twoForwardLeftJump == true) {
				twoForwardRight = false;
				twoForwardLeft = false;
				moveCounter = 1;
				checkWin();
			}
			else if (twoForwardRightJump == false && twoForwardLeftJump == false) {
				moveCounter = 1;
				checkWin();
			}
		}
		if (twoForwardRight == false && twoForwardLeft == false && twoForwardRightJump == false && twoForwardLeftJump == false) {
			moveCounter = 0;
			checkWin();
		}
	}
	
	public void playerTwoKingHighlight () {
		cellColor = true;
		draw.repaint();
		if ((column + 1) <= 7 && (row + 1) <= 7) {
			if (cells[column + 1][row + 1] == 0) {
				twoBackwardRight = true;
				draw.repaint();
				checkWin();
			}	
		}
		if ((column + 1) <= 7 && (row - 1) >= 0) {
			if (cells[column +1][row -1] == 0) {
				twoForwardRight = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row + 1) <= 7) {
			if (cells[column - 1][row + 1] == 0) {
				twoBackwardLeft = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row - 1) >= 0) {
			if (cells[column - 1][row -1] == 0) {
				twoForwardLeft = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row + 2) <= 7) {
			if ((cells[column + 1][row + 1] == 1  || cells[column + 1][row + 1] == 3) && cells[column + 2][row + 2] == 0) {
				twoBackwardRightJump = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row - 2) >= 0) {
			if ((cells[column + 1][row - 1] == 1  || cells[column + 1][row - 1] == 3) && cells[column + 2][row - 2] == 0) {
				twoForwardRightJump = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row + 2) <= 7) {
			if ((cells[column - 1][row + 1] == 1  || cells[column - 1][row + 1] == 3) && cells[column - 2][row + 2] == 0) {
				twoBackwardLeftJump = true;
				draw.repaint();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row - 2) >= 0) {
			if ((cells[column - 1][row - 1] == 1  || cells[column - 1][row - 1] == 3) && cells[column - 2][row - 2] == 0) {
				twoForwardLeftJump = true;
				draw.repaint();
				checkWin();
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
				checkWin();
			}
			else if (twoForwardRightJump == false && twoForwardLeftJump == false && twoBackwardRightJump == false && twoBackwardLeftJump == false) {
				moveCounter = 1;
				checkWin();
			}
		}
		if (twoForwardRight == false && twoForwardLeft == false && twoForwardRightJump == false && twoForwardLeftJump == false &&
				twoBackwardRight == false && twoBackwardLeft == false && twoBackwardRightJump == false && twoBackwardLeftJump == false) {
			moveCounter = 0;
			checkWin();
		}
	}

	public void playerOneNormalMove () {
		if ((column + 1) <= 7 && (row + 1) <= 7) { 
			if (secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) { //clicked move is a possible move
				cells[column][row] = 0; //set original cell to empty
				cells[column + 1][row + 1] = 1; //set new cell to have piece
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row + 1) <= 7) {
			if (secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) {
				cells[column][row] = 0;
				cells[column - 1][row + 1] = 1;
				//kingStatus();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row + 2) <= 7) {
			if (secondColumn == column + 2 && secondRow == row + 2 && forwardRightJump == true) {
				cells[column][row] = 0; 
				cells[column + 2][row + 2] = 1;
				cells[column + 1][row + 1] = 0; //remove jumped piece from play
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row + 2) <= 7) {
			if (secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true) {
				cells[column][row] = 0;
				cells[column - 2][row + 2] = 1;
				cells[column - 1][row + 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) || (secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) || (secondColumn == column + 2 && secondRow == row + 2) && forwardRightJump == true || (secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true)) {
			//if a move was made, de-highlight all squares and move to player 2
			cellColor = false;
			forwardRight = false;
			forwardLeft = false;
			forwardRightJump = false;
			forwardLeftJump = false;
			playerMove = 2;
			moveCounter = 0;
			draw.repaint();
			checkWin(); 
			kingStatus(); //check for possible king
		}
		else if (!(secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) && !(secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) && !(secondColumn == column + 2 && secondRow == row + 2 && forwardRightJump == true) && !(secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true)) {
			//if no move was made, de-highlight all squares and repeat player 1 turn
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

	public void playerOneNormalMoveAI () {
		if ((column + 1) <= 7 && (row + 1) <= 7) { 
			if (secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) { //clicked move is a possible move
				cells[column][row] = 0; //set original cell to empty
				cells[column + 1][row + 1] = 1; //set new cell to have piece
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row + 1) <= 7) {
			if (secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) {
				cells[column][row] = 0;
				cells[column - 1][row + 1] = 1;
				//kingStatus();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row + 2) <= 7) {
			if (secondColumn == column + 2 && secondRow == row + 2 && forwardRightJump == true) {
				cells[column][row] = 0; 
				cells[column + 2][row + 2] = 1;
				cells[column + 1][row + 1] = 0; //remove jumped piece from play
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row + 2) <= 7) {
			if (secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true) {
				cells[column][row] = 0;
				cells[column - 2][row + 2] = 1;
				cells[column - 1][row + 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) || (secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) || (secondColumn == column + 2 && secondRow == row + 2) && forwardRightJump == true || (secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true)) {
			//if a move was made, de-highlight all squares and move to player 2
			cellColor = false;
			forwardRight = false;
			forwardLeft = false;
			forwardRightJump = false;
			forwardLeftJump = false;
			draw.repaint();
			checkWin(); 
			kingStatus(); //check for possible king
			playerMove = 2;
			aiMove();
		}
		else if (!(secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) && !(secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) && !(secondColumn == column + 2 && secondRow == row + 2 && forwardRightJump == true) && !(secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true)) {
			//if no move was made, de-highlight all squares and repeat player 1 turn
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
	
	public void playerOneKingMove () {
		if ((column + 1) <= 7 && (row + 1) <= 7) {
			if (secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) {
				cells[column][row] = 0;
				cells[column + 1][row + 1] = 3;
				//kingStatus();
				checkWin();
			}
		}
		if ((column + 1) <= 7 && (row - 1) >= 0) {
			if (secondColumn == column + 1 && secondRow == row - 1 && backwardRight == true) {
				cells[column][row] = 0;
				cells[column + 1][row - 1] = 3;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row + 1) <= 7) {
			if (secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) {
				cells[column][row] = 0;
				cells[column - 1][row + 1] = 3;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row - 1) >= 0) {
			if (secondColumn == column - 1 && secondRow == row - 1 && backwardLeft == true) {
				cells[column][row] = 0;
				cells[column - 1][row - 1] = 3;
				//kingStatus();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row + 2) <= 7) {
			if (secondColumn == column + 2 && secondRow == row + 2 && forwardRightJump == true) {
				cells[column][row] = 0;
				cells[column + 2][row + 2] = 3;
				cells[column + 1][row + 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row - 2) >= 0) {
			if (secondColumn == column + 2 && secondRow == row - 2 && backwardRightJump == true) {
				cells[column][row] = 0;
				cells[column + 2][row - 2] = 3;
				cells[column + 1][row - 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row + 2) <= 7) {
			if (secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true) {
				cells[column][row] = 0;
				cells[column - 2][row + 2] = 3;
				cells[column - 1][row + 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row - 2) >= 0) {
			if (secondColumn == column - 2 && secondRow == row - 2 && backwardLeftJump == true) {
				cells[column][row] = 0;
				cells[column - 2][row - 2] = 3;
				cells[column - 1][row - 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) || (secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) || (secondColumn == column + 2 && secondRow == row + 2 && forwardRightJump == true) || (secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true) ||
				(secondColumn == column - 1 && secondRow == row - 1 && backwardLeft == true) || (secondColumn == column + 1 && secondRow == row - 1 && backwardRight == true) || (secondColumn == column + 2 && secondRow == row - 2 && backwardRightJump == true) || (secondColumn == column - 2 && secondRow == row - 2 && backwardLeftJump == true)) {
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
	
	public void playerOneKingMoveAI () {
		if ((column + 1) <= 7 && (row + 1) <= 7) {
			if (secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) {
				cells[column][row] = 0;
				cells[column + 1][row + 1] = 3;
				//kingStatus();
				checkWin();
			}
		}
		if ((column + 1) <= 7 && (row - 1) >= 0) {
			if (secondColumn == column + 1 && secondRow == row - 1 && backwardRight == true) {
				cells[column][row] = 0;
				cells[column + 1][row - 1] = 3;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row + 1) <= 7) {
			if (secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) {
				cells[column][row] = 0;
				cells[column - 1][row + 1] = 3;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row - 1) >= 0) {
			if (secondColumn == column - 1 && secondRow == row - 1 && backwardLeft == true) {
				cells[column][row] = 0;
				cells[column - 1][row - 1] = 3;
				//kingStatus();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row + 2) <= 7) {
			if (secondColumn == column + 2 && secondRow == row + 2 && forwardRightJump == true) {
				cells[column][row] = 0;
				cells[column + 2][row + 2] = 3;
				cells[column + 1][row + 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row - 2) >= 0) {
			if (secondColumn == column + 2 && secondRow == row - 2 && backwardRightJump == true) {
				cells[column][row] = 0;
				cells[column + 2][row - 2] = 3;
				cells[column + 1][row - 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row + 2) <= 7) {
			if (secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true) {
				cells[column][row] = 0;
				cells[column - 2][row + 2] = 3;
				cells[column - 1][row + 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row - 2) >= 0) {
			if (secondColumn == column - 2 && secondRow == row - 2 && backwardLeftJump == true) {
				cells[column][row] = 0;
				cells[column - 2][row - 2] = 3;
				cells[column - 1][row - 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((secondColumn == column - 1 && secondRow == row + 1 && forwardLeft == true) || (secondColumn == column + 1 && secondRow == row + 1 && forwardRight == true) || (secondColumn == column + 2 && secondRow == row + 2 && forwardRightJump == true) || (secondColumn == column - 2 && secondRow == row + 2 && forwardLeftJump == true) ||
				(secondColumn == column - 1 && secondRow == row - 1 && backwardLeft == true) || (secondColumn == column + 1 && secondRow == row - 1 && backwardRight == true) || (secondColumn == column + 2 && secondRow == row - 2 && backwardRightJump == true) || (secondColumn == column - 2 && secondRow == row - 2 && backwardLeftJump == true)) {
			cellColor = false;
			forwardRight = false;
			forwardLeft = false;
			forwardRightJump = false;
			forwardLeftJump = false;
			backwardRight = false;
			backwardLeft = false;
			backwardRightJump = false;
			backwardLeftJump = false;
			moveCounter = 0;
			draw.repaint();
			checkWin();
			playerMove = 2;
			aiMove();
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
	
	public void playerTwoNormalMove () {
		if ((column + 1) <= 7 && (row - 1) >= 0)	{
			if (secondColumn == column + 1 && secondRow == row - 1 && twoForwardRight == true) {
				cells[column][row] = 0;
				cells[column + 1][row - 1] = 2;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row - 1) >= 0)	{
			if (secondColumn == column - 1 && secondRow == row - 1 && twoForwardLeft == true) {
				cells[column][row] = 0;
				cells[column - 1][row - 1] = 2;
				//kingStatus();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row - 2) >= 0) {
			if (secondColumn == column + 2 && secondRow == row - 2 && twoForwardRightJump == true) {
				cells[column][row] = 0;
				cells[column + 2][row - 2] = 2;
				cells[column + 1][row - 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row - 2) >= 0) {
			if (secondColumn == column - 2 && secondRow == row - 2 && twoForwardLeftJump == true) {
				cells[column][row] = 0;
				cells[column - 2][row - 2] = 2;
				cells[column - 1][row - 1] = 0;
				//kingStatus();
				checkWin();
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
	
	public void playerTwoKingMove () {
		if ((column + 1) <= 7 && (row + 1) <= 7) {
			if (secondColumn == column + 1 && secondRow == row + 1 && twoBackwardRight == true) {
				cells[column][row] = 0;
				cells[column + 1][row + 1] = 4;
				//kingStatus();
				checkWin();
			}
		}
		if ((column + 1) <= 7 && (row - 1) >= 0) {
			if (secondColumn == column + 1 && secondRow == row - 1 && twoForwardRight == true) {
				cells[column][row] = 0;
				cells[column + 1][row - 1] = 4;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row + 1) <= 7) {
			if (secondColumn == column - 1 && secondRow == row + 1 && twoBackwardLeft == true) {
				cells[column][row] = 0;
				cells[column - 1][row + 1] = 4;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 1) >= 0 && (row - 1) >= 0) {
			if (secondColumn == column - 1 && secondRow == row - 1 && twoForwardLeft == true) {
				cells[column][row] = 0;
				cells[column - 1][row - 1] = 4;
				//kingStatus();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row + 2) <= 7) {
			if (secondColumn == column + 2 && secondRow == row + 2 && twoBackwardRightJump == true) {
				cells[column][row] = 0;
				cells[column + 2][row + 2] = 4;
				cells[column + 1][row + 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((column + 2) <= 7 && (row - 2) >= 0) {
			if (secondColumn == column + 2 && secondRow == row - 2 && twoForwardRightJump == true) {
				cells[column][row] = 0;
				cells[column + 2][row - 2] = 4;
				cells[column + 1][row - 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row + 2) <= 7) {
			if (secondColumn == column - 2 && secondRow == row + 2 && twoBackwardLeftJump == true) {
				cells[column][row] = 0;
				cells[column - 2][row + 2] = 4;
				cells[column - 1][row + 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((column - 2) >= 0 && (row - 2) >= 0) {
			if (secondColumn == column - 2 && secondRow == row - 2 && twoForwardLeftJump == true) {
				cells[column][row] = 0;
				cells[column - 2][row - 2] = 4;
				cells[column - 1][row - 1] = 0;
				//kingStatus();
				checkWin();
			}
		}
		if ((secondColumn == column - 1 && secondRow == row + 1 && twoForwardLeft == true) || (secondColumn == column + 1 && secondRow == row + 1 && twoForwardRight == true) || (secondColumn == column + 2 && secondRow == row + 2 && twoForwardRightJump == true) || (secondColumn == column - 2 && secondRow == row + 2 && twoForwardLeftJump == true) ||
				(secondColumn == column - 1 && secondRow == row - 1 && twoBackwardLeft == true) || (secondColumn == column + 1 && secondRow == row - 1 && twoBackwardRight == true) || (secondColumn == column + 2 && secondRow == row - 2 && twoBackwardRightJump == true) || (secondColumn == column - 2 && secondRow == row - 2 && twoBackwardLeftJump == true)) {
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
			playerMove = 2;
			moveCounter = 0;
			draw.repaint();
			checkWin();
		}
	}
	
	public void checkWin() { //check for a win
		twoPiecesCounter = 0; //reset counter for each check
		piecesCounter = 0;
		for (int i = 0; i < 8; i++) { //iterate through columns
			for (int j = 0; j < 8; j++) { //iterate through rows
				if (cells[i][j] == 2 || cells[i][j] == 4) { //Add 1 to twoPieceCounter if there are any Player 2 pieces on the board
					twoPiecesCounter++;
				}
				if (cells[i][j] == 1 || cells[i][j] == 3) { //Add 1 to piecesCounter if there are any Player 1 pieces on the board
					piecesCounter++;
				}
			}
		}
		if (twoPiecesCounter == 0) { //If no Player 2 pieces are left, Player 1 Wins!
			twoPiecesCounter = 0;
			info.setText("Player One Wins. Game Over."); //Change info label text
			twoPlayer.setBackground(Color.LIGHT_GRAY); //De-highlight
			twoPlayer.setOpaque(true);
			twoPlayer_state = 0; //stop game
			draw.repaint();
			frame.repaint();
		}
		if (piecesCounter == 0) { //If no Player 1 pieces are left, Player 2 Wins!
			piecesCounter = 0;
			info.setText("Player Two Wins. Game Over.");
			twoPlayer.setBackground(Color.LIGHT_GRAY);
			twoPlayer.setOpaque(true);
			twoPlayer_state = 0;
			draw.repaint();
			frame.repaint();
		}
	}
	
	public void aiPlayer() { // make AI player moves
	//	aiBlock();
	//	aiMove();
	}
	
	public void aiBlock() { // AI will attempt to make a block first
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
	
	public void aiMove() { //AI makes a challenging move against the Player 1
		if (vsAi_state == 1 && twoPlayer_state == 0) {
			for (columnAI = 0; columnAI < 8; columnAI++) { //column; TRY TO MAKE RANDOM NUMBER IN FOR LOOP
				for (rowAI = 0; rowAI < 8; rowAI++) { //row
					if ((cells[columnAI][rowAI] == 2 || cells[columnAI][rowAI] == 4) && playerMove == 2) {
						if ((columnAI + 2) <= 7 && (rowAI - 2) >= 0 && cells[columnAI][rowAI] == 2 && playerMove == 2) { //forward right jump
							if ((cells[columnAI + 1][rowAI - 1] == 1 || cells[columnAI + 1][rowAI -1] == 3) && cells[columnAI + 2][rowAI - 2] == 0) {
								twoForwardRightJumpAI = true;
								draw.repaint();
								//wait
								twoForwardRightJumpAI = false;
								draw.repaint();
								cells[columnAI][rowAI] = 0;
								cells[columnAI + 2][rowAI - 2] = 2;
								cells[columnAI + 1][rowAI - 1] = 0;
								kingStatus();
								checkWin();
								draw.repaint();
								playerMove = 1;
								moveCounter = 0;
							}
						}
						if ((columnAI - 2) >= 0 && (rowAI - 2) >= 0 && cells[columnAI][rowAI] == 2 && playerMove == 2) { //forward left jump
							if ((cells[columnAI - 1][rowAI - 1] == 1 || cells[columnAI - 1][rowAI -1] == 3) && cells[columnAI - 2][rowAI - 2] == 0) {
								twoForwardLeftJumpAI = true;
								draw.repaint();
								//wait
								twoForwardLeftJumpAI = false;
								draw.repaint();
								cells[columnAI][rowAI] = 0;
								cells[columnAI - 2][rowAI - 2] = 2;
								cells[columnAI - 1][rowAI - 1] = 0;
								kingStatus();
								checkWin();
								draw.repaint();
								playerMove = 1;
								moveCounter = 0;
							}
						}
						if ((columnAI + 1) <= 7 && (rowAI - 1) >= 0 && cells[columnAI][rowAI] == 2 && playerMove == 2)	{ //forward right
							if (cells[columnAI + 1][rowAI - 1] == 0) {
								twoForwardRightAI = true;
								draw.repaint();
								//wait
								twoForwardRightAI = false;
								draw.repaint();
								cells[columnAI][rowAI] = 0;
								cells[columnAI + 1][rowAI - 1] = 2;
								kingStatus();
								checkWin();
								draw.repaint();
								playerMove = 1;
								moveCounter = 0;
							}
						}
						if ((columnAI - 1) >= 0 && (rowAI - 1) >= 0 && cells[columnAI][rowAI] == 2 && playerMove == 2)	{ //forward left
							if (cells[columnAI - 1][rowAI - 1] == 0) {
								twoForwardLeftAI = true;
								draw.repaint();
								//wait
								twoForwardLeftAI = false;
								draw.repaint();
								cells[columnAI][rowAI] = 0;
								cells[columnAI - 1][rowAI - 1] = 2;
								kingStatus();
								checkWin();
								draw.repaint();
								playerMove = 1;
								moveCounter = 0;
							}
						}
						if ((columnAI + 2) <= 7 && (rowAI - 2) >= 0 && cells[columnAI][rowAI] == 4 && playerMove == 2) { //backward Left jump
							if ((cells[columnAI + 1][rowAI - 1] == 1 || cells[columnAI + 1][rowAI - 1] == 3) && cells[columnAI + 2][rowAI - 2] == 0) {
								twoBackwardLeftJumpAI = true;
								draw.repaint();
								//wait
								twoBackwardLeftJumpAI = false;
								draw.repaint();
								cells[columnAI][rowAI] = 0;
								cells[columnAI + 2][rowAI - 2] = 4;
								cells[columnAI + 1][rowAI - 1] = 0;
								kingStatus();
								checkWin();
								draw.repaint();
								playerMove = 1;
								moveCounter = 0;
							}
						}
						if ((columnAI + 2) <= 7 && (rowAI + 2) <= 7 && cells[columnAI][rowAI] == 4 && playerMove == 2) { //backward right jump
							if ((cells[columnAI + 1][rowAI + 1] == 1 || cells[columnAI + 1][rowAI + 1] == 3) && cells[columnAI + 2][rowAI + 2] == 0) {
								twoBackwardRightJumpAI = true;
								draw.repaint();
								//wait
								twoBackwardRightJumpAI = false;
								draw.repaint();
								cells[columnAI][rowAI] = 0;
								cells[columnAI + 2][rowAI + 2] = 4;
								cells[columnAI + 1][rowAI + 1] = 0;
								kingStatus();
								checkWin();
								draw.repaint();
								playerMove = 1;
								moveCounter = 0;
							}
						}
						if ((columnAI + 1) <= 7 && (rowAI + 1) <= 7 && cells[columnAI][rowAI] == 4 && playerMove == 2 ) { //backward right
							if (cells[columnAI + 1][rowAI + 1] == 0) {
								twoBackwardRightAI = true;
								draw.repaint();
								//wait
								twoBackwardRightAI = false;
								draw.repaint();
								cells[columnAI][rowAI] = 0;
								cells[columnAI + 1][rowAI + 1] = 4;
								kingStatus();
								checkWin();
								draw.repaint();
								playerMove = 1;
								moveCounter = 0;
							}
						}
						if ((columnAI - 1) <= 7 && (rowAI + 1) <= 7 && cells[columnAI][rowAI] == 4 && playerMove == 2 ) { //backward Left
							if (cells[columnAI - 1][rowAI + 1] == 0) {
								twoBackwardLeftAI = true;
								draw.repaint();
								//wait
								twoBackwardLeftAI = false;
								draw.repaint();
								cells[columnAI][rowAI] = 0;
								cells[columnAI - 1][rowAI + 1] = 4;
								kingStatus();
								checkWin();
								draw.repaint();
								playerMove = 1;
								moveCounter = 0;
							}
						}
					}
				}
			}
			if (playerMove == 2) {
				info.setText("Player One Wins. Game Over."); //Change info label text
				vsAi.setBackground(Color.LIGHT_GRAY); //De-highlight
				vsAi.setOpaque(true);
				vsAi_state = 0; //stop game
				draw.repaint();
				frame.repaint();
			}
		}
	}					
				/*if (cells[i][j] == 2 && (i + 1) <= 7 && (j + 1) <= 7 && (i - 1) >= 0 && (j - 1) >= 0) {
					if (cells[i + 1][j - 1] == 0) { //forward right
						cells[i][j] = 0;
						cells[i + 1][j - 1] = 2;
						draw.repaint();
						playerMove = 1;
					}
					else if (cells[i - 1][j - 1] == 0) { //forward right
						cells[i][j] = 0;
						cells[i - 1][j - 1] = 2;
						draw.repaint();
						playerMove = 1;
					}*/
			
				/*if (cells[i][j] == 2 && (i - 1) >= 0 && (j + 1) <= 7) {
					if (cells[i - 1][j + 1] == 0) {
						cells[i][j] = 0;
						cells[i - 1][j - 1] = 2;
						frame.repaint();
						playerMove = 1;
					}
				}*/
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
	

	public void reset() {
		//First, set all of the pieces to empty
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						cells[i][j] = 0;
					}
				}
				
				//Second, set all the white rectangles to 9, to ensure a piece never moves there
				for (int i = 0; i < 8; i = i + 2) {
					for (int j = 0; j < 8; j = j + 2) {
						cells[i][j] = 9;
					}
				}
				
				for (int i = 1; i < 8; i = i + 2) {
					for (int j = 1; j < 8; j = j + 2) {
						cells[i][j] = 9;
					}
				}
				
				//Third, set all the Player 1 Pieces to 1 and Player 2 Pieces to 2
				for (int i = 0; i < 12; i++) {
					CPieces.onepieces[i] = 1;
					CPieces.twopieces[i] = 2;
				}
				//Set the pieces based on the starting set-up of the game
				cells[1][0] = CPieces.onepieces[0];
				cells[3][0] = CPieces.onepieces[1];
				cells[5][0] = CPieces.onepieces[2];
				cells[7][0] = CPieces.onepieces[3];
				cells[0][1] = CPieces.onepieces[4];
				cells[2][1] = CPieces.onepieces[5];
				cells[4][1] = CPieces.onepieces[6];
				cells[6][1] = CPieces.onepieces[7];
				cells[1][2] = CPieces.onepieces[8];
				cells[3][2] = CPieces.onepieces[9];
				cells[5][2] = CPieces.onepieces[10];
				cells[7][2] = CPieces.onepieces[11];
				
				cells[0][5] = CPieces.twopieces[0];
				cells[2][5] = CPieces.twopieces[1];
				cells[4][5] = CPieces.twopieces[2];
				cells[6][5] = CPieces.twopieces[3];
				cells[1][6] = CPieces.twopieces[4];
				cells[3][6] = CPieces.twopieces[5];
				cells[5][6] = CPieces.twopieces[6];
				cells[7][6] = CPieces.twopieces[7];
				cells[0][7] = CPieces.twopieces[8];
				cells[2][7] = CPieces.twopieces[9];
				cells[4][7] = CPieces.twopieces[10];
				cells[6][7] = CPieces.twopieces[11];
		}
	
	public static void main(String[] args) {
		new Main();

	}
}