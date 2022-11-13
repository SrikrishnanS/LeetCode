/*
215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

*/

class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        Queue<Integer> Q = new PriorityQueue<Integer>((a, b) -> a - b);    
    
        for (int n : nums)
        {
            Q.offer(n);
            if (Q.size() > k)
                Q.poll();
        }
        return Q.peek();
    }
}