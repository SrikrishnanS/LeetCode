/*
1302. Deepest Leaves Sum

Given the root of a binary tree, return the sum of values of its deepest leaves.
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
    public int deepestLeavesSum(TreeNode root) 
    {
        int             sum = 0;
        Queue<TreeNode> Q = new LinkedList<>();
        
        if (root != null)
            Q.offer(root);
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            sum = 0;
            while ((qSize--) > 0)
            {
                TreeNode node = Q.poll();
                
                sum += node.val;
                if (node.left != null)
                    Q.offer(node.left);
                if (node.right != null)
                    Q.offer(node.right);
            }
        }
        return sum;
    }
}
