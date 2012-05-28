import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileHandler {
	private String exerciseListFile;
	private String activeDayListFile;
	
	FileHandler(String exerciseListFile, String activeDayListFile) {
		this.exerciseListFile=exerciseListFile;
		this.activeDayListFile=activeDayListFile;
	}
	
	public void readInfo(ExerciseList exerciseList, Calendar calendar) {
		readExercises(exerciseList);
		//readActiveDays(calendar);
	}
	
	public void writeInfo(ExerciseList exerciseList, Calendar calendar) {
		writeExercises(exerciseList);
		//writeActiveDays(calendar);
	}
	
	private void readExercises(ExerciseList exerciseList) {
		try {
			Scanner fileReader=new Scanner(new File(exerciseListFile));
			
			while (fileReader.hasNext()) {
				String[] info=fileReader.nextLine().split(";");
				Exercise exercise=new Exercise(info[0], info[1], Integer.parseInt(info[2]));
				exerciseList.addExercise(exercise);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No ExerciseList found! Starting a new DB");
		}
	}
	
	
	private void writeExercises(ExerciseList exerciseList) {
		Exercise[] exercises=exerciseList.getArray();
		System.out.println("Writing to file "+exerciseListFile);
		try {
			FileWriter output=new FileWriter(new File(exerciseListFile));
		
			for (int i=0; i<exercises.length; i++) {
				output.write(exercises[i].writeMe()+"\r\n");
			}
			output.close();
		} catch (IOException ioe) {
			System.out.println("IOException! Shutting down");
			System.exit(1);
		}
	}
	private void readActiveDays(Calendar calendar) {
		//TODO: Kode som leser inn workouts, adder i dager, og adder til activeDays
	}
}
