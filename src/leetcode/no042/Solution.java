package leetcode.no042;

/**
 * Created by Zhangkefei on 2016/1/6.
 */
public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2)
            return 0;

        int len = height.length;
        int max, curMax, ocp, prevMax, cut = 0;
        max = curMax = prevMax = ocp = height[0];
        for (int i = 1; i < len; i++) {
            ocp += height[i];
            if (height[i] > curMax){
                prevMax = curMax;
                curMax = height[i];
                cut += (i - 0) * (curMax - prevMax);
                if (height[i] > max)
                    max = height[i];
            }
        }

        curMax = prevMax = height[len-1];
        for (int i = len-2; i >=0 ; i--) {
            if (height[i] > curMax){
                prevMax = curMax;
                curMax = height[i];
                cut += (len - 1 - i) * (curMax - prevMax);
            }
        }

        return max * len - ocp - cut;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{2,0,2}));
    }
}
