/*
1490. Clone N-ary Tree

Given a root of an N-ary tree, return a deep copy (clone) of the tree.

Each node in the n-ary tree contains a val (int) and a list (List[Node]) of its children.

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution 
{
    public Node cloneTree(Node root) 
    {
        Node copyNode = null;
        if  (root == null)
            return copyNode;
    
        copyNode = new Node(root.val, new ArrayList<Node>());
    
        for (Node n : root.children)
            copyNode.children.add(cloneTree(n));
    
        return copyNode;
    }
}
