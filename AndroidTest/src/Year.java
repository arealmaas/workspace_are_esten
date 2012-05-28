
public class Year {
	private int yearNumber;
	private Month[] months;
	private String toString;
	
	Year(int yearNumber) {
		this.yearNumber=yearNumber;
		this.months=new Month[12];
		this.toString=Integer.toString(yearNumber);
		
		generateMonths();
	}
	
	private void generateMonths() {
		String[] monthNames={"January", "February", "March", "April", "May", "June", "July",
							"August", "September", "October", "November", "December"};
		
		for (int i=0; i<months.length; i++) {
			months[i]=new Month(monthNames[i], i, this);
		}
	}
	
	public Month findMonth(String monthName) {
		String[] monthNames={"January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December"};
		
		for (int i=0; i<monthNames.length; i++) {
			if (monthName.equals(monthNames[i]))
				return months[i];
		}
		
		System.out.println("Invalid month!");
		return null;
	}
	
	public Month getMonth(int index) {
		return months[index];
	}
	
	public int getYearNumber() {
		return yearNumber;
	}
	
	public void printMonths() {
		System.out.println("My months:");
		for (int i=0; i<months.length; i++) {
			System.out.println(months[i].toString());
		}
	}
	
	public String toString() {
		return toString;
	}
	
}
