/*
515. Find Largest Value in Each Tree Row

Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

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
    public List<Integer> largestValues(TreeNode root) 
    {
        List<Integer> L = new LinkedList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        
        if (root == null)
            return L;
        
        Q.offer(root);
        while (!Q.isEmpty())
        {
            int    qSize  = Q.size();
            Integer maxVal = null;
            
            while ((qSize--) > 0)
            {
                TreeNode node = Q.poll();
                
                maxVal = (maxVal == null) ? node.val 
                                          : Math.max(maxVal, node.val);
                if (node.left != null)
                    Q.offer(node.left);
                if (node.right != null)
                    Q.offer(node.right);
            }
            L.add(maxVal);
        }
        return L;
    }
}
