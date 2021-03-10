package FrontEnd;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import BackEnd.DataBoard;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;

public class Frame {
	
	JFrame frame;
	Container framePane;
	PanelBoard board;
	
	public Frame(DataBoard data){
		
		// Create and Configure Main Window
		frame = new JFrame();
		frame.setBounds(new Rectangle(600,600));
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePane = frame.getContentPane();
		framePane.setLayout(new BorderLayout());
		framePane.setBackground(Configuration.Settings.getBoardColor());
		
		// Create and Configure Gameboard
		board = new PanelBoard(data);
		frame.add(board, BorderLayout.CENTER);

		// Add Borders
		JPanel topBorder = new JPanel();
		topBorder.setPreferredSize(new Dimension(0,10));
		frame.add(topBorder, BorderLayout.NORTH);
		
		JPanel bottomBorder = new JPanel();
		bottomBorder.setPreferredSize(new Dimension(0,75));
		frame.add(bottomBorder, BorderLayout.SOUTH);
		
		JPanel leftBorder = new JPanel();
		leftBorder.setPreferredSize(new Dimension(10,0));
		frame.add(leftBorder, BorderLayout.EAST);
		
		JPanel rightBorder = new JPanel();
		rightBorder.setPreferredSize(new Dimension(10,0));
		frame.add(rightBorder, BorderLayout.WEST);
		
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
}
