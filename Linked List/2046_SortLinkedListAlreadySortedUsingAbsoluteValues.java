/*
2046. Sort Linked List Already Sorted Using Absolute Values

Given the head of a singly linked list that is sorted in non-decreasing order using the absolute values of its nodes, return the list sorted in non-decreasing order using the actual values of its nodes.

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
    public ListNode sortLinkedList(ListNode head) 
    {
        Stack<ListNode> S        = new Stack<>();
        ListNode        current  = new ListNode(9999, head);  
        ListNode        newHead  = null;
    
        newHead = head = current;
        
        // push all negative nodes to stack
        while (current.next != null)
        {
            if (current.next.val < 0)
            {
                ListNode temp = current.next;
                
                current.next = current.next.next;
                temp.next = null;
                S.push(temp);
            }
            else
                current = current.next;
        }
        
        // form a new linked list with negative nodes
        if (!S.isEmpty())
        {
            newHead = new ListNode(-9999, S.pop());
            current = newHead.next;
            while (!S.isEmpty())
            {
                current.next = S.pop();
                current = current.next;
            }
            // stitch the new lists together
            current.next = head.next;
        }        
        return newHead.next;
    }
}
