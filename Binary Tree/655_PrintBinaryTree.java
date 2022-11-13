/*
655. Print Binary Tree

Given the root of a binary tree, construct a 0-indexed m x n string matrix res that represents a formatted layout of the tree. The formatted layout matrix should be constructed using the following rules:

The height of the tree is height and the number of rows m should be equal to height + 1.
The number of columns n should be equal to 2height+1 - 1.
Place the root node in the middle of the top row (more formally, at location res[0][(n-1)/2]).
For each node that has been placed in the matrix at position res[r][c], place its left child at res[r+1][c-2height-r-1] and its right child at res[r+1][c+2height-r-1].
Continue this process until all the nodes in the tree have been placed.
Any empty cells should contain the empty string "".
Return the constructed matrix res.

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
    private int height(TreeNode node)
    {
        if (node == null)
            return -1;
    
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    public List<List<String>> printTree(TreeNode root) 
    {
        List<List<String>>  L = new ArrayList<List<String>>();
        int                 h = height(root); // height of the tree
        int                 m = h + 1;
        int                 n = (int)Math.pow(2, (h + 1)) - 1;
        int                 r = 0;
        int                 c = 0;
    
        Queue<Pair<TreeNode, Integer>> Q = new LinkedList<>();
        
        // Q: <node, position> pair
        Q.offer(new Pair<TreeNode, Integer>(root, ((n - 1) / 2)));
        while (!Q.isEmpty())
        {
            List<String> l;
            int          qSize = Q.size(); // no. of nodes in next level
            
            l = new ArrayList<String>();
            L.add(l); // new list for next rpw

            for (int i = 0; i < n; ++i)
                l.add(""); // set empty for all n cols
 
            while ((qSize--) > 0) // process cols in next row
            {
                Pair<TreeNode, Integer> p    = Q.poll();  
                TreeNode                node = p.getKey();
                int                     col;
                
                c  = p.getValue();
            
                l.set(c, node.val + ""); // set the value in the expected index
                if (node.left != null)
                {
                    col = c - (int)Math.pow(2, (h - r - 1));
                    Q.offer(new Pair<>(node.left, col));
                }
                if (node.right != null)
                {
                    col = c + (int)Math.pow(2, h - r - 1);
                    Q.offer(new Pair<>(node.right, col));
                }
            }
            ++r;
        }
        return L;
    }
}
