package frontend;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import backend.BoardBack;

@SuppressWarnings("serial")
public class BoardFront extends JPanel{
	
	GridLayout layout;
	CellFront[][] array;
	boolean draw;
	Color backgroundColor = configuration.Settings.getBoardColor();
	int boardDimension = configuration.Settings.getGridSize();
	BoardBack data;
	
	public BoardFront(BoardBack input){
		draw = false;
		layout = new GridLayout(boardDimension,boardDimension);
		layout.setHgap(1);
		layout.setVgap(1);
		this.setLayout(layout);
		this.setBackground(backgroundColor);
		this.setOpaque(true);	
		data = input;
		array = new CellFront[configuration.Settings.getGridSize()][configuration.Settings.getGridSize()];
		generateBoard();
	}
	
	private void generateBoard() {
		for(int x = 0; x < boardDimension; x++) {
			for(int y = 0; y < boardDimension; y++) {
				CellFront temp = new CellFront(x,y,this);
				this.add(temp);
				array[x][y] = temp;
			}
		}
		
		
		this.setVisible(true);
	}

	public void setCell(int row, int col, boolean state) {
		 array[row][col].setState(state);
	}
	
	public BoardBack getData() {return data;}
}
