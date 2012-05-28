import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class YearPanel extends JPanel{
	private Year year;
	private GUI gui;
	
	private JPanel topPanel, monthPanel;
	private JLabel yearNumber;
	private JButton prevYear, nextYear;
	private JButton[][] monthButtons;

	YearPanel(Year year, GUI gui) {
		this.year=year;
		this.gui=gui;
		setLayout(new BorderLayout());
		setTopPanel();
		setMonths();
	}
	
	private void setTopPanel() {
		prevYear=new JButton("<<");
		nextYear=new JButton(">>");
		yearNumber=new JLabel(year.toString());
		topPanel=new JPanel();
	
		prevYear.addActionListener(new YearButtonListener(-1));
		nextYear.addActionListener(new YearButtonListener(1));
	
		topPanel.add(prevYear);
		topPanel.add(yearNumber);
		topPanel.add(nextYear);
	
		if (year==gui.getMaxYear()) 
			nextYear.setEnabled(false);
		else
			nextYear.setEnabled(true);
		
		if (year==gui.getMinYear()) 
			prevYear.setEnabled(false);
		else
			prevYear.setEnabled(true);
		
		add(topPanel, BorderLayout.NORTH);
	}
	
	public class YearButtonListener implements ActionListener {
		int moreOrLess;
		
		YearButtonListener(int moreOrLess) {
			this.moreOrLess=moreOrLess;
		}
		
		public void actionPerformed(ActionEvent e) {
			gui.setActualYear(moreOrLess);
		}	
	}
	
	private void setMonths() {
		monthButtons=new JButton[4][3];
		monthPanel=new JPanel();
		monthPanel.setLayout(new GridLayout(4,3));
		Month month=null;
		
		for (int i=0; i<monthButtons.length; i++) {
			for (int j=0; j<monthButtons[i].length; j++) {
				month=year.getMonth(i*3+j);
				monthButtons[i][j]=new JButton(month.getName());
				monthButtons[i][j].addActionListener(new MonthButtonListener(month.getMonthNumber()));
				monthPanel.add(monthButtons[i][j]);
			}
		}
		
		add(monthPanel, BorderLayout.SOUTH);
	}
	
	public class MonthButtonListener implements ActionListener {
		int monthNumber;
		
		MonthButtonListener(int monthNumber) {
			this.monthNumber=monthNumber;
		}
		
		public void actionPerformed(ActionEvent e) {
			gui.setActualMonth(monthNumber, gui.right_position);
		}
		
	}
}
