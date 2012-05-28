import java.util.HashMap;


public class ExerciseList {
	HashMap<String, Exercise> exercises;
	
	ExerciseList() {
		exercises=new HashMap<String, Exercise>();
	}
	
	public Exercise getExercise(String exerciseName) {
		return exercises.get(exerciseName);
	}
	
	public Exercise createExercise(String exerciseName, String description) {
		Exercise exercise=new Exercise(exerciseName, description, 0);
		exercises.put(exerciseName, exercise);
		return exercise;
	}
	
	public boolean addExercise(Exercise exercise) {
		if (exercises.containsKey(exercise.getName()))
			return false;
		else {
			exercises.put(exercise.getName(), exercise);
			return true;
		}
	}
	
	public Exercise[] getArray() {
		Exercise[] temp=new Exercise[exercises.size()];
		int i=0;
		for (Exercise e: exercises.values()) {
			temp[i++]=e;
		}
		return temp;
	}
	
	public void printMe() {
		Exercise[] temp=getArray();
		System.out.println("number of exercises: "+temp.length);
		for (int i=0; i<temp.length; i++) {
			System.out.print(temp[i].writeMe()+"\n");
		}
	}
}
