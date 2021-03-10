import BackEnd.DataBoard;
import FrontEnd.Frame;

public class main {
	
    @SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("LIFE");
		DataBoard board = new DataBoard();
		Frame life = new Frame(board);
	}
}
