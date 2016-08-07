package hiho.hihointerview16.n3;

import java.util.*;

/**
 *
 * @author zkf
 *
 */

public class Main {
	private static class Position {
		int startCol, endCol, incLines, occurTime, occurLine;
	}

	private long n,m;
	private String[] words;
	List<Position> posList = new ArrayList<>();
	Map<Integer, Position> posMap = new HashMap<>();
	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				String[] nm = scanner.nextLine().split(" ");
				n = Long.parseLong(nm[0]);
				m = Long.parseLong(nm[1]);
				String line = scanner.nextLine();
				words = line.split(" ");

				posList.clear();
				posMap.clear();
				long curCol = -1, curLine = 0;
				for (int i = 0; i < n; i++) {
					for (String w : words) {
						curCol++;
						if (curCol > m) {
							curLine++;
							curCol -= m;
						}
						if (m - curCol < w.length()) {
							curCol = 0;
							curLine++;
						}
						curCol += w.length();
					}
				}

				System.out.println(curLine+1 + " " + curCol);

//				while (true) {
//					Position pos;
//					if ((pos = posMap.get(curCol)) != null) {
//						long linePeriod = curLine - pos.occurLine;
//						long timePeriod = curTime = pos.occurTime;
//						long pTimes = (n - curTime) / timePeriod;
//						long remTimes = (n - curTime) % timePeriod;
//						Position lastPos =
//						long remLines = posList.get((int)(pos.occurTime + remTimes)).occurLine - pos.occurLine;
//						long finalLine = curLine + pTimes * linePeriod + remLines;
//
//						break;
//					}
//				}
//
//				posList.add();
			}
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
