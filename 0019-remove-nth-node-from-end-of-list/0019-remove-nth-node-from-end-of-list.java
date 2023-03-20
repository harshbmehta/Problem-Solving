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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        int ni=n;
        ListNode lst=head;
        ListNode lstNth=head;
        ListNode lstN1=head;
        int len = 0;
        while(lst!=null) {
            len++;
            if(n != 0) {
                lst = lst.next;
                n--;
            } else {
                lstN1 = lstNth;
                lstNth = lstNth.next;
                lst = lst.next;
            }
        }
        if(len == ni) return head.next;
        lstN1.next = lstNth.next;
        return head;

    }
}