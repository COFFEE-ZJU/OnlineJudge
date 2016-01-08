package cn.edu.zju.coffee.leetcode.no065;

import java.util.EnumSet;

public class Solution {
	private enum State {NUM, POS_NUM_1, POS_NUM_2, INT, POS_INT_1, POS_INT_2};
	private EnumSet<State> isNum = EnumSet.of(State.POS_INT_2, State.POS_NUM_2);
	private State state;
	private boolean hadE;
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0)
			return false;

		s = s.trim();
		state = State.NUM;
		hadE = false;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			switch (state){
				case NUM:
					if (c == '+' || c == '-')
						state = State.POS_NUM_1;
					else if (c >= '0' && c <= '9')
						state = State.POS_NUM_2;
					else if (c == '.')
						state = State.POS_INT_1;
					else
						return false;
					break;
				case POS_NUM_1:
					if (c >= '0' && c <= '9')
						state = State.POS_NUM_2;
					else if (c == '.')
						state = State.POS_INT_1;
					else
						return false;
					break;
				case POS_NUM_2:
					if (c == '.')
						state = State.POS_INT_2;
					else if (c == 'e' || c == 'E') {
						hadE = true;
						state = State.INT;
					}
					else if (! (c >= '0' && c <= '9'))
						return false;
					break;
				case INT:
					if (c == '+' || c == '-')
						state = State.POS_INT_1;
					else if (c >= '0' && c <= '9')
						state = State.POS_INT_2;
					else
						return false;
					break;
				case POS_INT_1:
					if (c >= '0' && c <= '9')
						state = State.POS_INT_2;
					else
						return false;
					break;
				case POS_INT_2:
					if (c >= '0' && c <= '9')
						state = State.POS_INT_2;
					else if ((c == 'e' || c == 'E') && !hadE){
						hadE = true;
						state = State.INT;
					}
					else
						return false;
					break;
			}
		}

		return isNum.contains(state);
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.isNumber(" 123 "));
		System.out.println(sol.isNumber(" 123.2 "));
		System.out.println(sol.isNumber(" -123.2 "));
		System.out.println(sol.isNumber(" 123.2e10 "));
		System.out.println(sol.isNumber(" 123.2e10e2 "));
		System.out.println(sol.isNumber(" -12.2e10 "));
		System.out.println(sol.isNumber(" -01.2e-10 "));
		System.out.println(sol.isNumber(" 3. "));
		System.out.println(sol.isNumber(" . "));
	}
}