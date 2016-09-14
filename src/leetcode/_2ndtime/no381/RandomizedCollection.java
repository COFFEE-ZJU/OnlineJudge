package leetcode._2ndtime.no381;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Whiteboard coding!
 */
public class RandomizedCollection {
    private Map<Integer, Set<Integer>> posMap = new HashMap<>();
    private List<Integer> valList = new ArrayList<>();
    private Random rand = new Random(System.currentTimeMillis());

    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> set = posMap.get(val);
        boolean res = false;
        if (set == null) {
            set = new HashSet<>();
            posMap.put(val, set);
            res = true;
        }

        set.add(valList.size());
        valList.add(val);
        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> set = posMap.get(val);
        if (set == null || set.isEmpty()) return false;

        int swPos = valList.size()-1;
        int swVal = valList.remove(swPos);

        if (swVal == val) {
            set.remove(swPos);
            return true;
        }

        int anyPos = set.iterator().next();
        set.remove(anyPos);

        valList.set(anyPos, swVal);

        Set<Integer> swSet = posMap.get(swVal);
        swSet.remove(swPos);
        swSet.add(anyPos);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int size = valList.size();

        return size == 0 ? 0 : valList.get(rand.nextInt(size));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */