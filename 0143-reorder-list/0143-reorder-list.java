/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast != null && fast.next!=null) {
            curr = curr.next;
            fast = fast.next.next;
        }

        ListNode start = curr.next;
        curr.next = null; // middle node will end up being last so null
        ListNode prev = null;

        while(start!=null) {
            ListNode temp = start.next;
            start.next = prev;
            prev = start;
            start = temp;
        }

        ListNode newList = head;
        while(prev!=null) {
            ListNode t1 = newList.next;
            ListNode t2 = prev.next;
            newList.next = prev;
            prev.next = t1;
            newList = t1;
            prev = t2;
        }
    }
}