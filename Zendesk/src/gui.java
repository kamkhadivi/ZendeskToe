/**
 * Tic Tac Toe with GUI
 *  
 * Created by Kamran Khadivi-Dimbali
 *  
 * April 2019
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class gui extends JFrame {
	
	private Container    pane;
	private String       currentPlayer;
	private JButton [][] gameBoard;
	private boolean      hasWinner;
	private JMenuBar     menuBar;
	private JMenu        menu;
	private JMenuItem    quit;
	private JMenuItem    reset;
	private int count;


	public gui() { 
		
		super();
		pane = getContentPane();
		pane.setLayout(new GridLayout(3,3));
		setSize(600,600);
		setLocationRelativeTo(null);
		setTitle("Tic Tac Toe");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		currentPlayer = "ZEN";
		gameBoard = new JButton [3][3];
		hasWinner = false;
		//count = 0;
		initializeBoard();
		initializeMenuBar(); 
	}
	
	
	private void initializeMenuBar() {
		
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		
		reset = new JMenuItem("Reset");
		reset.addActionListener (new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resetBoard();
			}
		});
		
		quit = new JMenuItem("Quit");
		quit.addActionListener (new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);;
			}
		});

		menu.add(reset);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	
	
	private void resetBoard() {
		
		currentPlayer = "ZEN";
		hasWinner = false;
		count = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				gameBoard[i][j].setText("");
			}
		}
	}
	
	
	private void initializeBoard() {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				JButton button = new JButton();
				button.setFont(new Font(Font.SERIF, Font.BOLD,45));
				gameBoard[i][j] = button;
				button.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						if(((JButton)e.getSource()).getText().equals("") && hasWinner == false){
							button.setText(currentPlayer);
							isWinner();
							togglePlayer();
						}	

					}
				});
				pane.add(button);
				}
			}
	}
	
	
	private void togglePlayer() {
		if(currentPlayer.equals("ZEN")) 
			currentPlayer = "DESK";
		else 
			currentPlayer = "ZEN";
	}
	
	
	private void isWinner() {
		count++;
		
		if(gameBoard[0][0].getText().equals(currentPlayer) && gameBoard[0][1].getText().equals(currentPlayer) && gameBoard[0][2].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null, currentPlayer + " is the winner!!");
			hasWinner = true;
		} //top row
		else if(gameBoard[0][0].getText().equals(currentPlayer) && gameBoard[1][0].getText().equals(currentPlayer) && gameBoard[2][0].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null, currentPlayer + " is the winner!!");
			hasWinner = true;
		} //left column
		else if(gameBoard[1][0].getText().equals(currentPlayer) && gameBoard[1][1].getText().equals(currentPlayer) && gameBoard[1][2].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null, currentPlayer + " is the winner!!");
			hasWinner = true;
		} //middle row
		else if(gameBoard[2][0].getText().equals(currentPlayer) && gameBoard[2][1].getText().equals(currentPlayer) && gameBoard[2][2].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null, currentPlayer + " is the winner!!");
			hasWinner = true; 
		} //bottom row
		else if(gameBoard[0][0].getText().equals(currentPlayer) && gameBoard[1][1].getText().equals(currentPlayer) && gameBoard[2][2].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null, currentPlayer + " is the winner!!");
			hasWinner = true; 
		} //back slash
		else if(gameBoard[0][2].getText().equals(currentPlayer) && gameBoard[1][1].getText().equals(currentPlayer) && gameBoard[2][0].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null, currentPlayer + " is the winner!!");
			hasWinner = true; 
		} //forward slash
		else if(gameBoard[0][1].getText().equals(currentPlayer) && gameBoard[1][1].getText().equals(currentPlayer) && gameBoard[2][1].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null, currentPlayer + " is the winner!!");
			hasWinner = true;
		} //middle column
		else if(gameBoard[0][2].getText().equals(currentPlayer) && gameBoard[1][2].getText().equals(currentPlayer) && gameBoard[2][2].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null, currentPlayer + " is the winner!!");
			hasWinner = true;
		} //right column
		else if(count == 9 && hasWinner == false) {
			JOptionPane.showMessageDialog(null, "Cats Game!!");
			hasWinner = true;  
		} //cats game
	}
	
}