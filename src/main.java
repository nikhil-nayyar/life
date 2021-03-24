import backend.BoardBack;
import backend.Engine;

/**
 * This is the main class running Conway's Game of Life.
 * 
 * It instantiates the Front End GUI [frame], the Back End data structures [data] and the Back End algorithms [engine]
 */
public class main {
	
	static Frame frame;
	static BoardBack data;
	static Engine engine;
	
	/**
	 * Instantiates and links Front End and Back End components
	 */
    public static void main(final String[] args) {

		BoardBack data = new BoardBack();
		Engine engine = new Engine(data);
		Frame frame = new Frame(data, engine);
		data.setPanel(frame.getPanelBoard());
		
	}
}
