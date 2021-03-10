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
	boolean draw;
	Color backgroundColor = Configuration.Settings.getBoardColor();
	int boardDimension = Configuration.Settings.getGridSize();
	
	PanelBoard(DataBoard data){
		draw = false;
		layout = new GridLayout(boardDimension,boardDimension);
		layout.setHgap(1);
		layout.setVgap(1);
		this.setLayout(layout);
		this.setBackground(backgroundColor);
		this.setOpaque(true);
		
		for(int i = 0; i < boardDimension; i++) {
			for(int j = 0; j < boardDimension; j++) {
				this.add(new FrontCell(i,j,this,data));
			}
		}
		
		this.setVisible(true);	
	}

}
