/* 337. House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Val
{
    int val;
    int rob;
    int noRob;
    Val()
    {
        
    }
    Val(int val)
    {
        this.val = val;
    }
}

class Solution {

    Map<Integer, Val> map = new HashMap<Integer, Val>();
    private int toMap (TreeNode node, int index)
    {
        int lidx = -1;
        int ridx = -1;
        if (node == null)
            return -1;
        map.put(index, new Val(node.val));
        lidx = toMap(node.left,  2 * index + 1);
        ridx = toMap(node.right, 2 * index + 2);
        return Math.max(index, Math.max(lidx, ridx));
    }
    public int rob(TreeNode root) 
    {
        Val  rootVal;
        int  tot;
        int  last;
        int  i;
        // first serialize tree to a map accessible by index
        last = toMap(root, 0);
        
        for (i = last; i >= 0; --i)
        {
            Val parent   = map.get(i);
            Val [] children = new Val[2];
            if (parent == null) // node at this index not present
                continue;
            
            children[0] = map.get(2 * i + 1); // get left child
            children[1] = map.get(2 * i + 2); // get right child
            if (children[0] == null &&
                children[1] == null) // parent is a leaf node
            {
                parent.rob = parent.val;
                parent.noRob = 0;
            }
            else // atleast one child
            {
                parent.rob = parent.val; // start with node's value
                for (int j = 0; j < 2; ++j)
                {
                    if (children[j] == null)
                        continue;
                    parent.rob += children[j].noRob;
                    parent.noRob += Math.max(children[j].rob, children[j].noRob);
                }
            }
        }
        rootVal = map.get(0);
        tot = Math.max(rootVal.rob, rootVal.noRob);
        return tot;
    }
}
