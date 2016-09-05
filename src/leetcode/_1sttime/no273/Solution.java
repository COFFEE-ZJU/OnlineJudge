package leetcode._1sttime.no273;

public class Solution {
    private static final String[] postfix = new String[]{"", "Thousand ", "Million ", "Billion "};
    private static final String[] ones = new String[]{"", "One ", "Two ", "Three ",
            "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    private static final String[] teens = new String[]{"Ten ", "Eleven ", "Twelve ",
            "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    private static final String[] tens = new String[]{"", "", "Twenty ", "Thirty ", "Forty ",
            "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int postIdx = 0;
        long cut = 1;
        StringBuilder sb = new StringBuilder();
        while (num / cut != 0){
            int cur = (int)((long)num % (cut * 1000) / cut);
            if (cur != 0)
                sb.insert(0, postfix[postIdx]);
            int tt = cur % 100;
            if (tt >= 10 && tt <= 19){
                sb.insert(0, teens[tt-10]);
            }
            else {
                sb.insert(0, ones[tt%10]);
                sb.insert(0, tens[tt/10]);
            }
            if (cur / 100 != 0) {
                sb.insert(0, "Hundred ");
                sb.insert(0, ones[cur / 100]);
            }

            postIdx++;
            cut *= 1000;
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.numberToWords(123456));
        System.out.println(sol.numberToWords(103450));
        System.out.println(sol.numberToWords(1234567891));
    }
}
