

public class Row extends PartialBoard {

	Row(Square[] squares) {
		
		Square[] temp=new Square[squares.length];
		if (squares!=null)
			for (int i=0; i<squares.length; i++) 
				temp[i]=squares[i];
		super.setSquares(temp);
		
		setRows();
	}
	
	private void setRows() {
		for (int i=0; i<squares.length; i++) {
			squares[i].setRow(this);
		}
	}
}
