/* 1660. Correct a Binary Tree

You have a binary tree with a small defect. There is exactly one invalid node where its right child incorrectly points to another node at the same depth but to the invalid node''s right.

Given the root of the binary tree with this defect, root, return the root of the binary tree after removing this invalid node and every node underneath it (minus the node it incorrectly points to).
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
    public TreeNode correctBinaryTree(TreeNode root) 
    {
        Queue<TreeNode[]> Q    = new LinkedList<>();
        Set<Integer>      past = new HashSet<>();

        Q.offer(new TreeNode[]{null, root}); // parent - node pair
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            
            while (qSize-- > 0)
            {
                TreeNode[] pair = Q.poll();
                TreeNode parent = pair[0];
                TreeNode node   = pair[1];

                if (node == null)
                    continue;
                else if (node.right != null &&
                         past.contains(node.right.val))
                {
                    if (parent.left == node)
                        parent.left = null;
                    else
                        parent.right =  null;
                }
                else
                {
                    past.add(node.val);
                    Q.offer(new TreeNode[]{node, node.right});
                    Q.offer(new TreeNode[]{node, node.left});
                }
            }
            past.clear();
        }
        return root;
    }
}
