/* 1836. Remove Duplicates From an Unsorted Linked List

Given the head of a linked list, find all the values that appear more than once in the list and delete the nodes that have any of those values.

Return the linked list after the deletions.
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
    public ListNode deleteDuplicatesUnsorted(ListNode head) 
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        if (head == null || head.next == null)
            return head;
        
        ListNode curr = head;
        while (curr != null)
        {
            map.put(curr.val, 1 + map.getOrDefault(curr.val, 0));
            curr = curr.next;
        }
        ListNode prev = new ListNode(0, head);
        curr = head;
        head = prev;
        while (curr != null)
        {
            if (map.get(curr.val) > 1)
                prev.next = curr.next;
            else
                prev = curr;
            curr = curr.next;
        }
        return head.next;
    }
}
