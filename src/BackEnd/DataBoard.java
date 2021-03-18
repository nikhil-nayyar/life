package BackEnd;

import FrontEnd.PanelBoard;

public class DataBoard {
	
	private BackCell[][] board;
	private int gridSize;
	private int min;
	private int max;
	private PanelBoard panel;
	
	public DataBoard(){
		
		gridSize = Configuration.Settings.getGridSize();
		min = 0;
		max = gridSize - 1;
		board = new BackCell[gridSize][gridSize];
				
		for(int i = 0; i < gridSize; i++) {
			for(int j = 0; j < gridSize; j++) {
				board[i][j] = new BackCell(i,j,this);
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
		
		int x = cell.row;
		int y = cell.column;
		
		System.out.print("Cell " + x + "," + y + " has neighbors ");
		
		if(y+1 <= max) {cell.Neighbors[0] = board[x][y+1]; System.out.print("E ");}
		if(x-1 >= 0 & y+1 <= max) {cell.Neighbors[1] = board[x-1][y+1]; System.out.print("NE ");}
		if(x-1 >= 0) {cell.Neighbors[2] = board[x-1][y]; System.out.print("N ");}
		if(x-1 >= 0 & y-1 >=0) {cell.Neighbors[3] = board[x-1][y-1]; System.out.print("NW ");}
		if(y-1 >=0) {cell.Neighbors[4] = board[x][y-1]; System.out.print("W ");}
		if(x+1 <= max & y-1 >= 0) {cell.Neighbors[5] = board[x+1][y-1]; System.out.print("SW ");}
		if(x+1 <= max) {cell.Neighbors[6] = board[x+1][y]; System.out.print("S ");}
		if(x+1 <= max & y+1 <= max) {cell.Neighbors[7] = board[x+1][y+1]; System.out.print("SE ");}
		
		System.out.println();
		
	}
	
	public void setCell(int row, int col, boolean state) {
		board[row][col].setCurrState(state);
		panel.getComponentAt(row, col);
		//printBoard();
	}
	
	public BackCell getCell(int row, int col) {return board[row][col];}
	
	public void setPanel(PanelBoard input) {panel = input;}
	
	public PanelBoard getPanel() {return panel;}
	
 	public void printBoard() {

		System.out.println("-----------------");
		for(int i = 0; i < gridSize; i++) {
			for(int j = 0; j < gridSize; j++) {
				{System.out.print((board[i][j].getCurrState()) ? 1 : 0);}
				} 
				System.out.println();
			}
		}
}
