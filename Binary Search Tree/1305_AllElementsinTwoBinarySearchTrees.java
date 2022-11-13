/*
1305. All Elements in Two Binary Search Trees

Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

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
    private void traverse(TreeNode node, Map<Integer, Integer> map)
    {
        if (node == null)
            return;
        
        map.put(node.val, 1 + map.getOrDefault(node.val, 0));
        traverse(node.left, map);
        traverse(node.right, map);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) 
    {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        List<Integer>         L   = new ArrayList<>();
        
        traverse(root1, map);
        traverse(root2, map);
        
        for (int val : map.keySet())
        {
            int count = map.get(val);
            for (int i = 0; i < count; ++i)
                L.add(val);
        }
        return L;
    }
}
