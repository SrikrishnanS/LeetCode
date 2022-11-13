/* 143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
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
    private ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp;
        
        while (curr != null)
        {
            temp      = curr.next;
            curr.next = prev;
            prev      =  curr;
            curr      = temp;
        }
        return prev;
    }
    private ListNode getMiddleNode(ListNode head)
    {
        ListNode slow, fast;
        
        slow = fast = head;
        
        while (fast != null && fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private void reorderList(ListNode L1, ListNode L2)
    {
        ListNode temp1, temp2;
        while (L2 != null)
        {
            temp1 = L1.next;
            temp2 = L2.next;
            L1.next = L2;
            L2.next = temp1;
            L1 = temp1;
            L2 = temp2;
        }
    }

    public void reorderList(ListNode head) 
    {
        ListNode L1 = getMiddleNode(head);
        ListNode L2 = reverseList(L1.next);
    
        L1.next = null;
        L1 = head;
        reorderList(L1, L2);
    }
}
