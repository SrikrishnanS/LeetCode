/*
703. Kth Largest Element in a Stream

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

*/

class KthLargest 
{
    Queue<Integer> Q;
    int k;
    public KthLargest(int k, int[] nums) 
    {
        Q = new PriorityQueue<Integer>((a, b) -> (a - b));
        
        for (int n : nums)
            Q.offer(n);
    
        this.k = k;
        while (Q.size() > k)
            Q.poll();
    }
    
    public int add(int val) 
    {
        Q.offer(val);
        if (Q.size() > k)
            Q.poll();
        
        return Q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
