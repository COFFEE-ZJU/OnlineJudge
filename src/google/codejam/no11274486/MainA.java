package google.codejam.no11274486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class MainA {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner("A-large", MainA.class);
		Writer writer = CodejamUtils.getWriter("A-large", MainA.class);

		int t = Integer.parseInt(scanner.nextLine());
		for(int tt = 0; tt < t; tt++){
			int n = Integer.parseInt(scanner.nextLine());
            Name king = null;
            for (int i = 0; i < n; i++) {
                Name cur = new Name(scanner.nextLine());
                if (king == null || cur.compareTo(king) < 0)
                    king = cur;
            }
            writer.write(String.format("Case #%d: %s\n", tt+1, king.name));
		}
		
		scanner.close();
		writer.close();

	}

	private static class Name implements Comparable<Name>{
        static boolean[] occur = new boolean[26];
        final String name;
        final String stripName;
        int diffNum;

        private Name(String name) {
            this.name = name;
            this.stripName = name.replace(" ", "");
            Arrays.fill(occur, false);
            diffNum = 0;
            for (int i = 0; i < stripName.length(); i++) {
                int idx = stripName.charAt(i) - 'A';
                if (!occur[idx])
                    diffNum++;
                occur[idx] = true;
            }
        }

        @Override
        public int compareTo(Name o) {
            if (diffNum == o.diffNum)
                return stripName.compareTo(o.stripName);
            else
                return Integer.compare(o.diffNum, diffNum);
        }
    }
}
