package cn.edu.zju.coffee.leetcode.no126and127;

import java.util.*;

public class Solution {
    private Node[] nodes;
    private Map<String, Node> map = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null)
            return Collections.emptyList();
        if (beginWord.equals(endWord))
            return Collections.singletonList(Collections.singletonList(beginWord));

        wordList.remove(beginWord);
        wordList.remove(endWord);
        nodes = new Node[wordList.size() + 2];
        map.clear();
        int i = 0;
        nodes[i] = new Node(i++, beginWord);
        nodes[i] = new Node(i++, endWord);
        map.put(beginWord, nodes[0]);
        map.put(endWord, nodes[1]);
        for (String word : wordList) {
            nodes[i] = new Node(i, word);
            map.put(word, nodes[i]);
            i++;
        }

        for (Node node : nodes)
            setAdjs(node);

        List<Node>[] prevList = new List[nodes.length];
        int[] lens = new int[nodes.length];
        for (int j = 1; j < lens.length; j++)
            lens[j] = Integer.MAX_VALUE;
        prevList[0] = new LinkedList<>();

        List<Node> frontier = new ArrayList<>(nodes.length);
        List<Node> tmpSet = new ArrayList<>(nodes.length);
        frontier.add(nodes[0]);
        while (!frontier.isEmpty()){
            tmpSet.clear();
            for (Node node : frontier){
                if (node.idx == 1)
                    return genPath(prevList, 1);

                int ni = node.idx;
                for (Node adj : node.adjs) {
                    int ai = adj.idx;
                    if (lens[ai] < lens[ni] + 1)
                        continue;

                    lens[ai] = lens[ni] + 1;
                    if (prevList[ai] ==  null)
                        prevList[ai] = new LinkedList<>();

                    prevList[ai].add(node);

                    tmpSet.add(adj);
                }
            }
            List<Node> tmp = tmpSet;
            tmpSet = frontier;
            frontier = tmp;
        }

        return Collections.emptyList();
    }

    private List<List<String>> genPath(List<Node>[] prevList, int pos){
        List<List<String>> retList = new LinkedList<>();
        if (prevList[pos].isEmpty()){
            List<String> tmp = new LinkedList<>();
            tmp.add(nodes[pos].word);
            retList.add(tmp);
            return retList;
        }

        for (Node prev : prevList[pos])
            retList.addAll(genPath(prevList, prev.idx));

        for (List<String> l : retList)
            l.add(nodes[pos].word);
        return retList;
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null)
            return 0;
        if (beginWord.equals(endWord))
            return 1;

        wordList.remove(beginWord);
        wordList.remove(endWord);
        nodes = new Node[wordList.size() + 2];
        map.clear();
        int i = 0;
        nodes[i] = new Node(i++, beginWord);
        nodes[i] = new Node(i++, endWord);
        map.put(beginWord, nodes[0]);
        map.put(endWord, nodes[1]);
        for (String word : wordList) {
            nodes[i] = new Node(i, word);
            map.put(word, nodes[i]);
            i++;
        }

        for (Node node : nodes)
            setAdjs(node);

        int[] lens = new int[nodes.length];
        for (int j = 1; j < lens.length; j++)
            lens[j] = Integer.MAX_VALUE;

        List<Node> frontier = new ArrayList<>(nodes.length);
        List<Node> tmpSet = new ArrayList<>(nodes.length);
        frontier.add(nodes[0]);
        while (!frontier.isEmpty()){
            tmpSet.clear();
            for (Node node : frontier){
                for (Node adj : node.adjs) {
                    if (lens[adj.idx] != Integer.MAX_VALUE)
                        continue;
                    lens[adj.idx] = lens[node.idx] + 1;
                    if (adj.idx == 1)
                        return lens[1] + 1;
                    tmpSet.add(adj);
                }
            }
            List<Node> tmp = tmpSet;
            tmpSet = frontier;
            frontier = tmp;
        }

        return 0;
    }

    private void setAdjs(Node node){
        StringBuilder sb = new StringBuilder(node.word);
        for (int i = 0; i < sb.length(); i++) {
            char ori = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (ori == c)
                    continue;

                sb.setCharAt(i, c);
                Node n = map.get(sb.toString());
                if (n != null)
                    node.adjs.add(n);
            }
            sb.setCharAt(i, ori);
        }
    }

    private class Node {
        final int idx;
        final String word;
        List<Node> adjs = new LinkedList<>();
        int len = Integer.MAX_VALUE;

        private Node(int idx, String word) {
            this.idx = idx;
            this.word = word;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Set<String> set = new HashSet<>();
        String[] ws = new String[]{"hot","dot","dog","lot","log"};
        for (String w : ws)
            set.add(w);

        System.out.println(sol.ladderLength("hit", "cog", set));
        System.out.println(sol.findLadders("hit", "cog", set));

    }
}