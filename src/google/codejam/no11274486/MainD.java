package google.codejam.no11274486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class MainD {
    private static double err = 0.0000000001;
    static int m, n, max;

	
	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner("D-small", MainD.class);
		Writer writer = CodejamUtils.getWriter("D-small ", MainD.class);

		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
            m = scanner.nextInt();
            n = scanner.nextInt();
            Card[] cards = new Card[n];
            for (int nn = 0; nn < n; nn++) {
                int maxL = scanner.nextInt(), curL = scanner.nextInt();
                int[] atta = new int[maxL], costs = new int[maxL];
                for (int i = 0; i < maxL; i++) {
                    atta[i] = scanner.nextInt();
                }
                for (int i = 0; i < maxL - 1; i++) {
                    costs[i+1] = scanner.nextInt();
                }
                cards[nn] = new Card(curL-1, maxL-1, atta, costs);
            }

            max = 0;
            combAndCalc(cards, new Card[8], 0, 0);
            writer.write(String.format("Case #%d: %d\n", tt+1, max));
		}
		
		scanner.close();
		writer.close();

	}

    private static void combAndCalc(Card[] cards, Card[] card8, int idx, int idx8) {
        if (idx8 == 8) {
            max = Math.max(max, maxAttack(card8));
            return;
        }
        if (n - idx == 8 - idx8) {
            System.arraycopy(cards, idx, card8, idx8, n-idx);
            max = Math.max(max, maxAttack(card8));
            return;
        }

        card8[idx8] = cards[idx];
        combAndCalc(cards, card8, idx+1, idx8+1);
        combAndCalc(cards, card8, idx+1, idx8);
    }

    private static int maxAttack(Card[] cards) {
        int n = cards.length;
        int[] dp = new int[m+1], dpPrev = new int[m+1];
        for (int i = 0; i < n; i++) {
            Card card = cards[i];
            int[] tmp = dp;
            dp = dpPrev; dpPrev = tmp;
            for (int j = 0; j <= m; j++) {
                for (int k = card.curLevel; k <= card.maxLevel; k++) {
                    int c = card.costs[k];
                    if (c > j) break;
                    dp[j] = Math.max(dp[j], dpPrev[j-c] + card.attacks[k]);
                }
            }
        }

        return dp[m];
    }

    private static class Card {
        final int curLevel, maxLevel;
        final int[] attacks, costs;

        private Card(int curLevel, int maxLevel, int[] attacks, int[] costs) {
            this.curLevel = curLevel;
            this.maxLevel = maxLevel;
            this.attacks = attacks;
            this.costs = costs;
            costs[curLevel] = 0;
            for (int i = curLevel+1; i <= maxLevel; i++) {
                costs[i] += costs[i-1];
            }
        }
    }

}
