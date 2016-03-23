package leetcode.no220;

import java.util.TreeMap;

public class Solution {
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k <= 0 || t < 0)
            return false;

        map.clear();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (Integer fnum;;){
                fnum = map.floorKey(num);
                if (fnum == null)
                    break;
                if (i-map.get(fnum) > k){
                    map.remove(fnum);
                    continue;
                }
                if ((long)num-(long)fnum <= t)
                    return true;
                else
                    break;
            }
            for (Integer cnum;;){
                cnum = map.ceilingKey(num);
                if (cnum == null)
                    break;
                if (i-map.get(cnum) > k){
                    map.remove(cnum);
                    continue;
                }
                if ((long)cnum-(long)num <= t)
                    return true;
                else
                    break;
            }

            map.put(num, i);
        }

        return false;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.containsNearbyAlmostDuplicate(new int[]{-3,3},2,4));
    }
}
