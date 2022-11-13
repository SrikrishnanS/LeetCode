/* 133. Clone Graph

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution
{
    private HashMap <Node, Node> copied = new HashMap <Node, Node>();
    public Node cloneGraph(Node node)
    {
        Node       copyNode = null;
        ArrayList<Node> copyNeighbors;
    
        if (node == null)
            return copyNode;
        else if (copied.containsKey(node))
            return copied.get(node);
        
        
        copyNeighbors = new ArrayList<Node>();
        copyNode = new Node(node.val, copyNeighbors);
        copied.put(node, copyNode);
  
        for (Node next: node.neighbors)
            copyNeighbors.add(cloneGraph(next));

        return copyNode;
    
    }
}
