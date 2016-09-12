package tencent.n1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/9/11.
 */
public class Main {
    private static final boolean[] primes=new boolean[1001];

    static {
        Arrays.fill(primes,true);        // assume all integers are prime.
        primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.
        for (int i=2;i<primes.length;i++) {
            //if the number is prime,
            //then go through all its multiples and make their values false.
            if(primes[i]) {
                for (int j=2;i*j<primes.length;j++) {
                    primes[i*j]=false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int cnt = 0;
            for (int i = 2; i <= n / 2; i++) {
                int a = i, b = n - i;
                if (primes[a] && primes[b]) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
