package hiho.no1033;

public class Main {
	private static final int[][][] countKWith0, sumKWith0;
	private static final int mod = (int)Math.pow(10, 9) + 7;
	static  {
		countKWith0 = new int[19][10][201];
		sumKWith0 = new int[19][10][201];
		countKWith0[0][0][100] = 1;
		for (int i = 1; i < 19; i++) {
			for (int k = -100; k <= 100; k++) {
				for (int j = 0; j < 10; j++) {
					countKWith0[i][0][k+100] += countKWith0[i-1][j][-k+100];
					sumKWith0[i][0][k+100] += sumKWith0[i-1][j][-k+100];
				}
				sumKWith0[i][0][k+100] %= mod;
			}
			for (int k = -100; k <= 100; k++) {
				int addUp = i > 9 ? 0 : (int) Math.pow(10, i);
				for (int j = 1; j < 10; j++) {
					int prevK = k-j;
					if (prevK >= -100 && prevK <= 100) {
						countKWith0[i][j][k + 100] += countKWith0[i][0][prevK + 100];
						sumKWith0[i][j][k + 100] += sumKWith0[i][0][prevK + 100];
					}
				}
			}
		}
//		for (int i = -10; i <= 10; i++) {
//			System.out.print(i + ":");
//			System.out.print(countK[0][i+100] + ", ");
//			System.out.print(countK[1][i+100] + ", ");
//			System.out.println(countK[2][i+100]);
//		}
	}

	private static int countByDigit(int dig, int k) {
		int cnt = countKWith0[0][0][k+100];
		for (int i = 1; i <= dig; i++) {
			for (int j = 1; j < 10; j++) {
				cnt += countKWith0[i][j][k+100];
			}
		}

		return cnt;
	}

	private static int countByUpper(int upper, int k) {
		int cnt = 0;
		String num = ""+upper;
		int digit = num.length();
		cnt += countByDigit(digit-1, k);

		boolean flag = true;
		int prevSum = 0;
		for (char c : num.toCharArray()) {
			int cur = c - '0';
			for (int i = 0; i < cur; i++) {
				if (digit == num.length() && i == 0) continue;

				int kk = flag ? prevSum + i - k : k - prevSum + i;
				cnt += countKWith0[digit][0][-kk+100];
			}
			if (flag) prevSum += cur;
			else prevSum -= cur;
			flag = !flag;
			digit--;
		}
		if (prevSum == k) cnt++;
		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(countByDigit(2, 1));
		System.out.println(countByDigit(2, -1));
		System.out.println(countByUpper(110, 0));
		System.out.println(countByUpper(120, 0));
	}
}
