import java.util.Scanner;


public class WorkOut {
	Scanner input;
	String workOutName;
	ExerciseContainer[] exercisesPerformed;
	
	WorkOut(ExerciseList exerciseList) {
		input=new Scanner(System.in);
		exercisesPerformed=new ExerciseContainer[0];
		setName();
		loop(exerciseList);
	}
	
	private void setName() {
		System.out.print("Name of the workout: ");
		workOutName=input.nextLine();
	}
	
	private void loop(ExerciseList exerciseList) {
		String exerciseName="";
		
		while (!exerciseName.equals("q")) {
			if (exerciseName!="")
				exerciseName=input.nextLine();
			
			System.out.print("Name of exercise(q to quit): ");
			exerciseName=input.nextLine();
			
			if (exerciseName.equals("q"))
				break;
			
			addExercise(exerciseName, exerciseList);
		}
	}
	
	private boolean addExercise(String exerciseName, ExerciseList exerciseList) {
		Exercise exercise=exerciseList.getExercise(exerciseName);
		
		/* Checking if the user wants to create a new exercise if no exercise is found with that name */
		if (exercise==null) {
			System.out.print("Create exercise "+exerciseName+"? (y/n): ");
			String yesOrNo=input.next();
			
			if (yesOrNo.equals("y")) {
				input.nextLine();
				System.out.println("Write a short description for the exercise:");
				String description=input.nextLine();
				exercise=exerciseList.createExercise(exerciseName, description);
			} else
				return false;
			
		}
		
		ExerciseContainer[] temp=new ExerciseContainer[exercisesPerformed.length+1];
		for (int i=0; i<exercisesPerformed.length; i++) {
			temp[i]=exercisesPerformed[i];
		}
		
		temp[exercisesPerformed.length]=new ExerciseContainer(exercise);
		exercisesPerformed=temp;
		return true;
	}
	
	public String toString() {
		String toString=workOutName+"\n";
		for (int i=0; i<exercisesPerformed.length; i++) {
			toString+=exercisesPerformed[i].toString()+"\n";
		}
		return toString;
	}
}
