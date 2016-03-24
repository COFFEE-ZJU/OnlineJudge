package google.codejam.no6234486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * Created by zkf on 3/24/16.
 */
public class MainC {
	public static final String fileName = "C-small-practice-2";

	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner(fileName, MainC.class);
		Writer writer = CodejamUtils.getWriter(fileName, MainC.class);

		int r = scanner.nextInt();
		for(int rr=0; rr<r; rr++){
			int n = scanner.nextInt();
			scanner.nextLine();
			String[] names = new String[n];
			for (int i = 0; i < n; i++) {
				names[i] = scanner.nextLine();
			}
			String max = names[0];
			int cost = 0;
			for (int i = 1; i < names.length; i++) {
				int res = max.compareTo(names[i]);
				if (res == 0) continue;

				if (res > 0)
					cost++;
				else
					max = names[i];
			}

			writer.write(format(rr, cost));
		}

		writer.close();
		scanner.close();
	}
	
	private static String format(int caseNo, int d){
		return String.format("Case #%d: %d\n", caseNo+1, d);
	}
}
