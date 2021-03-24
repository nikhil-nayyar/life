package frontend;
import javax.swing.JPanel;

import backend.BoardBack;
import configuration.Settings;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CellFront extends JPanel implements MouseListener{

	boolean state;
	boolean draw;
	BoardFront parent;
	
	Color dead = Settings.getDeadColor();
	Color alive = Settings.getAliveColor();
	int row;
	int column;
	
	CellFront(int x, int y, BoardFront input1){
		parent = input1;
		state = false;
		draw = false;
		row = x;
		column = y;
		this.setBackground(dead);
		this.setOpaque(true);
		this.addMouseListener(this);
	}
	
	private void changeState() {
		if(this.state==false) {
			this.state=true;
			this.setBackground(alive);
			parent.getData().setCell(row, column, true);
		}
		else {
			this.state=false;
			this.setBackground(dead);
			parent.getData().setCell(row, column, false);
		}
	}

	public void setState(boolean input){
		if(input == true) {this.setBackground(alive);}
		else {this.setBackground(dead);}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		return;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		parent.draw=true;
		changeState();
		//System.out.println(this.toString());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		parent.draw=false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(parent.draw) {
			changeState();
			//System.out.println(this.toString());
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		return;		
	}
	
	@Override
	public String toString() {
		return "Cell " + row + "," + column + " Current State: " + state;
	}
	
}
