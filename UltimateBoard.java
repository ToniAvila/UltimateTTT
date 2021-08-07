package Ultimate;


public class UltimateBoard {
	public OtherBoard[][] ultimateBoard;	
	
	public UltimateBoard() {
		this.ultimateBoard = new OtherBoard[3][3];
		this.fill();
	}
	
	// fills ultimate board with default OtherBoards
	public void fill() {
		for(int i = 0; i < ultimateBoard.length; i++) {
			for(int j = 0; j < ultimateBoard[i].length; j++)
				ultimateBoard[i][j] = new OtherBoard();
		}
	}
	
	// displays ultimate board row by row
	public void display() {
		int boardNum;
		for(int i = 0; i < ultimateBoard.length; i++) {
			for(int counter = 0; counter < 3; counter++) {
				
				if(i <= 0) boardNum = 0;
				else if(i <= 1) boardNum = 3;
				else boardNum = 6;
				
				for(int j = 0; j < ultimateBoard[i].length; j++, boardNum++) {
					ultimateBoard[i][j].printRow(counter, boardNum); // print row by row
					
					if((boardNum + 1) % 3 == 0) // if at end, newline
						System.out.print("\n");
				}
			}
		}
	}
	
	// displays all small winners
	public void displayWon() {
		for(int i = 0; i < ultimateBoard.length; i++) {
			for(int j = 0; j < ultimateBoard[i].length; j++) {
				if(ultimateBoard[i][j].beenWon()){
					int boardNum = convertMove(i, j);
					System.out.println("Board# " +  boardNum  + " has been won by " + ultimateBoard[i][j].getWinner());
				}
			}
		}
	}
	
	// make move
	public boolean makeMove(String mark, int board, int box) {
		int[] boardXY = convertMove(board);
		int[] boxXY = convertMove(box);
	    // if box position at board position chosen is a dash, set mark of player and return true, else return false
		// Note: at position 0 we have the row, at position 1 we have the col
		if(ultimateBoard[boardXY[0]][boardXY[1]].getMark(boxXY[0], boxXY[1]) == Mark.DASH.getMark()){
			ultimateBoard[boardXY[0]][boardXY[1]].setMark(boxXY[0], boxXY[1], mark);
			return true;
		}else return false;
		
	}
	
	// converts single number to 2D equivalent
	public int[] convertMove(int num) {
		switch(num) {
		case 0: return new int[] {0, 0};
		case 1: return new int[] {0, 1};
		case 2: return new int[] {0, 2};
		case 3: return new int[] {1, 0};
		case 4: return new int[] {1, 1};
		case 5: return new int[] {1, 2};
		case 6: return new int[] {2, 0};
		case 7: return new int[] {2, 1};
		case 8: return new int[] {2, 2};
		}
		return null;
	}
	
	// converts 2 nums to 1D equivalent
	public int convertMove(int i, int j) {
		if(i == 0 && j == 0) return 0;
		else if(i == 0 && j == 1) return 1;
		else if(i == 0 && j == 2) return 2;
		else if(i == 1 && j == 0) return 3;
		else if(i == 1 && j == 1) return 4;
		else if(i == 1 && j == 2) return 5;
		else if(i == 2 && j == 0) return 6;
		else if(i == 2 && j == 1) return 7;
		else if(i == 2 && j == 2) return 8;
		else return -1;
	}
	
	// displays possible moves within a board (boxes)
	public void displayPossibleMoves(OtherBoard board) {
		System.out.print("\nPossible box to use: " );
		for(int i = 0; i < board.getRowSize(); i++) {
			for(int j = 0; j < board.getColSize(); j++) {
				if(board.getMark(i, j) == Mark.DASH.getMark()) {
					int possibleBox = convertMove(i, j); // conversion to single number
					System.out.print(possibleBox + " | ");
				}
			}
		}
	}
}
