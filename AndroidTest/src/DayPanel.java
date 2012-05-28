import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class DayPanel extends JPanel {
	private Day day;
	private GUI gui;
	
	private JPanel topPanel, midPanel, bottomPanel;
	private JButton nextDay, prevDay, addWorkOut;
	private JLabel dayName, workoutsLogged;
	private JTextArea workoutList;
	private JScrollPane workouts;
	
	DayPanel(Day day, GUI gui) {
		this.day=day;
		this.gui=gui;
		setLayout(new BorderLayout());
		generateTopPanel();
		generateMidPanel();
		generateBottomPanel();
	}
	
	private void generateTopPanel() {
		topPanel=new JPanel();
		
		prevDay=new JButton("<<");
		nextDay=new JButton(">>");
		dayName=new JLabel(day.toString());
		
		/* Checking if the day is the first available, and disabling prevDay button if so */
		if (day.getYear().getYearNumber()==gui.minYear && day.getMonth().getName().equals("January") && day.getDayOfMonth()==0)
			prevDay.setEnabled(false);
		else
			prevDay.setEnabled(true);
		
		/* Checking if the day is the last available, and disabling nextDay button if so */
		if (day.getYear().getYearNumber()==gui.maxYear && day.getMonth().getName().equals("December") && day.getDayOfMonth()==30)
			nextDay.setEnabled(false);
		else
			nextDay.setEnabled(true);
		
		prevDay.addActionListener(new DayButtonListener(-1));
		nextDay.addActionListener(new DayButtonListener(1));
		
		topPanel.add(prevDay);
		topPanel.add(dayName);
		topPanel.add(nextDay);
		
		add(topPanel, BorderLayout.NORTH);
	}
	
	public class DayButtonListener implements ActionListener {
		int moreOrLess;
		
		DayButtonListener(int moreOrLess) {
			this.moreOrLess=moreOrLess;
		}
		public void actionPerformed(ActionEvent e) {
			gui.setActualDay(day.getDayOfMonth()+moreOrLess);
		}
	}
	
	private void generateMidPanel() {
		midPanel=new JPanel();
		addWorkOut=new JButton("Add workout");
		addWorkOut.addActionListener(new WorkoutButtonListener());
		
		midPanel.add(addWorkOut);
		
		add(midPanel, BorderLayout.CENTER);
	}
	
	public class WorkoutButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			SaveWorkout saveWorkout=new SaveWorkout();
			WorkOut workout=saveWorkout.getWorkout();
		}
		
	}
	
	private void generateBottomPanel() {
		bottomPanel=new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		
		workoutsLogged=new JLabel("Workouts logged:");
		workoutList=new JTextArea("", 10, 30);
		workouts=new JScrollPane(workoutList);
		workouts.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		bottomPanel.add(workoutsLogged, BorderLayout.NORTH);
		bottomPanel.add(workouts, BorderLayout.CENTER);
		
		add(bottomPanel, BorderLayout.SOUTH);
	}
}
