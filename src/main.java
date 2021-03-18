import BackEnd.DataBoard;
import BackEnd.Engine;

public class main {
	
	static Frame frame;
	static DataBoard data;
	static Engine engine;
	
    @SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("THE GAME OF LIFE");
		
		DataBoard data = new DataBoard();
		Engine engine = new Engine(data);
		Frame frame = new Frame(data, engine);
		data.setPanel(frame.getPanelBoard());
		
	}
}
