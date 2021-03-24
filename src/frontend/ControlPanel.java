package frontend;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import backend.BoardBack;
import backend.Engine;
import configuration.Settings;

public class ControlPanel extends JPanel implements ActionListener{
	
	BoxLayout layout;
	JPanel panel;
	JButton play;
	JButton pause;
	JButton reset;
	Color backgroundColor = configuration.Settings.getPanelColor();
	Object source;
	BoardBack data;
	Engine engine;
	Thread engine_t;
	
	
	public ControlPanel(Engine input){
		
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
		play.setEnabled(true);
		play.setMaximumSize(new Dimension(50,50));
		play.setBorderPainted(false);
		play.setFocusPainted(false);
		play.setBackground(Settings.getButtonColor());
		play.addActionListener(this);
		
		pause = new JButton("PAUSE");
		pause.setEnabled(false);
		pause.setMaximumSize(new Dimension(50,50));
		pause.setBorderPainted(false);
		pause.setFocusPainted(false);
		pause.setBackground(Settings.getButtonColor());
		pause.addActionListener(this);

		reset = new JButton("RESET");
		reset.setEnabled(true);
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
		
		engine = input;
	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		source = e.getSource();
		if(source == play) {
			play.setEnabled(false);
			pause.setEnabled(true);
			reset.setEnabled(false);
			engine.setPlay(true);
			engine_t = new Thread(engine);
			engine_t.start();
		}
		else if (source == pause) {
			play.setEnabled(true);
			pause.setEnabled(false);
			reset.setEnabled(true);
			System.out.println("PAUSE");
			engine.setPlay(false);

		}
		else if (source == reset) {
			engine.boardReset();
		}
	}

}
