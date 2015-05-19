import java.util.Scanner;


public class Main {
	private int[][] grid;
	private int rowN, colN;
	
	public Main(int[][] grid, int rowN, int colN) {
		this.grid = grid;
		this.rowN = rowN;
		this.colN = colN;
	}

	private int getBestScoreInColumn(int colIdx, int rowIdxStart, int rowIdxEnd){
		if(grid[rowIdxStart][colIdx] == -1) return -1;	//start position blocked
		
		int prevScore = (colIdx == 0) ? 0 : grid[rowIdxStart][colIdx - 1];
		if(prevScore == -1) return -1;	//left of start position blocked
		
		//TODO:start position is the same as end, maybe not necessary
		if(rowIdxStart == rowIdxEnd) return prevScore + grid[rowIdxStart][colIdx];
		
		int upScore = prevScore + grid[rowIdxStart][colIdx];
		int downScore = upScore;
		
		//try upwards
		int curRowIdx = rowIdxStart;
		while(curRowIdx != rowIdxEnd){
			if(curRowIdx == 0){
				upScore = 0;
				curRowIdx = rowN - 1;
			} else curRowIdx --;
			
			if(grid[curRowIdx][colIdx] == -1){
				upScore = -1;
				break;
			}
			upScore += grid[curRowIdx][colIdx];
		}
		
		//try downwards
		curRowIdx = rowIdxStart;
		while(curRowIdx != rowIdxEnd){
			if(curRowIdx == rowN - 1){
				downScore = 0;
				curRowIdx = 0;
			} else curRowIdx ++;
			
			if(grid[curRowIdx][colIdx] == -1){
				downScore = -1;
				break;
			}
			downScore += grid[curRowIdx][colIdx];
		}
		
		return (upScore > downScore) ? upScore : downScore;
	}
	
	private int getBestScoreByStopPoint(int rowIdx, int colIdx){
		if(grid[rowIdx][colIdx] == -1) return -1;	//not possible to be a stop point
		
		int maxScore = -1;
		for(int i = 0; i < rowN; i++){
			int score = getBestScoreInColumn(colIdx, i, rowIdx);
			if(score > maxScore) maxScore = score;
		}
		
		return maxScore;
	}
	
	private int solve(){
		int[] colScores = new int[rowN];
		for(int j = 0; j < colN; j++){
			// get best score for each ending position in this column, -1 for impossible
			for(int i = 0; i < rowN; i++)
				colScores[i] = getBestScoreByStopPoint(i, j);
			
			for(int i = 0; i < rowN; i++)
				grid[i][j] = colScores[i];
		}
		
		int max = -1;
		for(int i = 0; i < rowN; i++){
			if(grid[i][colN - 1] > max) max = grid[i][colN - 1];
		}
		
		return max;
	}

	public static void test(String[] args) {
		int[][] grid = new int[][]{
				new int[]{-1, 4, 5, 1}, 
				new int[]{2, -1, 2, 4}, 
				new int[]{3, 3, -1, 3}, 
				new int[]{4, 2, 1, 2}
				};
		
		System.out.println(new Main(grid, 4, 4).solve());
		
		grid = new int[][]{
				new int[]{-1, 4, 5, 1}, 
				new int[]{2, -1, 2, 4}, 
				new int[]{3, 3, -1, -1}, 
				new int[]{4, 2, 1, 2}
				};
		
		System.out.println(new Main(grid, 4, 4).solve());
		
		grid = new int[][]{
				new int[]{-1, 4, 5, 1}, 
				new int[]{2, -1, 2, 4}, 
				new int[]{3, 3, -1, 3}, 
				new int[]{4, 2, -1, 2}
				};
		
		System.out.println(new Main(grid, 4, 4).solve());
	}

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
		
		System.out.println(new Main(grid, row, col).solve());
	}
}
