import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame implements ActionListener {
	final int row = 3; //initialize row
	final int col = 3; //initialize column
	JButton[][] button = new JButton[row][col]; //declare 2D array buttons
	boolean player = true; // keep track of player
	boolean win = false; //determines who wins the game
	Scanner input = new Scanner(System.in); //declare scanner
	JFrame frame = new JFrame("TIC TAC TOE"); //declare frame
	int turns = 0; //keep track of how many turns have been played

	//constructor
	public Game() { 

		frame.setSize(320, 270); // set frame size

		frame.setLayout(new GridLayout(3, 3)); // set the frame layout to grid
												// layout because tic tac toe
												// is 3x3
		
		frame.setLocationRelativeTo(null); // make the screen appear in the
											// center

		
		//start declaring buttons, adding listener and adding all buttons to frame
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				button[r][c] = new JButton("");
				button[r][c].addActionListener(this);

				frame.add(button[r][c]);
			}
		}
		//end

		System.out.println("game on, player 1 is X"); //indicates that the game has started

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set operation
		frame.setResizable(false);
		frame.setVisible(true); // make it visible

	}

	public static void main(String[] args) {
		Game game = new Game(); // run GUI
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// boolean player = true;

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (e.getSource() == (button[r][c]) && button[r][c].getText().equals("")) {
					if (player) {
						button[r][c].setText("X");
						button[r][c].setFont(new Font("Arial", Font.PLAIN, 40));
						player = false;
						X_checkforwin();
						if (checkfortie(turns)) {
							System.out.println("tie game");
							play_again();
						}
						if (win) {
							play_again();
						}

					} else {
						button[r][c].setText("O");
						button[r][c].setFont(new Font("Arial", Font.PLAIN, 40));
						player = true;
						O_checkforwin();
						if (checkfortie(turns)) {
							System.out.println("tie game");
							play_again();
						}
						if (win) {
							play_again();
						}

					}
				}
			}
		}
	}

	private boolean checkfortie(int turns) {
		if (turns == 9) {
			return true;
		}
		return false;
	}

	private void play_again() {
		// TODO Auto-generated method stub

		frame.setVisible(false);

		System.out.println("do you want to play again, Y or N");

		String response = input.next();

		if (response.equalsIgnoreCase("y")) {
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					button[r][c].setText("");
				}
			}
			frame.setVisible(true);
			turns = 0;
			player = true;
			win = false;
		} else if (response.equalsIgnoreCase("n")) {
			System.out.println("that's game");
			System.exit(0);
		} else {
			System.out.println("wrong command");
			play_again();
		}
	}

	private void O_checkforwin() {
		// TODO Auto-generated method stub
		int X_diagonal = 0;
		int Y_diagonal = 0;

		turns++;

		// O horizontals
		// 0,0 ; 0,1 ; 0,2 ; 1,0 ; 1,1 ; 1,2 ; 2,0 ; 2,1 ; 2,2
		for (int r = 0; r < row; r++) {
			if (button[r][0].getText().equals("O")) {
				if (button[r][1].getText().equals("O")) {
					if (button[r][2].getText().equals("O")) {
						System.out.println("O win");
						win = true;
					}
				}
			}
		}

		// O verticals
		// 0,0 ; 1,0; 2,0 ; 0,1 ; 1,1 ; 2,1 ; 0,2; 1,2 ; 2,2
		for (int c = 0; c < col; c++) {
			if (button[0][c].getText().equals("O")) {
				if (button[1][c].getText().equals("O")) {
					if (button[2][c].getText().equals("O")) {
						System.out.println("O win");
						win = true;
					}
				}
			}
		}
		// diagonals
		if (button[X_diagonal][Y_diagonal].getText().equals("O")) {
			if (button[X_diagonal + 1][Y_diagonal + 1].getText().equals("O")) {
				if (button[X_diagonal + 2][Y_diagonal + 2].getText().equals("O")) {
					System.out.println("O win");
					win = true;
				}
			}
		}
		if (button[X_diagonal][Y_diagonal + 2].getText().equals("O")) {
			if (button[X_diagonal + 1][Y_diagonal + 1].getText().equals("O")) {
				if (button[X_diagonal + 2][Y_diagonal].getText().equals("O")) {
					System.out.println("O win");
					win = true;
				}
			}
		}

	}

	private void X_checkforwin() {
		int X_diagonal = 0;
		int Y_diagonal = 0;

		turns++;

		// X horizontals
		// 0,0 ; 0,1 ; 0,2 ; 1,0 ; 1,1 ; 1,2 ; 2,0 ; 2,1 ; 2,2
		for (int r = 0; r < row; r++) {
			if (button[r][0].getText().equals("X")) {
				if (button[r][1].getText().equals("X")) {
					if (button[r][2].getText().equals("X")) {
						System.out.println("X win");
						win = true;
					}
				}
			}
		}

		// X verticals
		// 0,0 ; 1,0; 2,0 ; 0,1 ; 1,1 ; 2,1 ; 0,2; 1,2 ; 2,2
		for (int c = 0; c < col; c++) {
			if (button[0][c].getText().equals("X")) {
				if (button[1][c].getText().equals("X")) {
					if (button[2][c].getText().equals("X")) {
						System.out.println("X win");
						win = true;
					}
				}
			}
		}
		// diagonals
		if (button[X_diagonal][Y_diagonal].getText().equals("X")) {
			if (button[X_diagonal + 1][Y_diagonal + 1].getText().equals("X")) {
				if (button[X_diagonal + 2][Y_diagonal + 2].getText().equals("X")) {
					System.out.println("X win");
					win = true;
				}
			}
		}
		if (button[X_diagonal][Y_diagonal + 2].getText().equals("X")) {
			if (button[X_diagonal + 1][Y_diagonal + 1].getText().equals("X")) {
				if (button[X_diagonal + 2][Y_diagonal].getText().equals("X")) {
					System.out.println("X win");
					win = true;
				}
			}
		}

	}
}
