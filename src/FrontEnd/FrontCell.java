package FrontEnd;
import javax.swing.JPanel;

import BackEnd.DataBoard;
import Configuration.Settings;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class FrontCell extends JPanel implements MouseListener{

	boolean state;
	boolean draw;
	PanelBoard parent;
	DataBoard data;
	
	Color dead = Settings.getDeadColor();
	Color alive = Settings.getAliveColor();
	int row;
	int column;
	
	FrontCell(int x, int y, PanelBoard input1, DataBoard input2){
		parent = input1;
		data = input2;
		state = false;
		draw = false;
		row = x;
		column = y;
		this.setBackground(dead);
		this.setOpaque(true);
		this.addMouseListener(this);
	}
	
	private void changeState() {
		System.out.println("CHANGING " + row + " " + column);
		if(this.state==false) {
			this.state=true;
			this.setBackground(alive);
			data.setCell(row, column, true);
		}
		else {
			this.state=false;
			this.setBackground(dead);
			data.setCell(row, column, false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		return;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		parent.draw=true;
		changeState();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		parent.draw=false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(parent.draw) {
			changeState();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		return;		
	}
	
}
