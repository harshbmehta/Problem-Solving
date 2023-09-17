// Recursive Approach
// Complexity Analysis

// Time complexity : O(n+m)

// Because each recursive call increments the pointer to l1 or l2 by one (approaching the dangling null at the end of each list), there will be exactly one call to mergeTwoLists per element in each list. Therefore, the time complexity is linear in the combined size of the lists.

// Space complexity : O(n+m)

// The first call to mergeTwoLists does not return until the ends of both l1 and l2 have been reached, so n+m stack frames consume O(n+m) space.

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         termination condition
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}


// Iterative Approach

// Complexity Analysis

// Time complexity : O(n+m)

// Because exactly one of l1 and l2 is incremented on each loop
// iteration, the while loop runs for a number of iterations equal to the
// sum of the lengths of the two lists. All other work is constant, so the
// overall complexity is linear.

// Space complexity : O(1)

// The iterative approach only allocates a few pointers, so it has a
// constant overall memory footprint.

// class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         // maintain an unchanging reference to node ahead of the return node.
//         ListNode prehead = new ListNode(-1);

//         ListNode prev = prehead;
//         while (l1 != null && l2 != null) {
//             if (l1.val <= l2.val) {
//                 prev.next = l1;
//                 l1 = l1.next;
//             } else {
//                 prev.next = l2;
//                 l2 = l2.next;
//             }
//             prev = prev.next;
//         }

//         // At least one of l1 and l2 can still have nodes at this point, so connect
//         // the non-null list to the end of the merged list.
//         prev.next = l1 == null ? l2 : l1;

//         return prehead.next;
//     }
// }