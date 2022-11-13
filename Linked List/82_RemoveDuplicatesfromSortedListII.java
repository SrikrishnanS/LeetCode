/* 82. Remove Duplicates from Sorted List II

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
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
class Solution 
{
    public ListNode deleteDuplicates(ListNode head) 
    {
        ListNode prev, curr;

        if (head == null || head.next == null)
            return head;
    
        prev  = new ListNode(-1000, head);
        curr = head;
        head = prev;
        while (curr != null && curr.next != null)
        {
            if (curr.val == curr.next.val)
            {
                while (curr != null && curr.next != null &&
                       curr.val == curr.next.val)
                    curr = curr.next;
                
                if (curr != null)
                {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }
            else
            {
                prev = curr;
                curr = curr.next;
            }
        }
        return head.next;
    }
}
