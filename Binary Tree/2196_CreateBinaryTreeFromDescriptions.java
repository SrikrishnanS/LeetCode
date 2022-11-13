/*
2196. Create Binary Tree From Descriptions

You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.
Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

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
    public TreeNode createBinaryTree(int[][] descriptions)
    {
        Map<Integer, TreeNode> cache = new HashMap<Integer, TreeNode>();
        Set<Integer> children  = new HashSet<Integer>();

        // find child of every node
        for (int [] d : descriptions)
        {
            int      parent = d[0];
            int      child  = d[1];
            boolean  isLeft = (d[2] == 1);
            TreeNode pNode  = null, cNode = null;

            // create nodes first time and place in cache
            cache.putIfAbsent(parent, new TreeNode(parent));
            cache.putIfAbsent(child, new TreeNode(child));

            // assign child pointer
            pNode = cache.get(parent);
            cNode = cache.get(child);
            if (isLeft)
                pNode.left = cNode;
            else
                pNode.right = cNode;

            children.add(child);
        }

        // find the root
        for (int [] d : descriptions)
            if (!children.contains(d[0]))
                return cache.get(d[0]);

        return null;
    }
}
