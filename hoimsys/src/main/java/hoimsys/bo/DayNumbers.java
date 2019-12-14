package hoimsys.bo;

public class DayNumbers {

	private long timeStamep;
	private Integer Numbers;

	public DayNumbers() {
		super();
	}
	public DayNumbers(long timeStamep, Integer numbers) {
		super();
		this.timeStamep = timeStamep;
		Numbers = numbers;
	}
	public long getTimeStamep() {
		return timeStamep;
	}
	public void setTimeStamep(long timeStamep) {
		this.timeStamep = timeStamep;
	}
	public Integer getNumbers() {
		return Numbers;
	}
	public void setNumbers(Integer numbers) {
		Numbers = numbers;
	}
	@Override
	public String toString() {
		return "DayNumbers [timeStamep=" + timeStamep + ", Numbers=" + Numbers + "]";
	}
	
	
}
