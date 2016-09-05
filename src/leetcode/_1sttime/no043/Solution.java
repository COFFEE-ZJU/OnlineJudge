package leetcode._1sttime.no043;

import java.math.BigInteger;

/**
 *
 * A little bit too slow than using BigInteger...
 *
 * Created by Zhangkefei on 2016/1/6.
 */
public class Solution {
    public String cheatMultiply(String num1, String num2) {
        BigInteger n1 = new BigInteger(num1), n2 = new BigInteger(num2);
        return n1.multiply(n2).toString();
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() ==0 || num2.length() == 0)
            return "0";

        return new MyNum(num1).multiply(new MyNum((num2))).toString();
    }

    private static class MyNum{
        private static final int cutLen = 9;
        private static final long cutNum = (long)Math.pow(10, cutLen);
        long[] nums;

        private MyNum(){}

        MyNum(String str){
            int strLen = str.length();
            int len = strLen / cutLen;
            if (strLen % cutLen != 0) len ++;
            nums = new long[len];
            for (int i = 0; i < len; i++) {
                int end = strLen - i * cutLen;
                int start = (end - cutLen) > 0 ? (end - cutLen) : 0;
                nums[i] = Long.parseLong(str.substring(start, end));
            }
        }

        public MyNum multiply(MyNum other){
            MyNum res = new MyNum();
            int resLen = nums.length + other.nums.length;
            res.nums = new long[resLen];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < other.nums.length; j++) {
                    int idx = i + j;
                    res.nums[idx] += nums[i] * other.nums[j];
                    for (long div = res.nums[idx] / cutNum; div > 0;){
                        res.nums[idx] %= cutNum;
                        idx ++;
                        res.nums[idx] += div;
                        div = res.nums[idx] / cutNum;
                    }
                }
            }

            return res;
        }

        @Override
        public String toString(){
            StringBuffer sb = new StringBuffer();
            int i = 0;
            for (; i < nums.length; i++) {
                sb.insert(0, String.format("%09d", nums[i]));
            }
            while(sb.charAt(0) == '0' && sb.length() > 1)
                sb.deleteCharAt(0);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.cheatMultiply("12345666666789", "123654789"));
        System.out.println(sol.multiply("12345666666789", "123654789"));
        System.out.println(sol.multiply("0", "0"));
        System.out.println(sol.multiply("0", "1"));
        System.out.println(sol.multiply("1", "1"));
    }
}
