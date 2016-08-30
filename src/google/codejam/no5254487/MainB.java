package google.codejam.no5254487;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import google.codejam.CodejamUtils;

public class MainB {
    private static final int MOD = 1000000007;
    private int a,b,k;
    private long n;

	public void deal(Scanner scanner, Writer writer) throws IOException {

		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
            a = scanner.nextInt();
            b = scanner.nextInt();
            n = scanner.nextLong();
            k = scanner.nextInt();

            int res = solve();

            writer.write(String.format("Case #%d: %s\n", tt+1, res));
		}
	}

    private Map<Integer, Long> iCountByRem = new HashMap<>();
    private Map<Integer, Long> jCountByRem = new HashMap<>();

    private int solve() {
        iCountByRem.clear();
        jCountByRem.clear();
        long baseCount = n / k;
        long board = n % k;
        long totalCollision = 0;
        for (int i = 0; i < k; i++) {
            long cnt = i == 0 || i > board ? baseCount : baseCount + 1;
            if (cnt == 0) continue;
            int remA = getRem(i, a);
            int remB = getRem(i, b);

            if ((remA + remB) % k == 0) {
                totalCollision += cnt;
                totalCollision %= MOD;
            }
            addCount(iCountByRem, remA, cnt);
            addCount(jCountByRem, remB, cnt);
        }

        long totalCnt = (MOD - totalCollision) % MOD;
        for (Map.Entry<Integer, Long> entry : iCountByRem.entrySet()) {
            int remA = entry.getKey();
            long cntA = entry.getValue();
            int remB = remA == 0 ? 0 : k - remA;
            Long cntB = jCountByRem.get(remB);
            if (cntB != null) {
                totalCnt += cntA * cntB;
                totalCnt %= MOD;
            }
        }
        return (int)totalCnt;
    }

    private int getRem(int base, int exp) {
        if (k == 1) return 0;
        long finalRem = 1;
        long curExp = 1, curRem = base;
        while (curExp <= exp) {
            if ((curExp & exp) != 0) {
                finalRem = finalRem * curRem % k;
                if (finalRem == 0) return 0;
            }
            curExp <<= 1;
            curRem = curRem * curRem % k;
        }
        return (int)finalRem;
    }

    private void addCount(Map<Integer, Long> countByRem, int rem, long cnt) {
        Long val = countByRem.get(rem);
        if (val == null) {
            val = cnt;
        } else {
            val += cnt;
        }
        val %= MOD;
        countByRem.put(rem, val);
    }

    public static void main(String[] args) throws IOException {
        String fileName = "B-large-practice";
        Scanner scanner = CodejamUtils.getScanner(fileName, MainB.class);
        Writer writer = CodejamUtils.getWriter(fileName, MainB.class);

        new MainB().deal(scanner, writer);

        scanner.close();
        writer.close();
    }
}
