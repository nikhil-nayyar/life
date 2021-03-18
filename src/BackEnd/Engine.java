package BackEnd;

import java.util.concurrent.TimeUnit;

import Configuration.Settings;
import FrontEnd.PanelBoard;
import FrontEnd.PanelControl;

public class Engine implements Runnable{
	
	private DataBoard data;
	private int gridSize;
	private boolean play;
	private Thread game;
	
	public Engine(DataBoard input){
		data = input;
		gridSize = Settings.getGridSize() - 1;
	}
	
	public void boardPause() {}
	
	public void boardPlay() {
		
		while(play) {
			
			for(int x = 0; x <= gridSize; x++) {
				for(int y = 0; y <= gridSize; y++) {
					System.out.println("Calculating " + x + " " + y);
					calculateNextState(data.getCell(x, y));
				}
			}
			
			for(int x = 0; x <= gridSize; x++) {
				for(int y = 0; y <= gridSize; y++) {
					// System.out.println("Calculating " + i + " " + j);
					updateState(data.getCell(x, y));
				}
			}		
			
			System.out.println("-----------------------");
						
			try {
				TimeUnit.SECONDS.sleep(Configuration.Settings.generationTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void boardReset() {}
	
	private void calculateNextState(BackCell backCell) {
		int count = 0;
		int neighbor = 0;
		BackCell temp;
		
		System.out.println();
				
		for(int i = 0; i < 8; i++) {
			temp = backCell.Neighbors[i];
			if( temp != null) {
				neighbor += 1;
				count += temp.getCurrState() ? 1 : 0;
			}
		}
		
		// System.out.println(backCell.toString() + " has " + neighbor + " neighbors.");
		
		if(backCell.getCurrState()==true) {
			if(count < 2) {backCell.setNextState(false);}
			else if (count < 4) {backCell.setNextState(true);}
			else {backCell.setNextState(false);}
		}
		else if(backCell.getCurrState()==false) {
			if(count == 3) {backCell.setNextState(true);}
			else {backCell.setNextState(false);}
		}
		
	}

	private void updateState(BackCell backCell) {
		backCell.setCurrState(backCell.getNextState());
	}
	
	public void setPlay(boolean input) {play = input;}

	@Override
	public void run() {
		this.boardPlay();
	}
}
