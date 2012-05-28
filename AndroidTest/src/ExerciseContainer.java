import java.util.Scanner;


public class ExerciseContainer {
	Exercise exercise;
	int[][] repsAndWeight;
	
	ExerciseContainer(Exercise exercise) {
		this.exercise=exercise;
		setSets();
	}
	
	private void setSets() {
		Scanner input=new Scanner(System.in);
		int sets;
		
		System.out.print("Number of sets: ");
		sets=input.nextInt();
		
		repsAndWeight=new int[sets][2];
		
		for(int i=0; i<repsAndWeight.length; i++) {
			System.out.print("Reps for set "+(i+1)+": ");
			repsAndWeight[i][0]=input.nextInt();
			System.out.print("Weight for set "+(i+1)+": ");
			repsAndWeight[i][1]=input.nextInt();
		}
	}
	
	public String toString() {
		String toString=exercise.getName()+":\n";
		for (int i=0; i<repsAndWeight.length; i++) {
			toString+="Set "+(i+1)+": "+repsAndWeight[i][0]+"x"+repsAndWeight[i][1]+"kg\n";
		}
		return toString;
	}
}
