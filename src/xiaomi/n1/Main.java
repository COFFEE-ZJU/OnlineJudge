package xiaomi.n1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static final int[] realNum = new int[]{2,3,4,5,6,7,8,9,0,1};
	private int[] alphaCnt = new int[26];
	private int[] digitCnt = new int[10];
	private String word;
	StringBuilder sb = new StringBuilder();
	private void deal() {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextInt()) {
			int t = scanner.nextInt();
			for (int tt = 0; tt < t; tt++) {
				word = scanner.next();
				Arrays.fill(alphaCnt, 0);
				Arrays.fill(digitCnt, 0);
				for (int i = 0; i < word.length(); i++) {
					alphaCnt[word.charAt(i) - 'A']++;
				}

				countDigits();
				sb.setLength(0);
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < digitCnt[i]; j++) {
						sb.append(i);
					}
				}
				System.out.println(sb.toString());
			}
		}
	}

	private void countDigits() {
		int num = realNum[6];
		int cnt = alphaCnt['X'-'A'];
		digitCnt[num] = cnt;
		decWord("SIX", cnt);

		num = realNum[0];
		cnt = alphaCnt['Z'-'A'];
		digitCnt[num] = cnt;
		decWord("ZERO", cnt);

		num = realNum[8];
		cnt = alphaCnt['G'-'A'];
		digitCnt[num] = cnt;
		decWord("EIGHT", cnt);

		num = realNum[3];
		cnt = alphaCnt['H'-'A'];
		digitCnt[num] = cnt;
		decWord("THREE", cnt);

		num = realNum[4];
		cnt = alphaCnt['R'-'A'];
		digitCnt[num] = cnt;
		decWord("FOUR", cnt);

		num = realNum[5];
		cnt = alphaCnt['F'-'A'];
		digitCnt[num] = cnt;
		decWord("FIVE", cnt);

		num = realNum[7];
		cnt = alphaCnt['V'-'A'];
		digitCnt[num] = cnt;
		decWord("SEVEN", cnt);

		num = realNum[9];
		cnt = alphaCnt['I'-'A'];
		digitCnt[num] = cnt;
		decWord("NINE", cnt);

		num = realNum[2];
		cnt = alphaCnt['W'-'A'];
		digitCnt[num] = cnt;
		decWord("TWO", cnt);

		num = realNum[1];
		cnt = alphaCnt['O'-'A'];
		digitCnt[num] = cnt;
		decWord("ONE", cnt);
	}

	private void decWord(String w, int cnt) {
		for (int i = 0; i < w.length(); i++) {
			alphaCnt[w.charAt(i) - 'A'] -= cnt;
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
