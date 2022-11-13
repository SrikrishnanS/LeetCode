/* 23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
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
    public ListNode mergeKLists(ListNode[] lists) 
    {
         return mergeKLists(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKLists(ListNode[] lists, int low, int high)
    {
        int mid = low + ((high-low)/2);

        if (low == high)
            return lists[low];
        else if (low > high)
            return null;
        
        ListNode left  = mergeKLists(lists, low, mid);
        ListNode right = mergeKLists(lists, mid + 1, high);
        return mergeLists(left, right);
    }
    
    public ListNode mergeLists(ListNode L1, ListNode L2)
    {
        ListNode head, current;
        
        if (L1 == null)
            return L2;
        else if (L2 == null)
            return L1;
        
        head = current = new ListNode();
        while (L1 != null && L2 != null)
        {
            if (L1.val <= L2.val)
            {
                current.next = L1;
                L1 = L1.next;
            }
            else
            {
                current.next = L2;
                L2 = L2.next;
            }
            current = current.next;
        }
        if (L1 != null)
            current.next = L1;
        else
            current.next = L2;
        return head.next;
    }
}
