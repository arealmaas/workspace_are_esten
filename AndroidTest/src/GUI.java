import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends Thread {
	Calendar calendar;
	
	final int minYear=2011;
	final int maxYear=2014;
	final int left_position=0;
	final int right_position=1;
	
	Year currentYear;
	Month currentMonth;
	Day currentDay;
	Year actualYear;
	Month actualMonth;
	Day actualDay;
	
	JFrame entireFrame;
	JPanel yearPanel, monthPanel, dayPanel, leftPanel, rightPanel, topPanel;
	JComboBox options;
	
	GUI(Calendar calendar) {
		this.calendar=calendar;
	}
	
	public void run() {
		setCurrent();
		generateEntireFrame();
		generateTopPanel();
		generateYearPanel(false, left_position);
		generateMonthPanel(false, right_position);
		setPosition();
	}
	
	private void setCurrent() {
		GregorianCalendar cal=new GregorianCalendar();
		currentYear=calendar.findYear(cal.get(GregorianCalendar.YEAR));
		currentMonth=currentYear.getMonth(cal.get(GregorianCalendar.MONTH));
		currentDay=currentMonth.findDay(cal.get(GregorianCalendar.DAY_OF_MONTH));
		actualYear=currentYear;
		actualMonth=currentMonth;
		actualDay=currentDay;
	}

	private void generateEntireFrame() {
		entireFrame=new JFrame("ESTENPROEEES WORKOUTLOG v0.1alpHA");
		entireFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		entireFrame.setVisible(true);
		entireFrame.getContentPane().setLayout(new BorderLayout());
		
		topPanel=new JPanel();
		leftPanel=new JPanel();
		rightPanel=new JPanel();
		
		entireFrame.add(topPanel, BorderLayout.NORTH);
		entireFrame.add(leftPanel, BorderLayout.WEST);
		entireFrame.add(rightPanel, BorderLayout.EAST);
	}
	
	private void generateTopPanel() {
		String[] availableOptions={"View calendar", "View list of exercises", "View progress"};
		options=new JComboBox<String>(availableOptions);
		
		topPanel.add(options);
		
		entireFrame.pack();
	}
	
	private void generateYearPanel(boolean contains, int position) {
		if (contains) {
			if (position==left_position) 
				leftPanel.removeAll();
			 else
				rightPanel.removeAll();
		}
		
		yearPanel=(JPanel) new YearPanel(actualYear, this);
		
		if (position==right_position)
			rightPanel.add(yearPanel);
		else
			leftPanel.add(yearPanel);
		
		entireFrame.pack();
	}
	
	private void generateMonthPanel(boolean contains, int position) {
		if (contains) {
			if (position==left_position) 
				leftPanel.removeAll();
			 else
				rightPanel.removeAll();
		}
		
		monthPanel=(JPanel) new MonthPanel(actualMonth, this, right_position);
		
		if (position==right_position)
			rightPanel.add(monthPanel);
		else
			leftPanel.add(monthPanel);
		
		entireFrame.pack();
	}
	
	private void generateDayPanel() {
		rightPanel.removeAll();
		
		dayPanel=(JPanel) new DayPanel(actualDay, this);
		
		rightPanel.add(dayPanel);
		entireFrame.pack();
	}
	
	private void setPosition() {
		GraphicsConfiguration gc=entireFrame.getGraphicsConfiguration();
		Rectangle screenSize=gc.getBounds(); // Getting the size/resolution of the screen
		
		entireFrame.setLocation((int) ((screenSize.width/2)-(entireFrame.getWidth()/2)), 
				(int) ((screenSize.height/2)-(entireFrame.getHeight()/2)));
	}
	
	
	public void setActualYear(int newYear) {
		actualYear=calendar.findYear(actualYear.getYearNumber()+newYear);
		actualMonth=actualYear.getMonth(actualMonth.getMonthNumber());
		generateYearPanel(true, left_position);
		generateMonthPanel(true, right_position);
	}
	
	public void setActualMonth(int monthNumber, int position) {
		if (monthNumber==12) {
			setActualYear(1);
			actualMonth=actualYear.getMonth(0);
		} else if (monthNumber==-1) {
			setActualYear(-1);
			actualMonth=actualYear.getMonth(11);
		} else {
			actualMonth=actualYear.getMonth(monthNumber);
		}
		
		generateMonthPanel(true, position);
	}
	
	public void setActualDay(int dayOfMonth) {
		dayOfMonth=dayOfMonth-1; //Converting from actual date to place in array
		Day[] days=actualMonth.getDays();
		
		if (dayOfMonth<0) {
			setActualMonth(actualMonth.getMonthNumber()-1, left_position);
			days=actualMonth.getDays();
			actualDay=days[days.length-1];
		} else if (dayOfMonth>=days.length) {
			setActualMonth(actualMonth.getMonthNumber()+1, left_position);
			days=actualMonth.getDays();
			actualDay=days[0];
		} else {
			actualDay=days[dayOfMonth];
		}
		
		generateDayPanel();
	}
	
	public Year getMinYear() {
		return calendar.findYear(minYear);
	}
	
	public Year getMaxYear() {
		return calendar.findYear(maxYear);
	}
}
