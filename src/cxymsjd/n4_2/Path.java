package cxymsjd.n4_2;

import cxymsjd.UndirectedGraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Whiteboard coding!
 * From nowcoder.com
 * Created by zkf on 4/22/16.
 */
public class Path {
    private Set<UndirectedGraphNode> seen = new HashSet<>();
    private List<UndirectedGraphNode> toVisit = new LinkedList<>();
    public boolean checkPathOneDir(UndirectedGraphNode a, UndirectedGraphNode b) {
        // write code here
        seen.clear();
        toVisit.clear();
        toVisit.add(a);
        seen.add(a);
        while (!toVisit.isEmpty()) {
            UndirectedGraphNode node = toVisit.remove(0);
            if (node == b) return true;

            for (UndirectedGraphNode nn : node.neighbors) {
                if (seen.contains(nn))
                    continue;

                seen.add(nn);
                toVisit.add(nn);
            }
        }

        return false;
    }

    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        return checkPathOneDir(a, b) || checkPathOneDir(b, a);
    }
}
