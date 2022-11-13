/* 
314. Binary Tree Vertical Order Traversal

Given the root of a binary tree, return the vertical order traversal of its nodes'' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.
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
    public List<List<Integer>> verticalOrder(TreeNode root)
    {
        List<List<Integer>>             list = new ArrayList<>();
        Map<Integer, List<Integer>>     map;
        Queue <Pair<TreeNode, Integer>> Q;
        
        if (root == null)
            return list;
        
        map = new TreeMap<>(); // maps node to its group
        Q = new LinkedList<>();
        
        Q.offer(new Pair<TreeNode, Integer>(root, 0)); // start with root node
        while (!Q.isEmpty())   // bread-first search
        {
            Pair<TreeNode, Integer> pair = Q.poll();
            TreeNode                node = pair.getKey();
            int                     group = pair.getValue();
            List<Integer>           l;
            
            l = map.get(group);
            if (l == null)
            {
                l = new ArrayList<Integer>();
                map.put(group, l); // create an entry for the group the first time
            }
            l.add(node.val);
            
            if (node.left != null)
                Q.offer(new Pair<TreeNode, Integer>(node.left, group - 1));
            if (node.right != null)
                Q.offer(new Pair<TreeNode, Integer>(node.right, group + 1));
        }
        
        // add lists to result
        for (int group : map.keySet())
        {
            List<Integer> l = map.get(group);
            list.add(l);
        }
        return list;
    }
}
