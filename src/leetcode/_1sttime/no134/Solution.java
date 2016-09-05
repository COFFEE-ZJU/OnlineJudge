package leetcode._1sttime.no134;

public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length != cost.length || gas.length == 0)
			return -1;

		int len = gas.length;
		int start = 0;
		while (true){
			int cur = start;
			int amt = 0;
			boolean can = true;
			do {
				amt += gas[cur];
				amt -= cost[cur];
				if (amt < 0){
					can = false;
					break;
				}

				cur++;
				if (cur == len) cur = 0;
			} while (cur != start);
			if (can)
				return start;

			cur++;
			if (cur == len) cur = 0;
			if (cur <= start)
				return -1;
			start = cur;
		}
	}

    
    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.canCompleteCircuit(new int[]{1,2,3},new int[]{1,2,3}));
		System.out.println(sol.canCompleteCircuit(new int[]{1,2,3},new int[]{1,2,4}));
		System.out.println(sol.canCompleteCircuit(new int[]{0,2,5},new int[]{1,2,4}));
		System.out.println(sol.canCompleteCircuit(new int[]{0,1,6},new int[]{1,2,4}));
	}
}