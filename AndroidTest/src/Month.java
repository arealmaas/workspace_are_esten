
public class Month {
	private Year year;
	private String monthName;
	private int monthNumber;
	private Day[] days;
	private String toString;
	
	Month(String monthName, int monthNumber, Year year) {
		this.monthName=monthName;
		this.monthNumber=monthNumber;
		this.year=year;
		this.toString=monthName+", "+year.toString();
		
		generateDays();
	}
	
	private void generateDays() {
		/* Deciding how many days there should be in the month */
		if (monthName.equals("January") || monthName.equals("March") || monthName.equals("May") ||
			monthName.equals("July") || monthName.equals("August") || monthName.equals("October") ||
			monthName.equals("December"))
			days=new Day[31];
		else if (monthName.equals("February"))
			days=daysInFebruary();
		else
			days=new Day[30];
		
		/* Generating the days */
		for (int i=0; i<days.length; i++) {
			days[i]=new Day(year, this, i+1);
		}
	}
	
	private Day[] daysInFebruary() {
		int yearNumber=year.getYearNumber();
		
		/* Year divisible by 100 */
		if (yearNumber%100==0) {
			if (yearNumber%400==0) 
				return new Day[29];
			else
				return new Day[28];
			
		} else {
			if (yearNumber%4==0) 
				return new Day[29];
			else
				return new Day[28];
		}
	}
	
	public Day findDay(int dayOfMonth) {
		if (dayOfMonth-1<days.length && dayOfMonth-1>=0) 
			return days[dayOfMonth-1];
		else {
			System.out.println("Invalid day of month!");
			return null;
		}
	}
	
	public Day[] getDays() {
		return days;
	}
	
	public Year getYear() {
		return year;
	}
	
	public void printDays() {
		System.out.println("My days:");
		
		for (int i=0; i<days.length; i++) {
			System.out.println(days[i].toString());
		}
	}
	
	public String getName() {
		return monthName;
	}
	
	public String toString() {
		return toString;
	}
	
	public int getMonthNumber() {
		return monthNumber;
	}
}
