/* 
513. Find Bottom Left Tree Value

Given the root of a binary tree, return the leftmost value in the last row of the tree.
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
    public int findBottomLeftValue(TreeNode root) 
    {
        Queue <TreeNode> Q  = new LinkedList<> ();
        int last = -1;
        
        Q.offer(root);
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
 
            while ((qSize--) > 0)
            {
                TreeNode node = Q.poll();
                
                if (node == null)
                    continue;

                last = node.val;
                Q.offer(node.right);
                Q.offer(node.left);
            }
        }
        return last;
    }
}
