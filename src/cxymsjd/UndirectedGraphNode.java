package cxymsjd;

import java.util.ArrayList;

/**
 * Created by zkf on 4/22/16.
 */
public class UndirectedGraphNode {
    public int label = 0;
    public UndirectedGraphNode left = null;
    public UndirectedGraphNode right = null;
    public ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}
