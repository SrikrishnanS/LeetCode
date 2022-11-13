/* 652. Find Duplicate Subtrees

Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.
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
    private String findDuplicateSubtrees(TreeNode node,
                                         List<TreeNode> result,
                                         Map<String, Integer> count)
    {
        String path = "";
        if (node == null)
            return ".";
        
        
        String left = findDuplicateSubtrees(node.left,  result, count);
        String right = findDuplicateSubtrees(node.right, result, count);
    
        path = node.val + "|" + left + right;
        
        count.put(path, count.getOrDefault(path, 0) + 1);
        if (count.get(path) == 2)
            result.add(node);
        
        return path;
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) 
    {
        List<TreeNode> result = new ArrayList<TreeNode>();
        
        findDuplicateSubtrees(root, result, new HashMap<String, Integer>());
        return result;
    }
}
