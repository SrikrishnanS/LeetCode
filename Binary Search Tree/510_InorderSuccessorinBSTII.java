/*
510. Inorder Successor in BST II

Given a node in a binary search tree, return the in-order successor of that node in the BST. If that node has no in-order successor, return null.

The successor of a node is the node with the smallest key greater than node.val.

You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node. Below is the definition for Node:

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
    public Node inorderSuccessor(Node node)
    {
        if (node == null)
            return null;

        int val = node.val;

        // (1) go to right node, then all the way left
        if (node.right != null)
        {
            node = node.right;
            while (node.left != null)
                node = node.left;
        }
        // (2) go to my parent
        else if (node.parent != null)
        {
            node = node.parent;
            while (node != null && node.val < val)
                node = node.parent;
        }
        // (3) root node
        else
            node = null;
        return node;
    }
}
