package backend;

/**
 * Data structure containing information for a given cell
*/
public class CellBack {
	
	/**
	 * cell's row coordinate
	 */
	int row;
	
	/**
	 * cell's column coordinate
	 */
	int column;
	
	private BoardBack parent;
	
	private boolean currState;
	
	private boolean nextState;
	
	/**
	 * References to neighboring cells
	 * [East, NorthEast, North, NorthWest, West, SouthWest, South, SouthEast]
	 */
	CellBack[] Neighbors;

	/**
	 * Sets position information, sets neighbor references, and sets parent board reference.
	 */
	CellBack(int x, int y, BoardBack board){
		row = x;
		column = y;
		parent = board;
		currState = false;
		
		Neighbors = new CellBack[8];
		for(int i = 0; i < 8; i++) {Neighbors[i]=null;}
	}
	
	/**
	 * Gets cell's current state
	 * @return Current State
	 */
	boolean getCurrState() {return this.currState;}
	
	/**
	 * Gets cell's next state
	 * @return Next State
	 */
	boolean getNextState() {return this.nextState;}
	
	/**
	 * Sets cell's current state
	 * @param input
	 * 	value to set current state
	 */
	void setCurrState(boolean input) {this.currState = input; parent.getPanel().setCell(row,column,input);}
	
	/**
	 * Sets cell's next state
	 * @param input
	 *	value to set next state
	 */
	void setNextState(boolean input) {this.nextState = input;}
	
	@Override
	public String toString() {
		return "Cell " + row + "," + column + " | Current State: " + currState + " | Next State: " + nextState;
		
	}

}
