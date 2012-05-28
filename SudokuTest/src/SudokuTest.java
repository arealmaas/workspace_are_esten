public class SudokuTest {
	Ruter[][] ruter;
	Lengde[] lengder;
	Hoyde[] hoyder;
	Boks[][] bokser;
	int dimensjon;
	
	SudokuTest(int dimensjon) {
		this.dimensjon=dimensjon;
		ruter=new Ruter[dimensjon][dimensjon];
		createRuter();
		createLengder();
		createHoyder();
		createBokser();
		fillRandom();
		print();
	}
	
	private void createRuter() {
		for (int i=0; i<ruter.length; i++) {
			for (int j=0; j<ruter[i].length; j++) {
				ruter[i][j]=new Ruter();
			}
		}
	}
	
	private void createLengder() {
		for (int i=0; i<ruter.length; i++) {
			if (ruter[i]!=null)
				lengder[i]=new Lengde(ruter[i]);
		}
	}
	
	private void createHoyder() {
		Ruter[] nyRuter=new Ruter[dimensjon];
		for (int i=0; i<ruter.length; i++) {
			for (int j=0; j<ruter[0].length; j++) {
				nyRuter[j]=ruter[i][j];
			}
			hoyder[i]=new Hoyde(nyRuter);
		}
	}
	
	private void createBokser() {
		if (dimensjon==6) {
			bokser=new Boks[3][2];
			Ruter[][] nyRuter=new Ruter[2][3];
			int i=0;
			while (i<2) {
				int j=0;
				nyRuter[0][0]=ruter[i+0][j+0];
				nyRuter[0][1]=ruter[i+0][j+1];
				nyRuter[0][2]=ruter[i+0][j+2];
				nyRuter[1][0]=ruter[i+1][j+0];
				nyRuter[1][1]=ruter[i+1][j+1];
				nyRuter[1][2]=ruter[i+1][j+2];
				bokser[0][0]=new Boks(nyRuter);
				j+=2;
				nyRuter[0][0]=ruter[i+0][j+0];
				nyRuter[0][1]=ruter[i+0][j+1];
				nyRuter[0][2]=ruter[i+0][j+2];
				nyRuter[1][0]=ruter[i+1][j+0];
				nyRuter[1][1]=ruter[i+1][j+1];
				nyRuter[1][2]=ruter[i+1][j+2];
				bokser[1][0]=new Boks(nyRuter);
				j+=2;
				nyRuter[0][0]=ruter[i+0][j+0];
				nyRuter[0][1]=ruter[i+0][j+1];
				nyRuter[0][2]=ruter[i+0][j+2];
				nyRuter[1][0]=ruter[i+1][j+0];
				nyRuter[1][1]=ruter[i+1][j+1];
				nyRuter[1][2]=ruter[i+1][j+2];
				bokser[2][0]=new Boks(nyRuter);
				i++;
			}
		} else if (dimensjon==9) {
			bokser=new Boks[3][3];
		} else if (dimensjon==12) {
			bokser=new Boks[4][3];
		} else {
			System.out.println("Invalid dimension!");
			System.exit(1);
		}
	}
	public void fillRandom() {
		for (int i=0; i<ruter.length; i++) {
			for (int j=0; j<ruter[i].length; j++) {
				ruter[i][j].fillWithNumber();
			}
		}
	}
	
	public void print() {
		for (int i=0; i<ruter.length; i++) {
			System.out.print("\n");
			for (int j=0; j<ruter[i].length; j++) {
				if (ruter[i][j].number!=0) {
					System.out.print("["+ruter[i][j].number+"]");
				} else {
					System.out.print("[ ]");
				}
			}
		}
	}
}
