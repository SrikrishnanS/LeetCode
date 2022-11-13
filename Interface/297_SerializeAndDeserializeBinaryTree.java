/*
297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        StringBuilder str;
        Queue <TreeNode> q = new LinkedList<TreeNode>();

        if (root == null)
            return null;

        str = new StringBuilder();
        str.append("H#");
        q.offer(root);
        while (!q.isEmpty())
        {
            TreeNode node = q.poll();
            if (node != null)
            {
                str.append(node.val + "#");
                q.offer(node.left);
                q.offer(node.right);
            }
            else
                str.append("X#");
        }
        str.append("E");
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        TreeNode root = null, parent;
        String [] items;
        if (data == null)
            return root;

        items = data.split("#"); // delimiter

        if (items[0].equals("H") &&
            items[items.length - 1].equals("E")) // check header and footer
        {
            Queue <TreeNode> q = new LinkedList<TreeNode>();
            root = new TreeNode(Integer.parseInt(items[1]));
            q.offer(root);
            for (int i = 2; i < items.length - 1; i+=2)
            {
                parent = q.poll();
                if (!items[i].equals("X"))
                    parent.left = new TreeNode(Integer.parseInt(items[i]));
                if (!items[i+1].equals("X"))
                    parent.right = new TreeNode(Integer.parseInt(items[i+1]));
                if (parent.left != null)
                    q.offer(parent.left);
                if (parent.right != null)
                    q.offer(parent.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));