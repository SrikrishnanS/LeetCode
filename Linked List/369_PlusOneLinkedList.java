/* 369. Plus One Linked List

Given a non-negative integer represented as a linked list of digits, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list.
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
    private int addOne(ListNode node)
    {
        int carry = 0;
        
        if (node.next == null)  // last node in the list
        {
            if (++node.val > 9)
            {
                node.val = 0;
                carry = 1;
            }
        }
        else
        {
            carry = addOne(node.next);
            if (carry == 1)
            {
                if (++node.val > 9)
                    node.val = 0;
                else
                    carry = 0;
            }
                
        }
        return carry;
    }

    public ListNode plusOne(ListNode head) 
    {
        ListNode prev = new ListNode(1, head); // carry header
                
        if (addOne(head) == 1)
            head = prev;
        
        return head;
    }
}
