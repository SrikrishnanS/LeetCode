/*
102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> L = new ArrayList<>();
        Queue <TreeNode> Q = new LinkedList<>();
        
        if (root == null)
            return L;
        
        Q.offer(root);
        while (!Q.isEmpty())
        {
            List<Integer> l = new ArrayList<>();
            int qSize = Q.size();
            while ((qSize--) > 0)
            {
                TreeNode node = Q.poll();
                
                l.add(node.val);
                if (node.left != null)
                    Q.offer(node.left);
                if (node.right != null)
                    Q.offer(node.right);
            }
            L.add(l);
        }
        return L;
    }
}
