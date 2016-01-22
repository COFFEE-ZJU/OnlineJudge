package cn.edu.zju.coffee.leetcode.no092;

import cn.edu.zju.coffee.leetcode.ListNode;

public class Solution {
    private ListNode dummyHead = new ListNode(0);

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;

        dummyHead.next = head;
        int pos = 1;
        ListNode mPred, mCur, mSucc, nPred, nCur, nSucc;
        mPred = mCur = mSucc = nPred = nCur = nSucc = null;

        ListNode revTail = null, revHead = null, revPred = null;
        for (ListNode pred = dummyHead, cur = head, succ = head.next; ; ){
            if (pos >= m && pos <= n){
                cur.next = revHead;
                revHead = cur;
                if (pos == m) {
                    revTail = cur;
                    revPred = pred;
                }
                else if (pos == n){
                    revTail.next = succ;
                    revPred.next = revHead;
                    break;
                }
            }

            if (succ == null)
                break;

            pred = cur;
            cur = succ;
            succ = succ.next;
            pos ++;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseBetween(ListNode.genNodes(1,2,3,4,5), 1, 4));
        System.out.println(sol.reverseBetween(ListNode.genNodes(1,2,3,4,5), 2, 4));
        System.out.println(sol.reverseBetween(ListNode.genNodes(1,2,3,4,5), 2, 5));
        System.out.println(sol.reverseBetween(ListNode.genNodes(1,2,3,4,5), 1, 5));
        System.out.println(sol.reverseBetween(ListNode.genNodes(1,2,3,4,5), 1, 2));
    }
}