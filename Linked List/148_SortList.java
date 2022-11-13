/* 148. Sort List

Given the head of a linked list, return the list after sorting it in ascending order.
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
    public ListNode sortList(ListNode head) 
    {
        ListNode left = null, right = null, mid = null;

        if (head == null || head.next == null)
            return head;
    
        left = head;
        mid = getMiddleNode(head);
        if (mid != null) // split array into two
        {
            right = mid.next;
            mid.next = null;
        }
        left = sortList(left);
        right = sortList(right);
        return mergeLists(left, right);
    }

    private ListNode getMiddleNode(ListNode L)
    {
        ListNode slow, fast;
        if (L == null)
            return L;
        
        slow = fast = L;
        
        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode mergeLists(ListNode L1, ListNode L2)
    {
        ListNode head, curr;

        if (L1 == null)
            return L2;
        else if (L2 == null)
            return L1;
        
        head = curr = new ListNode(0); // dummy header
        while (L1 != null && L2 != null)
        {
            if (L1.val < L2.val)
            {
                curr.next = L1;
                L1 = L1.next;
            }
            else
            {
                curr.next = L2;
                L2 = L2.next;
            }
            curr = curr.next;
        }
        // connect if any remaining nodes
        if (L1 != null)
            curr.next = L1;
        else
            curr.next = L2;
        
        return  head.next;
    }
}
