package hiho.msintern.n3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int r = scanner.nextInt(), c = scanner.nextInt();
			int[][] block = new int[r+1][c+1];
			for (int i = 0; i < r; i++) {
				String line = scanner.next();
				for (int j = 0; j < c; j++) {
					block[i][j] = line.charAt(j) == '.' ? 0 : 1;
				}
				block[i][c] = 1;
			}
			Arrays.fill(block[r], 1);

			int[][] right = new int[r][c], down = new int[r][c];
			right[0][0] = block[0][0];
			down[0][0] = block[0][0] + 1 - block[0][1];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (i == 0 && j == 0)
						continue;
					int r1, r2, d1, d2;
					r1 = r2 = d1 = d2 = Integer.MAX_VALUE;
					if (i != 0) {
						r2 = down[i-1][j] + block[i][j] + 1 - block[i+1][j];
						d2 = down[i-1][j] + block[i][j];
					}
					if (j != 0) {
						r1 = right[i][j-1] + block[i][j];
						d1 = right[i][j-1] + block[i][j] + 1 - block[i][j+1];
					}
					right[i][j] = Math.min(r1, r2);
					down[i][j] = Math.min(d1, d2);
				}
			}

			System.out.println(Math.min(right[r-1][c-1], down[r-1][c-1]));
		}
	}
	
	public static void main(String[] args) {
		new Main().deal();
	}
}
