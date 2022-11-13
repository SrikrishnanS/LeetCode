/* 1721. Swapping Nodes in a Linked List

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
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
    public ListNode swapNodes(ListNode head, int k) 
    {
        ListNode first = null;
        ListNode fast  = head;
        ListNode slow  = head;
        int       n    = k;
        
        // move fast k nodes ahead
        while ((n--) > 1)
            fast = fast.next;
        
        first = fast;
        // find kth node from the end
        while (fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        // swap values
        int temp = slow.val;
        slow.val = first.val;
        first.val = temp;
        return head;
    }
}
