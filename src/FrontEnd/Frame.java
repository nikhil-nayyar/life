package FrontEnd;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import BackEnd.DataBoard;
import Configuration.Settings;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;

public class Frame {
	
	JFrame frame;
	Container framePane;
	PanelBoard board;
	PanelControl control;
	
	public Frame(DataBoard data){
		
		// Create and Configure Main Window
		frame = new JFrame();
		frame.setBounds(new Rectangle(600,600));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePane = frame.getContentPane();
		framePane.setLayout(new BorderLayout());
		
		// Create and Configure Gameboard
		board = new PanelBoard(data);
		frame.add(board, BorderLayout.CENTER);

		// Add Borders
		JPanel topBorder = new JPanel();
		topBorder.setPreferredSize(new Dimension(0,10));
		topBorder.setBackground(Settings.getPanelColor());
		frame.add(topBorder, BorderLayout.NORTH);
		
		control = new PanelControl();
		control.setPreferredSize(new Dimension(0,75));
		control.setBackground(Settings.getPanelColor());
		frame.add(control, BorderLayout.SOUTH);
		
		JPanel leftBorder = new JPanel();
		leftBorder.setPreferredSize(new Dimension(10,0));
		leftBorder.setBackground(Settings.getPanelColor());
		frame.add(leftBorder, BorderLayout.EAST);
		
		JPanel rightBorder = new JPanel();
		rightBorder.setPreferredSize(new Dimension(10,0));
		rightBorder.setBackground(Settings.getPanelColor());
		frame.add(rightBorder, BorderLayout.WEST);
		
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
}
