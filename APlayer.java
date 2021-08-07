package Ultimate;

public abstract class APlayer {
	
	private String name;
	private String mark;

	public APlayer(String name, String mark) {
		setName(name);
		setMark(mark);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMark() {
		return mark;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	// these two methods will be used for ultimate ttt
	public abstract int selectBoard(int range);
	public abstract int selectBox(int range);
}
