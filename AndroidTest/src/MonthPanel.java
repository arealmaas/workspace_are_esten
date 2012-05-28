import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MonthPanel extends JPanel {
	private Month month;
	private GUI gui;
	private int position;
	
	private JPanel topPanel, dayPanel;
	private JLabel monthName;
	private JButton nextMonth, prevMonth;
	private JButton[] dayButtons;
	
	MonthPanel(Month month, GUI gui, int position) {
		this.month=month;
		this.gui=gui;
		this.position=position;
		setLayout(new BorderLayout());
		setTopPanel();
		setDayButtons();
	}
	
	private void setTopPanel() {
		prevMonth=new JButton("<<");
		nextMonth=new JButton(">>");
		monthName=new JLabel(month.toString());
		topPanel=new JPanel();
		
		/* Checking if next and prev months exist */
		if (month.getYear()==gui.getMinYear() && month.getName().equals("January"))
			prevMonth.setEnabled(false);
		else
			prevMonth.setEnabled(true);
		
		if (month.getYear()==gui.getMaxYear() && month.getName().equals("December"))
			nextMonth.setEnabled(false);
		else
			nextMonth.setEnabled(true);
		
		prevMonth.addActionListener(new MonthButtonListener());
		nextMonth.addActionListener(new MonthButtonListener());
		
		topPanel.add(prevMonth);
		topPanel.add(monthName);
		topPanel.add(nextMonth);
		
		add(topPanel, BorderLayout.NORTH);
	}
	
	public class MonthButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton temp=(JButton) e.getSource();
			
			if (temp==prevMonth) {
				gui.setActualMonth(month.getMonthNumber()-1, position);
				gui.setActualYear(0);
			} else {
				gui.setActualMonth(month.getMonthNumber()+1, position);
				gui.setActualYear(0);
			}
		}
	}
	
	private void setDayButtons() {
		dayPanel=new JPanel();
		dayPanel.setLayout(new GridLayout(6, 7));
		Day[] days=month.getDays();
		dayButtons=new JButton[days.length];
		int startingPosition=findStartingPosition(days[0]);
		int counter=0;
		
		int numberOfPrevDays=0;
		if (month.getYear().getYearNumber()==2011 && month.getName().equals("January")) 
			numberOfPrevDays=32;
		else if (month.getName().equals("January"))
			numberOfPrevDays=32;
		else
			numberOfPrevDays=(month.getYear().getMonth(month.getMonthNumber()-1).getDays()).length+1;
			
		
		for (int i=0; i<6; i++) {
			for (int j=0; j<7; j++) {
				if (i==0 && j<startingPosition) {
					JButton temp=new JButton(Integer.toString(numberOfPrevDays-(startingPosition-j)));
					temp.setEnabled(false);
					dayPanel.add(temp);
				} else if (counter>=days.length) {
					JButton temp=new JButton(Integer.toString(counter-days.length+1));
					temp.setEnabled(false);
					dayPanel.add(temp);
					counter++;
				} else {
					dayButtons[counter]=new JButton(Integer.toString(counter+1));
					dayButtons[counter].addActionListener(new DayButtonListener(days[counter]));
					dayPanel.add(dayButtons[counter]);
					counter++;
				}
			}
		}

		add(dayPanel, BorderLayout.SOUTH);
	}
	
	public class DayButtonListener implements ActionListener {
		Day day;
		
		DayButtonListener(Day day) {
			this.day=day;
		}
		
		public void actionPerformed(ActionEvent e) {
			gui.setActualMonth(month.getMonthNumber(), gui.left_position);
			gui.setActualDay(day.getDayOfMonth());
		}
		
	}
	
	private int findStartingPosition(Day day) {
		String[] weekdays={"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		
		for (int i=0; i<7; i++)
			if (day.getName().equals(weekdays[i]))
				return i;
		
		return 0;
	}
}
