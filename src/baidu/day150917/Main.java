package baidu.day150917;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
		
		Matrix ma = new Matrix(n, m);
		for(int i = 0; i < k; i++){
			ma.setMine(scanner.nextInt(), scanner.nextInt());
		}
		System.out.println(String.format("%.6f", ma.getProb()));
		scanner.close();
	}
}

class Matrix{
	boolean[][] mineMatrix;
	BigDecimal[][] probMatrix;
	int n,m;
	
	public Matrix(int n, int m) {
		this.n = n;
		this.m = m;
		mineMatrix = new boolean[n][m];
		probMatrix = new BigDecimal[n][m];
	}
	
	public void setMine(int n, int m){
		mineMatrix[n-1][m-1] = true;
	}
	
	private BigDecimal getProb(int n, int m){
		if(probMatrix[n][m] != null)
			return probMatrix[n][m];
		
		if(mineMatrix[n][m]){
			probMatrix[n][m] = new BigDecimal(0);
			return probMatrix[n][m];
		}
		
		if(n == this.n-1 && m == this.m-1){
			probMatrix[n][m] = new BigDecimal(1);
			return probMatrix[n][m];
		}
		
		if(n == this.n-1){
			probMatrix[n][m] = getProb(n, m+1);
			return probMatrix[n][m];
		}
		
		if(m == this.m-1){
			probMatrix[n][m] = getProb(n+1, m);
			return probMatrix[n][m];
		}
		
		BigDecimal bd = new BigDecimal("0.5");
		bd = bd.multiply(getProb(n+1, m));
		BigDecimal bd2 = new BigDecimal("0.5");
		bd2 = bd2.multiply(getProb(n, m+1));
		
		probMatrix[n][m] = bd.add(bd2);
		
		return probMatrix[n][m];
	}
	
	public double getProb(){
		
		return getProb(0, 0).doubleValue();
	}
}