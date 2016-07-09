package google.codejam.no5254486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainB {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner("B-large", MainB.class);
		Writer writer = CodejamUtils.getWriter("B-large", MainB.class);

		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[][] cands = new int[4][n];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < n; j++) {
					cands[i][j] = scanner.nextInt();
				}
			}


			writer.write(String.format("Case #%d: %d\n", tt+1, calc(cands, n, k)));
		}
		
		scanner.close();
		writer.close();

	}

	private static Map<Integer, Integer> countMap1 = new HashMap<>(),
			countMap2 = new HashMap<>();
	private static int calc(int[][] cands, int n, int target) {

		countMap1.clear();
		countMap1.put(target, 1);
		for (int i = 0; i < 4; i++) {
			countMap2.clear();
			for (int j = 0; j < n; j++) {
				for (Map.Entry<Integer, Integer> ent : countMap1.entrySet()) {
					int cur = ent.getKey() ^ cands[i][j];
					int cnt = countMap2.getOrDefault(cur, 0);
					countMap2.put(cur, cnt+ent.getValue());
				}
			}
			Map<Integer, Integer> tmp = countMap1;
			countMap1 = countMap2;
			countMap2 = tmp;
		}
		return countMap1.getOrDefault(0, 0);
	}
}
