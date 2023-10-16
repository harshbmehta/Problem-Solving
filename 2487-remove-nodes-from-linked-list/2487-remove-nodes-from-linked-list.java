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
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);

        ListNode max = head, curr = head.next;

        while(curr != null) {
            if(max.val > curr.val)
                max.next = curr.next;
            else
                max = curr;

            curr = curr.next;
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }

        return prev;
    }
}