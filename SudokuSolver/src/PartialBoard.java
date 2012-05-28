/* Superclass for the rows, columns and boxes, containing some basic methods for setting values and getting availability of values */

public class PartialBoard {
	Square[] squares;
	
	public void setSquares(Square[] squares) {
		this.squares=squares;
	}
	
	public boolean contains(int number) {
		for (int i=0; i<squares.length; i++) {
			if (number==squares[i].getValue())
				return true;
		}
		return false;
	}
}
