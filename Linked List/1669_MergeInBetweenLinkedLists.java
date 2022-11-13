/*
1669. Merge In Between Linked Lists

You are given two linked lists: list1 and list2 of sizes n and m respectively.

Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

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
    public ListNode mergeInBetween(ListNode list1, int a, int b,
                                   ListNode list2)
    {
        ListNode node = list1, start = null, end = null;
        int count = 0;

        //find the start and end nodes
        while (node != null)
        {
            ++count;
            if (count == a)
                start = node;
            if (count == b)
            {
                end = node.next;
                break;
            }
            node = node.next;
        }
        start.next = node = list2;
        // find the tail of list2
        while (node.next != null)
            node = node.next;

        node.next = end.next;
        return list1;
    }
}
