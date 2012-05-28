import java.util.Iterator;
import java.util.LinkedList;


public class Calendar {
	private LinkedList<Year> years;
	private LinkedList<Day> daysOfActivity;
	
	Calendar() {
		years=new LinkedList<Year>();
		daysOfActivity=new LinkedList<Day>();
		
		generateYears();
		generateDayNames();
	}
	
	private void generateYears() {
		for (int i=2011; i<2015; i++) {
			Year year=new Year(i);
			years.add(year);
		}
	}
	
	public boolean addActiveDay(Day day) {
		daysOfActivity.add(day);
		return true;
	}
	
	public Day findDay(int yearNumber, String monthName, int dayOfMonth) {
		Year year=findYear(yearNumber);
		if (year==null)
			return null;
		
		Month month=year.findMonth(monthName);
		if (month==null) {
			return null;
		}
		
		return month.findDay(dayOfMonth);
	}
	
	public Month findMonth(int yearNumber, String monthName) {
		Year year=findYear(yearNumber);
		if (year==null) {
			return null;
		}
		
		return year.findMonth(monthName);
	}
	
	public Year findYear(int yearNumber) {
		Iterator<Year> iterator=years.iterator();
		
		while (iterator.hasNext()) {
			Year temp=iterator.next();
			
			if (temp.getYearNumber()==yearNumber)
				return temp;
		}
		
		System.out.println("Invalid year!");
		return null;
	}
	
	public LinkedList<Day> getDaysOfActivity() {
		return daysOfActivity;
	}
	
	private void generateDayNames() {
		String[] dayNames={"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		int counter=5;
		Iterator<Year> iterator=years.iterator();
		
		while (iterator.hasNext()) {
			Year year=iterator.next();
			for (int i=0; i<12; i++) {
				Day[] days=year.getMonth(i).getDays();
				for (int j=0; j<days.length; j++) {
					
					if (counter>6)
						counter=counter-7;
					
					days[j].setDayName(dayNames[counter++]);
				}
			}
		}
	}
}
