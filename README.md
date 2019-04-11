# ZendeskToe

##TIC TAC TOE GAME

Created by Kamran Khadivi-Dimbali

How to Run: If you want to run this program, you can download the Eclipse IDE for Java Developers, clone this repository and run the program.
I personally coded this with Eclipse IDE for Java Developers Version: 2019-03 (4.11.0), Build id: 20190314-1200

Summary: In this repository you will find a Tic Tac Toe game coded in Java.  I used Java Swing to provide a clean and neat graphical user interface where two players can battle it out in games of Tic Tac Toe!

Code: The program consists of two classes: main and gui.  The purpose of the main class is to instantiate the gui class. The gui class has the logic and methods that create the user interface and the game. Let us go over the methods which are key features in the gui class:

*initializeMenuBar()* -- This method prepares menu bar in the interface.  The menu bar for this game is equipped with two buttons: Reset and Quit.  Inside the methods I used ActiveListener to determine when someone clicks one of these buttons, so the program will respond accordingly.

*resetBoard()* -- This method resets each of the grids using a nested for loop and also resets a few variables.

*initializeBoard()* -- Here is where the game board gets updated when a player clicks one of the grids during the game. It also utilizes ActionListener and will update a space when chosen.  Once a space is chosen it will not be able to be used again.

*togglePlayer()* -- This method is called in the initializeBoard() method and will switch turns after a player has inputed their move.

*isWinner()* -- This method will determine the result of the game.  It is also called within initializeBoard().  The method consists of conditional statements which determine a victory in Tic Tac Toe or a tie (Cats game).  Once someone wins or all the spaces are full and we have a tie, a dialog box will pop up with a message of the result of the game.  This was implemented using JOptionPane from Java Swing. 
  
  
