package leetcode;

/**
 * Created by zkf on 1/8/16.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode genNodes(int ... xs){
        return genNode(xs);
    }

    public static ListNode genNode(int[] xs){
        if(xs.length == 0) return null;
        ListNode head = new ListNode(xs[0]), tail = head;
        for(int i = 1; i < xs.length; i++){
            ListNode node = new ListNode(xs[i]);
            tail.next = node;
            tail = node;
        }
        return head;
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }
}
