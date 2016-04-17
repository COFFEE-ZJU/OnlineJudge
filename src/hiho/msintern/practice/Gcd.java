package hiho.msintern.practice;

import java.util.Random;

/**
 * Created by Zhangkefei on 2016/4/17.
 */
public class Gcd {
    public int gcd0(int m, int n) {
        int rem = m % n;
        return (rem == 0) ? n : gcd0(n, rem);
    }

    public int gcd(int m, int n) {
        while (n != 0) {
            int tmp = m % n;
            m = n;
            n = tmp;
        }

        return m;
    }

    public static void main(String[] args) {
        Gcd gcd = new Gcd();
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < 1000; i++) {
            int m = rand.nextInt(), n = rand.nextInt();
            if (gcd.gcd0(m, n) != gcd.gcd(m, n)) {
                System.out.println("something wrong!");
                return;
            }
        }

        System.out.println("random tests passed!");
    }
}
