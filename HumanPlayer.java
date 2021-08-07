package Ultimate;

import java.util.*;

public class HumanPlayer extends APlayer {
	Scanner input = new Scanner(System.in);
	
	public HumanPlayer(String name, String mark) {
		super(name, mark);
	}
	
	@Override // select board
	public int selectBoard(int range) {
		System.out.println("\nPlease enter a valid board number (0 to " + (range - 1) +"): ");
		int board;
		do {
			board = input.nextInt();
			if(board < 0 || board > range - 1)
				System.out.print("Out of range, try again: "); // error message
		}while(board < 0 || board > range - 1);
		
		System.out.print("\nBoard selected: " + board);
		return board;
	}
	
	@Override // select box
	public int selectBox(int range) {
		System.out.println("\nPlease enter a valid box number (0 to " + (range - 1) +"): ");
		int box;
		do {
			box = input.nextInt();
			if(box < 0 || box > range - 1)
				System.out.println("Out of range, try again:"); // error message
		}while(box < 0 || box > range - 1);
		
		System.out.println("\nBox selected: " + box);
		return box;
	}
}
