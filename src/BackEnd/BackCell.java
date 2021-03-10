package BackEnd;

public class BackCell {
	
	int row;
	int column;
	
	boolean currState;
	boolean nextState;
	
	BackCell[] Neighbors;
	// [East, NorthEast, North, NorthWest, West, SouthWest, South, SouthEast]

	
	BackCell(int x, int y){
		row = x;
		column = y;
		currState = false;
		
		Neighbors = new BackCell[8];
		for(int i = 0; i < 8; i++) {Neighbors[i]=null;}
	}
	
	boolean getNextState(){return true;};

}
