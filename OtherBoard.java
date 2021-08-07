package Ultimate;

public class OtherBoard{

	private int boardRowSize;
	private int boardColSize;
	private String[][] board;
	private boolean hasWon = false;
	private String winner = "";


	OtherBoard(){
		this(3, 3, "TTT 2D array of char");
	}

	OtherBoard(int row, int col, String name){
		this.setSize(row, col);
	}

	
	// initialize board
	private void init() {
		this.board = new String[boardRowSize][boardColSize];
		for(int i = 0 ; i < board.length; i++){
			for(int j = 0 ; j < board[i].length; j++){
				board[i][j] = Mark.DASH.getMark();
			}
		}
	}
	
	// for use in printing ultimateBoard
	public void printRow(int row, int num) {
		System.out.print("BOARD#" + num + " |" );
		for(int j = 0; j < board[row].length; j++)
			System.out.print(" " + board[row][j] + " | ");
	}
	

	// to check availability
	public int availability() {
		int count = 0;
		for(int i = 0 ; i < board.length; i++){
			for(int j = 0 ; j < board[i].length; j++){
				if(board[i][j] == Mark.DASH.getMark()) count++;
			}
		}
		return count;
	}

	// get mark at position
	public String getMark(int row, int col) {
		return board[row][col];
	}

	// to set mark at position, for use in ultimate board
	public boolean setMark(int row, int col, String player) {
		if(board[row][col] == Mark.DASH.getMark()){
			board[row][col] = player;
			return true;
		}else return false;
	}

	public void setSize(int row, int col) {
		this.boardRowSize = row;
		this.boardColSize = col;
		this.init();
	}
	
	// assorted getters and setters
	
	public boolean beenWon() {
		return this.hasWon;
	}
	
	public void setWinner(String mark) {
		this.winner = mark;
	}
	
	public String getWinner() {
		return this.winner;
	}
	
	public void setWin() {
		this.hasWon = true;
	}

	public int getColSize() {
		return this.boardColSize;
	}

	public int getRowSize() {
		return this.boardRowSize;
	}
}
