/*
109. Convert Sorted List to Binary Search Tree

Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    private TreeNode toBST(List<Integer> list, int l, int r)
    {
        TreeNode root = null;
        
        if (l > r)
            return root;
        
        int m = l + ((r - l)/2);
        
        return new TreeNode(list.get(m),
                            toBST(list, l, m - 1),
                            toBST(list, m + 1, r));        
    }
    
    public TreeNode sortedListToBST(ListNode head) 
    {
        List<Integer> list = new ArrayList<Integer>();
        
        // linked list to array list
        while (head != null)
        {
            list.add(head.val);
            head = head.next;
        }
        return toBST(list, 0, list.size() - 1);
    }
}
