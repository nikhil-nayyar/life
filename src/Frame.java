
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import BackEnd.DataBoard;
import BackEnd.Engine;
import Configuration.Settings;
import FrontEnd.PanelBoard;
import FrontEnd.PanelControl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;

public class Frame implements Runnable{
	
	JFrame frame;
	Container framePane;
	PanelBoard board;
	PanelControl control;

	public Frame(DataBoard data, Engine engine){
		
		// Create and Configure Main Window
		frame = new JFrame();
		frame.setBounds(new Rectangle(600,600));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePane = frame.getContentPane();
		framePane.setLayout(new BorderLayout());
		
		// Add Gameboard
		board = new PanelBoard(data);
		frame.add(board, BorderLayout.CENTER);

		// Add Controlboard
		control = new PanelControl(engine);
		control.setPreferredSize(new Dimension(0,75));
		control.setBackground(Settings.getPanelColor());
		frame.add(control, BorderLayout.SOUTH);
		
		// Add Borders
		JPanel topBorder = new JPanel();
		topBorder.setPreferredSize(new Dimension(0,10));
		topBorder.setBackground(Settings.getPanelColor());
		frame.add(topBorder, BorderLayout.NORTH);
		
		JPanel leftBorder = new JPanel();
		leftBorder.setPreferredSize(new Dimension(10,0));
		leftBorder.setBackground(Settings.getPanelColor());
		frame.add(leftBorder, BorderLayout.EAST);
		
		JPanel rightBorder = new JPanel();
		rightBorder.setPreferredSize(new Dimension(10,0));
		rightBorder.setBackground(Settings.getPanelColor());
		frame.add(rightBorder, BorderLayout.WEST);
		
		// Refresh to Have Take Effect
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
	public PanelBoard getPanelBoard() {
		return board;
	}
	
	public PanelControl getPanelControl() {
		return control;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("FRAME RUNNING");
	}

}
