/*
426. Convert Binary Search Tree to Sorted Doubly Linked List

Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution 
{
    Node head = null, end = null;
    private void treeToList(Node node)
    {
        Node left, right;
        if (node == null)
            return;
        
        treeToList(node.left);
        if (end != null)
        {
            end.right = node;
            node.left = end;
        }
        else
            head = node;

        end = node;        
        treeToList(node.right);        
    } 
    public Node treeToDoublyList(Node root) 
    {
        if (root == null)
            return root;
        treeToList(root);
        head.left = end;
        end.right = head;
        return head;
    }
}
