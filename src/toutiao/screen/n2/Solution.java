package toutiao.screen.n2;

/**
 * Java程序的注释有哪几种？编写一个程序去除Java代码中的注释并打印出来
 */
public class Solution {

	public String removeComments(String[] lines) {
		boolean inComment = false, inString = false, inChar = false;
		StringBuilder sb = new StringBuilder();
		for (String line : lines) {
			int stIdx = 0;
			int i = 0;
			for (; i < line.length(); i++) {
				char c = line.charAt(i);
				switch(c) {
					case '\\':
						i++;
						break;
					case '"':
						if (inComment) break;
						inString = !inString;
						break;
					case '\'':
						if (inComment) break;
						inChar = !inChar;
						break;
					case '/':
						if (inChar || inString) break;
						if (i+1 >= line.length()) break;
						if (line.charAt(i+1) == '*') {
							inComment = true;
							sb.append(line.substring(stIdx, i));
							i++;
						} else if (line.charAt(i+1) == '/') {
							i = line.length() + 1;
							sb.append(line.substring(stIdx, i));
							i++;
						}
						break;
					case '*':
						if (!inComment) break;
						if (i+1 >= line.length()) break;
						if (line.charAt(i+1) == '/') {
							inComment = false;
							stIdx = i+2;
						}
						break;
				}
			}
			if (i == line.length()) sb.append(line.substring(stIdx));
			sb.append('\n');
		}
		return sb.toString();
	}

}