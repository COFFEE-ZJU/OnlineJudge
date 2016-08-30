package google.codejam.no5254487;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import google.codejam.CodejamUtils;

public class MainA {
	
	public static void main(String[] args) throws IOException {
	    String fileName = "A-large-practice";
		Scanner scanner = CodejamUtils.getScanner(fileName, MainA.class);
		Writer writer = CodejamUtils.getWriter(fileName, MainA.class);

		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
            long min = Math.min(scanner.nextInt(), scanner.nextInt());
            writer.write(String.format("Case #%d: %s\n", tt+1, min*(min+1)/2));
		}
		
		scanner.close();
		writer.close();

	}

}
