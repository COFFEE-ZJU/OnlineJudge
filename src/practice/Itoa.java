package practice;

/**
 * Created by Zhangkefei on 2016/4/17.
 */
public class Itoa {
    private static char getChar(int idx) {
        if (idx >= 0 && idx <= 9) return (char)('0'+idx);

        return (char)('a' + idx - 10);
    }

    private StringBuilder sb = new StringBuilder();
    public String itoa(int n, int base) {
        sb.setLength(0);
        boolean isNeg = n < 0;
        if (isNeg) n = -n;
        do {
            sb.append(getChar(n % base));
            n /= base;
        } while (n != 0);
        if (isNeg) sb.append('-');
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Itoa itoa = new Itoa();
        System.out.println(itoa.itoa(123, 10));
        System.out.println(itoa.itoa(-123, 10));
        System.out.println(itoa.itoa(-123, 16));
        System.out.println(itoa.itoa(-3, 2));
        System.out.println(itoa.itoa(0, 2));
    }
}
