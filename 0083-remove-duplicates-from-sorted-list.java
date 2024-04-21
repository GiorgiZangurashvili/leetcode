/*
  Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

  Time: O(n)
  Space: O(1)
*/

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode savedHead = head;
        int currValue = head.val;

        while (head != null) {
            if (head.next == null) {
                break;
            }

            if (currValue == head.next.val) {
                head.next = head.next.next;
            } else {
                currValue = head.next.val;
                head = head.next;
            }
        }

        return savedHead;
    }
}
