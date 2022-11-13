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
class Solution 
{
    private TreeNode getBST(int [] nums, int l, int r)
    {
        if (l > r)
            return null;
        
        int m = l + ((r - l)/2);        
    
        return new TreeNode(nums[m],
                            getBST(nums, l, m - 1),
                            getBST(nums, m + 1, r));
    }
    public TreeNode sortedArrayToBST(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return null;

        return getBST(nums, 0, nums.length - 1);
    }
}