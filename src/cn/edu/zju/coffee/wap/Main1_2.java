package cn.edu.zju.coffee.wap;

import java.util.Scanner;


class SnakeGame {
	private int[][] grid;
	private int rowN, colN;
	
	private long[] bestScorePrevCol;
	
	private long[] bestScoreDownwards;
	private long[] bestScoreUpwards;
	
	public SnakeGame(int[][] grid){
		this(grid, grid.length, grid[0].length);
	}
	
	public SnakeGame(int[][] grid, int rowN, int colN) {
		this.grid = grid;
		this.rowN = rowN;
		this.colN = colN;
		
		bestScoreDownwards = new long[rowN];
		bestScoreUpwards = new long[rowN];
		bestScorePrevCol = new long[rowN];
	}
	
	/**
	 * Calculate the best score one can achieve in this game.
	 * 
	 * @return the best score
	 */
	public long solve(){
		for(int j = 0; j < colN; j++){
			solveDownward(j);	//calculate best score of this column downwards
			solveUpward(j);		//calculate best score of this column upwards
			
			for(int i = 0; i < rowN; i++){	//compare and store the best score for each cell in this column
				bestScorePrevCol[i] = 
						(bestScoreDownwards[i] > bestScoreUpwards[i]) ? bestScoreDownwards[i] : bestScoreUpwards[i];
			}
		}
		
		long max = -1;
		for(int i = 0; i < rowN; i++){
			if(bestScorePrevCol[i] > max) max = bestScorePrevCol[i];
		}
		
		return max;
	}

	/**
	 * Calculate the best score for every cell of the column by allowing only one direction(downward/upward).
	 * 
	 * @param colIdx the column index that needs to be calculated
	 * @param bestScores the array to store the best scores
	 * @param delta 1(downward) or -1(upward) to indicate direction
	 */
	private void solveOneway(int colIdx, long[] bestScores, int delta){
		int startRow;
		if(delta == 1)		//downwards
			startRow = 0;
		else				//upwards
			startRow = rowN - 1;
		
		int teleportStartIdx = -1;	// no need to teleport initially
		long nonTeleportedBest = -1;
		
		//the first step needs special treat
		if(grid[startRow][colIdx] == -1)	//blocked
			bestScores[startRow] = -1;
		else if(bestScorePrevCol[startRow] != -1)	//left not blocked
			bestScores[startRow] = bestScorePrevCol[startRow] + grid[startRow][colIdx];
		else{	//left blocked and this cell not blocked, need to consider teleport
			for(int i = rowN - 1 - startRow; i != startRow; i -= delta){
				if(grid[i][colIdx] == -1) break;	//unable to teleport
				
				if(bestScorePrevCol[i] != -1){		//best index to teleport
					teleportStartIdx = i;
					break;
				}
			}
			
			bestScores[startRow] = (teleportStartIdx == -1) ? -1 : grid[startRow][colIdx];
		}
		
		for(int i = startRow + delta; i != rowN -1 - startRow + delta; i += delta){		//iterate by one direction
			
			//this cell is blocked, or previous cells are blocked, unreachable
			if(grid[i][colIdx] == -1 || (bestScores[i - delta] == -1 && bestScorePrevCol[i] == -1)){
				bestScores[i] = -1;
				continue;
			}
			
			//best score comes directly from left
			if(bestScorePrevCol[i] > bestScores[i - delta]){
				nonTeleportedBest = teleportStartIdx = -1;		//no need anymore
				
				bestScores[i] = bestScorePrevCol[i] + grid[i][colIdx];
				continue;
			}
			
			//best score comes from above(below)
			if(teleportStartIdx == -1){		//no need to teleport
				bestScores[i] = bestScores[i - delta] + grid[i][colIdx];
			}
			else{		//best downward(upward) is teleported to previous cell
				long nonTeleBestPrev = (nonTeleportedBest > bestScorePrevCol[i]) ? nonTeleportedBest : bestScorePrevCol[i];
				if(i == teleportStartIdx){		//teleport will cause overlap, unable to teleport here
					nonTeleportedBest = teleportStartIdx = -1;		//no need anymore
					
					bestScores[i] = (nonTeleBestPrev == -1) ? -1 : nonTeleBestPrev +  grid[i][colIdx];
				}
				else{	//still teleportable
					bestScores[i] = bestScores[i - delta] + grid[i][colIdx];
					nonTeleportedBest = (nonTeleBestPrev == -1) ? -1 : nonTeleBestPrev +  grid[i][colIdx];
				}
			}
		}
	}
	
	private void solveDownward(int colIdx){
		solveOneway(colIdx, bestScoreDownwards, 1);
	}
	
	private void solveUpward(int colIdx){
		solveOneway(colIdx, bestScoreUpwards, -1);
	}
}


public class Main1_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		int[][] grid = new int[row][col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				grid[i][j] = scanner.nextInt();
			}
		}
		scanner.close();
		
		System.out.println(new SnakeGame(grid, row, col).solve());
	}
}
