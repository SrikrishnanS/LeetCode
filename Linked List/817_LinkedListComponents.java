/*
817. Linked List Components

You are given the head of a linked list containing unique integer values and an integer array nums that is a subset of the linked list values.

Return the number of connected components in nums where two values are connected if they appear consecutively in the linked list.

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
    public int numComponents(ListNode head, int[] nums)
    {
        Set<Integer> set = new HashSet<>();

        for (int n : nums)
            set.add(n);

        int count = 0;
        ListNode node = head;

        while (node != null)
        {
            if (set.contains(node.val))
            {
                ++count;
                while (node != null && set.contains(node.val))
                    node = node.next;
            }
            if (node != null)
                node = node.next;
        }
        return count;
    }
}
