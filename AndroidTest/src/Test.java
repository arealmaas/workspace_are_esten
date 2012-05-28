import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Test {
	private Calendar calendar;
	private GUI gui;
	private ExerciseList exerciseList;
	private Scanner input;
	private FileHandler fileHandler;
	
	Test(String exerciseListFile, String activeDaysFile) {
		calendar=new Calendar();
		exerciseList=new ExerciseList();
		input=new Scanner(System.in);
		fileHandler=new FileHandler(exerciseListFile, activeDaysFile);
		gui=new GUI(calendar);
		gui.start();
		fileHandler.readInfo(exerciseList, calendar);
	}
	
	public void menu() {
		int command=1;
		
		while(command!=9) {
			System.out.println("Options:");
			System.out.println("1. Find day");
			System.out.println("2. Find month");
			System.out.println("3. Find year");
			System.out.println("4. Add workout");
			System.out.println("5. See days with workouts");
			System.out.println("6. Find workout");
			System.out.println("7. Add New Exercise");
			System.out.println("8. See Exercises");
			System.out.println("9. Exit");
			
			command=input.nextInt();
			
			if(command==1) {
				findDay();
			} else if (command==2) {
				findMonth();
			} else if (command==3) {
				findYear();
			} else if (command==4) {
				addWorkOut();
			} else if (command==5) {
				printWorkOuts();
			} else if (command==6) {
				findWorkOut();
			} else if (command==7) {
				addExercise();
			} else if (command==8) {
				printExercises();
			} else if (command==9) {
				fileHandler.writeInfo(exerciseList, calendar);
				System.exit(1);
			} else
				System.out.println("Invalid command! \n\n");
		}
	}
	
	private Day findDay() {
		int year;
		String month;
		int dayOfMonth;
		System.out.print("Year: ");
		year=input.nextInt();
		input.nextLine();
		System.out.print("Month: ");
		month=input.nextLine();
		System.out.print("Day of month: ");
		dayOfMonth=input.nextInt();
		
		Day day=calendar.findDay(year, month, dayOfMonth);
		
		if (day==null)
			return null;
		
		System.out.println(day.toString());
		return day;
	}
	
	private Month findMonth() {
		int year;
		String monthName;
		System.out.print("Year: ");
		year=input.nextInt();
		input.nextLine();
		System.out.print("Month: ");
		monthName=input.nextLine();
		
		Month month=calendar.findMonth(year, monthName);
		
		if (month==null)
			return null;
		
		System.out.println(month.toString());
		month.printDays();
		return month;
	}
	
	private Year findYear() {
		int yearNumber;
		System.out.print("Year: ");
		yearNumber=input.nextInt();
		
		Year year=calendar.findYear(yearNumber);
		
		if (year==null) 
			return null;
		
		System.out.println(year.toString());
		year.printMonths();
		
		return year;
	}
	
	private boolean addWorkOut() {
		Day day=findDay();
		
		if (day==null)
			return false;
		
		WorkOut workOut=new WorkOut(exerciseList);
		day.addWorkOut(workOut);
		calendar.addActiveDay(day);
		return true;
	}
	
	private void printWorkOuts() {
		LinkedList<Day> daysOfActivity=calendar.getDaysOfActivity();
		Iterator<Day> iterator=daysOfActivity.iterator();
		
		while(iterator.hasNext()) {
			Day day=iterator.next();
			System.out.println(day.toString());
			WorkOut[] workOuts=day.getWorkOuts();
			for (int i=0; i<workOuts.length; i++) {
				System.out.print(workOuts[i].toString());
			}
		}
	}
	
	private void findWorkOut() {
		Day day=findDay();
		WorkOut[] workOuts=day.getWorkOuts();
		if (workOuts.length==0) {
			System.out.println("No workouts this day!");
			return;
		} else {
			for (int i=0; i<workOuts.length; i++) {
				System.out.print(workOuts[i].toString());
			}
		}
	}
	
	private void addExercise() {
		input.nextLine();
		System.out.print("Name of the exercise: ");
		String exerciseName=input.nextLine();
		System.out.print("Description of exercise: ");
		String exerciseDescription=input.nextLine();
		Exercise exercise=new Exercise(exerciseName, exerciseDescription, 0);
		if (exerciseList.addExercise(exercise))
			System.out.println("Added exercise "+exerciseName);
	}
	
	private void printExercises() {
		System.out.println("Printing exercises:");
		exerciseList.printMe();
	}
}
