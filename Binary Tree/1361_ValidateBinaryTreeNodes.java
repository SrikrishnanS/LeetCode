/*
1361. Validate Binary Tree Nodes

You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.
*/

class Solution 
{
    public boolean validateBinaryTreeNodes(int n, int[] leftChild,
                                           int[] rightChild) 
    {
        Set<Integer> S = new HashSet<>();
        int          edges = 0;

        // this is directed graph
        // so first find root
        for (int i = 0; i < n; ++i)
            S.add(i);
        for (int c : leftChild)
            if (c != -1)
                S.remove(c); // can't be root
        for (int c : rightChild)
            if (c != -1)
                S.remove(c); // can't be root
        
        if (S.size() != 1)
            return false; // should have exactly 1 root and be connected
        
        int root = S.iterator().next();
        S.clear();
        
        if (hasCycle(root, leftChild, rightChild, S)) // should have no cycle
            return false;
        
        return S.size() == n; // connected
    }
    
    public boolean hasCycle(int n, int[] leftChild, int[] rightChild,
                            Set<Integer> visited)
    {
        if (n == -1)
            return false;
        if (visited.contains(n))
            return true; // seen before
        
        visited.add(n); // this node is now visited
    
        return hasCycle(leftChild[n], leftChild, rightChild, visited) ||
               hasCycle(rightChild[n], leftChild, rightChild, visited);        
    }
}
