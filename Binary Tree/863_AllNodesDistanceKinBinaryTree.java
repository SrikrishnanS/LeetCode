/*
863. All Nodes Distance K in Binary Tree

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    private void buildGraph(TreeNode parent,
                            TreeNode node,
                            Map<Integer, Integer[]> graph)
    {        
        if (node == null)
            return;
    
        Integer [] neighbors = new Integer[3]; // atmost 3 neighbors
   
        if (parent != null)
            neighbors[0] = parent.val;
        if (node.left  != null)
        {
            neighbors[1] = node.left.val;
            buildGraph(node, node.left, graph);
        }
        if (node.right != null)
        {
            neighbors[2] = node.right.val;      
            buildGraph(node, node.right, graph);
        }
        graph.put(node.val, neighbors); // set children for current node
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        Map<Integer, Integer[]> graph     = new HashMap<>();
        Queue<int[]>            Q         = new LinkedList<>();
        Set<Integer>            visited   = new HashSet<>();
        List<Integer>           result    = new ArrayList<>();

        if (root == null)
            return null;
        
        // build an access friendly graph
        buildGraph(null, root, graph);
    
        visited.add(target.val);
        Q.offer(new int[]{target.val, 0}); // node, distance pair
        
        // traverse the graph and find nodes at distance k
        while (!Q.isEmpty())
        {
            int[] pair  = Q.poll();
            int   n     = pair[0]; // node
            int   d     = pair[1]; // distance covered
        
            if (d < k) // distance yet to be covered
            {
                for (Integer c : graph.get(n)) // examine children
                {
                    if (c == null || visited.contains(c))
                        continue; // null or seen before
                
                    visited.add(c);
                    Q.offer(new int[]{c, d + 1}); // go one step further
                }
            }
            else if (d == k) // if  distance k reached, don't go further
                result.add(n);
        }
        return result;
    }
}
