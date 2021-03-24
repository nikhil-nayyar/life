package backend;
import frontend.BoardFront;

/**
 * Backend gameboard containing references to cells
*/
public class BoardBack {
	
	private CellBack[][] board;
	private int gridSize;
	private int min;
	private int max;
	private BoardFront panel;
	
	/**
	 * Instantiates and assigns positions to all cells
	*/
	public BoardBack(){
		
		gridSize = configuration.Settings.getGridSize();
		min = 0;
		max = gridSize - 1;
		board = new CellBack[gridSize][gridSize];
				
		for(int i = 0; i < gridSize; i++) {
			for(int j = 0; j < gridSize; j++) {
				board[i][j] = new CellBack(i,j,this);
			}
		}
		wireBoard();
	}
	
	/**
	 * Iterates through and connects all cells.
	*/
	private void wireBoard(){
		
		CellBack cell;
		
		for(int i = 0; i < gridSize; i++) {
			for(int j = 0; j < gridSize; j++) {
				cell = board[i][j];
				wireCell(cell);
			}
		}
		
	}
	
	/**
	 * Connects a given cell to it's neighbors\
	 * @param cell
	 * 	CellBack to connect to neighbors
	*/
	private void wireCell(CellBack cell) {
		
		int x = cell.row;
		int y = cell.column;
	
		if(y+1 <= max) {cell.Neighbors[0] = board[x][y+1]; System.out.print("E ");}
		if(x-1 >= min & y+1 <= max) {cell.Neighbors[1] = board[x-1][y+1]; System.out.print("NE ");}
		if(x-1 >= min) {cell.Neighbors[2] = board[x-1][y]; System.out.print("N ");}
		if(x-1 >= min & y-1 >=0) {cell.Neighbors[3] = board[x-1][y-1]; System.out.print("NW ");}
		if(y-1 >= min) {cell.Neighbors[4] = board[x][y-1]; System.out.print("W ");}
		if(x+1 <= max & y-1 >= 0) {cell.Neighbors[5] = board[x+1][y-1]; System.out.print("SW ");}
		if(x+1 <= max) {cell.Neighbors[6] = board[x+1][y]; System.out.print("S ");}
		if(x+1 <= max & y+1 <= max) {cell.Neighbors[7] = board[x+1][y+1]; System.out.print("SE ");}
		
		System.out.println();
		
	}
	
	/**
	 * Sets a given cell's state
	 * @param row
	 * 	row coordinate of cell to set
	 * @param col
	 * 	column coordinate of cell to set
	 * @param state
	 * 	cell's new state
	*/
	public void setCell(int row, int col, boolean state) {
		board[row][col].setCurrState(state);
		panel.getComponentAt(row, col);
	}
	
	/**
	 * Gets a given cell's state
	 * @param row
	 * 	row coordinate of cell to get
	 * @param col
	 * 	column coordinate of cell to get
	*/	
	public CellBack getCell(int row, int col) {return board[row][col];}
	
	/**
	 * Sets the reference to the control panel
	 * @param input
	 * 	application's ControlPanel object
	*/
	public void setPanel(BoardFront input) {panel = input;}
	
	/**
	 * Gets the reference to the control panel
	 * @return
	 * 	application's ControlPanel object
	*/ BoardFront getPanel() {return panel;}
	

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
