package indeed._0604.n3;

import java.util.*;

/**
 * Created by Zhangkefei on 2016/6/4.
 */
public class Main {
    static class Vert {
        int id;
        Set<Vert> nexts = new HashSet<>();
    }
    static Map<Vert, Integer> distMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt(), q = scanner.nextInt();
        Vert[] g = new Vert[v];
        for (int i = v-1; i >= 0; i--) {
            g[i] = new Vert();
            g[i].id = i;
            if (i != v-1)
                g[i].nexts.add(g[i+1]);
        }
        for (int i = 0; i < q; i++) {
            int from = scanner.nextInt(), to = scanner.nextInt();
            System.out.println(queryAndAdd(g[from-1], g[to-1]));
        }
    }

    private static int queryAndAdd(Vert from, Vert to) {
        distMap.clear();
        distMap.put(from, 0);
        Queue<Vert> toVisit = new LinkedList<>();
        toVisit.add(from);
        while (!toVisit.isEmpty()) {
            Vert cur = toVisit.poll();
            Integer nl = distMap.get(cur) + 1;
            for (Vert n : cur.nexts) {
                if (distMap.containsKey(n)) continue;
                if (n == to) {
                    from.nexts.add(to);
                    return nl;
                }

                distMap.put(n, nl);
                toVisit.add(n);
            }
        }

        from.nexts.add(to);
        return -1;
    }
}
