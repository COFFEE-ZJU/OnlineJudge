package leetcode.no006;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int len = s.length(), prd = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; ; i+=prd) {
            if (i >= len) break;
            sb.append(s.charAt(i));
        }
        for (int i = 1; i < numRows-1; i++) {
            for (int j = 0; ;j += prd) {
                if (j + i >= len) break;
                sb.append(s.charAt(j+i));
                if (j + prd - i >= len) break;
                sb.append(s.charAt(j + prd - i));
            }
        }
        for (int i = 0; ; i+=prd) {
            if (i+numRows-1 >= len) break;
            sb.append(s.charAt(i+numRows-1));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.convert("paypalishiring", 3));
    }
}
