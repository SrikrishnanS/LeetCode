/*
272. Closest Binary Search Tree Value II

Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST that are closest to the target. You may return the answer in any order.

You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

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
class Solution
{
    private void findClosest(TreeNode node, double target, int k,
                             Queue<double[]> Q)
    {
        if (node.left  != null)
            findClosest(node.left, target, k, Q);

        double diff = Math.abs(target - (double) node.val);

        Q.offer(new double[]{diff, (double) node.val});
        if (Q.size() > k)
            Q.poll();

        if (node.right != null)
            findClosest(node.right, target, k, Q);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k)
    {
        List<Integer> L = new ArrayList<Integer>();
        Queue<double[]> Q;

        Q = new PriorityQueue<double[]>((a, b) -> {
                if (b[0] < a[0])
                    return -1;
                else
                    return 1;
            });
        if (root != null)
            findClosest(root, target, k, Q);

        while (!Q.isEmpty())
            L.add((int) Q.poll()[1]);

        return L;
    }
}
