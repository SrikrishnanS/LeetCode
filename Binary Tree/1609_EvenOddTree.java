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
    public boolean isEvenOddTree(TreeNode root) 
    {
        Queue<TreeNode> Q = new LinkedList<>();
        boolean         isEven = true;
        
        Q.offer(root);
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            int previous = (isEven) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            while ((qSize--) >0)
            {
                TreeNode node = Q.poll();
            
                if ((isEven &&
                     ((node.val % 2 == 0) || previous >= node.val)) ||
                    (!isEven &&
                     ((node.val % 2 == 1) || previous <= node.val)))
                        return false;
                if (node.left != null)
                    Q.offer(node.left);
                if (node.right != null)
                    Q.offer(node.right);
                previous = node.val;
            }
            isEven = !isEven; // flip for next level
        }
        return true;
    }
}