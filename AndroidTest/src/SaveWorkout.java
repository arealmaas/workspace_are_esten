import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class SaveWorkout extends JFrame {
	JLabel nameOfWorkout;
	JTextField workoutNameField;
	
	String workoutName;
	
	SaveWorkout() {
		super("Save new workout:");
		generateFirstFrame();
		setPosition();
		setName();
	}
	
	private void generateFirstFrame() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		nameOfWorkout=new JLabel("Name the workout:");
		workoutNameField=new JTextField(20);
		setLayout(new BorderLayout());
		
		getContentPane().add(nameOfWorkout, BorderLayout.WEST);
		getContentPane().add(workoutNameField, BorderLayout.EAST);
		
		pack();
	}
	
	private void setPosition() {
		GraphicsConfiguration gc=getGraphicsConfiguration();
		Rectangle screenSize=gc.getBounds(); // Getting the size/resolution of the screen
		
		setLocation((int) ((screenSize.width/2)-(getWidth()/2)), 
				(int) ((screenSize.height/2)-(getHeight()/2)));
	}
	
	private void setName() {
		workoutName=workoutNameField.getText();
		System.out.println("NAME SAT TO "+workoutName);
	}
	
	
	public WorkOut getWorkout() {
		return null;
	}
}
