

public class Column extends PartialBoard {
	
	Column(Square[] squares) {
		Square[] temp=new Square[squares.length];
		
		if (squares!=null)
			for (int i=0; i<squares.length; i++) 
				temp[i]=squares[i];
		
		super.setSquares(temp);
		setColumns();
	}
	
	private void setColumns() {
		for (int i=0; i<squares.length; i++) {
			squares[i].setColumn(this);
		}
	}
}
