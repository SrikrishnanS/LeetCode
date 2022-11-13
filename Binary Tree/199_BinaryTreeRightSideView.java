/*
199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
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
    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>>  Q;

        if (root == null)
            return result;

        Q = new LinkedList<Pair<TreeNode, Integer>>();
        Q.offer(new Pair<TreeNode, Integer>(root, 0));
        while (!Q.isEmpty())
        {
            Pair<TreeNode, Integer> pair  = Q.poll();
            TreeNode                node  = pair.getKey();
            int                     level = pair.getValue();

            if (result.size() < level + 1)
                result.add(node.val);
            else
                result.set(level, node.val); // update the value with right most node

            if (node.left != null)
                Q.offer(new Pair<TreeNode, Integer>(node.left, level + 1));
            if (node.right != null)
                Q.offer(new Pair<TreeNode, Integer>(node.right, level + 1));
        }
        return result;
    }
}
