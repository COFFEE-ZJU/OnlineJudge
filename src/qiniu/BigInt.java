package qiniu;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zkf on 4/15/16.
 */
public class BigInt {
    private static final int MAX_PER_INT = 10000;
    private boolean neg = false;
    private List<Integer> vals;

    public static BigInt newBigInt(long val) {
        BigInt bi = new BigInt();

        bi.neg = val < 0;
        val = (val < 0 ? -val : val);
        if (val < MAX_PER_INT) {
            bi.vals = Collections.singletonList((int)val);
        }
        else {
            bi.vals = new ArrayList<>();
            do {
                bi.vals.add((int) (val % MAX_PER_INT));
                val /= MAX_PER_INT;
            } while (val != 0);
        }

        return bi;
    }

    private static void addUp(int[] nums, int pos, int add) {
        nums[pos] += add;
        int carry = nums[pos] / MAX_PER_INT;
        nums[pos] %= MAX_PER_INT;
        while (carry != 0) {
            pos++;
            nums[pos] += carry;
            carry = nums[pos] / MAX_PER_INT;
            nums[pos] %= MAX_PER_INT;
        }
    }

    public static BigInt multiply(BigInt a, BigInt b) {
        int[] res = new int[a.vals.size() + b.vals.size()];

        for (int i = 0; i < a.vals.size(); i++) {
            for (int j = 0; j < b.vals.size(); j++) {
                int tmpRes = a.vals.get(i) * b.vals.get(j);
                addUp(res, i+j, tmpRes);
            }
        }

        int end = 0;
        for (int i = res.length-1; i >= 0; i--) {
            if (res[i] != 0) {
                end = i;
                break;
            }
        }

        BigInt bi = new BigInt();
        bi.vals = new ArrayList<>();
        for (int i = 0; i <= end; i++) {
            bi.vals.add(res[i]);
        }

        bi.neg = a.neg ^ b.neg;
        return bi;
    }

    @Override
    public String toString() {
        if (vals == null || vals.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        if (neg) sb.append('-');
        sb.append(vals.get(vals.size()-1));
        for (int i = vals.size()-2; i >= 0; i--) {
            sb.append(String.format("%04d", vals.get(i)));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        long a = 10, b = -9892381;

        BigInt bi = BigInt.newBigInt(a);
        System.out.println(bi);
        System.out.println(BigInt.multiply(bi, bi));

        BigInt bi2 = BigInt.newBigInt(b);
        System.out.println(bi2);
        System.out.println(BigInt.multiply(bi2, bi));

        System.out.println(BigInteger.valueOf(a).multiply(BigInteger.valueOf(a)));
        System.out.println(BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)));
    }
}
