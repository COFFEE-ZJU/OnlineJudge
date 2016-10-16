package google.codejam.no5264486;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import google.codejam.CodejamUtils;

public class MainC {
    private static class Word {
        private String word;
        private int[] cnts;
        private int diffChar;

        private int[] rems;
        private int remDiffChar;
        Word(String word) {
            this.word = word;
            cnts = new int[26];
            rems = new int[26];
            diffChar = 0;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (cnts[idx]++ == 0) diffChar++;
            }
        }

        @Override
        public String toString() {
            return "Word{" +
                    "word='" + word + '\'' +
                    ", diffChar=" + diffChar +
                    ", remDiffChar=" + remDiffChar +
                    '}';
        }

        void reset() {
            System.arraycopy(cnts, 0, rems, 0, 26);
            remDiffChar = diffChar;
        }

        int addChar(char c) {
            if (remDiffChar <= 0) return -1;
            int idx = c - 'a';
            int res = --rems[idx];
            if (res < 0) {
                remDiffChar = -1;
            } else if (res == 0) {
                remDiffChar--;
            }

            return remDiffChar;
        }
    }
	public static void main(String[] args) throws IOException {
	    String fileName = "C-large-practice";
        Scanner scanner = CodejamUtils.getScanner(fileName, MainC.class);
		Writer writer = CodejamUtils.getWriter(fileName, MainC.class);

		int t = Integer.parseInt(scanner.nextLine());
		for(int tt = 0; tt < t; tt++){
            int v = scanner.nextInt();
            int s = scanner.nextInt();
            Word[] words = new Word[v];
            for (int i = 0; i < v; i++) {
                words[i] = new Word(scanner.next());
            }

            StringBuilder sb = new StringBuilder(String.format("Case #%d:", tt+1));
            for (int i = 0; i < s; i++) {
                String str = scanner.next();
                int len = str.length();
                long[] dp = new long[len+1];
                dp[0] = 1;
                for (int st = 1; st <= len; st++) {
                    if (dp[st-1] == 0) continue;
                    for (Word w : words) w.reset();

                    int candCnt = v;
                    for (int j = st; j <= len && candCnt > 0; j++) {
                        char c = str.charAt(j-1);
                        for (Word w : words) {
                            if (w.remDiffChar <= 0) continue;
                            int res = w.addChar(c);
                            if (res <= 0) candCnt--;
                            if (res == 0) dp[j] = (dp[j] + dp[st-1]) % 1000000007;
                        }
                    }
                }
                sb.append(' ').append(dp[len]);
            }
            writer.write(sb.append('\n').toString());
        }
		
		scanner.close();
		writer.close();

	}
}
