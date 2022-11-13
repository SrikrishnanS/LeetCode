/* 234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome.
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
    private ListNode getMiddleNode(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverseNodes(ListNode head)
    {
        ListNode curr, prev;
        
        curr = head;
        prev = null;
        while (curr != null)
        {
            ListNode temp = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) 
    {
        if (head.next == null)
            return true;

        ListNode L1 = getMiddleNode(head);
        ListNode L2 = reverseNodes(L1.next);
        
        L1 = head;
        while (L2 != null)
        {
            if (L1.val != L2.val)
                return false;
            L2 = L2.next;
            L1 = L1.next;
        }
        return true;
    }
}
