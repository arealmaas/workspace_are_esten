import java.util.GregorianCalendar;

public class CurrentDate {
	GregorianCalendar cal;
	int year;
	int month;
	int day;
	
	CurrentDate() {
		cal=new GregorianCalendar();
		year=cal.get(GregorianCalendar.YEAR);
		month=cal.get(GregorianCalendar.MONTH);
		day=cal.get(GregorianCalendar.DAY_OF_MONTH);
	}
	
	public String getDate() {
		return year+"."+month+"."+day;
	}
}
