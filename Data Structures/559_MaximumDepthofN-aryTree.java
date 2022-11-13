/*
559. Maximum Depth of N-ary Tree

Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution 
{
    int maxHeight = Integer.MIN_VALUE;
    private void getMaxDepth(Node node, int depth)
    {
        if (node == null)
            return;
    
        maxHeight = Math.max(maxHeight, depth);
        for (Node n : node.children)
            getMaxDepth(n, depth + 1);
    }
    public int maxDepth(Node root) 
    {
        getMaxDepth(root, 1);
        return this.maxHeight;
    }
}
