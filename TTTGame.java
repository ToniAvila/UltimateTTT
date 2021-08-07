package Ultimate;

public class TTTGame {
	
	private APlayer[] players = new APlayer[2];
	private UltimateBoard board;
	
	private String[] marks = {"X", "O"};
	
	private int gameRowSize = 3;
	private int gameColSize = 3;
	private int gameScoreToWin = 3;

	private int currentPlayerIndex = -1;
	
	
	public TTTGame() {
		setPlayers();
		setBoard(new UltimateBoard());
	}

	public void setBoard(UltimateBoard board) {
		//System.out.println("Ultimate Tic Tac Toe Starting...");
		this.board = board;
	}

	private void setPlayers() {
		for(int i = 0; i < players.length; i++) {
			CompPlayer p = new CompPlayer("player " + (i + 1), marks[i]);
			players[i] = p;
		}
	}
	
	public void setPlayers(APlayer player1, APlayer player2) {
		players[0] = player1;
		players[1] = player2;
	}
	
	// handles running of game
	public void start() {
		System.out.println("Ultimate Tic Tac Toe game has started!");
		board.display();
		
		// these will hold the first move and any subsequent moves to keep curr board
		int currBoardNum;
		int[] currBoard2D = null;
			
		switchPlayer();
		System.out.println("\nCurrent Player is: " + players[this.currentPlayerIndex].getMark());
		
		// make first move and save box chosen in currBoardNum for next iteration
		while(!board.makeMove(players[this.currentPlayerIndex].getMark(), 
				players[this.currentPlayerIndex].selectBoard(9), 
			    currBoardNum = players[this.currentPlayerIndex].selectBox(9))) {
			System.out.println("Try again...");
		}
		
		board.display();
		currBoard2D = board.convertMove(currBoardNum); // initializes curr board location (2D)
		
		do {
			switchPlayer();
			System.out.println("\nCurrent Player is: " + players[this.currentPlayerIndex].getMark());
	
			System.out.print("Selected board: " + currBoardNum);
			if(board.ultimateBoard[currBoard2D[0]][currBoard2D[1]].availability() != 0) { // if board sent to is available
				int holdCurrent = currBoardNum;
				board.displayPossibleMoves(board.ultimateBoard[currBoard2D[0]][currBoard2D[1]]);
				while(!board.makeMove(players[this.currentPlayerIndex].getMark(), 
						holdCurrent, 
						currBoardNum = players[this.currentPlayerIndex].selectBox(9)))
					System.out.println("Try again...");
			}else { // if board sent to is full, choose another and store boardNum
				while(!board.makeMove(players[this.currentPlayerIndex].getMark(), 
						players[this.currentPlayerIndex].selectBoard(9), 
						currBoardNum = players[this.currentPlayerIndex].selectBox(9)))
					System.out.println("Try again...");
				}
			
			board.display();
			
			checkSmalls(); // checking smaller boards for wins
			board.displayWon(); // displaying smaller board wins
			currBoard2D = board.convertMove(currBoardNum); // saving row,col of board for next iteration
		
		}while(!bigGameOver());
	}
	
	// checking for win in small board
	public void checkSmalls() {
		for(int i = 0; i < board.ultimateBoard.length; i++) {
			for(int j = 0; j < board.ultimateBoard[i].length; j++) {
				isWinnerSmall(board.ultimateBoard[i][j]);
			}
		}
	}
	
	// checks if every specific board has been won
	public boolean allWon() {
		for(int i = 0; i < board.ultimateBoard.length; i++) {
			for(int j = 0; j < board.ultimateBoard[i].length; j++) {
				if(!board.ultimateBoard[i][j].beenWon())
					return false;
			}
		}
		return true;
	}
	
	// checks if every specific board is full
	public boolean allFull() {
		for(int i = 0; i < board.ultimateBoard.length; i++) {
			for(int j = 0; j < board.ultimateBoard[i].length; j++) {
				if(board.ultimateBoard[i][j].availability() != 0)
					return false;
			}
		}
		return true;
	}

	// switches player each loop, simply change player index
	private void switchPlayer() {
		if(this.currentPlayerIndex == -1 || this.currentPlayerIndex == 1) 
			this.currentPlayerIndex = 0;
		else
			this.currentPlayerIndex = 1;
	}
	
	// checks if the game is over, checks for win, tie by by board wins, and tie by capacity
	private boolean bigGameOver() {
		if(bigWinner()) {
			System.out.println(this.marks[this.currentPlayerIndex] + " won.");
			return true;
		}else if(!bigWinner() && allWon()) {
			System.out.println("The game was a tie.");
			return true;
		}else if(!bigWinner() && allFull()) {
			System.out.println("The game was a tie.");
			return true;
		}
		
		return false;
	}

	// checks win in big board
	private boolean bigWinner() {
		if(bigCheckHorizontal())
			return true;
		if(bigCheckVertical())
			return true;
		if(bigCheckLDiag())
			return true;
		if(bigCheckDiag())
			return true;
		
		return false;
	}

	// checking for diagonal win on ultimate
	private boolean bigCheckDiag() {
		int counter = 0;
		
		for(int i = 0; i < board.ultimateBoard.length && i < board.ultimateBoard[i].length; i++) {
			if(board.ultimateBoard[i][i].beenWon() && board.ultimateBoard[i][i].getWinner() == 
					players[this.currentPlayerIndex].getMark())
				counter++;
			}
		
		if(counter == this.gameScoreToWin) // 
			return true;
		
		return false;
	}


	// checking for diagonal win on ultimate
	private boolean bigCheckLDiag() {
		int j = 0, counter = 0;
		for(int i = board.ultimateBoard.length - 1; i >= 0; i--) {
			
			if(board.ultimateBoard[i][j].beenWon() && board.ultimateBoard[i][j].getWinner() == 
					players[this.currentPlayerIndex].getMark())
				counter++;

			j++;
			}
		
		if(counter == 3)
			return true;
		
		return false;
	}

	// checking for vertical win on ultimate
	private boolean bigCheckVertical() {
		int points = 0;
		for(int i = 0; i < board.ultimateBoard.length; i++) {
			points = 0;
			for(int j = 0; j < board.ultimateBoard[i].length; j++) {
				if(board.ultimateBoard[j][i].beenWon() && board.ultimateBoard[j][i].getWinner() == 
						players[this.currentPlayerIndex].getMark())
					points++;
				
				if(points == 3)
					return true;
			}
				
		}
		return false;
	}

	// checking for horizontal win on ultimate
	private boolean bigCheckHorizontal() {
		int points = 0;
		for(int i = 0; i < board.ultimateBoard.length; i++) {
			points = 0;
			for(int j = 0; j < board.ultimateBoard[i].length; j++) {
				if(board.ultimateBoard[i][j].beenWon() && board.ultimateBoard[i][j].getWinner() == 
						players[this.currentPlayerIndex].getMark())
					points++;
				
				if(points == 3)
					return true;
			}
				
		}
		return false;
	}
	
	// checking all forms of winning
	private void isWinnerSmall(OtherBoard current) {
		if(checkRows(current)) {
			if(!current.beenWon()) { // making sure we dont change a winner
				current.setWin();
				current.setWinner(players[this.currentPlayerIndex].getMark());
			}
		}
		else if(checkCols(current)) {
			if(!current.beenWon()) {
				current.setWin();
				current.setWinner(players[this.currentPlayerIndex].getMark());
			}
		}
		else if(checkRDiag(current)) {
			if(!current.beenWon()) {
				current.setWin();
				current.setWinner(players[this.currentPlayerIndex].getMark());
				}		
		}
		else if(checkLDiag(current)) {
			if(!current.beenWon()) {
				current.setWin();
				current.setWinner(players[this.currentPlayerIndex].getMark());
				}
		}
	}
	
	// check each col individually
	private boolean checkCols(OtherBoard current) {
		for(int col = 0; col < this.gameColSize; col++) {
			if(checkCol(col, current))
				return true;
		}
		return false;
	}
	
	// check specific col
	private boolean checkCol(int col, OtherBoard current) {
		int count = 0;
		for(int row = 0; row < this.gameRowSize; row++) {
			if(current.getMark(row,  col) == players[currentPlayerIndex].getMark())
				count++;
		}
		if(count == this.gameScoreToWin)
			return true;
	
		return false;
	}
	
	// checks each row individually
	private boolean checkRows(OtherBoard current) {
		for(int row = 0; row < this.gameRowSize; row++) {
			if(checkRow(row, current))
				return true;
		}
		return false;
	}
	
	// check specific row
	private boolean checkRow(int row, OtherBoard current) {
		int count = 0;
		for(int col = 0; col < this.gameColSize; col++) {
			if(current.getMark(row,  col) == (players[currentPlayerIndex].getMark()))
				count++;
		}
		if(count == this.gameScoreToWin)
			return true;

		return false;
	}
	
	// checks right to left diag
	private boolean checkRDiag(OtherBoard current) {
		int count = 0;
		for(int row = 0, col = this.gameRowSize-1; row < this.gameColSize && col >= 0; row++, col--) {
			if(current.getMark(row,  col) == (players[currentPlayerIndex].getMark()))
				count++;
		}
		if(count == this.gameScoreToWin)
			return true;
		
		return false;
	}
	
	// checks left to right diag
	private boolean checkLDiag(OtherBoard current) {
		int count = 0;
		for(int col = 0, row = 0; col < this.gameColSize && row < this.gameRowSize; row++, col++) {
			if(current.getMark(row,  col) == (players[currentPlayerIndex].getMark()))
				count++;
		}
		if(count == this.gameScoreToWin)
			return true;
		
		return false;
	}
	
}
	

