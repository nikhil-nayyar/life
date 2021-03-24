package backend;

import java.util.concurrent.TimeUnit;
import configuration.Settings;

/**
 * Contains methods pertaining to the operation of the application's main backend algorithms
*/
public class Engine implements Runnable{
	
	private BoardBack data;
	private int gridSize;
	private boolean play;
	
	/**
	 * Contains methods pertaining to the operation of the application's main backend algorithms
	*/
	public Engine(BoardBack input){
		data = input;
		gridSize = Settings.getGridSize() - 1;
	}
	
	/**
	 * Iterates through BoardBack and performs Life computations
	*/
	public void boardPlay() {
		
		while(play) {
			
			for(int x = 0; x <= gridSize; x++) {
				for(int y = 0; y <= gridSize; y++) {
					calculateNextState(data.getCell(x, y));
				}
			}
			
			for(int x = 0; x <= gridSize; x++) {
				for(int y = 0; y <= gridSize; y++) {
					updateState(data.getCell(x, y));
				}
			}		
						
			try {
				TimeUnit.SECONDS.sleep(configuration.Settings.generationTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * Resets all cells in BackBoard to dead state
	*/
	public void boardReset() {
		
		for(int x = 0; x <= gridSize; x++) {
			for(int y = 0; y <= gridSize; y++) {
				data.getCell(x, y).setCurrState(false);
				data.getCell(x, y).setNextState(false);
			}
		}
		
	}
	
	/**
	 * Given a cell, calculates the next state by analyzing neighbors
	 * @param backCell
	 * 	the cell to be analyzed
	*/
	private void calculateNextState(CellBack backCell) {
		int count = 0;
		CellBack temp;
						
		for(int i = 0; i < 8; i++) {
			temp = backCell.Neighbors[i];
			if( temp != null) {
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

	/**
	 * Given a cell, converts the nextState to currState
	 * @param backCell
	 * 	the cell to be updated
	*/
	private void updateState(CellBack backCell) {
		backCell.setCurrState(backCell.getNextState());
	}
	
	/**
	 * Updates the play control button to the desired state
	 * @param input
	 * 	desired state
	*/
	public void setPlay(boolean input) {play = input;}

	/**
	 * Runs the Life algorithm
	*/
	@Override
	public synchronized void run() {
		this.boardPlay();
	}
}
