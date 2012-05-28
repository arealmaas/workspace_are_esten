

public class Box extends PartialBoard {
	int dimension;
	Square[] squares;
	
	Box(int dimension) {
		this.dimension=dimension;
		squares=new Square[dimension];
	}
	
	/* Set each squares myBox variable as this */
	private void setBoxes() {
		for (int i=0; i<squares.length; i++) {
			squares[i].setBox(this);
		}
	}
	
	public void add(Square square) {
		for (int i=0; i<squares.length; i++) {
			if (squares[i]==null) {
				squares[i]=square;
				return;
			}
		}
	}
	
	/* Filling the superclass with info */
	public void setInitials() {
		super.setSquares(squares);
		setBoxes();
	}
}
