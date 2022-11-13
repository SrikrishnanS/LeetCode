/*
1161. Maximum Level Sum of a Binary Tree

Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

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
    public int maxLevelSum(TreeNode root) 
    {
        Queue<TreeNode> Q = new LinkedList<>();
        int             level = 0;
        Integer         maxSum = null;
        int             maxLevel = -1;

        Q.offer(root);
        while (!Q.isEmpty())
        {
            int qSize  = Q.size();
            int curSum = 0;
            while ((qSize--) > 0)
            {
                TreeNode node  = Q.poll();
                
                curSum += node.val;
                if (node.left != null)
                    Q.offer(node.left);
                if (node.right != null)
                    Q.offer(node.right);
            }
            ++level;
            if (maxSum == null || curSum > maxSum)
            {
                maxSum = curSum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
