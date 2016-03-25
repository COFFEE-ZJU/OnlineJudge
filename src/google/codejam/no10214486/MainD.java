package google.codejam.no10214486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zkf on 3/25/16.
 */
public class MainD {
//	public static final String fileName = "d-test";
	public static final String fileName = "D-large-practice";
//	public static final String fileName = "D-small-practice";

	private static int divider = 1000000007;
	private static long[][][] dp = new long[4][501][501];
	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner(fileName, MainD.class);
		Writer writer = CodejamUtils.getWriter(fileName, MainD.class);

		int t = scanner.nextInt();
		for(int tt=0; tt<t; tt++){
			String str = scanner.next();
			initDP();

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				moveOne(c);
			}

			writer.write(format(tt, dp[3][0][0]-1));
		}

		writer.close();
		scanner.close();
	}

	private static void initDP() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 501; j++) {
				Arrays.fill(dp[i][j], 0);
			}
		}
		dp[3][0][0] = 1;
	}

	private static void moveOne(char c) {
		switch (c) {
			case 'a':
				for (int i = 500; i >= 2; i--) {
					dp[0][i][0] += dp[0][i-1][0];
					dp[0][i][0] %= divider;
				}
				dp[0][1][0] += dp[3][0][0];
				dp[0][1][0] %= divider;
				break;
			case 'b':
				for (int i = 1; i < 501; i++) {
					for (int j = 500; j >= 2; j--) {
						dp[1][i][j] += dp[1][i][j-1];
						dp[1][i][j] %= divider;
					}
				}
				for (int i = 1; i < 501; i++) {
					dp[1][i][1] += dp[0][i][0];
					dp[1][i][1] %= divider;
				}
				break;
			case 'c':
				for (int i = 1; i < 501; i++) {
					for (int j = 0; j < 500; j++) {
						dp[2][j][i] += dp[2][j+1][i]+dp[1][j+1][i];
						dp[2][j][i] %= divider;
					}
				}
				break;
			case 'd':
				for (int i = 0; i < 500; i++) {
					dp[3][i][0] += dp[3][i+1][0]+dp[2][0][i+1];
					dp[3][i][0] %= divider;
				}
				break;
		}
	}

	private static String format(int caseNo, long d){
		return String.format("Case #%d: %d\n", caseNo+1, d);
	}
}
