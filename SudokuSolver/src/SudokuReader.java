/* Reading the file, and has get methods for dimension, box-height, box-length and the board itself */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SudokuReader {
	File file;

	int dimension;
	int height;
	int length;
	String[] board;
	
	SudokuReader(String readFile) {
		file=new File(readFile);
		read();
	}
	
	public void read() {
		
		try {
			Scanner sc=new Scanner(file);
			
			/* Getting the first lines of data */
			dimension=sc.nextInt();
			height=sc.nextInt();
			length=sc.nextInt();
			sc.nextLine(); // Too jump past the rest of the empty line
			board=new String[dimension];
			
			/* Checking if the data is valid */
			if (dimension!=6 && dimension!=9 && dimension!=12 && dimension!=16) 
				throw new InvalidFormatException();
			else if (height*length!=dimension)
				throw new InvalidFormatException();
			else {
				
				/* Reading the board */
				int i=0;
				while(sc.hasNext()) {
					board[i]=sc.nextLine();
					if (board[i].length()!=dimension)
						throw new InvalidFormatException();
					i++;
				}
			}
			
			} catch (InvalidFormatException i) {
			System.out.println("Invalid file format");
			System.exit(1);
		} catch (FileNotFoundException f) {
			System.out.println("File not found!");
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("Invalid file format");
			System.exit(1);
		}
		
	}
	
	/*public boolean fileIsValid() {
		String filename=file.getName();
		if (filename.substring(filename.length(), (filename.length()-2)).equals("txt"))
			return true;
		else
			return false;
	}*/
	
	public int getDimension() {
		return dimension;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getLength() {
		return length;
	}
	
	public String[] getBoard() {
		return board;
	}
}