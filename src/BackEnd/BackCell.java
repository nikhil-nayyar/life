package BackEnd;

import FrontEnd.PanelBoard;

public class BackCell {
	
	int row;
	int column;
	DataBoard parent;
	
	private boolean currState;
	private boolean nextState;
	
	BackCell[] Neighbors;
	// [East, NorthEast, North, NorthWest, West, SouthWest, South, SouthEast]

	BackCell(int x, int y, DataBoard input1){
		row = x;
		column = y;
		parent = input1;
		currState = false;
		
		Neighbors = new BackCell[8];
		for(int i = 0; i < 8; i++) {Neighbors[i]=null;}
	}
		
	boolean getCurrState() {return this.currState;}
	
	boolean getNextState() {return this.nextState;}
	
	void setCurrState(boolean input) {this.currState = input; parent.getPanel().setCell(row,column,input);}
	
	void setNextState(boolean input) {this.nextState = input;}
	
	@Override
	public String toString() {
		return "Cell " + row + "," + column + " | Current State: " + currState + " | Next State: " + nextState;
		
	}

}
