/*
589. N-ary Tree Preorder Traversal

Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

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
    private List<Integer> preorder (Node node, List<Integer> L)
    {
        if (node == null)
            return L;

        L.add(node.val);
        for (Node n : node.children)
            preorder(n, L);

        return L; // for convenience
    }
    public List<Integer> preorder(Node root) 
    {
        return preorder(root, new LinkedList());
    }
}