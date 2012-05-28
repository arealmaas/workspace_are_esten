/* A Class containg the entire sudoku-board, including rows, columns, boxes, and separate squares. 
 * Has methods for filling the board with values, solving the board, and different ways of extracting
 * solutions, as well as a couple of standard get methods */

public class Board {
	boolean solvable;
	int dimension;
	
	public Square[][] squares;
	private Row[] rows;
	private Column[] columns;
	private Box[] boxes;
	
	private FreeSquare firstFreeSquare;
	private SudokuBuffer buffer;

	/* Constructor used for new boards */
	Board(int dimension, int height, int length, String[] board) {
		this.dimension=dimension;
		squares = new Square[dimension][dimension];
		rows = new Row[dimension];
		columns = new Column[dimension];
		boxes = new Box[dimension];
		
		generateSquares(board);
		generateRows();
		generateColumns();
		generateBoxes(height, length);
		
		buffer=new SudokuBuffer(this);
	}

	/* Fills the squares with the values from the given board */
	private void generateSquares(String[] board) {
		FreeSquare actualFree=null;
		FreeSquare lastFree=null;
		boolean firstFree=true;
		
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				
				/* Separating filled and free squares */
				if (board[i].charAt(j) == '.') {
					squares[i][j] = new FreeSquare(this);
					
					if (firstFree) { // Special scenario for the first open square
						firstFreeSquare=(FreeSquare) squares[i][j];
						actualFree=(FreeSquare) squares[i][j];
						firstFree=false;
						lastFree=(FreeSquare) squares[i][j];
						
					} else {
						actualFree.nextFreeSquare=(FreeSquare) squares[i][j];
						actualFree=actualFree.nextFreeSquare;
						lastFree=(FreeSquare) squares[i][j];
					}
					
				} else {
					char c = board[i].charAt(j);
					squares[i][j] = new FilledSquare(c, this);
				}
				
			}
		}
		lastFree.isLastFree();
	}
	
	/* Generating rows, filling them, and adding each row to their squares */
	private void generateRows() {
		for (int i=0; i<squares.length; i++) {
			rows[i]=new Row(squares[i]);
		}
	}
	
	/* Same with columns */
	private void generateColumns() {
		Square[] squareArr=new Square[squares.length];
		for (int i=0; i<squares.length; i++) {
			for (int j=0; j<squares.length; j++) {
				squareArr[j]=squares[j][i];
			}
			columns[i]=new Column(squareArr);
		}
	}
	
	/* Same with boxes */
	private void generateBoxes(int height, int length) {
		int boxId;
		
		for (int i=0; i<squares.length; i++) {
			for (int j=0; j<squares[i].length; j++) {
				boxId=j/length+((i/height)*height);
				
				if (boxes[boxId]==null)
					boxes[boxId]=new Box(height*length);
				boxes[boxId].add(squares[i][j]);
			}
		}
		
		for (int i=0; i<boxes.length; i++) {
			boxes[i].setInitials();
		}
	}

	/* Starts the recursive solving algorithm */
	public void solveIt() {
		firstFreeSquare.setNumberMeAndTheRest();
	}

	/* Adds the current board to the SudokuBuffer as a double String Array */
	public void addSolution() {
		solvable=true;
		buffer.insert(this.toStringArray());
	}
	
	public SudokuBuffer getBuffer() {
		return buffer;
	}
	
	/* Returns the board as one single-lined String, where the rows are separated by // */
	public String toString() {
		String returnString="";
		
		for (int i=0; i<squares.length; i++) {
			for (int j=0; j<squares.length; j++) {
				returnString+=Character.toString(squares[i][j].getValue());
			}
			returnString+="// ";
		}
		
		return returnString;
	}
	
	/* Returns the values of the current board as a double String Array */
	public String[][] toStringArray() {
		String[][] solvedBoard=new String[dimension][dimension];
		
		for (int i=0; i<dimension; i++) {
			for (int j=0; j<dimension; j++) {
				solvedBoard[i][j]=Character.toString(squares[i][j].getValue());
			}
		}
		
		return solvedBoard;
	}
}
