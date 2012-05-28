/* A square which is free when the board is read */

public class FreeSquare extends Square {
	public FreeSquare nextFreeSquare=null;
	private boolean isLastFree=false;
	
	FreeSquare(Board b) {
		super('0', b);
	}
	
	/* The recursive solving method*/ 
	public void setNumberMeAndTheRest() {
		for (int i=0; i<myBoard.dimension; i++) {
			if (isGoodValue(valueArray[i])) {
				this.value=valueArray[i];
				if (!isLastFree) 
					nextFreeSquare.setNumberMeAndTheRest();
				else // Saves the board in the buffer if the square is the last free square
					myBoard.addSolution();
			}
		}
		
		this.value='0'; // Sets value as 0 if no available values are found
	}
	
	/* Checks if the value in the parameter is free in the row, column and box of the square */
	private boolean isGoodValue(char value) {
		if (myRow.contains(value)) {
			return false;
		} else if (myColumn.contains(value)) {
			return false;
		} else if (myBox.contains(value)) {
			return false;
		} else
			return true;
	}
	
	public void isLastFree() {
		isLastFree=true;
	}
}
