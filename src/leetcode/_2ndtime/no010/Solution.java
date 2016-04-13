package leetcode._2ndtime.no010;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public boolean isMatch(String s, String p) {
		int slen = s.length(), plen = p.length();
		List<Character> pat = new ArrayList<>(plen);
		List<Boolean> pstar = new ArrayList<>(plen);
		for (int i = 0; i < plen; i++) {
			pat.add(p.charAt(i));
			if (i+1 < plen && p.charAt(i+1) == '*') {
				i++;
				pstar.add(true);
			}
			else
				pstar.add(false);
		}

		plen = pat.size();

		boolean[][] dp = new boolean[plen+1][slen+1];
		dp[0][0] = true;
		for (int i = 1; i <= plen; i++) {
			boolean star = pstar.get(i-1);
			char pc = pat.get(i-1);
			dp[i][0] = star && dp[i-1][0];
			for (int j = 1; j <= slen; j++) {
				char sc = s.charAt(j-1);
				if (star)
					dp[i][j] = dp[i-1][j] || ((pc == sc || pc == '.') && dp[i][j-1]);
				else
					dp[i][j] = (pc == sc || pc == '.') && dp[i-1][j-1];
			}
		}

		return dp[plen][slen];
	}
}