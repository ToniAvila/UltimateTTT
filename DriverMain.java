package Ultimate;

/* Toni Avila, TXA180025
 * Ultimate TTT
 * 
 * Analysis: Create an Ultimate Tic Tac Toe game using OOP. Utilizing code I have already written
 * previously, I can add another class which will be the UltimateBoard class. This class will have
 * a 3x3 array of OtherBoard objects, or simple 3x3 boards. We will check for a win on each small board then subsequently
 * also check if a win has happened on the big board. We will utilize similar methods in both checking
 * for wins on a single small board and the large board, checking vertically, horizontally, and both diagonal 
 * ways. Essentially, what I am doing is creating an ultimate board comprised of regular boards.
 * 
 * 
 * Design: Create an UltimateBoard class which houses a 2D 3x3 array of OtherBoard objects. We will also
 * need a makeMove method and a convertMove method. The make move method will make a move on a specific board,
 * the convertMove method will convert a single int into a 2D row, col array in order to find the correct board.
 * Another convert move method will be created to convert a row, col location into a single int num. That is the
 * basis for how the program runs, similar to a regular small tictactoe game. At first run, we select a board and
 * a box in which to make our move. Those single ints are converted into usable coordinates then a move is made
 * in order to set the mark of the current player where the player chooses. On subsequent iterations, we utilize the 
 * previously entered box number as our board num, not asking for a board num ever again unless a player is sent to a 
 * full board, which then means he is allowed a free move. Our TTTGame class will initialize the game and players
 * and also have all the methods checking for wins, a big win, ties, a big tie, etc. where "big" references the ultimate
 * board.
 * 
 * 
 * Test: The only input validation tests I had to perform were tests for numbers out of range being
 * entered. If a number out of range is entered, we simply keep looping in order to
 * get a valid number. 
 * 
 * Another test I performed was of course attempting to place a mark where a mark is already inserted, which
 * will loop the program until the user enters a valid box. 
 * 
 * 
*/

public class DriverMain {
	public static void main(String[] args) {
		
		TTTGame game = new TTTGame();
	    //game.setPlayers(new HumanPlayer("Player1", "X"), new HumanPlayer("Player2", "O"));
		game.setPlayers(new CompPlayer("Player1", "X"), new CompPlayer("Player2", "O"));
	    //game.setPlayers(new HumanPlayer("Player1", "X"), new CompPlayer("Player2", "O"));
		game.start();
		
	}

}
