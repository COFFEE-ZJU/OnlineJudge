package cn.edu.zju.coffee.no012;

public class Solution {
	private String intToRomanSingle(int num, int pos){
		String[][] strs = new String[][]{
				new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
				new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
				new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
				new String[]{"", "M", "MM", "MMM", "", "", "", "", "", ""},
			};
		return strs[pos][num];
	}
	
    public String intToRoman(int num) {
        int k = num / 1000;
        int h = num / 100 % 10;
        int t = num / 10 % 10;
        int s = num % 10;
        
        return intToRomanSingle(k, 3) + intToRomanSingle(h, 2) + intToRomanSingle(t, 1) + intToRomanSingle(s, 0);
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().intToRoman(1984));
	}
}