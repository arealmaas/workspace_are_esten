/* The Main class of the program, reads the info, and starts both the GUI and the solver with the board from the given file */

public class Main {
	public static void main(String[] args) {
		
		boolean writeToFile=false;
		String writeFile=null;
		SudokuReader reader=null;
		
		/* Checking for arguments and handling them */
		if (args.length==1) {
			reader=new SudokuReader(args[0]);
		} else if (args.length==2) {
			reader=new SudokuReader(args[0]);
			writeToFile=true;
			writeFile=args[1];
		} else {
			System.out.println("No more than 2 arguments allowed! Exiting the program");
			System.exit(1);
		}
				
		/* Creates a board from the given file */
		Board originalBoard = new Board(reader.getDimension(), reader.getHeight(), 
										reader.getLength(), reader.getBoard());
		
		/* Creates a copy of the board to show on the GUI while the real board is being solved */
		Board originalBoardCopy = new Board(reader.getDimension(), reader.getHeight(), 
				reader.getLength(), reader.getBoard());
		
		/* Starts solving the board in a separate thread */
		SudokuSolver solver=new SudokuSolver(originalBoard);
		solver.start();
		
		/* Writes info to file if a second filename is given as an argument */
		if (writeToFile) 
			originalBoard.getBuffer().writeToFile(writeFile);
	}
}
