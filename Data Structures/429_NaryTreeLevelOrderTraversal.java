/*
429. N-ary Tree Level Order Traversal

Given an n-ary tree, return the level order traversal of its nodes' values.

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
    public List<List<Integer>> levelOrder(Node root) 
    {
        List<List<Integer>> L = new ArrayList<>();
        Queue<Node>         Q = new LinkedList<>();
        
        if (root != null)
            Q.offer(root);
       
        while (!Q.isEmpty())
        {
            int            qSize = Q.size();
            List<Integer>  l = new ArrayList<>();
        
            while ((qSize--) > 0)
            {
                Node node = Q.poll();
                
                l.add(node.val);
                for (Node n : node.children)
                    Q.offer(n);
            }
            L.add(l);
        }
        return L;
    }
}
