package Configuration;

import java.awt.Color;

public class Settings {
	
	// Front End Settings
	private static int gridSize = 64;	
	public static int getGridSize(){
			return gridSize;
	}

	// Color Settings
	private static Color frameColor ;
	private static Color boardColor = Color.decode("#484349");
	public static Color getBoardColor() {return boardColor;}
	private static Color gridColor = Color.decode("#9A8F97");
	public static Color getGridColor() {return gridColor;}
	private static Color aliveColor = Color.decode("#E0EFDE");
	public static Color getAliveColor() {return aliveColor;}
	private static Color deadColor = Color.decode("#9A8F97");
	public static Color getDeadColor() {return deadColor;}

	
}
