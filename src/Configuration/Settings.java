package configuration;

import java.awt.Color;

public class Settings {
	
	// Front End Settings
	private static int gridSize = 64;	
	public static int getGridSize(){
			return gridSize;
	}

	// Color Settings
	private static Color frameColor ;
	private static Color panelColor = Color.decode("#5D675B");
	public static Color getPanelColor() {return panelColor;}
	private static Color boardColor = Color.decode("#40262A");
	public static Color getBoardColor() {return boardColor;}
	private static Color gridColor = Color.decode("#59363B");
	public static Color getGridColor() {return gridColor;}
	private static Color aliveColor = Color.decode("#F0D3A8");
	public static Color getAliveColor() {return aliveColor;}
	private static Color deadColor = Color.decode("#59363B");
	public static Color getDeadColor() {return deadColor;}
	private static Color buttonColor = Color.decode("#9A8F97");
	public static Color getButtonColor() {return buttonColor;}

	// Engine Settings
	public static int generationTime = 1; // in seconds

	
}
