package leetcode._1sttime.no041;

/**
 * Created by Zhangkefei on 2016/1/3.
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        swaps(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1){
                return i+1;
            }
        }

        return nums.length + 1;
    }

    private void swaps(int[] nums){
        for (int i = 0; i < nums.length;) {
            int pos = nums[i] - 1;
            if (pos != i && pos >=0 && pos < nums.length && nums[pos] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = tmp;
            }
            else
                i++;
        }

//        for (int i = nums.length - 1; i >= 0; i--) {
//            int pos = nums[i] - 1;
//            if (pos >=0 && pos < nums.length){
//                int tmp = nums[i];
//                nums[i] = nums[pos];
//                nums[pos] = tmp;
//            }
//        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[]{-4,24,32,25,16,-8,3,-5,-6,30,3,3,29,-5,6,-3,1,29,-2,4,4,7,14,20,5,0,25,2,13,26,-9,7,6,33}));
    }
}
