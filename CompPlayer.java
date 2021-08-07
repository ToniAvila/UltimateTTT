package Ultimate;

public class CompPlayer extends APlayer {
	
	
	public CompPlayer(String name, String mark) {
		super(name, mark);
	}
	
	public int randomNumber(int range) {
		return (int) (Math.random() * range);
	}
	
	@Override // selecting random board within range
	public int selectBoard(int range) {
		int randomNum = randomNumber(range);
		System.out.println("\nBoard selected: " + randomNum);
		return randomNum;
	}
	
	@Override // selecting random box within range
	public int selectBox(int range) {
		int randomNum = randomNumber(range);
		System.out.println("\nBox selected: " + randomNum);
		return randomNum;
	}
	
}
