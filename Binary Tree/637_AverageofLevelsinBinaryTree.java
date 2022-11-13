/*
637. Average of Levels in Binary Tree

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.

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
    public List<Double> averageOfLevels(TreeNode root) 
    {
        List<Double>    L = new ArrayList<>();
        Queue<TreeNode> Q = new LinkedList<>();
 
        Q.offer(root);
        while (!Q.isEmpty())
        {
            int    qSize = Q.size();
            double sum   = 0;
            
            for (int i = 0; i < qSize; ++i)
            {
                TreeNode node = Q.poll();
            
                sum += node.val;
                if (node.left != null)
                    Q.offer(node.left);
                if (node.right != null)
                    Q.offer(node.right);
            }
            L.add(sum / qSize);
        }
        return L;
    }
}
