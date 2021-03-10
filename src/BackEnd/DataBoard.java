package BackEnd;

public class DataBoard {
	
	private BackCell[][] board;
	private int gridSize;
	private int min;
	private int max;
	
	public DataBoard(){
		
		gridSize = Configuration.Settings.getGridSize();
		int min = 0;
		int max = gridSize - 1;
		board = new BackCell[gridSize][gridSize];
		
		for(int i = 0; i < gridSize; i++) {
			for(int j = 0; j < gridSize; j++) {
				board[i][j] = new BackCell(i,j);
			}
		}
		
		wireBoard();		
	}
	
	public void wireBoard(){
		
		BackCell cell;
		
		for(int i = 0; i < gridSize; i++) {
			for(int j = 0; j < gridSize; j++) {
				cell = board[i][j];
				wireCell(cell);
			}
		}
		
		System.out.println("DONE CREATING BOARD");
		
	}
	
	public void wireCell(BackCell cell) {
		
		int x = cell.column;
		int y = cell.row;
		
		
		if(y+1 <= max) {cell.Neighbors[0] = board[x][y+1];}
		if(x-1 >= 0 && y+1 <= max) {cell.Neighbors[1] = board[x-1][y+1];}
		if(x-1 >= 0) {cell.Neighbors[2] = board[x-1][y];}
		if(x-1 >= 0 && y-1 >=0) {cell.Neighbors[3] = board[x-1][y-1];}
		if(y-1 >=0) {cell.Neighbors[4] = board[x][y-1];}
		if(x+1 <= max && y-1 >= 0) {cell.Neighbors[5] = board[x+1][y-1];}
		if(x+1 <= max) {cell.Neighbors[6] = board[x+1][y];}
		if(x+1 <= max && y+1 <= max) {cell.Neighbors[7] = board[x+1][y+1];}
		
	}

	public void setCell(int row, int col, boolean state) {
		board[row][col].currState = state;
		printBoard();
	}
	
	public void printBoard() {
		System.out.println("-----------------");
		for(int i = 0; i < gridSize; i++) {
			for(int j = 0; j < gridSize; j++) {
				{System.out.print((board[i][j].currState) ? 1 : 0);}
				} 
				System.out.println();
			}
		}
}
