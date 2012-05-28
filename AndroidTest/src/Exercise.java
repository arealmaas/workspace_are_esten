
public class Exercise {
	private String name;
	private String description;
	private int personalRecord;
	
	Exercise(String name, String description, int personalRecord) {
		this.name=name;
		this.description=description;
		this.personalRecord=personalRecord;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getPersonalRecord() {
		return personalRecord;
	}
	
	public String getName() {
		return name;
	}
	
	public String writeMe() {
		return name+";"+description+";"+personalRecord;
	}
}
