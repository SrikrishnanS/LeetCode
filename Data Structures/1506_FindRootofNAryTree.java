/*
1506. Find Root of N-Ary Tree

You are given all the nodes of an N-ary tree as an array of Node objects, where each node has a unique value.

Return the root of the N-ary tree.

Custom testing:

An N-ary tree can be serialized as represented in its level order traversal where each group of children is separated by the null value (see examples).

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
    public Node findRoot(List<Node> tree)
    {
        Set<Integer> visited = new HashSet<Integer>();

        for (Node node : tree)
            for (Node child : node.children)
                visited.add(child.val);

        for (Node node: tree)
            if (!visited.contains(node.val))
                return node;

        return null;
    }
}