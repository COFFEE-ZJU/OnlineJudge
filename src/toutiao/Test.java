package toutiao;

/**
 * Created by Zhangkefei on 2016/9/29.
 */
public class Test {
    private static int[] radix = new int[]{0, 1, 2, 2, 3, 3, 4, 4, 5, 6};

    public void solve(int a, int b) {
        a--; b--;
        char[] as = (""+a).toCharArray();
        char[] bs = (""+b).toCharArray();
        handleDigits(as);
        handleDigits(bs);
        System.out.println(getCnt(bs) - getCnt(as));
    }

    private int getCnt(char[] digits) {
        int cnt = 0;
        for (char c : digits) {
            cnt = cnt * 7 + radix[c-'0'];
        }
        return cnt;
    }

    private void handleDigits(char[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if ("357".indexOf(digits[i]) != -1) {
                digits[i]--;
                i++;
                while (i < digits.length) digits[i++] = '9';
            }
        }
    }

    public static void main(String[] args) {
        new Test().solve(16, 21);
    }
}
