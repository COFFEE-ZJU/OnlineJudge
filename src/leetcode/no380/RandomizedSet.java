package leetcode.no380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Whiteboard coding!
 */

public class RandomizedSet {
    private Map<Integer, Integer> posMap;
    private List<Integer> nums;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        posMap = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (posMap.containsKey(val)) return false;

        posMap.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!posMap.containsKey(val)) return false;

        int pos = posMap.remove(val);
        if (pos == nums.size()-1) {
            nums.remove(pos);
        } else {
            int toMov = nums.remove(nums.size()-1);
            nums.set(pos, toMov);
            posMap.put(toMov, pos);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
