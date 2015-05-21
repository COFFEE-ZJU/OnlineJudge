import java.util.Scanner;


public class Main1_2 {
	private int[][] grid;
	private int rowN, colN;
	
	private int[] bestScorePrevCol;
	
	private int[] bestScoreDownwards;
	private int[] bestScoreUpwards;
	public Main1_2(int[][] grid, int rowN, int colN) {
		this.grid = grid;
		this.rowN = rowN;
		this.colN = colN;
		
		bestScoreDownwards = new int[rowN];
		bestScoreUpwards = new int[rowN];
		bestScorePrevCol = new int[rowN];
	}
	
	private void solveOneway(int colIdx, int[] bestScores, int delta){
		int startRow;
		if(delta == 1)		//downwards
			startRow = 0;
		else				//upwards
			startRow = rowN - 1;
		
		int teleportStartIdx = -1;	// no need to teleport initially
		int nonTeleportedBest = -1;
		
		if(grid[startRow][colIdx] == -1) bestScores[startRow] = -1;
		else if(bestScorePrevCol[startRow] != -1)
			bestScores[startRow] = bestScorePrevCol[startRow] + grid[startRow][colIdx];
		else{
			for(int i = rowN - 1 - startRow; i != startRow; i -= delta){
				if(grid[i][colIdx] == -1) break;
				
				if(bestScorePrevCol[i] != -1){
					teleportStartIdx = i;
					break;
				}
			}
			
			bestScores[startRow] = (teleportStartIdx == -1) ? -1 : grid[startRow][colIdx];
		}
		
		for(int i = startRow + delta; i != rowN -1 - startRow + delta; i += delta){
			if(grid[i][colIdx] == -1 || (bestScores[i - delta] == -1 && bestScorePrevCol[i] == -1)){
				bestScores[i] = -1;
				continue;
			}
			
			if(bestScorePrevCol[i] > bestScores[i - delta]){
				teleportStartIdx = nonTeleportedBest = -1;		//no need anymore
				
				bestScores[i] = bestScorePrevCol[i] + grid[i][colIdx];
				continue;
			}
			
			if(teleportStartIdx == -1){		//no need to teleport
				bestScores[i] = bestScores[i - delta] + grid[i][colIdx];
			} else{		//best downward is teleported to prev point
				int nonTeleBest = (nonTeleportedBest > bestScorePrevCol[i]) ? nonTeleportedBest : bestScorePrevCol[i];
				if(i == teleportStartIdx){		//unable to teleport here
					teleportStartIdx = nonTeleportedBest = -1;		//no need anymore
					
					bestScores[i] = (nonTeleBest == -1) ? -1 : nonTeleBest +  grid[i][colIdx];
				}
				else{	//still teleportable
					bestScores[i] = bestScores[i - delta] + grid[i][colIdx];
					nonTeleportedBest = (nonTeleBest == -1) ? -1 : nonTeleBest +  grid[i][colIdx];
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

	private void solveDownwardBkup(int colIdx){
		int teleportStartIdx = -1;	// no need to teleport initially
		int nonTeleportedBest = -1;
		
		if(grid[0][colIdx] == -1) bestScoreDownwards[0] = -1;
		else if(bestScorePrevCol[0] != -1)
			bestScoreDownwards[0] = bestScorePrevCol[0] + grid[0][colIdx];
		else{
			for(int i = rowN - 1; i >= 1; i--){
				if(grid[i][colIdx] == -1) break;
				
				if(bestScorePrevCol[i] != -1){
					teleportStartIdx = i;
					break;
				}
			}
			
			bestScoreDownwards[0] = (teleportStartIdx == -1) ? -1 : grid[0][colIdx];
		}
		
		for(int i = 1; i < rowN; i++){
			if(grid[i][colIdx] == -1 || (bestScoreDownwards[i - 1] == -1 && bestScorePrevCol[i] == -1)){
				bestScoreDownwards[i] = -1;
				continue;
			}
			
			if(bestScorePrevCol[i] > bestScoreDownwards[i - 1]){
				teleportStartIdx = nonTeleportedBest = -1;		//no need anymore
				
				bestScoreDownwards[i] = bestScorePrevCol[i] + grid[i][colIdx];
				continue;
			}
			
			if(teleportStartIdx == -1){		//no need to teleport
				bestScoreDownwards[i] = bestScoreDownwards[i - 1] + grid[i][colIdx];
			} else{		//best downward is teleported to prev point
				int nonTeleBest = (nonTeleportedBest > bestScorePrevCol[i]) ? nonTeleportedBest : bestScorePrevCol[i];
				if(i >= teleportStartIdx){		//unable to teleport here
					teleportStartIdx = nonTeleportedBest = -1;		//no need anymore
					
					bestScoreDownwards[i] = (nonTeleBest == -1) ? -1 : nonTeleBest +  grid[i][colIdx];
				}
				else{	//still teleportable
					bestScoreDownwards[i] = bestScoreDownwards[i - 1] + grid[i][colIdx];
					nonTeleportedBest = (nonTeleBest == -1) ? -1 : nonTeleBest +  grid[i][colIdx];
				}
			}
		}
	}
	
	public int solve(){
		for(int j = 0; j < colN; j++){
			solveDownward(j);
			solveUpward(j);
			
			for(int i = 0; i < rowN; i++){
				bestScorePrevCol[i] = 
						(bestScoreDownwards[i] > bestScoreUpwards[i]) ? bestScoreDownwards[i] : bestScoreUpwards[i];
			}
		}
		
		int max = -1;
		for(int i = 0; i < rowN; i++){
			if(bestScorePrevCol[i] > max) max = bestScorePrevCol[i];
		}
		
		return max;
	}

	public static void test() {
		int[][] grid = new int[][]{
				new int[]{-1, 4, 5, 1}, 
				new int[]{2, -1, 2, 4}, 
				new int[]{3, 3, -1, 3}, 
				new int[]{4, 2, 1, 2}
				};
		
		System.out.println(new Main1_2(grid, 4, 4).solve());
		
		grid = new int[][]{
				new int[]{-1, 4, 5, 1}, 
				new int[]{2, -1, 2, 4}, 
				new int[]{3, 3, -1, -1}, 
				new int[]{4, 2, 1, 2}
				};
		
		System.out.println(new Main1_2(grid, 4, 4).solve());
		
		grid = new int[][]{
				new int[]{-1, 4, 5, 1}, 
				new int[]{2, -1, 2, 4}, 
				new int[]{3, 3, -1, 3}, 
				new int[]{4, 2, -1, 2}
				};
		
		System.out.println(new Main1_2(grid, 4, 4).solve());
	}

	public static void main(String[] args) {
		test();
//		Scanner scanner = new Scanner(System.in);
//		int row = scanner.nextInt();
//		int col = scanner.nextInt();
//		int[][] grid = new int[row][col];
//		for(int i = 0; i < row; i++){
//			for(int j = 0; j < col; j++){
//				grid[i][j] = scanner.nextInt();
//			}
//		}
//		scanner.close();
//		
//		System.out.println(new Main1_2(grid, row, col).solve());
	}
}
