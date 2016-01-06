package cn.edu.zju.coffee.leetcode.no043;

import java.math.BigInteger;

/**
 * Created by Zhangkefei on 2016/1/6.
 */
public class SolutionCheatWithBigInteger {
    public String multiply(String num1, String num2) {
        BigInteger n1 = new BigInteger(num1), n2 = new BigInteger(num2);
        return n1.multiply(n2).toString();
    }

    public static void main(String[] args) {
        System.out.println(new SolutionCheatWithBigInteger().multiply("123","123567"));
    }
}
