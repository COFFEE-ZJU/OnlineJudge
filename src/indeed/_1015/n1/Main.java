package indeed._1015.n1;

import java.util.Scanner;

public class Main {
    private void deal() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            System.out.println(line.replace("ra", ""));
        }
    }

    public static void main(String[] args) {
        new Main().deal();
    }
}
