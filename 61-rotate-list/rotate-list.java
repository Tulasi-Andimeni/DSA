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
    public ListNode rotateRight(ListNode head, int k) {
               if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length
        int length = 1;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Step 2: Make circular
        temp.next = head;

        // Step 3: Reduce k
        k = k % length;

        // Step 4: Find new tail (length - k steps)
        int steps = length - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
        
    }
}