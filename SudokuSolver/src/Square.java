/* Superclass for the squares */

public class Square {
	protected char value='0';
	protected Row myRow;
	protected Column myColumn;
	protected Box myBox;
	protected Board myBoard;
	protected char[] valueArray; // Sets possible values from 0-9 and then from A-Z, depending on the dimension of the board

	Square(char value, Board board) {
		this.value = value;
		myBoard=board;
		fillValueArray();
	}

	public char getValue() {
		if (value=='0')
			return ' ';
		else
			return value;
	}
	
	public void setRow(Row r) {
		myRow=r;
	}
	
	public void setColumn(Column c) {
		myColumn=c;
	}
	
	public void setBox(Box b) {
		myBox=b;
	}
	
	/* Fills the valueArray with correct values according to the dimension */
	private void fillValueArray() {
		char[] tempArray={'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		valueArray=new char[myBoard.dimension];
		
		for (int i=0; i<myBoard.dimension; i++) {
			valueArray[i]=tempArray[i];
		}
	}
}
