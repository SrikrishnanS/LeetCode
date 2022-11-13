/*
117. Populating Next Right Pointers in Each Node II

Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution 
{
    public Node connect(Node root) 
    {
        if (root == null)
            return root;
        
        Queue<Node> Q = new LinkedList<>();
        
        Q.offer(root);        
        while (!Q.isEmpty())
        {
            int  qSize = Q.size();
            Node prev = null;
            
            for (int i = 0; i < qSize; ++i)
            {
                Node node = Q.poll();
                
                if (prev != null)
                    prev.next = node;
                
                if (node.left != null)
                    Q.offer(node.left);
                if (node.right != null)
                    Q.offer(node.right);
                prev = node;
            }   
        }
        return root;
    }
}
