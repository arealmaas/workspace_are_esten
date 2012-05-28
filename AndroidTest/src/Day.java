
public class Day {
	private Year year;
	private Month month;
	private int dayOfMonth;
	private String toString;
	private String dayName;
	private String date;
	private WorkOut[] workOuts;
	
	Day(Year year, Month month, int dayOfMonth) {
		this.year=year;
		this.month=month;
		this.dayOfMonth=dayOfMonth;
		this.date=year+""+month+""+dayOfMonth;
		this.workOuts=new WorkOut[0];
	}
	
	public void setDayName(String dayName) {
		this.dayName=dayName;
		toString=dayName+", "+Integer.toString(dayOfMonth)+" "+month.toString();
	}
	
	public boolean addWorkOut(WorkOut workOut) {
		WorkOut[] temp=new WorkOut[workOuts.length+1];
		
		for (int i=0; i<workOuts.length; i++) {
			temp[i]=workOuts[i];
		}
		
		temp[workOuts.length]=workOut;
		workOuts=temp;
		return true;
	}
	
	public WorkOut[] getWorkOuts() {
		if (workOuts.length==0) {
			return null;
		} else
			return workOuts;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getName() {
		return dayName;
	}
	
	public String toString() {
		return toString;
	}
	
	public Year getYear() {
		return year;
	}
	
	public Month getMonth() {
		return month;
	}
	
	public int getDayOfMonth() {
		return dayOfMonth;
	}
}
