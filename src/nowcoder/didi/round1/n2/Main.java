package nowcoder.didi.round1.n2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Zhangkefei on 2016/9/6.
 */
public class Main {
    private static class Client implements Comparable<Client>{
        final int num, price;

        private Client(int num, int price) {
            this.num = num;
            this.price = price;
        }

        @Override
        public int compareTo(Client o) {
            return Integer.compare(o.price, price);
        }
    }

    private static class Table implements Comparable<Table>{
        private static int idGen = 0;
        int num, id;

        private Table(int num) {
            this.num = num;
            this.id = idGen++;
        }
        private Table(int num, int id) {
            this.num = num;
            this.id = id;
        }

        @Override
        public int compareTo(Table o) {
            int res = Integer.compare(num, o.num);
            if (res == 0) return Integer.compare(id, o.id);
            return res;
        }
    }

    private int m, n;
    private SortedSet<Table> tables = new TreeSet<>();
    private Client[] clients;

    private void deal() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            tables.clear();
            for (int i = 0; i < n; i++) {
                tables.add(new Table(scanner.nextInt()));
            }

            clients = new Client[m];
            for (int i = 0; i < m; i++) {
                clients[i] = new Client(scanner.nextInt(), scanner.nextInt());
            }
            Arrays.sort(clients);

            int income = 0;
            Table compTable = new Table(0, -1);
            for (Client c : clients) {
                compTable.num = c.num;
                SortedSet<Table> res = tables.tailSet(compTable);
                if (!res.isEmpty()) {
                    tables.remove(res.first());
                    income += c.price;
                }
            }

            System.out.println(income);
        }
    }

    public static void main(String[] args) {
        new Main().deal();
    }
}
