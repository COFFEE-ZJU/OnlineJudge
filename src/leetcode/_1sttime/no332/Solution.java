package leetcode._1sttime.no332;

import java.util.*;

public class Solution {
    int len;
    private Map<String, List<String>> adjMap = new HashMap<>();

    private List<String> res;
    public List<String> findItinerary(String[][] tickets) {
        len = tickets.length;
        adjMap.clear();
        for (String[] t : tickets) {
            String from = t[0], to = t[1];
            List<String> list = adjMap.get(from);
            if (list == null) {
                list = new ArrayList<>();
                adjMap.put(from, list);
            }
            list.add(to);
        }
        for (List<String> val : adjMap.values())
            Collections.sort(val);

        res = new LinkedList<>();
        res.add("JFK");
        goRec("JFK", 0);

        return res;
    }

    private boolean goRec(String from, int curLen) {
        if (curLen == len) return true;

        List<String> adjs = adjMap.get(from);
        if (adjs == null) return false;

        String prev = null;
        for (int i = 0; i < adjs.size(); i++) {
            String cand = adjs.get(i);
            if (cand == null || cand.equals(prev)) continue;
            res.add(cand);
            adjs.set(i, null);

            if (goRec(cand, curLen+1))
                return true;

            adjs.set(i, cand);
            res.remove(res.size()-1);
            prev = cand;
        }

        return false;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.findItinerary(new String[][]{
                new String[]{"MUC", "LHR"},
                new String[]{"JFK", "MUC"},
                new String[]{"SFO", "SJC"},
                new String[]{"LHR", "SFO"},
        }));

        System.out.println(sol.findItinerary(new String[][]{
                new String[]{"EZE","TIA"},
                new String[]{"EZE","AXA"},
                new String[]{"AUA","EZE"},
                new String[]{"EZE","JFK"},
                new String[]{"JFK","ANU"},
                new String[]{"JFK","ANU"},
                new String[]{"AXA","TIA"},
                new String[]{"JFK","AUA"},
                new String[]{"TIA","JFK"},
                new String[]{"ANU","EZE"},
                new String[]{"ANU","EZE"},
                new String[]{"TIA","AUA"},
        }));
    }
}
