/* 1602. Find Nearest Right Node in Binary Tree

Given the root of a binary tree and a node u in the tree, return the nearest node on the same level that is to the right of u, or return null if u is the rightmost node in its level.
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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) 
    {
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        
        Q.offer(root);
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            TreeNode previous = null;
            while ((qSize--) > 0)
            {
                TreeNode curr = Q.poll();
                
                if (curr == null)
                    continue;
                else if (curr.val == u.val) // node found
                    return previous;
                
                Q.offer(curr.right);
                Q.offer(curr.left);
                previous = curr;
            }
        }
        return null; // node not found
    }
}