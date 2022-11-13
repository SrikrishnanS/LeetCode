/* 1650. Lowest Common Ancestor of a Binary Tree III

Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).

Each node will have a reference to its parent node. The definition for Node is below:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution 
{
    public Node lowestCommonAncestor(Node p, Node q) 
    {
        List<Node> plist = new LinkedList<>();
        List<Node> qlist = new LinkedList<>();
        
        while (p != null)
        {
            plist.add(0, p);
            p = p.parent;
        }
        while (q != null)
        {
            qlist.add(0, q);
            q = q.parent;
        }
    
        int i;
        for (i = 0; i < plist.size() && i < qlist.size() &&
                    plist.get(i).val == qlist.get(i).val; ++i)
        {}
    
        return plist.get(i-1);
    }
}
