package FrontEnd;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Configuration.Settings;

public class PanelControl extends JPanel implements ActionListener{
	
	BoxLayout layout;
	JPanel panel;
	JButton play;
	JButton pause;
	JButton reset;
	Color backgroundColor = Configuration.Settings.getPanelColor();

	
	PanelControl(){
		
		// Create and set panel and layout
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(580,50));
		layout = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(layout);
		panel.setAlignmentX(CENTER_ALIGNMENT);
		
		// Set Background
		panel.setBackground(backgroundColor);
		panel.setOpaque(true);

		// Create and Place Buttons
		play = new JButton("PLAY");
		play.setMaximumSize(new Dimension(50,50));
		play.setBorderPainted(false);
		play.setFocusPainted(false);
		play.setBackground(Settings.getButtonColor());
		play.addActionListener(this);
		
		pause = new JButton("PAUSE");
		pause.setMaximumSize(new Dimension(50,50));
		pause.setBorderPainted(false);
		pause.setFocusPainted(false);
		pause.setBackground(Settings.getButtonColor());
		pause.addActionListener(this);

		reset = new JButton("RESET");
		reset.setMaximumSize(new Dimension(100,50));
		reset.setBorderPainted(false);
		reset.setFocusPainted(false);
		reset.setBackground(Settings.getButtonColor());
		reset.addActionListener(this);

		panel.add(Box.createRigidArea(new Dimension(10,0)));
		panel.add(play);
		panel.add(pause);
		panel.add(Box.createHorizontalGlue());
		panel.add(Box.createRigidArea(new Dimension(100,0)));
		panel.add(reset);
		panel.add(Box.createRigidArea(new Dimension(10,0)));

		panel.setVisible(true);
		this.add(panel);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
	}

}
