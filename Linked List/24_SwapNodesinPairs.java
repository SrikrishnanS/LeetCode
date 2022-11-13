/* 24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
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
    public ListNode swapPairs(ListNode head) 
    {
        if (head == null || head.next  == null)
            return head;

        ListNode prev = new ListNode(0, head);

        ListNode n0 = head;
        head = prev;
        while (n0 != null && n0.next  != null)
        {
            ListNode n1 = n0.next;
            
            prev.next = n1;
            n0.next = n1.next;
            n1.next = n0;
            
            prev = n0;
            n0 = n0.next;
        }
        return head.next;
    }
}
