/*
662. Maximum Width of Binary Tree

Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

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
    private int mapNodes(Map<Integer, Integer> map, TreeNode node,
                          int depth, int nodeIndex, int[] width)
    {
        if (node == null)
            return 0;

        // is the node the first one for this depth?
        map.putIfAbsent(depth, nodeIndex);

        width[0] = Math.max(width[0], nodeIndex - map.get(depth) + 1);

        mapNodes(map, node.left,  depth + 1, 2 * nodeIndex + 1, width);
        mapNodes(map, node.right, depth + 1, 2 * nodeIndex + 2, width);
        return width[0];
    }

    public int widthOfBinaryTree(TreeNode root)
    {
        return mapNodes(new HashMap<Integer, Integer>(), root,
                        0, 0, new int[1]);
    }
}
