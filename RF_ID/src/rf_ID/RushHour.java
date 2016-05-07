package rf_ID;

public class RushHour {
	private String start;
	private String end;
	private int number;
	public RushHour(String start, String end, int num) {
		this.start = start;
		this.end = end;
	}
	@Override
	public String toString() {
		return (this.start + " --- " +  this.end); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}
