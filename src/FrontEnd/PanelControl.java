package FrontEnd;

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

import BackEnd.DataBoard;
import BackEnd.Engine;
import Configuration.Settings;

public class PanelControl extends JPanel implements ActionListener{
	
	BoxLayout layout;
	JPanel panel;
	JButton play;
	JButton pause;
	JButton reset;
	Color backgroundColor = Configuration.Settings.getPanelColor();
	Object source;
	DataBoard data;
	Engine engine;
	Thread engine_t;
	
	
	public PanelControl(Engine input){
		
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
		engine_t = new Thread(engine);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		source = e.getSource();
		if(source == play) {
			play.setEnabled(false);
			pause.setEnabled(true);
			reset.setEnabled(false);
			engine.setPlay(true);
			engine_t.start();
		}
		else if (source == pause) {
			play.setEnabled(true);
			pause.setEnabled(false);
			reset.setEnabled(true);
			System.out.println("PAUSE");
			engine.setPlay(false);
			engine_t.interrupt();

		}
		else if (source == reset) {
			System.out.println("RESET");
		}
	}

}
