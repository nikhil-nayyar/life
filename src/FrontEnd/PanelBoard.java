package FrontEnd;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import BackEnd.DataBoard;

@SuppressWarnings("serial")
public class PanelBoard extends JPanel{
	
	GridLayout layout;
	FrontCell[][] array;
	boolean draw;
	Color backgroundColor = Configuration.Settings.getBoardColor();
	int boardDimension = Configuration.Settings.getGridSize();
	DataBoard data;
	
	public PanelBoard(DataBoard input){
		draw = false;
		layout = new GridLayout(boardDimension,boardDimension);
		layout.setHgap(1);
		layout.setVgap(1);
		this.setLayout(layout);
		this.setBackground(backgroundColor);
		this.setOpaque(true);	
		data = input;
		array = new FrontCell[Configuration.Settings.getGridSize()][Configuration.Settings.getGridSize()];
		generateBoard();
	}
	
	private void generateBoard() {
		for(int x = 0; x < boardDimension; x++) {
			for(int y = 0; y < boardDimension; y++) {
				FrontCell temp = new FrontCell(x,y,this);
				this.add(temp);
				array[x][y] = temp;
			}
		}
		
		
		this.setVisible(true);
	}

	public void setCell(int row, int col, boolean state) {
		 array[row][col].setState(state);
	}
	
	public DataBoard getData() {return data;}
}
