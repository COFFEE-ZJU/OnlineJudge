package indeed._0709.n3;

import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/7/2.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        System.out.println(line.replace(',','\n'));

        scanner.close();
    }
}
