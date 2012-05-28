import java.util.Random;

public class Ruter {
	int number;
	Random r=new Random();
	Lengde lengde;
	Hoyde hoyde;
	Boks boks;
	
	Ruter() {
	}
	public void fillWithNumber() {
		boolean goodNumber=false;
		while (goodNumber==false) {
			number=r.nextInt(9);
			goodNumber=checkIfGoodNumber(number);
		}
	}
	private boolean checkIfGoodNumber(int number2) {
		if (number==0) 
			return false;
		else
			return true;
	}
}
