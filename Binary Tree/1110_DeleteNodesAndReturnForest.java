/*
1110. Delete Nodes And Return Forest

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) 
    {
        List<TreeNode> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (int n : to_delete)
            set.add(n);
        
        prune(root, set, list);
        
        if (!set.contains(root.val))
            list.add(root);
            
        return list;
    }
    
    private TreeNode prune(TreeNode node, Set<Integer> set,
                           List<TreeNode> list)
    {
        if (node == null)
            return node;
        
        node.left  = prune(node.left, set, list);
        node.right = prune(node.right, set, list);
        if (set.contains(node.val))
        {
            if (node.left != null)
                list.add(node.left);
            if (node.right != null)
                list.add(node.right);
            node = null;
        }
        return node;
    }    
}
