/* The buffer where solutions are stored, so the GUI can retrieve them */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SudokuBuffer {
	private String[][][] solved; // An array containing the solved boards as double String Arrays
	private int solutions=0;

	SudokuBuffer(Board originalBoard) {
		solved=new String[500][originalBoard.dimension][originalBoard.dimension];
	}
	
	public boolean insert(String[][] board) {
		solved[++solutions]=board;
		return true;
	}
	
	public String[][] get(int i) {
		return solved[i];
	}
	
	public int getSolutionCount() {
		return solutions;
	}
	
	public void writeToFile(String filename) {
		
		try {
			File file=new File(filename);
			FileWriter writer=new FileWriter(file);
			
			for (int i=0; i<solved.length; i++) {
				if (solved[i]!=null) {
					writer.write(i+": "+solved[i].toString()+"\r\n");
				}
			}
			writer.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
