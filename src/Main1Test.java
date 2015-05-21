import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Main1Test {
	private static final Random random = new Random(System.currentTimeMillis());
	
	private static final int[][] grid1 = new int[][]{
		new int[]{-1, 4, 5, 1}, 
		new int[]{2, -1, 2, 4}, 
		new int[]{3, 3, -1, 3}, 
		new int[]{4, 2, 1, 2}
		};
	private static final int[][] grid2 = new int[][]{
		new int[]{-1, 4, 5, 1}, 
		new int[]{2, -1, 2, 4}, 
		new int[]{3, 3, -1, -1}, 
		new int[]{4, 2, 1, 2}
		};
	private static final int[][] grid3 = new int[][]{
		new int[]{-1, 4, 5, 1}, 
		new int[]{2, -1, 2, 4}, 
		new int[]{3, 3, -1, 3}, 
		new int[]{4, 2, -1, 2}
		};
	
	private static int[][] getRamdomGrid(int row, int col, int maxScore, float blockRate){
		int[][] grid = new int[row][col];
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(random.nextFloat() <= blockRate)
					grid[i][j] = -1;
				else
					grid[i][j] = random.nextInt(maxScore) + 1;
			}
		}
		
		return grid;
	}
	
	private static void printGrid(int[][] grid){
		int row = grid.length;
		int col = grid[0].length;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.printf("%3d\t", grid[i][j]);
			}
			System.out.println();
		}
	}
	
	private static int[][] copyGrid(int[][] grid){
		int r = grid.length, c = grid[0].length;
		int[][] ret = new int[r][c];
		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				ret[i][j] = grid[i][j];
			}
		}
		
		return ret;
	}
	
	public static void randomCompare(int times){
		int row = 500, col = 500;
		int[][] grid, cp;
		long t1=0, t2=0, start;
		for(int i = 0; i < times; i++){
			grid = getRamdomGrid(row, col, 99999, 0.5f);
			cp = copyGrid(grid);
			
			start = System.currentTimeMillis();
			int s2 = new Main1_2(grid, row, col).solve();
			t2 += (System.currentTimeMillis() - start);
			
			start = System.currentTimeMillis();
			int s1 = new Main1(grid, row, col).solve();
			t1 += (System.currentTimeMillis() - start);
			
			if(s1 != s2){
				System.err.println("not matched!!!");
				printGrid(cp);
				System.out.println("answer1: "+s1);
				System.out.println("answer2: "+s2+"\n\n");
			}
		}
		System.out.println("sol 1 use time:" + TimeUnit.SECONDS.convert(t1, TimeUnit.MILLISECONDS));
		System.out.println("sol 2 use time:" + TimeUnit.SECONDS.convert(t2, TimeUnit.MILLISECONDS));
	}
	
	public static void test1() {
		int[][] grid = new int[][]{
				new int[]{-1, 4, 5, 1}, 
				new int[]{2, -1, 2, 4}, 
				new int[]{3, 3, -1, 3}, 
				new int[]{4, 2, 1, 2}
				};
		
		System.out.println(new Main1(grid, 4, 4).solve());
		
		grid = new int[][]{
				new int[]{-1, 4, 5, 1}, 
				new int[]{2, -1, 2, 4}, 
				new int[]{3, 3, -1, -1}, 
				new int[]{4, 2, 1, 2}
				};
		
		System.out.println(new Main1(grid, 4, 4).solve());
		
		grid = new int[][]{
				new int[]{-1, 4, 5, 1}, 
				new int[]{2, -1, 2, 4}, 
				new int[]{3, 3, -1, 3}, 
				new int[]{4, 2, -1, 2}
				};
		
		System.out.println(new Main1(grid, 4, 4).solve());
	}
	
	public static void main(String[] args) {
		randomCompare(2000);
	}
}
