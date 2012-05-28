import java.io.File;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Main m=new Main();
		m.start(args[0]);
	}
	public void start(String args) {
		String type=args;
		Scanner input=new Scanner(System.in);

		while(!type.equals("Caesar") && !type.equals("Nokkel")) {
			System.out.print("Ugyldig type! Prov igjen:");
			type=input.next();
		}
		if (type.equals("Caesar")) {
			System.out.print("Strengen som skal dekrypteres(skriv fil for aa hente fra fil): ");
			String tekst=input.nextLine();
			if (tekst.equals("fil")) {
				System.out.print("Filnavn: ");
				String filnavn=input.next();
				tekst=getString(filnavn);
			}
			new CaesarKnekker(tekst);
		} else if (type.equals("Nokkel")) {
			System.out.print("Nokkelen som skal brukes: ");
			String nokkel=input.nextLine();
			System.out.print("Strengen som skal dekrypteres(skriv fil for aa hente fra fil): ");
			String tekst=input.nextLine();
			if (tekst.equals("fil")) {
				System.out.print("Filnavn: ");
				String filnavn=input.next();
				tekst=getString(filnavn);
			}
			new NokkelKnekker(nokkel, tekst);
		}
	}


	private String getString(String filename) {
		String string="";
		try {
			Scanner fileReader=new Scanner(new File(filename));

			while (fileReader.hasNext()) {
				string+=fileReader.nextLine()+"\n";
			}

			return string;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
}
