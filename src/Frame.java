
import backend.BoardBack;
import backend.Engine;
import configuration.Settings;
import frontend.BoardFront;
import frontend.ControlPanel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;

/**
 * main GUI window for application
*/

public class Frame{
	
	JFrame frame;
	Container framePane;
	BoardFront board;
	ControlPanel control;

	/**
	 * Constructor
	 * @param data
	 * 	the backend data object for the application
	 * @param engine
	 * 	the backend algorithm object for the application
	*/
	public Frame(BoardBack data, Engine engine){
		
		// Create and Configure Main Window
		frame = new JFrame("The Game of Life");
		frame.setBounds(new Rectangle(600,600));
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("C:\\Users\\nikhi\\eclipse-workspace\\Life\\src\\cell.svg").getImage());
		framePane = frame.getContentPane();
		framePane.setLayout(new BorderLayout());
		
		
		// Add backend gameboard
		board = new BoardFront(data);
		frame.add(board, BorderLayout.CENTER);

		// Add frontend controls
		control = new ControlPanel(engine);
		control.setPreferredSize(new Dimension(0,75));
		control.setBackground(Settings.getPanelColor());
		frame.add(control, BorderLayout.SOUTH);
		
		// Add window borders
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
		
		// Refresh to have changes take effect
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
	/**
	 * returns the BoardFront object used for the application
	*/
	public BoardFront getPanelBoard() {
		return board;
	}
	
	/**
	 * returns the ControlPanel object used for the application
	*/
	public ControlPanel getPanelControl() {
		return control;
	}

}
