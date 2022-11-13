/*
103. Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> list = new ArrayList<>();
        Queue <TreeNode>    Q    = new LinkedList<>();    
        boolean             fromLeft;

        if (root == null)
            return list;
        
        fromLeft = true;
        Q.offer(root);
        while (!Q.isEmpty())
        {
            List<Integer> l     = new LinkedList<>();
            int           qSize = Q.size();
            while ((qSize--) > 0)
            {
                TreeNode node = Q.poll();
                
                if (fromLeft)
                    l.add(node.val);
                else
                    l.add(0, node.val);
                
                if (node.left != null)
                    Q.offer(node.left);
                if (node.right != null)
                    Q.offer(node.right);
            }
            fromLeft = !fromLeft;
            list.add(l);
        }
        return list;
    }
}