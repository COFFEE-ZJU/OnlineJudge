package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhangkefei on 2016/1/29.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
