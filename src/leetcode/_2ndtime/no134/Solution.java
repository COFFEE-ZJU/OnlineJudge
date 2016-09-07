package leetcode._2ndtime.no134;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len;
        if (gas == null || (len=gas.length) == 0) return -1;
        int curGas, minGas, minPos;
        curGas = minGas = minPos = 0;
        for(int i = 0; i < len; i++) {
            curGas = curGas + gas[i] - cost[i];
            if (curGas < minGas) {
                minGas = curGas;
                minPos = i + 1;
            }
        }
        if (curGas < 0) return -1;
        else return minPos;
    }
}