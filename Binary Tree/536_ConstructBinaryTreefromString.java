/*
536. Construct Binary Tree from String

You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.

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
    public TreeNode str2tree(String s) 
    {
        TreeNode root   = null;
        
        int      sLen        = s.length();
        boolean  isNegative  = false;
        int      i           = 0;
        String   numStr;
        int      num;
        int      start;
        
        if (s.equals(""))
            return root;
        
        // extract the root number first
        while (i < sLen && s.charAt(i) != '(') { ++i; }
        
        numStr = s.substring(0, i);
        num = Integer.valueOf(numStr);
        root = new TreeNode(num);
        
        // extract left subtree
        if (i < sLen)
        {
            num = 1; // match for (
            ++i;
            start = i;

            while (num != 0)
            {
                char  ch = s.charAt(i++);

                if (ch == '(')        ++num;
                else if (ch == ')')   --num;
            }
            // make left subtree
            root.left = str2tree(s.substring(start, i - 1));
        }
        
        // extract right subtree
        if (i < sLen)
        {
            num = 1; // match for )
            ++i;
            start = i;

            while (num != 0)
            {
                char  ch = s.charAt(i++);

                if (ch == '(')        ++num;
                else if (ch == ')')   --num;
            }
            // make left subtree
            root.right = str2tree(s.substring(start, i - 1));
            
        }
        return root;
    }
}
